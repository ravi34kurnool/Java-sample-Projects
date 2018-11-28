package common.testproject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExpression {
	public static void main(String[] args) throws Exception {
		testRegx();
		
	//	$scope.menonicPattern = "%?[0-9A-Za-z\\-_]+-[01234567]-+[0-9A-Za-z\\-_]+.*";
	}

	private static void testRegx() throws Exception {
	// 	String regx1 ="%?[0-9A-Za-z\\-_]+-[01234567]-+[0-9A-Za-z\\-_]+.*"; 
		String regx = "%?[0-9A-Za-z\\.*-_]+-[01234567]-+[0-9A-Za-z\\-_]+.*";
		File file = new File("C:\\Users\\rmummadu\\Desktop\\Note_files\\Signature_Pattrens.txt"); 
	    Scanner sc = new Scanner(file); 
	  
	    // we just need to use \\Z as delimiter 
	    sc.useDelimiter("\\Z"); 
	    
	    List<String> validSignatureFormats = new ArrayList<String>();
	    List<String> inValidSignatureFormats = new ArrayList<String>();
	     
		while (sc.hasNextLine()) {
	        String signature = sc.nextLine();
			if(Pattern.matches(regx,signature)){
				validSignatureFormats.add(signature);
			}else{
				inValidSignatureFormats.add(signature);
			}
		}
		
		System.out.println("Total Valid Signatures Count is : "+validSignatureFormats.size());
		System.out.println("Total IN Valid Signatures Count is : "+inValidSignatureFormats.size());
		
		StringBuffer sbf = new StringBuffer();
		
		for(String str : inValidSignatureFormats){
			sbf.append(str).append(",").append("\n");
		}
		Files.write(Paths.get("C:\\Users\\rmummadu\\Desktop\\Note_files\\invalid_Signature_Pattrens.csv"), sbf.toString().getBytes());
	}
}
