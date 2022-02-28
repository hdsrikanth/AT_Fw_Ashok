package com.avin.networks.at.utility;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private DataProviderUtils() { 	}
	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m) {
		String testName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails("DATA");
		}
		List<Map<String, String>> subList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).get("Testcasename").equalsIgnoreCase(testName)) && (list.get(i).get("execute").equalsIgnoreCase("yes"))) {
				subList.add(list.get(i));
			}
		}
		list.removeAll(subList);
		return subList.toArray();
	}
}
