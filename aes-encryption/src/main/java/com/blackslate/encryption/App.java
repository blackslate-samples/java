package com.blackslate.encryption;

public class App 
{
    public static void main( String[] args )
    {
        
    	try {
			String secretKey = "MySecretKey12345"; // 16, 24, or 32 bytes
			String originalText = "This is a secret message.";
			
			// Encrypting the text
			EncryptedData encryptedData = AESAdvancedEncryptionExample.encrypt(originalText, secretKey);
			System.out.println("Encrypted Text: " + encryptedData.getData());
			System.out.println("IV String: " + encryptedData.getIv());
			
			// Decrypting the text
			String decryptedText = AESAdvancedEncryptionExample.decrypt(encryptedData, secretKey);
			System.out.println("Decrypted Text: " + decryptedText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
}
