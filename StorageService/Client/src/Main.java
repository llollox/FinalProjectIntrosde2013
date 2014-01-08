import it.unitn.sde.finalproject.*;

public class Main {
	
	public static void main(String[] args) {
		CRUDPerson cperson = new PersonService().getCRUD();
		Person p = cperson.readPerson(1);
		System.out.println(p.getFirstname() + " " + p.getLastname());
	}

}
