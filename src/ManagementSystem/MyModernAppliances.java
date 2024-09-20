package ManagementSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Appliances.*;

public class MyModernAppliances extends ModernAppliances {
	
	public MyModernAppliances() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkout() {
		System.out.println("Enter the item number of an appliance: ");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		long itemNumber;
		
		try {
			itemNumber = Long.parseLong(input);
			
		} catch (NumberFormatException e){
			System.out.println("Invalid input. Please enter a valid number.");
			return;
		}
		
		System.out.println("Results for item #" + itemNumber);
		Appliance foundAppliance = null;
		
		for (Appliance appliance:appliances) {
			if (itemNumber == appliance.getItemNumber()) {
				foundAppliance = appliance;
				break;
			}
		}
		
		if (foundAppliance != null) {
            System.out.println(String.format("Checkout for appliance: %d - %s", foundAppliance.getItemNumber(), foundAppliance.getBrand()));

            if (foundAppliance.isAvailable()) {
                foundAppliance.checkout();
                System.out.println("The Appliance has been checked out!");
                System.out.println(String.format("Appliance Quantity: %d", foundAppliance.getQuantity()));
            }

        } else {
            System.out.println(String.format("The number: %d is not a valid item number.", itemNumber));
        }
        System.out.println();
	}
	
	@Override
	public void find() {
		Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the brand that you want to search for: ");
        String brandName = scanner.nextLine();
        brandName = toTitleCase(brandName);
        System.out.println("\n");

        List<Appliance> brandAppliances = new ArrayList<>();

        for (Appliance appliance : appliances) {
            if (appliance.getBrand().equals(brandName)) {
                brandAppliances.add(appliance);
            }
        }

        if (!brandAppliances.isEmpty()) {
            int totalAppliances = 1;
            for (Appliance brandAppliance : brandAppliances) {
                System.out.println(totalAppliances + ". " + brandAppliance.getItemNumber());
                System.out.println(brandAppliance + "\n");
                totalAppliances++;
            }
        } else {
            System.out.println("There are no appliances with the brand name: " + brandName);
        }

        System.out.println("\n");
	}
	
	@Override
	public void randomList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Appliance Types: \n0 - Any \n1 - Refrigerators \n2 - Vacuums \n3 - Microwaves \n4 - Dishwashers");
        System.out.println("Enter type of appliance:");
        String applianceType = scanner.nextLine();
        System.out.println("Enter number of appliances:");
        int applianceNum = Integer.parseInt(scanner.nextLine());

        List<Appliance> foundAppliances = new ArrayList<>();
        switch (applianceType) {
            case "0":
                foundAppliances = new ArrayList<>(appliances);
                break;
            case "1":
                for (Appliance appliance : appliances) {
                    if (appliance instanceof Refrigerator) {
                        foundAppliances.add(appliance);
                    }
                }
                break;
            case "2":
                for (Appliance appliance : appliances) {
                    if (appliance instanceof Vacuum) {
                        foundAppliances.add(appliance);
                    }
                }
                break;
            case "3":
                for (Appliance appliance : appliances) {
                    if (appliance instanceof Microwave) {
                        foundAppliances.add(appliance);
                    }
                }
                break;
            case "4":
                for (Appliance appliance : appliances) {
                    if (appliance instanceof Dishwasher) {
                        foundAppliances.add(appliance);
                    }
                }
                break;
        }

