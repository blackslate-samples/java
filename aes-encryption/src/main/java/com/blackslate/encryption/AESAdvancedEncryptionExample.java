package com.blackslate.encryption;

import java.security.AlgorithmParameters;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESAdvancedEncryptionExample {
	
	private static final String AES_ALGORITHM = "AES";
	private static final String CIPHER_MODE   = "AES/CBC/PKCS5Padding";
	private static final String CHARSET       = "UTF-8";
	
	public static EncryptedData encrypt(String plaintext, String secretKey) throws Exception {
		
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new SecureRandom());
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(CHARSET));
        
        String iv   = Base64.getEncoder().encodeToString(cipher.getIV());
        String data = Base64.getEncoder().encodeToString(encryptedBytes);
        
        return new EncryptedData(data, iv);
    }

	public static String decrypt(EncryptedData encryptedData, String secretKey) throws Exception {
		
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData.getData());
	    byte[] iv = Base64.getDecoder().decode(encryptedData.getIv());
		
		SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), AES_ALGORITHM);
	    Cipher cipher = Cipher.getInstance(CIPHER_MODE);
	    cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
	    byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
	    return new String(decryptedBytes, CHARSET);
	}

}
