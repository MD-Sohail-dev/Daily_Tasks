import java.util.*;

// Step 1: Create Employee class
class Employee {
    String name;
    int age;
    double salary;

    // Step 2: Constructor
    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // toString() for easy display
    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        // Step 3: Store multiple employees in ArrayList
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sohail", 22, 35000));
        employees.add(new Employee("Amit", 25, 42000));
        employees.add(new Employee("Rahul", 28, 38000));
        employees.add(new Employee("Priya", 24, 42000));
        employees.add(new Employee("Neha", 23, 30000));

        System.out.println("Original List:");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Step 4: Sort by salary (descending)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                // Descending => compare second - first
                return Double.compare(e2.salary, e1.salary);
            }
        });

        System.out.println("\nSorted by Salary (Descending):");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // Step 5: Sort by name (ascending)
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.name.compareTo(e2.name); // Ascending order
            }
        });

        System.out.println("\nSorted by Name (Ascending):");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
