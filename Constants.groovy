
public class Constants {

    public static String BEGIN_MARKER_PATTERN = /^-+ *BEGIN.+$/
    public static String END_MARKER_PATTERN   = /^-+ *END.+$/

    public static String HEADER_MARKER = '-----BEGIN-----'
    public static String FOOTER_MARKER = '-----END-----'

    public static String HEADER_RSA_PRIVATE_MARKER =
        '-----BEGIN RSA PRIVATE KEY-----'
    public static String HEADER_RSA_PUBLIC_MARKER  =
        '-----BEGIN RSA PUBLIC KEY-----'
    public static String FOOTER_RSA_PRIVATE_MARKER =
        '-----END RSA PRIVATE KEY-----'
    public static String FOOTER_RSA_PUBLIC_MARKER  =
        '-----END RSA PUBLIC KEY-----'
}