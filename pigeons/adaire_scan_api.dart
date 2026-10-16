import 'package:pigeon/pigeon.dart';

@ConfigurePigeon(
  PigeonOptions(
    dartOut: 'lib/src/adaire_scan_api.g.dart',
    dartOptions: DartOptions(),
    kotlinOut:
        'android/src/main/kotlin/com/adairetech/adaire_scan/AdaireScanApi.g.kt',
    kotlinOptions: KotlinOptions(package: 'com.adairetech.adaire_scan'),
    dartPackageName: 'adaire_scan',
  ),
)
enum NativeOutcomeType {
  success,
  cancelled,
  permissionDenied,
  unavailable,
  busy,
  failure,
}

class NativeScanRequest {
  NativeScanRequest({required this.formats});

  List<String> formats;
}

class NativeScanReply {
  NativeScanReply({required this.type, this.value, this.format, this.code});

  NativeOutcomeType type;
  String? value;
  String? format;
  String? code;
}

@HostApi()
abstract class AdaireScanHostApi {
  @async
  NativeScanReply scan(NativeScanRequest request);
}
