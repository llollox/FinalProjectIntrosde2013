package finalproject.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import finalproject.utils.DatabaseUtil;

@Entity
@XmlRootElement
public class ActivityHistoryValue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "idactivityhistory")
	private ActivityHistory activityHistory;
	
	@ManyToOne
	@JoinColumn(name = "idvaluetype")
	private ActivityValueType valueType;
	
	public ActivityHistoryValue() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getActivityHistoryId() {
		if (activityHistory == null)
			return -1;
		return activityHistory.getId();
	}

	public void setActivityHistoryId(int activityHistoryId) {
		ActivityHistory a = ActivityHistory.read(activityHistoryId);
		if (a != null)
			this.activityHistory = a;
	}

	public int getValueTypeId() {
		if (valueType == null)
			return -1;
		return valueType.getId();
	}

	public void setValueTypeId(int id) {
		ActivityValueType a = ActivityValueType.read(id);
		if (a != null)
			this.valueType = a;
	}

	// ##########################################
	// # CRUD
	// ##########################################

	public static ActivityHistoryValue create(ActivityHistoryValue a) {
		// reset id
		a.setId(0);

		if (a.getValue() == null || ActivityHistory.read(a.getActivityHistoryId()) == null || ActivityValueType.read(a.getValueTypeId()) == null)
			return null;
		
		Activity activity = Activity.read(ActivityHistory.read(a.getActivityHistoryId()).getActivityId());
		ActivityValueType valuetype= ActivityValueType.read(a.getValueTypeId());
		
		if (!activity.getValuetypes().contains(valuetype))
			return null;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(a);
		tx.commit();

		em.close();
		return a;
	}

	public static ActivityHistoryValue read(int id) {
		EntityManager em = DatabaseUtil.createEntityManager();
		ActivityHistoryValue a = em.find(ActivityHistoryValue.class, id);
		em.close();
		return a;
	}

	public static ActivityHistoryValue update(ActivityHistoryValue a) {

		if (a.getId() <= 0)
			return null;

		if (a.getValue() == null || ActivityHistory.read(a.getActivityHistoryId()) == null || ActivityValueType.read(a.getValueTypeId()) == null)
			return null;
		
		Activity activity = Activity.read(ActivityHistory.read(a.getActivityHistoryId()).getActivityId());
		ActivityValueType valuetype= ActivityValueType.read(a.getValueTypeId());
		
		if (!activity.getValuetypes().contains(valuetype))
			return null;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		a = em.merge(a);
		tx.commit();
		em.close();

		return a;
	}

	public static boolean delete(int id) {
		ActivityHistoryValue a = read(id);

		if (a == null)
			return false;

		EntityManager em = DatabaseUtil.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		a = em.merge(a);
		em.remove(a);
		tx.commit();

		em.close();

		return true;
	}

}
