import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).
                collect(Collectors.toList());

        // Congratulations! You last also through the have challenge!
        // Swap have last
        // Replace made have
        // Delete 2
        // Put it 4
        // Stop

        // This the my quest! final
        // Put is 2
        // Swap final quest!
        // Delete 2
        // Stop

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String[] operations = command.split(" ");

            switch (operations[0]) {

                case "Delete":
                    int numToDelete = Integer.parseInt(operations[1]);


                    if (numToDelete + 1 < words.size() && numToDelete + 1 >= 0) {
                        words.remove(numToDelete + 1);
                    }
                    break;

                case "Swap":

                    if (words.contains(operations[1]) && words.contains(operations[2])) {
                        Collections.swap(words, words.indexOf(operations[1]), words.indexOf(operations[2]));
                    }
                    break;

                case "Put":

                    int indexToPut = Integer.parseInt(operations[2]);


                    //   check !!!
                    if (indexToPut - 1 == words.size()) {
                        words.add(operations[1]);
                        break;
                    }

                    if (indexToPut - 1 < words.size() && indexToPut - 1 >= 0) {

                        words.add(indexToPut - 1, operations[1]);
                    }
                    break;

                case "Sort":
                    words.sort(Collections.reverseOrder());
                    break;

                case "Replace":

                    if (words.contains(operations[2])) {
                        words.set(words.indexOf(operations[2]), operations[1]);
                    }
                    break;

            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");
        }
    }
}
