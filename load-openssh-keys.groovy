// load RSA private and public keys in OpenSSH encoding
import java.security.KeyFactory
import java.security.Security
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Grab('org.bouncycastle:bcprov-jdk15on:1.62')
import org.bouncycastle.jce.provider.BouncyCastleProvider
import org.bouncycastle.jce.spec.OpenSSHPrivateKeySpec
import org.bouncycastle.jce.spec.OpenSSHPublicKeySpec

import static Utils.formatKey
import static Utils.loadKeyfile

if (Security.getProvider('BC') == null) {
    Security.addProvider(new BouncyCastleProvider())
    println "add bouncycastle provider."
}
def factory = KeyFactory.getInstance('RSA', 'BC')

args.each {

    String encodedPrivate = loadKeyfile(it)
    def privateSpec = new OpenSSHPrivateKeySpec(encodedPrivate.decodeBase64())
    def privateKey = factory.generatePrivate(privateSpec)
    assert privateKey instanceof RSAPrivateKey
    println formatKey(privateKey)

    String encodedPublic = loadKeyfile("${it}.pub")
    def publicSpec = new OpenSSHPublicKeySpec(encodedPublic.decodeBase64())
    def publicKey = factory.generatePublic(publicSpec)
    assert publicKey instanceof RSAPublicKey
    println formatKey(publicKey)
}