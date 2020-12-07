import java.util.*;
import java.util.stream.Collectors;

public class LastStop__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        // 115 115 101 114 73 111 116 75
        String command = scanner.nextLine();


        while (!command.equals("END")) {
            String[] operations = command.split(" ");

            switch (operations[0]) {

                case "Change":
                    if (elements.contains(operations[1])) {
                        elements.set(elements.indexOf(operations[1]), operations[2]);

                    }
                    break;

                case "Hide":
                    if (elements.contains(operations[1])) {
                        elements.remove(elements.indexOf(operations[1]));
                    }
                    break;
                case "Switch":
                    if (elements.contains(operations[1]) && elements.contains(operations[2])) {
                        Collections.swap(elements, elements.indexOf(operations[1]), elements.indexOf(operations[2]));
                    }
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(operations[1]);

                    if (indexToInsert + 1 < elements.size() && indexToInsert + 1 >= 0 && indexToInsert < elements.size()
                            && indexToInsert >= 0) {
                        elements.add(indexToInsert + 1, operations[2]);
                    }
                    break;

                case "Reverse":
                    Collections.reverse(elements);
                    break;
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < elements.size(); i++) {
            System.out.print(elements.get(i) + " ");

        }
    }
}
