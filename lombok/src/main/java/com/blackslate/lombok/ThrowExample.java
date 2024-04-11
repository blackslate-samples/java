package com.blackslate.lombok;

import java.io.File;
import java.io.FileInputStream;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor
public class ThrowExample {
	
	@SneakyThrows
	public void readFromFile() {
		
		@Cleanup 
		FileInputStream fio = new FileInputStream(new File("/path/to/file"));
		fio.read();
	}

}
