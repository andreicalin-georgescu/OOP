import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Interface for a database
 */
interface Database {
    /**
     * Getter for dimension with which the database was initialized.
     * @return the size of the database
     */
    int getDimension();
    /**
     * Getter for the time with which the database was initialized
     * @return the number of days for which the database can be used
     */
    int getValidDays();
    /**
     * Adds data with the given dimension to the database - increases the amount of space used
     * in the database
     * @param dimension the size of the data to be added (in GB)
     * @return true if the data was added successfully or false if there was not enough space
     */
    boolean addData(int dimension);
}


/**
 * Factory class for the 3 types of available databases
 */
class DatabaseFactory {
    /**
     * Creates a database corresponding to the given amount of money.
     * @param money the amount of money available for a database
     * @return the corresponding database
     */
    public static Database getDatabase(int money) {
        // TODO
        if (money >= 10) {
            return new ExpensiveDatabase();
        } else if (money >= 4) {
            return new MediumDatabase();
        } else return new CheapDatabase();
    }
}

class CheapDatabase implements Database{
    private final int validDays = 7;
    private final int dimension = 5;
    private int used = 0;

    public int getUsed() {
        return used;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public int getValidDays() {
        return validDays;
    }

    @Override
    public boolean addData(int dimension) {
        if (dimension + this.getUsed() <= this.getDimension()) {
            used += dimension;
            return true;
        } else return false;
    }
}

class MediumDatabase implements Database{
    private final int validDays = 14;
    private final int dimension = 10;
    private int used = 0;

    public int getUsed() {
        return used;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public int getValidDays() {
        return validDays;
    }

    @Override
    public boolean addData(int dimension) {
        if (dimension + this.getUsed() <= this.getDimension()) {
            used += dimension;
            return true;
        } else return false;
    }
}

class ExpensiveDatabase implements Database{
    private final int validDays = 20;
    private final int dimension = 30;
    private int used = 0;

    public int getUsed() {
        return used;
    }

    @Override
    public int getDimension() {
        return dimension;
    }

    @Override
    public int getValidDays() {
        return validDays;
    }

    @Override
    public boolean addData(int dimension) {

        if (dimension + this.getUsed() <= this.getDimension()) {
            used += dimension;
            return true;
        } else return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Get the companies and the corresponding databases
        int N = s.nextInt();
        s.nextLine();

        // Map that stores the database for each company.
        // Key -> company name
        // Value -> corresponding Database object
        Map<String, Database> databases = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String line = s.nextLine();
            String[] data = line.split(" ");

            // data[0] -> company name; data[1] -> money for database

            // TODO: populate databases
            int money = Integer.parseInt(data[1]);
            databases.put(data[0], DatabaseFactory.getDatabase(money));
        }

        // Apply every action
        int M = s.nextInt();
        s.nextLine();

        for (int i = 0; i < M; i++) {
            String line = s.nextLine();
            String[] data = line.split(" ");

            // data[0] -> company name; data[1] -> dimension of data to add;
            // data[2] -> day in which to add

            int dimensionToAdd = Integer.parseInt(data[1]);
            int day = Integer.parseInt(data[2]);

            Database database = databases.get(data[0]);

            if( day > database.getValidDays()) {
                System.out.println("TimeError" + " " + data[0] + " " + day);
            } else {
                if (!database.addData(dimensionToAdd)) {
                    System.out.println("SpaceError" + " " + data[0] + " " + day);
                }
            }

            // TODO: show errors if necessary
        }

        s.close();
    }
}