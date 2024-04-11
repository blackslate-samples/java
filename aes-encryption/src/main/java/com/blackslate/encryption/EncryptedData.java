package com.blackslate.encryption;

public class EncryptedData {
	
	private String data;
	private String iv;
	
	public EncryptedData(String data, String iv) {
		super();
		this.data = data;
		this.iv = iv;
	}
	
	public String getData() {
		return data;
	}
	
	public String getIv() {
		return iv;
	}

}
