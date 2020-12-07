import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>  itemCollect = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        // Iron, Wood, Sword
        // Collect - Gold
        // Drop - Wood
        // Craft!

        // Iron, Sword
        // Drop - Bronze
        // Combine Items - Sword:Bow
        // Renew - Iron
        // Craft!

         String command = scanner.nextLine();

        while (!command.equals("Craft!")){

            String[] currentItem = command.split(" - ");

            switch (currentItem[0]){

                case "Collect":
                    if(itemCollect.contains(currentItem[1])){
                        break;
                    } else {
                        itemCollect.add(currentItem[1]);
                    }
                    break;

                case "Drop":
                    if(itemCollect.contains(currentItem[1])){
                        itemCollect.remove(currentItem[1]);
                    }
                    break;

                case "Combine Items":
                    String [] combine = currentItem[1].split(":");
                    if(itemCollect.contains(combine[0])){
                        itemCollect.add(itemCollect.indexOf(combine[0])+1,combine[1]);
                    }
                    break;

                case "Renew":
                    if(itemCollect.contains(currentItem[1])){
                        itemCollect.remove(currentItem[1]);
                        itemCollect.add(currentItem[1]);

                    }
                    break;

            }
            command = scanner.nextLine();

        }

        for (int i = 0; i < itemCollect.size() ; i++) {
            if(itemCollect.size()-1 == i){
                System.out.print(itemCollect.get(itemCollect.size()-1));
                return;
            }
            System.out.print(itemCollect.get(i)+", ");
        }
    }
}
