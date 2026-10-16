import 'dart:io';

Future<void> main() async {
  final result = await Process.run(Platform.resolvedExecutable, const [
    'run',
    'pigeon',
    '--input',
    'pigeons/adaire_scan_api.dart',
  ]);
  stdout.write(result.stdout);
  stderr.write(result.stderr);
  if (result.exitCode != 0) exit(result.exitCode);

  final kotlin = File(
    'android/src/main/kotlin/com/adairetech/adaire_scan/AdaireScanApi.g.kt',
  );
  final generated = await kotlin.readAsString();
  const unsafe =
      'NativeScanReply(type=\$type, value=\$value, format=\$format, code=\$code)';
  const redacted =
      'NativeScanReply(type=\$type, value=<redacted>, format=\$format, code=\$code)';
  if (!generated.contains(unsafe)) {
    stderr.writeln('Expected generated NativeScanReply string was not found.');
    exitCode = 1;
    return;
  }
  await kotlin.writeAsString(
    generated
        .replaceFirst(unsafe, redacted)
        .replaceFirst('import android.util.Log\n', ''),
  );

  final redactedGenerated = await kotlin.readAsString();
  final errorStart = redactedGenerated.indexOf('  fun wrapError(');
  final errorEnd = redactedGenerated.indexOf('  fun doubleEquals', errorStart);
  if (errorStart < 0 || errorEnd < 0) {
    stderr.writeln('Expected generated error wrapper was not found.');
    exitCode = 1;
    return;
  }
  const safeError = '''  fun wrapError(@Suppress("UNUSED_PARAMETER") exception: Throwable): List<Any?> {
    return listOf("transport_error", "Transport failed", null)
  }
''';
  await kotlin.writeAsString(
    redactedGenerated.replaceRange(errorStart, errorEnd, safeError),
  );
}
