import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> gifts = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();


        // Eggs StuffedAnimal Cozonac Sweets EasterBunny Eggs Clothes
        // OutOfStock Eggs
        // Required Spoon 2
        // JustInCase ChocolateEggs
        // No Money

        // Sweets Cozonac Clothes Flowers Wine Clothes Eggs Clothes
        // Required Paper 8
        // OutOfStock Clothes
        // Required Chocolate 2
        // JustInCase Hat
        // OutOfStock Cable
        // No Money



        while (!command.equals("No Money")){
            String[] operations = command.split(" ");

            switch (operations[0]){
                case "OutOfStock":



                    for (int i = 0; i < gifts.size() ; i++) {
                        if(gifts.contains(operations[1])){
                            gifts.set(gifts.indexOf(operations[1]), "None");
                        }
                    }
                    break;

                case "Required":
                    int indexToChange = Integer.parseInt(operations[2]);
                    if(indexToChange < 0 || indexToChange >= gifts.size()){
                        break;
                    }

                    if(indexToChange < gifts.size()){
                        gifts.set(indexToChange,operations[1]);
                    } else {
                        break;
                    }
                    break;

                case "JustInCase":

                    gifts.set(gifts.size()-1, operations[1]);
                    break;


            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < gifts.size() ; i++) {
            if(gifts.contains("None")){
                gifts.remove("None");
            }
        }

        for (int i = 0; i < gifts.size() ; i++) {
            System.out.print(gifts.get(i) + " ");
        }
    }
}
