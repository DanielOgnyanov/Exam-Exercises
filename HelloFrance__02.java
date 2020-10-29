import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HelloFrance__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        double budget = Double.parseDouble(scanner.nextLine());
        double saved = budget;

        List<Double> numSaved = new ArrayList<>();

        double sum = 0;

        // Clothes->43.30|Shoes->25.25|Clothes->36.52|Clothes->20.90|Accessories->15.60

        for (int i = 0; i < items.size(); i++) {
            String[] operations = items.get(i).split("->");

            switch (operations[0]) {

                case "Clothes":
                    double priceClothes = Double.parseDouble(operations[1]);
                    if (priceClothes <= 50 && budget >= priceClothes) {
                        budget -= priceClothes;
                        sum += priceClothes;
                        numSaved.add(priceClothes);
                    }
                    break;

                case "Shoes":
                    double priceShoes = Double.parseDouble(operations[1]);
                    if (priceShoes <= 35 && budget >= priceShoes) {
                        budget -= priceShoes;
                        sum += priceShoes;
                        numSaved.add(priceShoes);
                    }
                    break;

                case "Accessories":
                    double priceAccessories = Double.parseDouble(operations[1]);
                    if (priceAccessories <= 20.50 && priceAccessories > 0 && budget >= priceAccessories) {
                        budget -= priceAccessories;
                        sum += priceAccessories;
                        numSaved.add(priceAccessories);
                    }
                    break;

            }
        }


        double profit = (sum * 1.40) + budget;

        for (int i = 0; i < numSaved.size(); i++) {
            double profitForSingle = numSaved.get(i) * 1.40;

            numSaved.set(i, profitForSingle);

            System.out.printf("%.2f ", numSaved.get(i));
        }
        System.out.println();

        System.out.printf("Profit: %.2f\n", profit - saved);
        if (profit < 150) {
            System.out.println("Time to go.");
        } else {
            System.out.println("Hello, France!");
        }


    }
}
