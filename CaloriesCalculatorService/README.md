##Calories Calculator

This is a simple SOAP service that provide some calories calculation stuff.

####Documentation

* <b>GET IDEAL WEIGHT</b>
	
	@param height is the height of the person, you can pass both in meters or centimeters. 
	
	@return is a double that indicates ideal weight.
	
	```public double getIdealWeight(double height)``` 
	
	The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).