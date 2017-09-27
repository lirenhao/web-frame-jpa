package com.yada.test.excel;

import com.yada.commons.report.excel.EasyExcel;
import com.yada.commons.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelTest {

    public static void main(String[] args) throws Exception {
        testCreateExcel();
//		testParse();
    }

    public static void testCreateExcel() throws Exception {
        EasyExcel fastExcel = new EasyExcel("/Users/yd/Desktop/data.xlsx");
        List<MyTest> list = new ArrayList<MyTest>();
        for (int i = 0; i < 10; i++) {
            MyTest test = new MyTest();
            test.setName("张三" + i);
            test.setPhone("15321111111");
            test.setAddress("三里屯");
            test.setLat(135.11111);
            test.setType(1);
            test.setPrice(i * 1.1);
            test.setSize(i);
            test.setDateTime(new Date());
            test.setXx(i % 2 == 0);
            list.add(test);
        }
        fastExcel.createExcel(list);
        fastExcel.close();
    }

    public static void testParse() throws Exception {
        EasyExcel fastExcel = new EasyExcel("/Users/yd/Desktop/data.xlsx");
        fastExcel.setSheetName("Sheet1");
        List<MyTest> tests = fastExcel.parse(MyTest.class);
        if (null != tests && !tests.isEmpty()) {
            for (MyTest myTest : tests) {
                System.out.println(JsonUtils.toJson(myTest));
            }
        } else {
            System.out.println("没有结果");
        }
        fastExcel.close();
    }
}
