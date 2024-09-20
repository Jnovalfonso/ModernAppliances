package Appliances;

import java.util.HashMap;

public class Dishwasher extends Appliance {
	
	protected String _feature;
	protected String _soundRating;
	
	public String getSoundRating() { 
		return _soundRating;
	}
	
	public final HashMap<String, String> SOUND_RATINGS = new HashMap<>();{
		SOUND_RATINGS.put("Qt","Quietest");
		SOUND_RATINGS.put("Qr","Quieter");
		SOUND_RATINGS.put("Qu","Quiet");
		SOUND_RATINGS.put("M","Moderate");
	}
	
	public Dishwasher(long itemNumber, String brand, int quantity, double wattage, String color, float price, String feature, String soundRating) {
        super(itemNumber, brand, quantity, wattage, color, price); 
        this._feature = feature;
        this._soundRating = soundRating;
    }
	
	@Override
	public String formatForFile() {
	    String baseFormat = super.formatForFile();
	    String dishFormat = String.join(";", baseFormat, _feature, _soundRating);

	    return dishFormat;
	}
	
	@Override 
	public String toString() {
		return  "Item Number: " + _itemNumber + "\n" +
                "Brand: " + _brand + "\n" +
                "Quantity: " + _quantity + "\n" +
                "Wattage: " + _wattage + "\n" +
                "Color: " + _color + "\n" +
                "Price: " + _price + "\n" +
                "Feature: " + _feature + "\n" +
                "Sound Rating: " + SOUND_RATINGS.get(_soundRating) + "\n";
	}
}
