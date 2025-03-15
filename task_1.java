//Task 1
import java.util.ArrayList;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        // Entering grades
        System.out.println("Enter student grades (Enter -1 to stop): ");
        while (true) {
            int grade = scanner.nextInt();
            if (grade == -1) break;
            grades.add(grade);
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
            return;
        }

        // Calculating average, highest, and lowest grade
        int sum = 0, highest = grades.get(0), lowest = grades.get(0);
        for (int grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }
        double average = (double) sum / grades.size();

        // Displaying results
        System.out.println("\nTotal Students: " + grades.size());
        System.out.println("Average Grade: " + average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);

        scanner.close();
    }
}
