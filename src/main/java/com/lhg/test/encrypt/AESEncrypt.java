package com.lhg.test.encrypt;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by liuhg on 16-6-20.
 */
public class AESEncrypt {
    private static final String ALGO = "AES";
    private static final byte[] keyValue =
            new byte[]{'E', 'N', 'C', 'R', 'Y', 'P', 'T',
                       'A', 'U', 'D', 'I', 'O', 'I', 'D',
                       'X','Z'};

    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);

        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    public static void main(String[] args) {
        try {
            String id = AESEncrypt.decrypt("0y+zxzibyc153VBwQg4+Fw==");
            System.out.println(AESEncrypt.encrypt("2838"));
            System.out.println(id);
            System.out.println(AESEncrypt.decrypt("BFFin4ZHzUPSX8gb/myaRg=="));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//C7iHtqLi9Q8KPhzEgRL6ug==