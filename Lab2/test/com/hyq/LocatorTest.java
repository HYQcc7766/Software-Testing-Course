package com.hyq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LocatorTest {
    private List<List<String>> list;
    String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";
    private Locator loc = null;

    @Before
    public void setUp() throws Exception {
        loc = new Locator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void verification() {
        List<List<String>> excelData = Locator.getExcelData("src/Selenium+Lab2020.xlsx");
        ArrayList<String> data = Locator.getData();
        for (int i = 0; i < excelData.size(); i++) {
            assertEquals(excelData.get(i).get(1), data.get(i));
        }


    }
}