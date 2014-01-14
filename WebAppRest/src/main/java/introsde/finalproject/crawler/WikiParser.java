package introsde.finalproject.crawler;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Random;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import finalproject.model.Goal;
import finalproject.model.HealthProfile;
import finalproject.model.Person;

public class WikiParser {

	private static Random random = new Random();

	public static void main(String[] args) throws Exception {

		/************* INSERT EXERCISES AND EX.CATEGORIES ********************/

		File dir = new File("crawl");
		dir.mkdir();

		int numberOfCrawlers = 1;
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder("crawl");
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig,
				pageFetcher);
		CrawlController controller = new CrawlController(config, pageFetcher,
				robotstxtServer);
		controller.addSeed("http://www.exrx.net/Calculators/Calories.html");
		controller.start(GetExercisesCrawler.class, numberOfCrawlers);

		/************* INSERT GOALS ********************/

		Goal goalTW = new Goal();
		goalTW.setName("Loose Weight Seriously");

		Goal goalIHB = new Goal();
		goalIHB.setName("Important Health Benefits");

		Goal goalGHB = new Goal();
		goalGHB.setName("Great Health Benefits");

		goalTW = Goal.create(goalTW);
		goalIHB = Goal.create(goalIHB);
		goalGHB = Goal.create(goalGHB);

		// /************* INSERT ACTIVITIES ********************/
		//
		// // ************************************
		// // General Activity
		//
		// Activity doSpecificSport = new Activity();
		// doSpecificSport.setDescription("Do a specific sport");
		// doSpecificSport.setType(0);
		// doSpecificSport.setValue(0);
		//
		// // ************************************
		// // Per il lose weight
		// // ************************************
		//
		// Activity loseTargetWeight = new Activity();
		// loseTargetWeight.setDescription("Loose weight");
		// loseTargetWeight.setType(0);
		// loseTargetWeight.setValue(0);
		//
		// // ************************************
		// // Important Health Benefits
		// // ************************************
		//
		// Activity ihbMinutes = new Activity();
		// ihbMinutes
		// .setDescription("150 minutes Moderate Intentensity Aerobic Activities");
		// ihbMinutes.setType(0);
		// // ihbMinutes.set
		// // ihbMinutes.setValue(0);
		//
		// // ************************************
		// Activity ihbTimes = new Activity();
		// ihbTimes.setDescription("Do a specific sport");
		// ihbTimes.setType(0);
		// ihbTimes.setValue(0);
		//
		// // ************************************
		// // Greater Health Benefits
		// // ************************************
		//
		// Activity ghbMinutes = new Activity();
		// ghbMinutes.setDescription("Do a specific sport");
		// ghbMinutes.setType(0);
		// ghbMinutes.setValue(0);
		// // ************************************
		//
		// Activity ghbTimes = new Activity();
		// ghbTimes.setDescription("Do a specific sport");
		// ghbTimes.setType(0);
		// ghbTimes.setValue(0);
		// // ************************************

		/************* INSERT PERSON ********************/

		HashSet<String> names = new HashSet<String>();

		String sparqlService = "http://dbpedia.org/sparql";

		String sparql = "SELECT distinct *"
				+ "	WHERE { "
				+ "		?work a <http://dbpedia.org/ontology/Athlete> ."
				+ "       ?work <http://dbpedia.org/property/name> ?name ."
				+ "	    ?work <http://dbpedia.org/ontology/height> ?height ."
				+ "	    ?work <http://dbpedia.org/ontology/weight> ?weight ."
				+ "	    ?work <http://dbpedia.org/ontology/birthDate> ?birthDate ."
				+ "	{"
				+ "	  ?work <http://purl.org/dc/terms/subject> <http://dbpedia.org/resource/Category:Australian_basketball_players> ."
				+ "        }" + "           }";

		ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(
				sparql);

		com.hp.hpl.jena.query.Query query = paramQuery.asQuery();

		QueryExecution qexec = QueryExecutionFactory.sparqlService(
				sparqlService, query);
		ResultSet results = (ResultSet) qexec.execSelect();

		String nameAttribute = "name";
		String heightAttribute = "height";
		String weightAttribute = "weight";
		String birthDateAttribute = "birthDate";

		String fullName = null;
		String firstName = null;
		String lastName = null;
		String heightString = null;
		String weightString = null;
		String birthDate = null;
		double height;
		double weight;

		while (results.hasNext()) {
			QuerySolution qs = results.next();

			fullName = qs.get(nameAttribute).toString();

			if (fullName.indexOf(',') > -1) {
				int index = fullName.indexOf(',');
				lastName = fullName.substring(0, index);
				firstName = fullName
						.substring(index + 2, fullName.length() - 3);

				firstName = firstName.replace("'", "''");
				lastName = lastName.replace("'", "''");
			}

			heightString = qs.get(heightAttribute).toString();
			heightString = heightString.substring(0, heightString.indexOf('^'));
			weightString = qs.get(weightAttribute).toString();
			weightString = weightString.substring(0, weightString.indexOf('^'));

			birthDate = qs.get(birthDateAttribute).toString();
			birthDate = birthDate.substring(0, birthDate.indexOf('^'));

			if (heightString != null && weightString != null
					&& firstName != null && WikiParser.isValid(birthDate)) {
				height = Double.parseDouble(heightString);
				weight = (Double.parseDouble(weightString)) / 1000;

				if (names.add(firstName + " " + lastName)) {

					System.out.println(firstName);
					System.out.println(lastName);
					System.out.println(birthDate + "\n");

					Person p = new Person();

					p.setFirstname(firstName);
					p.setLastname(lastName);
					p.setBirthdate(birthDate);
					p.setSex(randBetween(0, 1));
					p.setExerciseTimesPerWeek(randBetween(0, 7));

					p = Person.create(p);

					int pId = p.getId();

					int num_healthProfiles = randBetween(1, 5);

					/************* INSERT HEALTH PROFILES ********************/

					for (int i = 0; i < num_healthProfiles; i++) {
						int year = randBetween(
								Integer.parseInt(birthDate.substring(0, 4)),
								2013);
						int month = randBetween(1, 12);
						int day = randBetween(1, 28);

						int hearthRate = randBetween(60, 90);
						int minBloadPressure = randBetween(60, 110);
						int maxBloadPressure = randBetween(
								minBloadPressure + 10, 180);

						String dateRandom = year + "-" + month + "-" + day;

						Double randWeight = randBetween(
								weight - (randBetween(0.5, 5.0)), weight
										+ (randBetween(0.5, 5.0)));
						Double randHeight = randBetween(
								height - (randBetween(0.01, 0.5)), height
										+ (randBetween(0.01, 0.2)));

						HealthProfile hp = new HealthProfile();

						hp.setHeight(randHeight);
						hp.setWeight(randWeight);

						hp.setDate(dateRandom);
						hp.setHeartrate(hearthRate);
						hp.setMaxbloodpressure(maxBloadPressure);
						hp.setMinbloodpressure(minBloadPressure);
						hp.setPersonId(pId);

						HealthProfile.create(pId, hp);

						System.out
								.println("HealthProfile created successfully");
					}
				}
			}
		}
		qexec.close();

	}

	public static boolean isValid(String text) {
		if (text == null || !text.matches("\\d{4}-[01]\\d-[0-3]\\d"))
			return false;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		try {
			df.parse(text);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static Double randBetween(Double start, Double end) {
		return start + (end - start) * random.nextDouble();
	}
}
