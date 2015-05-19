package tool.mastery.core;

public class StringUtil {
	
	
	public static boolean StringIsNull(String str) {
		if(str == null || str.equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean isExistSpace(String str) {
		char[] lineArray = str.toCharArray();
		for(int i = 0 ; i < lineArray.length ; i ++) {
			String c = String.valueOf(lineArray[i]);
			if(!c.matches("[a-zA-Z_]+")) {
				return true;
			}
		}
		return false;
	}
	
	public static String changeArrayStringToString(String[] arrs) {
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0 ; i < arrs.length ; i ++) {
			sb.append(arrs[i] + ",");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append("]");
		return sb.toString();
	}
}
