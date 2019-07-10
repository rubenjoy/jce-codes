import java.security.KeyPair
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

import static Utils.formatKey
import static java.security.KeyPairGenerator.getInstance

boolean printPrivate = true
boolean printPublic = true

args.each {
    switch(it) {
        case ~/--disable-private/:
            printPrivate = false
            break
        case ~/--disable-public/:
            printPublic = false
            break
        default:
            break
    }
}

def keyPair = getInstance("RSA").generateKeyPair()

def privateKey = keyPair.getPrivate()
assert privateKey instanceof RSAPrivateKey
if (printPrivate) {
    println formatKey(privateKey)
}

def publicKey = keyPair.getPublic()
assert publicKey instanceof RSAPublicKey
if (printPublic) {
    println formatKey(publicKey)
}