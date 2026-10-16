import 'package:adaire_scan/adaire_scan.dart';
import 'package:adaire_scan/src/adaire_scan_api.g.dart';
import 'package:adaire_scan_example/main.dart';
import 'package:flutter_test/flutter_test.dart';

class FakeHost extends AdaireScanHostApi {
  @override
  Future<NativeScanReply> scan(NativeScanRequest request) async =>
      NativeScanReply(type: NativeOutcomeType.cancelled);
}

void main() {
  testWidgets('launches QR scan and renders typed cancellation', (
    tester,
  ) async {
    await tester.pumpWidget(
      AdaireScanExample(scanner: AdaireScan(host: FakeHost())),
    );
    await tester.tap(find.text('Scan QR code'));
    await tester.pumpAndSettle();
    expect(find.text('Scan cancelled'), findsOneWidget);
  });
}
