package day3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler {

	public static void main(String[] args) {
		System.out.println(formatDate(new Date()));
	}

	// 1.格式化时间
	public static String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(date);
	}

	// 2.得到当前时间的字符串
	public static String getNowTimeStr() {
		return formatDate(new Date());
	}
}
