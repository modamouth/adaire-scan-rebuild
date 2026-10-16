import 'package:adaire_scan/adaire_scan.dart';
import 'package:flutter/material.dart';

void main() => runApp(const AdaireScanExample());

class AdaireScanExample extends StatefulWidget {
  const AdaireScanExample({super.key, this.scanner});
  final AdaireScan? scanner;

  @override
  State<AdaireScanExample> createState() => _AdaireScanExampleState();
}

class _AdaireScanExampleState extends State<AdaireScanExample> {
  late final AdaireScan scanner = widget.scanner ?? AdaireScan();
  ScanOutcome? outcome;
  bool scanning = false;

  Future<void> scan() async {
    setState(() {
      scanning = true;
      outcome = null;
    });
    final result = await scanner.scan();
    if (!mounted) return;
    setState(() {
      scanning = false;
      outcome = result;
    });
  }

  void clear() => setState(() => outcome = null);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(title: const Text('Adaire Scan private verification')),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(24),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                const Text(
                  'QR only. Use synthetic test values.',
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 24),
                FilledButton(
                  onPressed: scanning ? null : scan,
                  child: Text(scanning ? 'Scanner open' : 'Scan QR code'),
                ),
                const SizedBox(height: 24),
                Semantics(
                  liveRegion: true,
                  child: Text(_description(outcome), key: const Key('outcome')),
                ),
                if (outcome != null)
                  TextButton(
                    onPressed: clear,
                    child: const Text('Clear result'),
                  ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  String _description(ScanOutcome? value) => switch (value) {
    null => 'No scan result',
    ScanSuccess(:final value) => 'QR result: $value',
    ScanCancelled() => 'Scan cancelled',
    ScanPermissionDenied() => 'Camera permission denied',
    ScanUnavailable(:final code) => 'Scanner unavailable: $code',
    ScanBusy() => 'Scanner is already open',
    ScanFailure(:final code) => 'Scan failed: $code',
  };
}
