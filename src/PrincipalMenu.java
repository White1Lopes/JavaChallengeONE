import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalMenu {
    private final ArrayList<String> conversionLists = new ArrayList<>();

    public void showFirstOptions() {
        System.out.println("Please, select a option/number base:");
        listCodes();
        System.out.println("11) Leave");
        System.out.println("12) Show the most five recent conversions");
    }

    public void showSecondOptions() {
        System.out.println("Please, select a option/number to convert:");
        listCodes();
        System.out.println("11) Turn back!");
    }

    public boolean isValid(int choice) {
        return choice >= 1 && choice <= 10;
    }

    public int tryConvertUserChoiceToInt(Scanner scanner) {
        int userChoice = 0;
        try {
            userChoice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please, select one of the numbers available");
            scanner.nextLine();
        }

        return userChoice;
    }

    public double tryConvertUserChoiceToDouble(Scanner scanner) {
        double userChoice = 0;
        try {
            userChoice = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Please, text a number.");
            scanner.nextLine();
        }

        return userChoice;
    }

    public void storeConversionRate(String text) {
        if (conversionLists.size() >= 5) conversionLists.remove(0);

        conversionLists.add(text);
    }

    public void showConversionList() {
        for (int i = 0; i < conversionLists.size(); i++) {
            System.out.println("----------------" + i + "------------------");
            System.out.println(conversionLists.get(i));
        }
        System.out.println("-----------------------------------");
    }

    private void listCodes()
    {
        System.out.println("1) United States Dollar");
        System.out.println("2) Argentine Peso");
        System.out.println("3) Colombian peso");
        System.out.println("4) Bolivian Bolivian");
        System.out.println("5) Brazilian real");
        System.out.println("6) Chilean peso");
        System.out.println("7) Canadian Dollar");
        System.out.println("8) Chinese Renminbi");
        System.out.println("9) Euro");
        System.out.println("10) Japanese Yen");
    }
}
