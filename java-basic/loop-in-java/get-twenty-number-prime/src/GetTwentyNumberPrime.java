import java.util.Scanner;

public class GetTwentyNumberPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter quantity get number prime: ");
        int qty = scanner.nextInt();

        for (int i = 0; i <= qty; i++) {
            if (i < 2) continue;

            int n = 2;
            boolean check = true;
            while (n <= Math.sqrt(i)) {
                if (i % n == 0) {
                    check = false;
                    break;
                }
                n++;
            }

            if (check) {
                System.out.println(i + " is a prime");
            }
        }
    }
}
