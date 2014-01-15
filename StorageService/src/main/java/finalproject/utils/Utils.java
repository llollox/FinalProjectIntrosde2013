package finalproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utils {

	public static boolean isDateValid(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);

		try {
			df.parse(date);
		} catch (ParseException e) {
			return false;
		}

		if (date.length() != 10)
			return false;

		return true;
	}
}
