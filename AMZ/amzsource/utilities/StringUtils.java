package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	
	public static String getStringByString(String input, String start, String end, boolean last) {
		int indexStart = 0;
		if (last)
			indexStart = input.lastIndexOf(start) + start.length();
		else
			indexStart = input.indexOf(start) + start.length();
		int indexEnd = input.indexOf(end, indexStart);
		return input.substring(indexStart, indexEnd);
	}
	
	public static String subStringByString(String input, String start, String end) {		
		int beginIndex = input.indexOf(start);
		int endIndex = input.indexOf(end, beginIndex);		
		return input.substring(beginIndex, endIndex);
	}
	
	public static String getCurrentDateTime(String format){
		return new SimpleDateFormat(format).format(new Date());		
	}
	
	public static long getDuration(String format, String dateStart, String dateEnd) throws ParseException{
		try{
			DateFormat f = new SimpleDateFormat(format);
			Date date1 = f.parse(dateStart);
			Date date2 = f.parse(dateEnd);		
			return (date2.getTime() - date1.getTime());
		}
		catch(Exception ex)
		{
			return 0;
		}		
	}
	
	public static String getsuiteOutputPath(){//default report for testNG
		String path = "test-output/surefire-reports";
		if (System.getProperty("suiteOutputPath") != null) {
			path = System.getProperty("suiteOutputPath");
		}
		return path;
	}
	
	public static String getExtendReportOutputPath(){//extended file set in file dom.xml
		String path = "test-output/surefire-reports/extend-reports/";
		if (System.getProperty("suiteExtendReportPath") != null) {
			path = System.getProperty("suiteExtendReportPath") + "html/";
		}
		return path;
	}
	
	public static String getAllureReportOutputPath(){//allure files set in file dom.xml
		String path = "test-output/surefire-reports/allure-results";
		if (System.getProperty("suiteAllureReportPath") != null) {
			path = System.getProperty("suiteAllureReportPath");
		}
		return path;
	}
	
	public static String getJenkinBuildOutputPath(){//Jenkin set in file dom.xml
		String path = "test-output/surefire-reports/jenkin";
		if (System.getProperty("suiteBuildPath") != null) {
			path = System.getProperty("suiteBuildPath") + "html/";
		}
		return path;
	}
	
	
}
