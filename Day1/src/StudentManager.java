import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private String grade;

    // Constructor
    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // toString method for displaying student details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}

// Main class
public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();

    // Add student
    public static void addStudent(int id, String name, String grade) {
        students.add(new Student(id, name, grade));
        System.out.println("Student added successfully!");
    }

    // Remove student by ID
    public static void removeStudent(int id) {
        boolean removed = false;
        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student removed successfully!");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    // Display all students
    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("----- Student List -----");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();
                    addStudent(id, name, grade);
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    int removeId = sc.nextInt();
                    removeStudent(removeId);
                    break;

                case 3:
                    displayStudents();
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