        List<Appliance> randomizedList = new RandomComparer().compare(foundAppliances);
        displayAppliancesFromList(randomizedList, applianceNum);
    }
	
	
	// DISPLAYS
	
	@Override
	public void displayRefrigerators() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Possible options: \n0 - Any \n2 - Double Doors \n3 - Three Doors \n4 - Four Doors");
        System.out.print("Enter number of doors: ");
        int doors = Integer.parseInt(scanner.nextLine());

        List<Appliance> found = new ArrayList<>();
        if (doors > 0) {
            for (Appliance appliance : appliances) {
                if (appliance instanceof Refrigerator) {
                    Refrigerator refrigerator = (Refrigerator) appliance;
                    if (refrigerator.getDoors() == doors) {
                        found.add(refrigerator);
                    }
                }
            }
        } else {
            for (Appliance appliance : appliances) {
                if (appliance instanceof Refrigerator) {
                    found.add(appliance);
                }
            }
        }

        displayAppliancesFromList(found);
    }

    // Method to display vacuums
	@Override
    public void displayVacuums() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Possible options: \n0 - Any\n1 - Residential\n2 - Commercial");
        System.out.print("Enter grade: ");
        String gradeInput = scanner.nextLine();
        String grade = null;
        switch (gradeInput) {
            case "0":
                grade = null;
                break;
            case "1":
                grade = "Residential";
                break;
            case "2":
                grade = "Commercial";
                break;
            default:
                System.out.println("Invalid input for grade");
                return;
        }

        System.out.println("Possible options: \n0 - Any\n1 - 18 Volt\n2 - 24 Volt");
        System.out.print("Enter voltage: ");
        String voltageInput = scanner.nextLine();
        short voltage = 0;
        switch (voltageInput) {
            case "0":
                voltage = 0;
                break;
            case "1":
                voltage = 18;
                break;
            case "2":
                voltage = 24;
                break;
            default:
                System.out.println("Invalid option for voltage");
                return;
        }

        List<Appliance> found = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Vacuum) {
                Vacuum vacuum = (Vacuum) appliance;
                boolean gradeCondition = grade == null || vacuum.getGrade().equals(grade);
                boolean voltageCondition = voltage == 0 || vacuum.getVoltage() == voltage;
                if (gradeCondition && voltageCondition) {
                    found.add(vacuum);
                }
            }
        }

        displayAppliancesFromList(found);
    }

    // Method to display microwaves
	@Override
    public void displayMicrowaves() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Possible options: \n0 - Any \n1 - Kitchen \n2 - Work site");
        System.out.print("Enter room type: ");
        String userInput = scanner.nextLine();
        char room;
        switch (userInput) {
            case "0":
                room = 'A';
                break;
            case "1":
                room = 'K';
                break;
            case "2":
                room = 'W';
                break;
            default:
                System.out.println("Invalid option.");
                displayMicrowaves();
                return;
        }

        List<Appliance> found = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Microwave) {
                Microwave microwave = (Microwave) appliance;
                if (room == 'A' || microwave.getRoomType() == String.valueOf(room)) {
                    found.add(microwave);
                }
            }
        }

        displayAppliancesFromList(found);
    }

    // Method to display dishwashers
    public void displayDishwashers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Possible options: \n0 - Any\n1 - Quietest\n2 - Quieter\n3 - Quiet\n4 - Moderate");
        System.out.print("Enter sound rating: ");
        String input = scanner.nextLine();
        String soundRating;
        switch (input) {
            case "0":
                soundRating = "Any";
                break;
            case "1":
                soundRating = "Qt";
                break;
            case "2":
                soundRating = "Qr";
                break;
            case "3":
                soundRating = "Qu";
                break;
            case "4":
                soundRating = "M";
                break;
            default:
                System.out.println("Invalid Option.");
                return;
        }

        List<Appliance> found = new ArrayList<>();
        for (Appliance appliance : appliances) {
            if (appliance instanceof Dishwasher) {
                Dishwasher dishwasher = (Dishwasher) appliance;
                if (soundRating.equals("Any") || dishwasher.getSoundRating().equals(soundRating)) {
                    found.add(dishwasher);
                }
            }
        }
        displayAppliancesFromList(found);
    }
  

	private String toTitleCase(String input) {
        String[] words = input.split("\\s");
        String titleCase = "";
        for (String word : words) {
            if (!word.isEmpty()) {
                titleCase +=(String.valueOf(Character.toUpperCase(word.charAt(0))))
                         +(word.substring(1).toLowerCase())
                         +" ";
            }
        }
        return titleCase.toString().trim();
    }
}
