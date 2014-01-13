package assignment2.crawler;

import it.unitn.sde.finalproject.HealthProfile;
import it.unitn.sde.finalproject.Person;
import it.unitn.sde.finalproject.PersonService;

import java.sql.PseudoColumnUsage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Random;

import javax.ws.rs.core.Response;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import assignment2.service.HealthProfileResource;
import assignment2.service.PersonResource;

import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;

public class WikiParser {
	
	public static PersonResource ps = new PersonResource();
	public static HealthProfileResource hps = new HealthProfileResource();
	private static Random random = new Random();
	private static GregorianCalendar gc = new GregorianCalendar();
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, ParseException {

        HashSet<String> names = new HashSet<String>();

        String sparqlService = "http://dbpedia.org/sparql";
        
        String sparql = "SELECT distinct *" +
        		"	WHERE { "	+
        		"		?work a <http://dbpedia.org/ontology/Athlete> ." +
                "       ?work <http://dbpedia.org/property/name> ?name ." +
        		"	    ?work <http://dbpedia.org/ontology/height> ?height ." +
        		"	    ?work <http://dbpedia.org/ontology/weight> ?weight ." +
        		"	    ?work <http://dbpedia.org/ontology/birthDate> ?birthDate ." +
        		"	{" +
        		"	  ?work <http://purl.org/dc/terms/subject> <http://dbpedia.org/resource/Category:Australian_basketball_players> ." +
        		"        }" +
        	    "           }";

        ParameterizedSparqlString paramQuery = new ParameterizedSparqlString(sparql);


        com.hp.hpl.jena.query.Query query = paramQuery.asQuery();

        QueryExecution qexec = QueryExecutionFactory.sparqlService(sparqlService, query);
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
                lastName = fullName.substring(0,index);
                firstName = fullName.substring(index+2, fullName.length()-3);

                firstName = firstName.replace("'","''");
                lastName = lastName.replace("'","''");
            }

            heightString = qs.get(heightAttribute).toString();
            heightString = heightString.substring(0,heightString.indexOf('^'));
            weightString = qs.get(weightAttribute).toString();
            weightString = weightString.substring(0,weightString.indexOf('^'));

            birthDate = qs.get(birthDateAttribute).toString();
            birthDate = birthDate.substring(0,birthDate.indexOf('^'));

            if (heightString != null && weightString != null && firstName != null && WikiParser.isValid(birthDate)) {
                height = Double.parseDouble(heightString);
                weight = (Double.parseDouble(weightString))/1000;

                if (names.add(firstName + " " + lastName)) {

                    System.out.println(firstName);
                    System.out.println(lastName);
//                    System.out.println(height);
//                    System.out.println(weight);
                    System.out.println(birthDate + "\n");
                    
                    Person p = new Person();
                    
                    p.setFirstname(firstName);
                    p.setLastname(lastName);
                    p.setBirthdate(birthDate);
                    p.setSex(randBetween(0, 1));
                    
                    Response r = ps.createPerson(p);
                    int pId = (Integer) r.getEntity();
                    
                    int num_healthProfiles = randBetween(1, 5);
                    
                    for(int i=0;i<num_healthProfiles;i++){
                    	int year = randBetween(Integer.parseInt(birthDate.substring(0, 4)), 2010);
                        gc.set(gc.YEAR, year);
                        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
                        gc.set(gc.DAY_OF_YEAR, dayOfYear);

                        String dateRandom = gc.get(gc.YEAR) + "-" + gc.get(gc.MONTH) + "-" + gc.get(gc.DAY_OF_MONTH);
                        Date date = dateFormat.parse(dateRandom);
                        
                        Double randWeight = randBetween(weight-(randBetween(0.5,5.0)), weight+(randBetween(0.5,5.0)));
                        Double randHeight = randBetween(height-(randBetween(0.0,0.5)), height+(randBetween(0.0,0.5)));
                        
                        HealthProfile hp = new HealthProfile();
                        hp.setHeight(randHeight);
                        hp.setWeight(randWeight);
                        hp.setDate(dateRandom);
                        hp.setPersonId(pId);
                        
                        hps.createHealthProfile(hp);
                        
                        
//                        stmt = c.createStatement();
//                        String INSERT_INTO_WEIGHT = "INSERT INTO healthprofile (person_id,weight,height,date,steps,calories)" +
//                                "VALUES ( "+ personId +", " + randWeight + ", " + randHeight + ", " + date.getTime() + "," + steps + "," + calories + ");";
//
//                        System.out.println(INSERT_INTO_WEIGHT);

//                        stmt.executeUpdate(INSERT_INTO_WEIGHT);
//                        stmt.close();
                        System.out.println("HealthProfile created successfully");
                    }
                  
//                    SQLiteJDBC.addPerson(firstName, lastName, birthDate, weight, height);

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
        return start + (int)Math.round(Math.random() * (end - start));
    }
    
    public static Double randBetween(Double start, Double end) {
    	return start + (end - start) * random.nextDouble();
    }
}