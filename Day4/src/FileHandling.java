import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        String inputFile = "src/products.csv";         // input file
        String outputFile = "filtered_products.csv"; // output file

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                FileWriter writer = new FileWriter(outputFile);
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Split each line by comma
                String[] parts = line.split(",");

                if (parts.length == 2) { // only if line has name and price
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);

                    // Check condition: price > 1000
                    if (price > 1000) {
                        writer.write(name + "," + price + "\n");
                    }
                }
            }

            System.out.println("Filtered products written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
