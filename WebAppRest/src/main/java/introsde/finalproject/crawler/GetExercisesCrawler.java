package introsde.finalproject.crawler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import finalproject.model.Activity;
import finalproject.model.Exercise;
import finalproject.model.ExerciseCategory;

public class GetExercisesCrawler extends WebCrawler {

	private final static Pattern FILTERS = Pattern
			.compile(".*(\\.(css|js|bmp|gif|jpe?g"
					+ "|png|tiff?|mid|mp2|mp3|mp4"
					+ "|wav|avi|mov|mpeg|ram|m4v|pdf"
					+ "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

	/**
	 * You should implement this function to specify whether the given url
	 * should be crawled or not (based on your crawling logic).
	 */
	@Override
	public boolean shouldVisit(WebURL url) {
		String href = url.getURL().toLowerCase();
		return !FILTERS.matcher(href).matches()
				&& href.startsWith("http://www.exrx.net/Calculators/Calories.html");
	}

	/**
	 * This function is called when a page is fetched and ready to be processed
	 * by your program.
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		System.out.println("URL: " + url);

		String html = null;
		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			html = htmlParseData.getHtml();
		}
		Document doc = Jsoup.parse(html);
		Element select = doc.select("select").get(2);
		System.out.println(select);
		Elements options = select.select("option");

		Set<String> exCategories = new HashSet<String>();
		ExerciseCategory exCat = null;

		for (Element option : options) {
			Exercise e = new Exercise();
			e.setDescription(option.text());
			e.setDifficultyvalue(Float.parseFloat(option.val()));

			int index = e.getDescription().indexOf("(");
			String found = null;
			if (index == -1)
				found = e.getDescription();
			else
				found = e.getDescription().substring(0, index - 1);

			if (!found.equals("Sitting") && !found.equals("Standing")
					&& !found.equals("Lying")) { // NO SENSE
				if (exCategories.add(found)) { // nuova categoria
					exCat = new ExerciseCategory();
					exCat.setName(found);

					if (Arrays.asList("Calisthenics", "Dancing", "Golf",
							"Gymnastics", "Housework", "Rowing Machine",
							"Weight Training", "Yardwork").contains(found))
						exCat.setAerobic(0);
					else
						exCat.setAerobic(1);

					ExerciseCategory.create(exCat);
				}
				e.setCategory(exCat);
				Exercise.create(e);
			}

		}

		List<Activity> list = Activity.getActivities();

		System.out.println(exCategories);

	}

}

/*************
 * 
 * ANAEROBICI
 * 
 * Calisthenics, Dancing, Golf, Gymnastics, Housework, Lying, Rowing Machine,
 * Weight Training, Yardwork
 * 
 * 
 * NO SENSE Sitting, Standing
 */
