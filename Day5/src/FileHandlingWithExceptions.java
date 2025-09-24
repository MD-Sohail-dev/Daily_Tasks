import java.io.*;

// Custom Exception for invalid data
class InvalidProductDataException extends Exception {
    public InvalidProductDataException(String message) {
        super(message);
    }
}

public class FileHandlingWithExceptions {
    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "filtered_products.csv";

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            // Try to open files
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new FileWriter(outputFile);

            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    // Split line
                    String[] parts = line.split(",");

                    if (parts.length != 2) {
                        throw new InvalidProductDataException("Invalid row format: " + line);
                    }

                    String name = parts[0].trim();
                    double price;

                    try {
                        price = Double.parseDouble(parts[1].trim());
                    } catch (NumberFormatException e) {
                        throw new InvalidProductDataException("Invalid price in row: " + line);
                    }

                    // Filter condition
                    if (price > 1000) {
                        writer.write(name + "," + price + "\n");
                    }

                } catch (InvalidProductDataException e) {
                    // Handle custom exception
                    System.err.println("Skipping row -> " + e.getMessage());
                }
            }

            System.out.println("Filtered products written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found (" + inputFile + ")");
        } catch (IOException e) {
            System.err.println("Error while reading/writing file: " + e.getMessage());
        } finally {
            // Ensure resources are closed safely
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error while closing resources: " + e.getMessage());
            }
        }
    }
}
