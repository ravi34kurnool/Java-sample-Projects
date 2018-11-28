package common.testproject;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		List<String> ll = null;
		for (String s : CommonUtils.emptyIfNull(ll)) {
			System.out.println(s);
		}
		stringReplace();
		
		System.err.println(removeNextLineChar("\\n682926045HAI\\n"));
		
		System.out.println(subStringRemove("CloudRay_PLATFORM-2-PS_FAIL3"));
	}
	
	public static void stringReplace(){
		StringBuilder sb = new StringBuilder("Ravi,Ravi,Ravi,Ravi,Ravi,Ravi");
		if(sb.charAt(sb.length()-1) == ','){
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.println(sb.toString());
	}

	public static String removeNextLineChar(String textValue){
		String rep = null;
		if(textValue.startsWith("\\n")){
			rep= textValue. replace("\\n", "");
			return rep;
		}
		return textValue;
	}
	
	public static String subStringRemove(String alarmType){
		String cloudRayString = "CloudRay_";
		String signatureAliasVal = "";
		if(alarmType.startsWith(cloudRayString)){
			signatureAliasVal = alarmType.substring(cloudRayString.length());
		}else{
			signatureAliasVal = alarmType;
		}
		return signatureAliasVal;
	}
}
