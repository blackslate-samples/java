package com.blackslate.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Employee {
	
	String name;
	String birthDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonSetter("birthDate")
	public void setDateOfBirth(String birthDate) {
        this.birthDate = birthDate;
    }

	@JsonGetter("birthDate")
	public String getDateOfBirth() {
        return birthDate;
    }
	
	public String toString() {
		return name + " " + birthDate;
	}
}
