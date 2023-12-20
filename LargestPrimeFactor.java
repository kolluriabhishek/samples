import java.util.Scanner;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //number 13195 : ans = 29
        long number = sc.nextInt(); // Replace this with your target number
        long largestPrimeFactor = findLargestPrimeFactor(number);
        System.out.println("Largest Prime Factor: " + largestPrimeFactor);
    }

    private static long findLargestPrimeFactor(long number) {
        long largestPrimeFactor = -1;

        // Divide the number by 2 until it is odd
        while (number % 2 == 0) {
            largestPrimeFactor = 2;
            number /= 2;
        }

        // Check odd numbers starting from 3
        for (long i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                largestPrimeFactor = i;
                number /= i;
            }
        }

        // If the remaining number is a prime greater than 2
        if (number > 2) {
            largestPrimeFactor = number;
        }

        return largestPrimeFactor;
    }
}
