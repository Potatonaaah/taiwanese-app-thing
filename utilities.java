import java.util.*;


public class utilities {

	public Hashtable<String, Double> length = new Hashtable<String, Double>();
	public Hashtable<String, Double> volume = new Hashtable<String, Double>();

	
	
	public utilities(){
		length.put("inch", 39.3701);
		length.put("foot", 3.28084);
		length.put("yard", 1.09361);
		length.put("mile", 0.000539957);
		length.put("millimeter", 1000.0);
		length.put("centimeter", 100.0);
		length.put("meter", 1.0);
		length.put("kilometer", 1000.0);
		
		volume.put("milliliter", 1000.0);
		volume.put("liter", 1.0);
		volume.put("cubic meter", 0.001);
		volume.put("gallon", 0.264172);
		volume.put("quart", 1.05669);
		volume.put("pint", 2.11338);
		volume.put("cup", 4.16667);
		volume.put("ounce", 33.814);
		volume.put("cup", 67.628);
		volume.put("teaspoon", 202.884);
		
		
		
		
		
	}

	
	public double convertToYuan(double input) {
		return input*0.034;
	}
	
	public double convertToDollar(double input) {
		return input*29.33;
	}
	
	public double fToC(double input) {
		return (5.0/9.0)*(input-32);
	}
	
	public double cToF(double input) {
		return input*(9.0/5.0)+32;
	}
	
	public double  convertLength(String from, String to, double input) {//from  and to refers to string that describes unit , for example from = "inch", to = "kilometer"
		// available units: inch, foot, yard, mile, millimeter, centimeter, meter, kilometer
		
		input/=length.get(from);
		input*=length.get(to);
		return ((double)Math.round(input*100))/100;
	}
	
	public double  convertVolume(String from, String to, double input) {//from  and to refers to string that describes unit , for example from = "inch", to = "kilometer"
		// available units: inch, foot, yard, mile, millimeter, centimeter, meter, kilometer
				
		input/=volume.get(from);
		input*=volume.get(to);
		return ((double)Math.round(input*100))/100;
	}
}
