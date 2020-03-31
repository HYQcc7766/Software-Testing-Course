package com.hyq;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Locator {

    //获取最终结果
	public static ArrayList<String> getData() {
		String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();

		String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
		List<List<String>> list = getExcelData("src/Selenium+Lab2020.xlsx");
		driver.get(baseUrl);

		ArrayList<String> data = new ArrayList<String>();

		for (List<String> i : list) {
			WebElement userName = driver.findElement(By.name("user_number"));
			WebElement passName = driver.findElement(By.name("password"));
			WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));
//			System.out.println(i.get(0));
			userName.clear();
			passName.clear();
			userName.sendKeys(i.get(0));
			passName.sendKeys(i.get(1));

			submitName.click();
			WebElement text = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
			System.out.println(text.getText());
			data.add(text.getText());
		}

		driver.close();

		return data;

	}

	//获取表格数据
	public static List<List<String>> getExcelData(String path) {
		List<List<String>> list = new ArrayList<>();

		try {
			OPCPackage pac = OPCPackage.open(path);
			XSSFWorkbook exc = new XSSFWorkbook(pac);
			XSSFSheet sheet0 = exc.getSheetAt(0);

			for (Iterator rowIterator = sheet0.iterator(); rowIterator.hasNext(); ) {
				XSSFRow row = (XSSFRow) rowIterator.next();
				String username = row.getCell(1).getStringCellValue();
				String password = row.getCell(2).getStringCellValue();

//				直到表格数据读取完毕
				if (username.equals("") && password.equals("")) {
					break;
				} else {
					list.add(new ArrayList<String>(Arrays.asList(username, password)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
