package com.avin.networks.at.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.avin.networks.at.config.constants.GlobalConstants;
import com.avin.networks.at.exceptions.ExcelfileException;


public final class ExcelUtils {

	private ExcelUtils() { }
	
	@SuppressWarnings("resource")
	public static List<Map<String, String>> getTestDetails(String nameOfSheet) {
		List<Map<String, String>> list = null;
		try(FileInputStream fis = new FileInputStream(GlobalConstants.getInstance().getExcelpath())) {
			XSSFWorkbook woorkbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = woorkbook.getSheet(nameOfSheet);

			int lastRowNo = sheet.getLastRowNum();
			int lastColNo = sheet.getRow(0).getLastCellNum();

			Map<String, String> map = null;
			list = new ArrayList<>();
			for (int i = 1; i <= lastRowNo; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastColNo; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new ExcelfileException("Excel file you trying to read is not found.");
		} catch (IOException e) {
			throw new ExcelfileException("Something went for IO exception happned while reading excel file.");
		}
		return list;
	}
}
