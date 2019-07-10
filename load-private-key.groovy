// load RSA private key from PKCS8 encoding

import java.security.KeyFactory
import java.security.interfaces.RSAPrivateKey
import java.security.spec.PKCS8EncodedKeySpec

import static Utils.formatKey
import static Utils.loadKeyfile

def factory = KeyFactory.getInstance('RSA')

args.each {

    String encoded = loadKeyfile(it)
    def spec = new PKCS8EncodedKeySpec(encoded.decodeBase64())

    def key = factory.generatePrivate(spec)
    assert key instanceof RSAPrivateKey
    println formatKey(key)
}