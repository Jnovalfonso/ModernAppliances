package Appliances;

public abstract class Appliance {
	
	public enum applianceTypes {
		APPLIANCE,RE,VA,MI,DI;
	}
	
	protected long _itemNumber;
	protected String _brand;
	protected int _quantity;
	protected double _wattage;
	protected String _color;
	protected float _price;
	
	public long getItemNumber() {
		return _itemNumber;
	}
	
	public String getBrand() {
        return _brand;
    }
	
    public int getQuantity() {
        return _quantity;
    }

    public double getWattage() {
        return _wattage;
    }

    public String getColor() {
        return _color;
    }

    public float getPrice() {
        return _price;
    }
	
    public boolean isAvailable() {
    	return _quantity > 0;
    }
    
    public void checkout() {
    	if (isAvailable()) {
    		_quantity -= 1;
    	}
    	else {
    		System.out.println("No Product Availability!");
    	}
    }
    
    public String formatForFile() {
    	return String.join(";", String.valueOf(_itemNumber), _brand, String.valueOf(_quantity), String.valueOf(_wattage), _color, String.valueOf(_price));
    }
    
    public Appliance (long itemNumber, String brand, int quantity, double wattage, String color, float price) {
    	_itemNumber = itemNumber;
    	_brand = brand;
    	_quantity = quantity;
    	_wattage = wattage;
    	_color = color;
    	_price = price;
    }
	
    public applianceTypes determineAppliance(long itemNumber) {
    	char firstDigit = String.valueOf(itemNumber).charAt(0);
    	
    	switch (firstDigit) {
    		case '1':
    			return applianceTypes.RE;
    		case '2':
    			return applianceTypes.VA;
    		case '3':
    			return applianceTypes.MI;
    		case '4':
    			return applianceTypes.DI;
    		default:
    			return applianceTypes.APPLIANCE;
    	}
    }
    
}
