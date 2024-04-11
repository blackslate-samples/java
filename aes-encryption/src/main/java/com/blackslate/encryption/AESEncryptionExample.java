package com.blackslate.encryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptionExample {
	
	private static final String AES_ALGORITHM = "AES";
	private static final String CHARSET       = "UTF-8";

	public static String encrypt(String plaintext, String secretKey) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(CHARSET), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

	public static String decrypt(String encryptedText, String secretKey) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(CHARSET), AES_ALGORITHM);
	    Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
	    cipher.init(Cipher.DECRYPT_MODE, keySpec);
	    byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
	    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
	    return new String(decryptedBytes, CHARSET);
	}
}
