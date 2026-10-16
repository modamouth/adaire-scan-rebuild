import 'src/adaire_scan_api.g.dart';

enum ScanFormat { qr }

sealed class ScanOutcome {
  const ScanOutcome();
}

final class ScanSuccess extends ScanOutcome {
  const ScanSuccess({required this.value, required this.format});
  final String value;
  final ScanFormat format;
  @override
  String toString() => 'ScanSuccess(value: <redacted>, format: ${format.name})';
}

final class ScanCancelled extends ScanOutcome {
  const ScanCancelled();
  @override
  String toString() => 'ScanCancelled()';
}

final class ScanPermissionDenied extends ScanOutcome {
  const ScanPermissionDenied();
  @override
  String toString() => 'ScanPermissionDenied()';
}

final class ScanUnavailable extends ScanOutcome {
  const ScanUnavailable(this.code);
  final String code;
  @override
  String toString() => 'ScanUnavailable(code: $code)';
}

final class ScanBusy extends ScanOutcome {
  const ScanBusy();
  @override
  String toString() => 'ScanBusy()';
}

final class ScanFailure extends ScanOutcome {
  const ScanFailure(this.code);
  final String code;
  @override
  String toString() => 'ScanFailure(code: $code)';
}

class AdaireScan {
  AdaireScan({AdaireScanHostApi? host}) : _host = host ?? AdaireScanHostApi();
  final AdaireScanHostApi _host;

  Future<ScanOutcome> scan({
    Set<ScanFormat> formats = const {ScanFormat.qr},
  }) async {
    if (formats.length != 1 || !formats.contains(ScanFormat.qr)) {
      return const ScanFailure('invalid_formats');
    }
    try {
      return _mapReply(
        await _host.scan(NativeScanRequest(formats: const ['qr'])),
      );
    } on Object {
      return const ScanFailure('transport_error');
    }
  }

  ScanOutcome _mapReply(NativeScanReply reply) {
    final hasPayload = reply.value != null || reply.format != null;
    switch (reply.type) {
      case NativeOutcomeType.success:
        final value = reply.value;
        if (value == null ||
            value.isEmpty ||
            reply.format != 'qr' ||
            reply.code != null) {
          return const ScanFailure('malformed_result');
        }
        return ScanSuccess(value: value, format: ScanFormat.qr);
      case NativeOutcomeType.cancelled:
        return hasPayload || reply.code != null
            ? const ScanFailure('malformed_result')
            : const ScanCancelled();
      case NativeOutcomeType.permissionDenied:
        return hasPayload || reply.code != null
            ? const ScanFailure('malformed_result')
            : const ScanPermissionDenied();
      case NativeOutcomeType.unavailable:
        return _coded(reply, const {
          'no_activity',
          'no_camera',
          'activity_detached',
        }, true);
      case NativeOutcomeType.busy:
        return hasPayload || reply.code != null
            ? const ScanFailure('malformed_result')
            : const ScanBusy();
      case NativeOutcomeType.failure:
        return _coded(reply, const {
          'camera_start_failed',
          'decode_failed',
          'presentation_failed',
          'interrupted',
        }, false);
    }
  }

  ScanOutcome _coded(
    NativeScanReply reply,
    Set<String> allowed,
    bool unavailable,
  ) {
    final code = reply.code;
    if (reply.value != null ||
        reply.format != null ||
        code == null ||
        !allowed.contains(code)) {
      return const ScanFailure('malformed_result');
    }
    return unavailable ? ScanUnavailable(code) : ScanFailure(code);
  }
}
