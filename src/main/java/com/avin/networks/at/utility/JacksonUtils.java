package com.avin.networks.at.utility;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class JacksonUtils {

	private JacksonUtils() {
		
	}
	  public static <T> T deserializeObject(String fileName, Class<T> T) throws IOException {
	        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
	        ObjectMapper objectMapper = new ObjectMapper();
	        return objectMapper.readValue(is,T);
	    }
}
