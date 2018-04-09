import java.util.Random;
import java.util.Scanner;

/**
 * b
 *
 * @see a
 */
public class b {

    /**
    * Entry point for program
    *
    * @param args Arguments passed to the program
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Get the user's input
        int choice;
        while (true) {
            // It must be an int
            if (in.hasNextInt()) {
                choice = in.nextInt();
                // And it must be odd
                if (choice % 2 == 0) {
                    System.out.println("Please enter an odd number");
                } else {
                    break;
                }
            } else {
                System.out.println("Please enter a number");
                in.next();
            }
        }
        // Finally, calculate the square and display it
        System.out.println("Should be true:");
        System.out.println(isValid(generateSquare(choice)));
        System.out.println("Should be false:");
        System.out.println(isValid(shuffle(generateSquare(choice))));
        printSquare(shuffle(generateSquare(choice)));
    }

    /**
     * Checks if the magic square is valid
     *
     * @param square The magic square that is besing checked
     *
     * @return Whether the magic square is valid
     */
    public static boolean isValid(int[][] square) {
        // Get the length of the sides
        int n = square.length;
        // The correct total if the square is magic
        int correctTotal = (n * ((n * n) + 1) / 2);
        // Whether the square is valid or not
        boolean isValid = true;
        int total;
        // Rows
        // For each row
        for (int[] row : square) {
            total = 0;
            for (int value : row) total += value;
            if (total != correctTotal) {
                isValid = false;
            }
        }

        // Columns
        // For column
        for (int i = 0; i < n; i++) {
            total = 0;
            // Get that column for each row
            for (int[] row : square) {
                // And add it to the total
                total += row[i];
            }
            if (total != correctTotal) {
                isValid = false;
            }
        }

        // Diagonal from origin
        total = 0;
        for (int x = 0; x < n; x++) {
                    total += square[x][x];
        }
        if (total != correctTotal) {
            isValid = false;
        }

        // Disgonal from opposite origin
        total = 0;
        for (int x = 0; x < n; x++) {
            total += square[n - x - 1][n - x - 1];
        }
        if (total != correctTotal) {
            isValid = false;
        }

        return isValid;
    }

    /**
     * Shuffles the magic square item by item n^2 times
     *
     * @param square The magic square
     *
     * @return The shuffled magic square
     */
    public static int[][] shuffle(int[][] square) {
        // Get the size of the square
        int n = square.length;
        // Shuffle it n^2 times
        for (int i = 0; i < n * n; i++) {
            // Create a new random generator
            Random r = new Random();
            // Get some random coordinates
            int x = r.nextInt(n);
            int y = r.nextInt(n);
            // Get a random direction
            int direction = r.nextInt(4);
            int temp;
            // Swap the values of the random location and the adjacent square of the specified direction
            // I don't need the normalize function for every set of coordinates however it is more readable if I always use it
            switch (direction) {
                case 0:
                temp = square[normalize(y, n)][normalize(x, n)];
                square[normalize(y, n)][normalize(x, n)] = square[normalize(y + 1, n)][normalize(x, n)];
                square[normalize(y + 1, n)][normalize(x, n)] = temp;
                break;
                case 1:
                temp = square[normalize(y, n)][normalize(x, n)];
                square[normalize(y, n)][normalize(x, n)] = square[normalize(y, n + 1)][normalize(x, n)];
                square[normalize(y, n + 1)][normalize(x, n)] = temp;
                break;
                case 2:
                temp = square[normalize(y, n)][normalize(x, n)];
                square[normalize(y, n)][normalize(x, n)] = square[normalize(y - 1, n)][normalize(x, n)];
                square[normalize(y - 1, n)][normalize(x, n)] = temp;
                break;
                case 3:
                temp = square[normalize(y, n)][normalize(x, n)];
                square[normalize(y, n)][normalize(x, n)] = square[normalize(y, n - 1)][normalize(x, n)];
                square[normalize(y, n - 1)][normalize(x, n)] = temp;
                break;
                default:
                break;
            }
        }
        // Return the shuffled square
        return square;
    }

    /**
    * Prints the magic square with correct formatting
    *
    * @param square The 2D array that represents the magic square
    */
    public static void printSquare(int[][] square) {
        // Get the longest number so that all of the numbers can be padded correctly
        int longest = 0;
        for (int[] row : square) {
            for (int value : row) {
                if (Integer.toString(value).length() > longest) {
                    longest = Integer.toString(value).length();
                }
            }
        }
        // Display the values
        for (int[] row : square) {
            for (int value : row) {
                // Get the value as a string
                String valueString = Integer.toString(value);
                // Build the padding so that the rows and columns are maintained
                StringBuilder padding = new StringBuilder();
                for (int i = 0; i < longest - valueString.length() + 1; i++) {
                    // For each character that the current number is shorter than the longest, add a space
                    padding.append(" ");
                }
                // Print the value
                System.out.print(padding.toString() + valueString);
            }
            // Add a new line at the end of each row
            System.out.println("");
        }
    }

    /**
    * Normalizes the input to prevent the index out of range error
    *
    * @param n The number to normalize
    * @param max The length of the array that n must be an index of
    *
    * @return The normalized value of {@code n}
    */
    public static int normalize(int n, int max) {
        while (n < 0) {
            // Make it positive
            n = n + max;
        }
        // If it is larger than max, make it not larger than max
        if (n >= max) {
            return n % max;
        } else {
            return n;
        }
    }

    /**
    * Generates a magic square such that all of the rows, columns, and diagonals sum to the same number
    *
    * @param n The size of the magic square
    *
    * @return The magic square
    */
    public static int[][] generateSquare(int n) {
        // Implement the algorithm
        int[][] square = new int[n][n];
        int x = 1;
        int y = (n + 1) / 2;
        square[normalize(y - 1, n)][normalize(x - 1, n)] = 1;
        for (int i = 2; i <= n * n; i++) {
            if (square[normalize(y - 1 - 1, n)][normalize(x - 1 - 1, n)] == 0) {
                x = x - 1;
                y = y - 1;
            } else {
                x = x + 1;
            }
            square[normalize(y - 1, n)][normalize(x - 1, n)] = i;
        }

        return square;
    }
}