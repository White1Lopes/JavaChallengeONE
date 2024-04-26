import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        ExchangeRateService rateService = new ExchangeRateService();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        PrincipalMenu principalMenu = new PrincipalMenu();
        var currentCodes = Utils.currentCodes();

        var response = rateService.callApi();

        var responseSerialized = gson.fromJson(response.body(), ExchangeRateDto.class);

        System.out.println("Hello, welcome to the ExChange!");
        do {
            principalMenu.showFirstOptions();
            int userChoice = principalMenu.tryConvertUserChoiceToInt(reader);

            if (userChoice == 11) break;
            if (userChoice == 12) principalMenu.showConversionList();

            if (principalMenu.isValid(userChoice)) {
                int firstChoice = userChoice;
                do {
                    principalMenu.showSecondOptions();

                    userChoice = principalMenu.tryConvertUserChoiceToInt(reader);

                    if (userChoice == 11) break;

                    if (principalMenu.isValid(userChoice)) {
                        double value;
                        String firstCurrentCode = currentCodes.get(firstChoice);
                        String secondCurrentCode = currentCodes.get(userChoice);
                        System.out.println("Okay, now tell me the value to convert:");

                        do {
                            value = principalMenu.tryConvertUserChoiceToDouble(reader);
                        } while (value == 0);

                        var convertedFirstCurrentCode = Double.parseDouble(responseSerialized.conversion_rates().get(firstCurrentCode));
                        var convertedSecondCurrentCode = Double.parseDouble(responseSerialized.conversion_rates().get(secondCurrentCode));

                        var finalValue = ExchangeCalculator.calculateConversion(convertedFirstCurrentCode, convertedSecondCurrentCode, value);

                        var message = "Date: " + LocalDate.now() + " " + LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS) +
                                "\n" +"Base rate: " + firstCurrentCode + " - Value: " + String.format("%.4f", value) +
                                "\n" + "Conversion rate: "+ secondCurrentCode + " - Value: " + String.format("%.4f", finalValue);

                        System.out.println(message);
                        principalMenu.storeConversionRate(

                                message
                        );

                        break;
                    }
                } while (true);
            }
        } while (true);

        System.out.println("Check back often");
        System.out.println("Bye bye!");
    }
}
