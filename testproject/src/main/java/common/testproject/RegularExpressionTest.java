package common.testproject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	public static void main(String[] args) throws Exception {
	//	testRegx();
		
	//	$scope.menonicPattern = "%?[0-9A-Za-z\\-_]+-[01234567]-+[0-9A-Za-z\\-_]+.*";
		
		findCLILoginExpect();
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
	
	
	public static void findCLILoginExpect() {
		String expectedStringsArray[] = new String[7];
		expectedStringsArray[0]="\n\nUser Access Verification\n\n BIDGSTONE NOC:";
	/*	expectedStringsArray[1]="\n\nUser Access Verification\n\nCOMCAST:";
		expectedStringsArray[2]="User Access Verification Username:";
		expectedStringsArray[3]="User Access Verification login:";
		expectedStringsArray[4]="User Access Verification\n\n USER WITH LOGIN:";
		expectedStringsArray[5]="User Access Verification Login:";
		expectedStringsArray[6]="EDGE-XR (Global Tacacs) Access Verification\n\n\n\nBRIDGETON NOC:";
	*/
	/*	
		expectedStringsArray[1]="COMCAST:";
		expectedStringsArray[2]="Username:";
		expectedStringsArray[3]="login534:";
		expectedStringsArray[4]="USER WITH LOGIN:";
		expectedStringsArray[5]="3Lo56gin:";
		expectedStringsArray[6]="COMCAST BRIDGETON NOC:";
		expectedStringsArray[7]="BRIDGETON NOC:";
		expectedStringsArray[8]=" BRIDGETON NOC:";
		expectedStringsArray[9]="cisco\npassword";
		expectedStringsArray[10]="enable";
	*/
		
		
		expectedStringsArray[1]="Username";
		expectedStringsArray[2]="login";
		expectedStringsArray[3]="Login";
		expectedStringsArray[4]="comcast";
		expectedStringsArray[5]="COMCAST";
		expectedStringsArray[6]="username";
		
		
		// String regEx = "([a-zA-Z]\\w*)[:\\\\s]*\\\\z";
	//	String regEx = "^(assword) && ([a-zA-Z0-9 ]*)[:\\s]*\\z";
	//	String regEx = "^(?!.*(assword)$).([a-zA-Z0-9][a-zA-Z0-9 ]*)[:\\s]*\\z";
		String regEx = "(?)(username|login|comcast)";
		System.out.println("----------------------------------");
		System.out.println("Reg Expres : "+regEx);
		Pattern pattern = Pattern.compile(regEx,Pattern.MULTILINE);
		for(int i=0;i<expectedStringsArray.length;i++) {
			Matcher match = pattern.matcher(expectedStringsArray[i]);
			if(match.matches()) {
				System.out.println("Expected String is matched with RegEx Pattern related to USERNAME : "+expectedStringsArray[i]);
			}else {
				System.out.println("Invalid Pattren  : "+expectedStringsArray[i]);
			}
		}
		
	}
}
