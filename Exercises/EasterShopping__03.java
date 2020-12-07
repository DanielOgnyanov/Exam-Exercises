import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterShopping__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shops = Arrays.stream(scanner.nextLine().split(" ")).
                collect(Collectors.toList());

        int numberCommand = Integer.parseInt(scanner.nextLine());


        // Bershka CandyStore ThriftShop Armani Groceries ToyStore PeakStore
        // Include HM
        // Visit first 2
        // Visit last 1
        // Prefer 3 1
        // Place Library 2

        // Boutique Flowers CandyStore ThriftShop Versace Groceries ToyStore PeakStore
        // 6
        // Visit first 9
        // Visit last 4
        // Prefer 3 8
        // Prefer 0 1
        // Place Store 7
        // Place ShoeAquarium 2


        int countVisitOne = 0;
        int countVisitTwo = 0;

        for (int i = 0; i < numberCommand; i++) {
            String command = scanner.nextLine();
            String[] operations = command.split(" ");


            switch (operations[0]) {

                case "Include":
                    shops.add(operations[1]);
                    break;

                case "Visit":
                    int index = Integer.parseInt(operations[2]);


                    if (index <= shops.size() && index >= 0) {
                        if (operations[1].equals("first")) {
                            for (int j = 0; j < index; j++) {
                                shops.remove(j);
                                countVisitOne++;
                                if (countVisitOne == index) {
                                    break;
                                }
                                j--;
                            }
                        }

                        if (operations[1].equals("last")) {
                            for (int j = shops.size() - 1; j >= 0; j--) {
                                shops.remove(j);

                                countVisitTwo++;
                                if (countVisitTwo == index) {
                                    break;
                                }

                            }
                        }

                    }


                    break;

                case "Prefer":
                    int firstIndex = Integer.parseInt(operations[1]);
                    int secondIndex = Integer.parseInt(operations[2]);


                    if (firstIndex < shops.size() && firstIndex >= 0 &&
                            secondIndex < shops.size() && secondIndex >= 0) {
                        Collections.swap(shops, secondIndex, firstIndex);
                    }

                    break;

                case "Place":
                    int indexToInsert = Integer.parseInt(operations[2]);


                    if (indexToInsert + 1 < shops.size() && indexToInsert + 1 >= 0) {
                        shops.add(indexToInsert + 1, operations[1]);
                    }


                    break;
            }


        }

        System.out.println("Shops left:");
        for (int i = 0; i < shops.size(); i++) {
            System.out.print(shops.get(i) + " ");
        }
    }
}
