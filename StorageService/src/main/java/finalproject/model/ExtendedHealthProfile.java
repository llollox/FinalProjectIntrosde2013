package finalproject.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import finalproject.utils.DoubleAdapter;

@XmlRootElement
public class ExtendedHealthProfile extends HealthProfile {

	private String bloodPressureLabel;
	private String bmiLabel;

	private Double idealWeight;
	private Double idealBmi;
	private Double bmi;
	private Double bmr;
	private Double idealKcal;
	private Double menagedWeightKcal;
	private Double targetHearthRate;

	private Integer age;

	public ExtendedHealthProfile() {
		super();
	}

	public ExtendedHealthProfile(HealthProfile hp) {

		setHeight(hp.getHeight());
		setWeight(hp.getWeight());
		setMinbloodpressure(hp.getMinbloodpressure());
		setMaxbloodpressure(hp.getMaxbloodpressure());
		setHeartrate(hp.getHeartrate());
		setDate(hp.getDate());
		setId(hp.getId());
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBloodPressureLabel() {
		return bloodPressureLabel;
	}

	public void setBloodPressureLabel(String bloodPressureLabel) {
		this.bloodPressureLabel = bloodPressureLabel;
	}

	public String getBmiLabel() {
		return bmiLabel;
	}

	public void setBmiLabel(String bmiLabel) {
		this.bmiLabel = bmiLabel;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getIdealWeight() {
		return idealWeight;
	}

	public void setIdealWeight(Double idealWeight) {
		this.idealWeight = idealWeight;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getIdealBmi() {
		return idealBmi;
	}

	public void setIdealBmi(Double idealBmi) {
		this.idealBmi = idealBmi;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getBmi() {
		return bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getBmr() {
		return bmr;
	}

	public void setBmr(Double bmr) {
		this.bmr = bmr;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getIdealKcal() {
		return idealKcal;
	}

	public void setIdealKcal(Double idealKcal) {
		this.idealKcal = idealKcal;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getMenagedWeightKcal() {
		return menagedWeightKcal;
	}

	public void setMenagedWeightKcal(Double menagedWeightKcal) {
		this.menagedWeightKcal = menagedWeightKcal;
	}

	@XmlJavaTypeAdapter(DoubleAdapter.class)
	public Double getTargetHearthRate() {
		return targetHearthRate;
	}

	public void setTargetHearthRate(Double targetHearthRate) {
		this.targetHearthRate = targetHearthRate;
	}

}
