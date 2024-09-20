package Appliances;

public class Vacuum extends Appliance {
    private String grade;
    private double batteryVoltage;
    
    public String getGrade() {
    	return grade;
    }
    
    public double getVoltage() {
    	return batteryVoltage;
    }

    public Vacuum(long itemNumber, String brand, int quantity, double wattage, String color, float price, String grade, double batteryVoltage) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.grade = grade;
        this.batteryVoltage = batteryVoltage;
    }

    @Override
    public String formatForFile() {
        String baseFormat = super.formatForFile();
        return String.join(";", baseFormat, grade, String.valueOf(batteryVoltage));
    }

    @Override
    public String toString() {
        return "Item Number: " + getItemNumber() + "\n" +
               "Brand: " + getBrand() + "\n" +
               "Quantity: " + getQuantity() + "\n" +
               "Wattage: " + getWattage() + "\n" +
               "Color: " + getColor() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Grade: " + grade + "\n" +
               "Battery Voltage: " + batteryVoltage + "\n";
    }
}

