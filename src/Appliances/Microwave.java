package Appliances;

public class Microwave extends Appliance {
    private float capacity;
    private char roomType;

    public static final char ROOM_TYPE_WORKSITE = 'W';
    public static final char ROOM_TYPE_KITCHEN = 'K';

    public Microwave(long itemNumber, String brand, int quantity, double wattage, String color, float price, float capacity, char roomType) {
        super(itemNumber, brand, quantity, wattage, color, price);
        this.capacity = capacity;
        this.roomType = roomType;
    }
    

    public String getRoomType() {
        return String.valueOf(roomType);
    }

    public String getRoomTypeDescription() {
        switch (roomType) {
            case ROOM_TYPE_WORKSITE:
                return "Work Site";
            case ROOM_TYPE_KITCHEN:
                return "Kitchen";
            default:
                return "Not a valid type of room";
        }
    }

    @Override
    public String formatForFile() {
        String baseFormat = super.formatForFile();
        String microFormat = String.join(";", baseFormat, String.valueOf(capacity), getRoomType());

	    return microFormat;
    }

    @Override
    public String toString() {
        return "Item Number: " + getItemNumber() + "\n" +
               "Brand: " + getBrand() + "\n" +
               "Quantity: " + getQuantity() + "\n" +
               "Wattage: " + getWattage() + "\n" +
               "Color: " + getColor() + "\n" +
               "Price: " + getPrice() + "\n" +
               "Capacity: " + capacity + "\n" +
               "Room Type: " + getRoomTypeDescription() + "\n";
    }

}

