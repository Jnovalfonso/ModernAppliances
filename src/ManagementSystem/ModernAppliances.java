package ManagementSystem;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import Appliances.*;

public abstract class ModernAppliances {
	
	public String currentDirectory = System.getProperty("user.dir");
	public final String APPLIANCE_FILE_NAME = "src" + File.separator +"ManagementSystem" + File.separator + "appliances.txt";
	
	List<Appliance> appliances = new ArrayList<>();
	
	public ModernAppliances() throws IOException {
		this.appliances = this.readAppliances();
	}
	
	public void displayMenu() {
		System.out.println("Welcome to Modern Appliances!\n" +
                "How May We Assist You ?\n" +
                "1 – Check out appliance\n" +
                "2 – Find appliances by brand\n" +
                "3 – Display appliances by type\n" +
                "4 – Produce random appliance list\n" +
                "5 – Save & exit");
	}
	
	public abstract void checkout();
	public abstract void find();
	public abstract void displayRefrigerators();
	public abstract void displayVacuums();
	public abstract void displayMicrowaves();
	public abstract void displayDishwashers();
	public abstract void randomList();

	public void displayType() {
		System.out.println("Appliance Types\n" +
                "1 – Refrigerators\n" +
                "2 – Vacuums\n" +
                "3 – Microwaves\n" +
                "4 – Dishwashers");
		
		System.out.print("Enter type of appliance");
		
		Scanner scanner = new Scanner(System.in);
		int applianceTypeNum;
		String input = scanner.nextLine();
		
		try {
			applianceTypeNum = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			displayType();
			return;
		}
		
		switch (applianceTypeNum)
		{
		    case 1:
		        {
		            this.displayRefrigerators();
		            break;
		        }

		    case 2:
		        {
		            this.displayVacuums();
		            break;
		        }

		    case 3:
		        {
		            this.displayMicrowaves();
		            break;
		        }

		    case 4:
		        {
		            this.displayDishwashers();
		            break;
		        }

		    default:
		        {
		            System.out.println("Invalid appliance type entered.");
		            break;
		        }
		}
	}
	
	public void save() {
		String applianceFile = currentDirectory + File.separator + APPLIANCE_FILE_NAME;
		
		System.out.println("Saving the file...");
		
		try (FileWriter fileStream = new FileWriter(applianceFile)){
			for(Appliance appliance:appliances) {
				fileStream.write(appliance.formatForFile() + "\n");
			}
			System.out.println("File Saved.");
			
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IO exceptions
		}
	}
	
	private List<Appliance> readAppliances() throws IOException {
		String applianceFile = currentDirectory + File.separator + APPLIANCE_FILE_NAME;
		
		List<Appliance> fileAppliances = new ArrayList<Appliance>();
		List<String> lines = Files.readAllLines(Paths.get(applianceFile));
		
		for (String line:lines) {
			Appliance appliance = this.createApplianceFromLine(line);
			if (appliance != null) {
				fileAppliances.add(appliance);
			}
		}
		
		return fileAppliances;
	}
	
	private Appliance createApplianceFromLine (String line) {
		String[] applianceProperties = line.split(";");
		
		char firstDigit = line.charAt(0);
		Appliance appliance;
		
		switch (firstDigit) {
			case '1':
				//Refrigerator
				appliance = createRefrigerator(applianceProperties);
				return appliance;
		    case '2':
		        // Vacuum
		        appliance = createVacuum(applianceProperties);
		        break;
		    case '3':
		        // Microwave
		        appliance = createMicrowave(applianceProperties);
		        break;
		    case '4':
		    case '5':
		        // Dishwasher
		        appliance = createDishwasher(applianceProperties);
		        break;
		    default:
		        appliance = null;
		        break;
		}

		return appliance;	
		}

	private Refrigerator createRefrigerator(String[] properties) {
        if (properties.length == 9) {
            long itemNumber = Long.parseLong(properties[0]);
            String brand = properties[1];
            int quantity = Integer.parseInt(properties[2]);
            double wattage = Double.parseDouble(properties[3]);
            String color = properties[4];
            float price = Float.parseFloat(properties[5]); 
            short doors = Short.parseShort(properties[6]);
            int width = Integer.parseInt(properties[7]);
            int height = Integer.parseInt(properties[8]);

            // Create and return the Refrigerator instance
            return new Refrigerator(itemNumber, brand, quantity, wattage, color, price, doors, width, height);
        } else {
            System.out.println("Not a valid input to create an instance of 'Refrigerator' \n" + String.join(", ", properties));
            return null;
        }
    }

    private Vacuum createVacuum(String[] properties) {
        if (properties.length == 8) {
            long itemNumber = Long.parseLong(properties[0]);
            String brand = properties[1];
            int quantity = Integer.parseInt(properties[2]);
            double wattage = Double.parseDouble(properties[3]);
            String color = properties[4];
            float price = Float.parseFloat(properties[5]); 
            String grade = properties[6];
            short batteryVoltage = Short.parseShort(properties[7]);

            // Create and return the Vacuum instance
            return new Vacuum(itemNumber, brand, quantity, wattage, color, price, grade, batteryVoltage);
        } else {
            System.out.println("Not a valid input to create an instance of 'Vacuum' \n" + String.join(", ", properties));
            return null;
        }
    }

    private Microwave createMicrowave(String[] properties) {
        if (properties.length == 8) {
            long itemNumber = Long.parseLong(properties[0]);
            String brand = properties[1];
            int quantity = Integer.parseInt(properties[2]);
            double wattage = Double.parseDouble(properties[3]);
            String color = properties[4];
            float price = Float.parseFloat(properties[5]); 
            float capacity = Float.parseFloat(properties[6]);
            char roomType = properties[7].charAt(0);

            // Create and return the Microwave instance
            return new Microwave(itemNumber, brand, quantity, wattage, color, price, capacity, roomType);
        } else {
            System.out.println("Not a valid input to create an instance of 'Microwave' \n" + String.join(", ", properties));
            return null;
        }
    }

    private Dishwasher createDishwasher(String[] properties) {
        if (properties.length == 8) {
            long itemNumber = Long.parseLong(properties[0]);
            String brand = properties[1];
            int quantity = Integer.parseInt(properties[2]);
            double wattage = Double.parseDouble(properties[3]);
            String color = properties[4];
            float price = Float.parseFloat(properties[5]); 
            String feature = properties[6];
            String soundRating = properties[7];

            // Create and return the Dishwasher instance
            return new Dishwasher(itemNumber, brand, quantity, wattage, color, price, feature, soundRating);
        } else {
            System.out.println("Not a valid input to create an instance of 'Dishwasher' \n" + String.join(", ", properties));
            return null;
        }
    }
    
    public void displayAppliancesFromList(List<Appliance> appliances, int max) {
    	if (max < 1) {
    		System.out.println("No appliances found, number was less than 1");
    	}
    	
    	int count = Math.min(max, appliances.size());
        for (int i = 0; i < count; i++) {
            System.out.println(appliances.get(i));
        }
    }
    
    public void displayAppliancesFromList(List<Appliance> appliances) {
        // OVERLOADED METHOD WITHOUT MAX
    	displayAppliancesFromList(appliances, appliances.size());
    }
}
