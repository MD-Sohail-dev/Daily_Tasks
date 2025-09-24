# File Handling with Exception Handling in Java

## 📌 Author
**MD Sohail Ansari**

## 📖 Project Overview
This project demonstrates **File I/O in Java** with proper **Exception Handling**.  
It reads product data from a CSV file (`products.csv`), processes it, filters products based on price, and writes valid results into a new CSV file (`filtered_products.csv`).  

It also handles invalid data gracefully using **custom exceptions**.


---

## 📝 Input File: `products.csv`
The input file contains products with their names and prices (and optionally quantity).  
Example:

Laptop,55000
Mouse,500
Keyboard,1200
Monitor,9500
Pendrive,750
Chair,abc
OnlyName


- ✅ Valid rows will be parsed and processed.  
- ❌ Invalid rows (like missing fields or non-numeric prices) will throw a custom `InvalidProductDataException`.

---

## ⚙️ Features
- Uses **BufferedReader** to read data.
- Splits each line by `,` and parses values.
- Converts price to `double` and checks if price > **1000**.
- Uses **FileWriter** to write matching products into `filtered_products.csv`.
- Implements **try-catch-finally** for safe exception handling.
- Custom exception **InvalidProductDataException** for invalid rows.

---

## 🚀 How It Works
1. Reads product data from `products.csv`.
2. Tries to parse each line:
   - If valid → processes normally.
   - If invalid → throws and catches exceptions.
3. Writes products with price > **1000** into `filtered_products.csv`.
4. Closes all resources safely using `finally`.

---

## ✅ Example Output: `filtered_products.csv`
After running the program, the output file may look like this:
Laptop,55000.0
Keyboard,1200.0
Monitor,9500.0


---

## 🛠️ Exception Handling Demonstrated
- **FileNotFoundException** → if `products.csv` is missing.  
- **NumberFormatException** → if price is not a number (e.g., `Chair,abc`).  
- **InvalidProductDataException** → if row format is invalid (e.g., `OnlyName`).  
- **finally block** → ensures file resources are closed safely.

---



