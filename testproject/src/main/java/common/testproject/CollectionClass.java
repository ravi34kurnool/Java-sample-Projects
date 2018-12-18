package common.testproject;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CollectionClass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readFile();
	}
	
	public static void readFile() throws IOException{
		    // pass the path to the file as a parameter
		    FileReader fr =   new FileReader("C:\\Users\\ravi\\Desktop\\LOG\\commd_ids.txt");
		    int i;
		    List<Integer> list = new ArrayList<Integer>(11000);
		    String str = "";
		    while ((i=fr.read()) != -1){
		    	if(i != ','){
		    	  str += (char) i;
		    	}else{
		    		if(str!= null && str.length() > 0 ){
		    			list.add(Integer.parseInt(str.trim()));
		    	//		System.out.println(str);
		    			str="";
		    		}
		    	}
		    }
		    Collections.sort(list);
//		    System.err.println("list size : "+list.size());
//		    System.err.println(list);
		    writeDataIntoExcel(list);
	}
	
	private static void writeDataIntoExcel(List<Integer> list) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");
        int rowCount = 0;
        for (Integer val : list) {
            Row row = sheet.createRow(++rowCount);
                Cell cell = row.createCell(1);
                cell.setCellValue(val);
        }
        FileOutputStream outputStream = null;
        try {
        	outputStream = new FileOutputStream("C:\\Users\\ravi\\Desktop\\JavaBook.xlsx");
            workbook.write(outputStream);
            System.out.println("Exported all data..");
        }catch(Exception e){
        	System.err.println("Erro Got...............");
        	outputStream.close();
        }
	}

}
