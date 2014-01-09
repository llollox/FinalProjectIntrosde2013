import it.unitn.sde.finalproject.*;

public class Main {

	public static void main(String[] args) {
		CRUDPerson cperson = new PersonService().getCRUD();
		Person p = cperson.readPerson(1);

		System.out.println(p.getFirstname());

		// p = new Person();
		// p.setFirstname("Pippo");
		// p.setLastname("Pluto");
		// p.setSex(1);
		// p.setBirthdate("2100-10-30");
		// System.out.println(cperson.createPerson(p));

	}

}
