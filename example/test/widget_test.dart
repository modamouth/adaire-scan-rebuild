import 'package:adaire_scan_example/main.dart';
import 'package:flutter_test/flutter_test.dart';

void main() {
  testWidgets('shows the bounded RB-4 scaffold state', (tester) async {
    await tester.pumpWidget(const AdaireScanExample());

    expect(find.textContaining('Adaire Scan scaffold'), findsOneWidget);
    expect(find.textContaining('RB-5'), findsOneWidget);
  });
}
