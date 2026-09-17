import java.util.*;

class Booking {
    int id;
    String name;
    String roomType;
    int days;
    double cost;

    Booking(int id, String name, String roomType, int days) {
        this.id = id;
        this.name = name;
        this.roomType = roomType;
        this.days = days;

        if (roomType.equalsIgnoreCase("Single")) {
            cost = days * 1000;
        } else if (roomType.equalsIgnoreCase("Double")) {
            cost = days * 1500;
        } else {
            cost = days * 2500;
        }
    }

    void display() {
        System.out.println("Booking ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Room Type: " + roomType);
        System.out.println("Days: " + days);
        System.out.println("Total Cost: ₹" + cost);
        System.out.println("----------------------");
    }
}

public class HotelBooking {

    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== HOTEL BOOKING SYSTEM =====");
            System.out.println("1. Add Booking");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBooking();
                    break;

                case 2:
                    cancelBooking();
                    break;

                case 3:
                    viewBookings();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addBooking() {

        System.out.print("Enter Booking ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Room Type (Single/Double/Suite): ");
        String room = sc.nextLine();

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        Booking b = new Booking(id, name, room, days);
        bookings.add(b);

        System.out.println("Booking added successfully!");
        System.out.println("Total Cost: ₹" + b.cost);
    }

    static void cancelBooking() {

        System.out.print("Enter Booking ID to cancel: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Booking b : bookings) {
            if (b.id == id) {
                bookings.remove(b);
                System.out.println("Booking cancelled successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found!");
        }
    }

    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }

        System.out.println("\n===== ALL BOOKINGS =====");

        for (Booking b : bookings) {
            b.display();
        }
    }
}
