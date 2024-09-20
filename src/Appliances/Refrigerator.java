package Appliances;

public class Refrigerator extends Appliance {
    private short doors;
    private int width;
    private int height;
    
    public short getDoors() {
		return doors;
	}

    public Refrigerator(long itemNumber, String brand, int quantity, double wattage, String color, float price, short doors, int width, int height) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.doors = doors;
        this.width = width;
        this.height = height;
    }

    @Override
    public String formatForFile() {
        String baseFormat = super.formatForFile();
        return String.join(";", baseFormat, String.valueOf(doors), String.valueOf(width), String.valueOf(height));
    }

    @Override
    public String toString() {
        return "Item Number: " + getItemNumber() + "\n" +
               "Brand: " + getBrand() + "\n" +
               "Quantity: " + getQuantity() + "\n" +
               "Wattage: " + getWattage() + "\n" +
               "Color: " + getColor() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Doors: " + doors + "\n" +
               "Width: " + width + "\n" +
               "Height: " + height + "\n";
    }

	
}

