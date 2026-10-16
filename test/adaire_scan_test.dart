import 'package:adaire_scan/adaire_scan.dart';
import 'package:adaire_scan/src/adaire_scan_api.g.dart';
import 'package:flutter_test/flutter_test.dart';

class FakeHost extends AdaireScanHostApi {
  FakeHost(this.reply);
  final NativeScanReply reply;
  @override
  Future<NativeScanReply> scan(NativeScanRequest request) async => reply;
}

void main() {
  test('maps valid success and redacts diagnostics', () async {
    final outcome = await AdaireScan(
      host: FakeHost(
        NativeScanReply(
          type: NativeOutcomeType.success,
          value: 'SYNTHETIC',
          format: 'qr',
        ),
      ),
    ).scan();
    expect(outcome, isA<ScanSuccess>());
    expect((outcome as ScanSuccess).value, 'SYNTHETIC');
    expect(outcome.toString(), isNot(contains('SYNTHETIC')));
  });

  test('rejects empty formats before transport', () async {
    final outcome = await AdaireScan(
      host: FakeHost(NativeScanReply(type: NativeOutcomeType.cancelled)),
    ).scan(formats: const {});
    expect(outcome, isA<ScanFailure>());
  });

  test('rejects contradictory success without exposing payload', () async {
    final outcome = await AdaireScan(
      host: FakeHost(
        NativeScanReply(
          type: NativeOutcomeType.success,
          value: 'SYNTHETIC',
          format: 'ean13',
        ),
      ),
    ).scan();
    expect(outcome, isA<ScanFailure>());
    expect(outcome.toString(), isNot(contains('SYNTHETIC')));
  });

  test('maps non-success terminal outcomes', () async {
    expect(
      await AdaireScan(
        host: FakeHost(NativeScanReply(type: NativeOutcomeType.cancelled)),
      ).scan(),
      isA<ScanCancelled>(),
    );
    expect(
      await AdaireScan(
        host: FakeHost(
          NativeScanReply(type: NativeOutcomeType.permissionDenied),
        ),
      ).scan(),
      isA<ScanPermissionDenied>(),
    );
    expect(
      await AdaireScan(
        host: FakeHost(NativeScanReply(type: NativeOutcomeType.busy)),
      ).scan(),
      isA<ScanBusy>(),
    );
  });
}
