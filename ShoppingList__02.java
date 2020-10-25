import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split("\\!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        // Tomatoes!Potatoes!Bread

        // Milk!Pepper!Salt!Water!Banana
        // Urgent Salt
        // Unnecessary Grapes
        // Correct Pepper Onion
        // Rearrange Grapes
        // Correct Tomatoes Potatoes
        // Go Shopping!

        while (!command.equals("Go Shopping!")) {

            String[] operationToDo = command.split(" ");

            switch (operationToDo[0]) {
                case "Urgent":
                    if (items.contains(operationToDo[1])) {
                        break;
                    } else {
                        items.remove(operationToDo[1]);

                        items.add(0, operationToDo[1]);
                    }

                    break;

                case "Unnecessary":
                    if (items.contains(operationToDo[1])) {
                        items.remove(operationToDo[1]);
                    }
                    break;

                case "Correct":
                    if (items.contains(operationToDo[1])) {
                        items.set(items.indexOf(operationToDo[1]), operationToDo[2]);

                    }
                    break;

                case "Rearrange":
                    if (items.contains(operationToDo[1])) {
                        items.remove(operationToDo[1]);
                        items.add(operationToDo[1]);
                    }
                    break;

            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < items.size(); i++) {
            if (items.size() - 1 == i) {
                System.out.print(items.get(items.size() - 1));
                return;
            }
            System.out.print(items.get(i) + ", ");

        }
    }
}
