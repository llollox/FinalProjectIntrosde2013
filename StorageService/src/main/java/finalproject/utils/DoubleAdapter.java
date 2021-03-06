package finalproject.utils;

import java.text.DecimalFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String, Double> {

	private DecimalFormat decimalFormat = new DecimalFormat("###.##");

	@Override
	public String marshal(Double arg0) throws Exception {
		return decimalFormat.format(arg0);
	}

	@Override
	public Double unmarshal(String arg0) throws Exception {
		return decimalFormat.parse(arg0).doubleValue();
	}

}
