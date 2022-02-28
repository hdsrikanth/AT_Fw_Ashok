package com.avin.networks.at.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.avin.networks.at.config.constants.GlobalConstants;
import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.exceptions.PropertitesUtilsException;

public final class PropertitesUtils {



	public static Properties property = new Properties();
	public static BufferedReader reader = null;
	
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();

	private PropertitesUtils() {	}

	static {
		try {
			reader = new BufferedReader(new FileReader(GlobalConstants.getInstance().getConfigFilePath()));
			property.load(reader);
			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
		} catch (IOException e) {
			throw new PropertitesUtilsException("Something went for IO exception happned while reading Propertites file.");
		}
	}

	public static String get(ConfigProperties key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertitesUtilsException("Property name :" + key + " is not Found. Please check config.properties");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
