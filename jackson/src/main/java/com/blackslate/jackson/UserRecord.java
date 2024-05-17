package com.blackslate.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonRootName("user")
public class UserRecord {
	
	private String id;
	private String name;
	private String email;
		
	public UserRecord(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	@JsonCreator
	public UserRecord(@JsonProperty("user") String user) {
		String val[] = user.split("-");
		id = val[0];
		name = val[1];
		email = val[2];
	}
	

	@JsonValue
	public String toString() {
		return id + "-" + name + "-" + email;
	}

}
