package introsde.finalproject.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	private static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	public static Date parseDate(String dateString) {

		Date date;
		try {
			date = format.parse(dateString);

		} catch (ParseException e) {
			date = null;
		}

		return date;
	}

	public static String jsonId(int id) {

		return "{\"id\":\"" + id + "\"}";
	}

	// private void addImagesUrl(List<String> listUrls) {
	// String url = listUrls.get(0);
	// listUrls.add(url.replace(".s.", ".m."));
	// listUrls.add(url.replace(".s.", ".l."));
	// listUrls.add(url.replace(".s.", ".xl."));
	// }

	// private Random rand = new Random(System.currentTimeMillis());
	// private QueryParams getRandomPrams() {
	// QueryParams params = new QueryParams();
	// for (int n = 0; n < 2; n++) {
	// params.add(new KeyValuePair(Yummly.ALLOWED_INGREDIENT, ingr[rand
	// .nextInt(ingr.length)]));
	// }
	// return params;
	// }

	String[] ingr = new String[] { "onion", "pepper", "butter", "cheese",
			"salad", "chicken", "chilly", "potato", "fish", "spaghetti",
			"tuna", "oil", "meat", "tomato", "bacon", "zucchini", "salami",
			"bread", "egg" };
}
