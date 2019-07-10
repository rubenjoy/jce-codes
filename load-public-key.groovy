// load RSA Public key in X509 encoding

import java.security.KeyFactory
import java.security.interfaces.RSAPublicKey
import java.security.spec.X509EncodedKeySpec

import static Utils.formatKey
import static Utils.loadKeyfile

def factory = KeyFactory.getInstance('RSA')

args.each {

    String encoded = loadKeyfile(it)
    def spec = new X509EncodedKeySpec(encoded.decodeBase64())

    def key = factory.generatePublic(spec)
    assert key instanceof RSAPublicKey
    println formatKey(key)
}