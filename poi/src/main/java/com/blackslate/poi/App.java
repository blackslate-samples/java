package com.blackslate.poi;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ExcelService excelService = new ExcelService();
    	
    	//excelService.writeToExcel("employee.xlsx");
    	
    	excelService.readFromExcel("employee.xlsx");
    }
}
