# EmployeeSorting (Java Collections & Comparator)

## 📌 Project Overview
This project demonstrates how to use **Java Collections** and **Comparator** to sort a list of employees by:
- Salary (Descending order)
- Name (Ascending order)

It also covers the use of:
- **String class** (`compareTo`)
- **Loops** (for-each loop for printing)
- **Conditional statements** (inside Comparator)
- **StringBuilder / toString** for easy display of employee details

---

## 🛠️ Technologies Used
- Java 8+
- Collections Framework
- Comparator Interface
- IntelliJ IDEA (IDE)

---

## 📂 Project Structure
├── .idea/ # IntelliJ IDEA project settings
├── .gitignore # Git ignore rules
├── misc.xml # IntelliJ config
├── modules.xml # IntelliJ config
├── src/
│ └── EmployeeSorting.java # Main program file
├── Day3.iml # IntelliJ project file
└── README.md # Project documentation



---

## 🚀 Features
1. Create an `Employee` class with fields: **name, age, salary**.
2. Store multiple employees in an `ArrayList`.
3. Sort employees by:
   - **Salary (descending)** using `Collections.sort()` and `Comparator`.
   - **Name (ascending)** using another `Comparator`.
4. Print results before and after sorting.

---

## 📖 Example Output
Original List:
Employee{name='Sohail', age=22, salary=35000.0}
Employee{name='Amit', age=25, salary=42000.0}
Employee{name='Rahul', age=28, salary=38000.0}
Employee{name='Priya', age=24, salary=42000.0}
Employee{name='Neha', age=23, salary=30000.0}

Sorted by Salary (Descending):
Employee{name='Amit', age=25, salary=42000.0}
Employee{name='Priya', age=24, salary=42000.0}
Employee{name='Rahul', age=28, salary=38000.0}
Employee{name='Sohail', age=22, salary=35000.0}
Employee{name='Neha', age=23, salary=30000.0}

Sorted by Name (Ascending):
Employee{name='Amit', age=25, salary=42000.0}
Employee{name='Neha', age=23, salary=30000.0}
Employee{name='Priya', age=24, salary=42000.0}
Employee{name='Rahul', age=28, salary=38000.0}
Employee{name='Sohail', age=22, salary=35000.0}



---

## 📬 Author
**MD Sohail Ansari**

