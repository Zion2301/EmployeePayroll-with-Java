import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        EmployeeLogic people = new EmployeeLogic();

        while (true) {
            System.out.println("*******************************************");
            System.out.println("*                                         *");
            System.out.println("*   Welcome to the Employee Payroll Management   *");
            System.out.println("*                                         *");
            System.out.println("*******************************************");
            System.out.println();
            System.out.println("   1. ➤ Add Employee");
            System.out.println("   2. ➤ Select Employee");
            System.out.println("   3. ➤ Display ALL Employees");
            System.out.println("   4. ➤ Delete Employees");
            System.out.println("   5. ➤ Exit");
            System.out.println();
            System.out.println("*******************************************");
            System.out.println("*   Please select an option from 1 to 5   *");
            System.out.println("*******************************************");

            int choice = scan.nextInt();
            scan.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Enter FirstName, SurName, Age, and Status (Format: FirstName-Surname Age Status):");
                    String employee = scan.nextLine();

                    // Check if input is valid before adding it
                    if (isValidInput(employee)) {
                        people.addInfo(employee);

                        // Open the BufferedWriter here, add employee, and close it after writing
                        try (BufferedWriter writing = new BufferedWriter(new FileWriter("EmployeesFile.txt", true))) {
                            writing.write("\n" + employee);
                            writing.flush();
                        } catch (IOException e) {
                            System.out.println("Error writing to the file: " + e.getMessage());
                        }

                        System.out.println("Employee has been added");
                    } else {
                        System.out.println("Invalid input. Please enter all values in the correct format.");
                    }
                    break;

                case 2:
                    System.out.println("Enter ID to search");
                    int newid = scan.nextInt();
                    people.SelectInfo(newid);
                    System.out.println(people.SelectInfo(newid));
                    break;

                case 3:
                    people.displayInfo();
                    System.out.println(people.displayInfo());
                    break;

                case 4:
                    System.out.println("Enter ID to delete");
                    int delete = scan.nextInt();
                    people.deleteProduct(delete);
                    System.out.println("Successfully deleted");
                    break;

                case 5:
                    System.out.println("Exiting Now......");
                    scan.close();
                    return;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    public static boolean isValidInput(String input) {
        // Split input by spaces
        String[] parts = input.split(" ");

        // Check if it contains exactly 3 parts: "FirstName-Surname", "Age", and "Status"
        if (parts.length != 3) {
            return false;
        }

        // Split first part by dash to check for "FirstName-Surname"
        String[] nameParts = parts[0].split("-");
        if (nameParts.length != 2 || nameParts[0].isEmpty() || nameParts[1].isEmpty()) {
            return false;
        }

        // Check if the age is a valid integer
        try {
            Integer.parseInt(parts[1]); // Check if age is a valid number
        } catch (NumberFormatException e) {
            return false;
        }

        // Check if status is non-empty
        if (parts[2].isEmpty()) {
            return false;
        }

        return true;
    }
}
