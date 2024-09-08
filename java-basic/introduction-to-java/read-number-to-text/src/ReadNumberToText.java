import java.util.Scanner;

public class ReadNumberToText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your number: ");
        int number = scanner.nextInt();

        String result = "";
        int length = String.valueOf(Math.abs(number)).length();

        if (number >= 0 && length <= 3) {
            int hundred = number / 100;
            int tens = (number % 100) / 10;
            int units = number % 10;

            String textHundred = "";
            String textTens = "";
            String textUnits = "";

            switch (hundred) {
                case 1: textHundred = "one hundred"; break;
                case 2: textHundred = "two hundred"; break;
                case 3: textHundred = "three hundred"; break;
                case 4: textHundred = "four hundred"; break;
                case 5: textHundred = "five hundred"; break;
                case 6: textHundred = "six hundred"; break;
                case 7: textHundred = "seven hundred"; break;
                case 8: textHundred = "eight hundred"; break;
                case 9: textHundred = "nine hundred"; break;
            }

            if (tens == 1 && number % 100 >= 10) {
                switch (units) {
                    case 0: textUnits = "ten"; break;
                    case 1: textUnits = "eleven"; break;
                    case 2: textUnits = "twelve"; break;
                    case 3: textUnits = "thirteen"; break;
                    case 4: textUnits = "fourteen"; break;
                    case 5: textUnits = "fifteen"; break;
                    case 6: textUnits = "sixteen"; break;
                    case 7: textUnits = "seventeen"; break;
                    case 8: textUnits = "eighteen"; break;
                    case 9: textUnits = "nineteen"; break;
                }
                textTens = "";
            } else {
                switch (tens) {
                    case 2: textTens = "twenty"; break;
                    case 3: textTens = "thirty"; break;
                    case 4: textTens = "forty"; break;
                    case 5: textTens = "fifty"; break;
                    case 6: textTens = "sixty"; break;
                    case 7: textTens = "seventy"; break;
                    case 8: textTens = "eighty"; break;
                    case 9: textTens = "ninety"; break;
                }

                switch (units) {
                    case 1: textUnits = "one"; break;
                    case 2: textUnits = "two"; break;
                    case 3: textUnits = "three"; break;
                    case 4: textUnits = "four"; break;
                    case 5: textUnits = "five"; break;
                    case 6: textUnits = "six"; break;
                    case 7: textUnits = "seven"; break;
                    case 8: textUnits = "eight"; break;
                    case 9: textUnits = "nine"; break;
                }
            }

            if (number % 100 == 0) {
                textTens = "";
                textUnits = "";
            }

            result = textHundred + (textHundred.isEmpty() || textTens.isEmpty() ? "" : " ")
                     + textTens + (textTens.isEmpty() || textUnits.isEmpty() ? "" : " ")
                     + textUnits;

            System.out.println(result.trim());
        } else {
            System.out.println("Number " + number + " is invalid.");
        }

        scanner.close();
    }
}
