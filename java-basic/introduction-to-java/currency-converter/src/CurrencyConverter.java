import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your amount USD: ");
        float usd = scanner.nextFloat();

        int vnd = (int) (usd * 23000);

        System.out.println("Amount USD after converter to VND: " + vnd + "VND");
    }
}
