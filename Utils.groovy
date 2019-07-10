import groovy.util.logging.Log
import java.io.File
import java.security.Key
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Log
public class Utils {

    static String loadKeyfile(String keyFile) {
        def result = ''

        new File(keyFile).eachLine {
            result += it.replaceAll(Constants.BEGIN_MARKER_PATTERN, '')
                        .replaceAll(Constants.END_MARKER_PATTERN , '')
                        .replaceAll(/\s/, '')
        }
        log.info("key content: $result")
        result
    }

    static String formatKey(RSAPrivateKey key) {
        return formatKeyBase64(key,
                               Constants.HEADER_RSA_PRIVATE_MARKER,
                               Constants.FOOTER_RSA_PRIVATE_MARKER)
    }

    static String formatKey(RSAPublicKey key) {
        return formatKeyBase64(key,
                               Constants.HEADER_RSA_PUBLIC_MARKER,
                               Constants.FOOTER_RSA_PUBLIC_MARKER)
    }

    static String formatKeyBase64(Key key, String header, String footer) {
        return "${header}\n${key.getEncoded().encodeBase64()}\n${footer}"
    }
}