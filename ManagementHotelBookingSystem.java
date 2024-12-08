import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Abstract class representing a hotel room
abstract class Room {
    private String name;
    private String description;
    private int price;

    public Room(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getDetails();

    public void displayRoom() {
        System.out.println("========================================" + name + "========================================");
        System.out.println(description + "\n");
        System.out.println("Room Details:");
        System.out.println(getDetails());
        System.out.println("Price Rate: $" + price + " per night\n");
    }
}

// Subclasses representing specific room types
class StandardRoom extends Room {
    public StandardRoom() {
        super("Standard Room", "Our Standard Room offers comfort and convenience.", 50);
    }

    @Override
    public String getDetails() {
        return "- Smart Television with Satellite Channels\n- High-Speed WiFi\n- Bathrooms\n- Closet\n- In-room Refrigerator\n- Individually Air-conditioning System\n- Coffee/Tea Maker";
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom() {
        super("Deluxe Room", "Welcome to our Deluxe Room, where elegance and comfort combine to provide you with a memorable stay.", 100);
    }

    @Override
    public String getDetails() {
        return "- Smart Television with Satellite Channels\n- High Speed Wifi\n- Coffee/Tea Maker\n- Individually Air-conditioning System\n- Hair Dryer\n- Bath Robe\n- In-room Refrigerator\n- Rain Shower/Bathtub\n- Electronic Safety locks\n- Personal Bar\n- Closet\n- Safety Deposit box\n- 76in x 80in King Bed size";
    }
}

class PresidentialSuite extends Room {
    public PresidentialSuite() {
        super("Presidential Suite", "Our Presidential Suite is the epitome of luxury, combining indulgence and unsurpassed comfort.", 150);
    }

    @Override
    public String getDetails() {
        return "- Smart Television with Satellite Channels\n- High Speed Wifi\n- Coffee/Tea Maker\n- Individually Air-conditioning System\n- Hair Dryer\n- Bath Robe\n- In-room Refrigerator\n- Rain Shower/Bathtub\n- Electronic Safety locks\n- Personal Bar\n- Closet\n- Safety Deposit box\n- Entertainment Room\n- And much more for the ultimate luxury experience.";
    }
}

// Class to represent a hotel and its operations
class Hotel {
    private String name;
    private String mobNumber;
    private int days;
    private int choice;
    private int cash;
    private int totalPrice;
    private int change;

    public int getChoice() {
        return choice;
    }
    
    public int getDays() {
        return days;
    }

    // Fields to store check-in and check-out date
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public void getInformation(Scanner scanner) {
        System.out.println("Book Processing...");
        System.out.println("");
        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        // Validate phone number
        while (true) {
            System.out.print("Enter your phone number: ");
            mobNumber = scanner.nextLine();

            if (mobNumber.matches("\\d+")) { // Regex to check if input contains only digits
                break;
            } else {
                System.out.println("Invalid phone number. Please enter digits only.");
            }
        }

        System.out.println("Enter your preferred date to check-in:");

        // Validate Date
        while (true) {
            try {
                System.out.print("Enter date in format YYYY-MM-DD: ");
                checkInDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            }
        }

        // Validate Days of Stay
        while (true) {
            System.out.print("How many days will you be staying (Min: 2, Max: 12): ");
            try {
                days = Integer.parseInt(scanner.nextLine());
                if (days >= 2 && days <= 12) break;
                else System.out.println("Invalid input. Please enter a number between 2 and 12.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Calculate the checkout date
        checkOutDate = checkInDate.plusDays(days);

        // Validate Room Choice
        while (true) {
            System.out.print("Enter the choice of room (1: Standard, 2: Deluxe, 3: Presidential): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) break;
                else System.out.println("Invalid input. Please enter a number between 1 and 3.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Payment
        System.out.print("Enter your payment: ");
        cash = scanner.nextInt();
    }

    public int calculateTotal(int days, Room room, Scanner scanner) {
        totalPrice = days * room.getPrice();
        System.out.println("Total: $" + totalPrice);

        // Loop until the cash entered is sufficient
        while (true) {
            System.out.println("Cash entered: $" + cash);
            if (cash < totalPrice) {
                System.out.println("Your cash is insufficient! Please enter a sufficient amount.");
                System.out.print("Enter your new payment: ");
                cash = scanner.nextInt();
            } else {
                change = cash - totalPrice;
                System.out.println("Your change is: $" + change);
                return change; // Return the change after sufficient cash is entered
            }
        }
    }

    public void displayInfo(Room room) {
        // Print the client's information only after valid payment
        System.out.println("========================================CLIENT'S INFORMATION========================================");
        System.out.println("Name: " + name);
        System.out.println("Mobile no.: " + mobNumber);
        System.out.println("Date of check-in: " + checkInDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println("Date of check-out: " + checkOutDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println("Days staying: " + days);
        System.out.println("Nights staying: " + (days - 1));
        System.out.println("Chosen room: " + room.getName());

        // Generate a random message to print below the information
        Random random = new Random();
        String[] messages = {
            "Enjoy your stay! We hope you have a memorable experience. See you!",
            "Welcome! Your comfort is our priority. Have a great stay! See you!",
            "Thank you! We wish you a relaxing time! See you!",
            "Your booking is confirmed! Enjoy your stay and let us know if you need anything! See you!",
            "Relax and unwind. Enjoy every moment of your stay! See you!"
        };

        int randomIndex = random.nextInt(messages.length);
        System.out.println("\n" + messages[randomIndex]);
    }
}

// Main Class
public class ManagementHotelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create room options
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new StandardRoom());
        rooms.add(new DeluxeRoom());
        rooms.add(new PresidentialSuite());

        System.out.println("Welcome to our Management Hotel Booking System! Press Enter to view more details.");
        scanner.nextLine(); // Pause

        // Display room details
        for (Room room : rooms) {
            room.displayRoom();
        }

        System.out.println("Would you like to proceed for due process? Press Enter if affirmative.");
        scanner.nextLine(); // Pause to proceed

        // Initialize hotel object and room selection
        Hotel hotel = new Hotel();
        hotel.getInformation(scanner);

        // Replace hotel.choice with hotel.getChoice()
    Room selectedRoom = null;
    switch (hotel.getChoice()) {
        case 1:
            selectedRoom = new StandardRoom();
            break;
        case 2:
            selectedRoom = new DeluxeRoom();
            break;
        case 3:
            selectedRoom = new PresidentialSuite();
            break;
        default:
            System.out.println("Invalid room choice. Exiting system.");
            System.exit(0);
}
    hotel.calculateTotal(hotel.getDays(), selectedRoom, scanner);


        // Display client information and finalize booking
        hotel.displayInfo(selectedRoom);

        System.out.println("Thank you for using our Management Hotel Booking System!");
        scanner.close();
    }
}


