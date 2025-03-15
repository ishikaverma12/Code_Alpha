//Task 3

import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    double price;
    boolean isBooked;
    String customerName;

    Room(int roomNumber, String type, double price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }

    void bookRoom(String customerName) {
        if (!isBooked) {
            this.isBooked = true;
            this.customerName = customerName;
            System.out.println("Room " + roomNumber + " booked successfully for " + customerName);
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    void cancelBooking() {
        if (isBooked) {
            System.out.println("Booking cancelled for " + customerName);
            this.isBooked = false;
            this.customerName = "";
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    void showDetails() {
        String status = isBooked ? "Booked by " + customerName : "Available";
        System.out.println("Room " + roomNumber + " (" + type + ") - ₹" + price + " - " + status);
    }
}

public class task_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Room[] rooms = {
            new Room(1, "Single", 2000),
            new Room(2, "Double", 3500),
            new Room(3, "Deluxe", 5000),
            new Room(4, "Suite", 8000)
        };

        while (true) {
            System.out.println("\n1. Show Rooms\n2. Book Room\n3. Cancel Booking\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for (Room room : rooms) {
                        room.showDetails();
                    }
                    break;
                case 2:
                    System.out.print("Enter room number to book (1-4): ");
                    int roomNum = scanner.nextInt();
                    if (roomNum >= 1 && roomNum <= 4) {
                        System.out.print("Enter customer name: ");
                        String name = scanner.next();
                        rooms[roomNum - 1].bookRoom(name);
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to cancel booking (1-4): ");
                    int cancelRoom = scanner.nextInt();
                    if (cancelRoom >= 1 && cancelRoom <= 4) {
                        rooms[cancelRoom - 1].cancelBooking();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}