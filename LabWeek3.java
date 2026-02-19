import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Each operation is wrapped in a timer to calculate time to execute
        // Initialize variables used in time calculations
        long startTime;
        long endTime;
        long timeGenerate;
        long timeLoad;
        long timeRetrieveLatestSale;
        long timeCalculateTotalRevenue;
        long timeCheckDuplicateIds;
        long timeSearchForId;

        // Generate random CSV
        startTime = System.nanoTime();

        int size = 100;
        generateCsv(size);
        System.out.println("CSV file generated of size: " + size);

        endTime = System.nanoTime();
        timeGenerate = endTime - startTime;

        // Load data from generated file into an ArrayList
        startTime = System.nanoTime();

        ArrayList<Sale> sales = loadSalesData();

        endTime = System.nanoTime();
        timeLoad = endTime - startTime;

        // Output latest sale

        startTime = System.nanoTime();

        System.out.print("The latest sale is: " + getLatestSale(sales));

        endTime = System.nanoTime();
        timeRetrieveLatestSale = endTime - startTime;

        // Output total revenue
        startTime = System.nanoTime();

        System.out.println("The total revenue is: $" + getTotalRevenue(sales));

        endTime = System.nanoTime();
        timeCalculateTotalRevenue = endTime - startTime;

        // Check for duplicate ids (if they exist, output ID and indices in ArrayList)
        startTime = System.nanoTime();

        if(checkDuplicateId(sales)) {
            System.out.println("There are no duplicate ids!");
        } else if (!checkDuplicateId(sales)) {
            System.out.println("There is a duplicate id!");
        }

        endTime = System.nanoTime();
        timeCheckDuplicateIds = endTime - startTime;

        // Finds a specific sale by its id number
        startTime = System.nanoTime();

        int desiredSaleId = 99;
        System.out.println("The sale at id number " + desiredSaleId + " is: " + findSale(desiredSaleId, sales));

        endTime = System.nanoTime();
        timeSearchForId = endTime - startTime;

        /*
        System.out.println(sales.toString());  // Prints loaded sales data if desired
         */

        // Output the operation times for analysis
        System.out.println("Generating the CSV file took: " + timeGenerate + " ns");
        System.out.println("Loading sales data from the CSV file took: " + timeLoad + " ns");
        System.out.println("Retrieving the latest sale took: " + timeRetrieveLatestSale + " ns");
        System.out.println("Calculating the total revenue took: " + timeCalculateTotalRevenue + " ns");
        System.out.println("Checking for duplicate ids took: " + timeCheckDuplicateIds + " ns");
        System.out.println("Finding a specific sale id took: " + timeSearchForId + " ns");

    }

    static void generateCsv(int size){
        Random random = new Random();

            // BufferedWriter to write to a CSV files using random generation for ids, dates, etc.
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("data.csv"))) {
                for(int i = 0; i < size; i++) {

                    // generate random realistic date
                    int year = random.nextInt(2020, 2027);
                    int month = random.nextInt(1, 13);
                    int day;
                    if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 ||
                            month == 12) {
                        day = random.nextInt(1, 32);    // all 31 day months
                    } else if(month == 4 || month == 6 || month == 9 || month == 11) {
                        day = random.nextInt(1, 31);    // all 30 day months
                    } else {
                        day = random.nextInt(1, 29);    // february
                    }
                    String date = String.format("%04d-%02d-%02d", year, month, day);    // format date cleanly

                    // generate random realistic price
                    double num1 = random.nextDouble(100, 250);
                    String price = String.format("%.2f", num1);

                    // generate random product names (4 possible)
                    int num2 = random.nextInt(0, 4);
                    String productName;
                    if(num2 == 0) {
                        productName = "Product1";
                    } else if (num2 == 1) {
                        productName = "Product2";
                    } else if (num2 == 2) {
                        productName = "Product3";
                    } else {
                        productName = "Product4";
                    }

                    writer.write(i + "," + date + "," + price + "," + productName + "\n");
                }
            } catch(Exception e) {
                System.out.println("an error has occurred");
            }
    }

    static ArrayList<Sale> loadSalesData() {
        ArrayList<Sale> sales = new ArrayList<>();

        // BufferedReader to load data from CSV file
        // ArrayList of Sale objects (outlined in Sale.java) used to store these indexes for easy access later on
        try(BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while((line = reader.readLine()) != null) {
                // Creates array of data from CSV split by the commas (comma separated values)
                String[] columns = line.split(",");

                // parse methods used to modify data types for object creation
                int id = Integer.parseInt(columns[0]);
                LocalDate date = LocalDate.parse(columns[1]);
                double price = Double.parseDouble(columns[2]);
                String name = columns[3];
                
                Sale sale = new Sale(id, date, price, name);
                sales.add(sale);
            }
        } catch(Exception e) {
            System.out.println("an error has occurred");
        }

        return sales;
    }

    static Sale getLatestSale(ArrayList<Sale> sales) {
        // .getFirst gets the first index in an ArrayList (IDE recommendation over sales.get(0);)
        Sale latestSale = sales.getFirst();

        // Checks sale against each id to compare recency of dates
        for(Sale sale : sales) {
            if(sale.date.isAfter(latestSale.date)) {
                latestSale = sale;
            }
        }

        // Checks if multiple sales have the same most recent sale date
        for(Sale sale : sales) {
            if(sale.date.isEqual(latestSale.date) && sale.id != latestSale.id) {
                System.out.println("WARNING: Multiple Sales have the latest sale date!");
            }
        }

        return latestSale;
    }

    static double getTotalRevenue(ArrayList<Sale> sales) {
        double total = 0;

        // Simple loop to add the sale price of each sale to a total value
        for(Sale sale : sales) {
            total += sale.price;
        }

        return total;
    }

    static boolean checkDuplicateId(ArrayList<Sale> sales) {
        // Nested for loop checks for duplicate ids O(n^2) complexity
        // Returns false if duplicate is found, returns true if no duplicate is found
        for(int i = 0; i < sales.size(); i++) {
            int currentId = sales.get(i).id;
            for(int j = i + 1; j < sales.size(); j++) {
                if(currentId == sales.get(j).id) {
                    System.out.println("Duplicate Found: Id#" + currentId + " (indices " + i + " and " + j +")");
                    return false;
                }
            }
        }

        return true;
    }

    static String findSale(int id, ArrayList<Sale> sales) {

        // Simple search for a specific id number by comparing id integers
        for(Sale sale : sales) {
            if(id == sale.id) {
                return sale.toString();
            }
        }
        return null;
    }
}
