# Java Cryptography Extension Example Codes

I put all JCE related codes here so that I have my own learning trail
to grasp Java Cryptography Extension. Other than Java Crypto standard
library, you can find also Bouncycastle(bouncycastle.org) library used.
A single file should be executable with single bouncycastle dependency.
Except the classname in capitalized naming.

## Command to Generate Keys

### ssh-keygen

```
$ ssh-keygen [-b 1024|2048] [-t rsa | ecdsa] -f keyfile.key
$ ssh-keygen -e -m [PKCS8|PEM] -f keyfile.key # export public key
```

### openssl

```
$ openssl genrsa -out keyfile.key 2048
$ openssl rsa -in keyfile.key -pubout
$ openssl pkcs8 -topk8 -inform PEM -in keyfile.key -out keyfile.pk8 -nocrypt
```

### java.security.KeyPair

```
$ groovy gen-rsa-keypair.groovy
```