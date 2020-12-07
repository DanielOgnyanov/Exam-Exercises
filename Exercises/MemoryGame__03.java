import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();
        // 1 1 2 2 3 3 4 4 5 5
        // a 2 4 a 2 4

        int count = 0;
        int countTryToWin = 0;


        while (!command.equals("end")) {
            String[] index = command.split("\\s+");


            int numAtIndex = Integer.parseInt(index[0]);
            int numTwoAtIndex = Integer.parseInt(index[1]);

            for (int i = 0; i < elements.size(); i++) {
                if (numAtIndex == numTwoAtIndex || numAtIndex < 0 || numTwoAtIndex < 0 || numAtIndex > elements.size()
                        || numTwoAtIndex > elements.size()) {
                    System.out.println("Invalid input! Adding additional elements to the board");
                    elements.add(elements.size() / 2, "-" + count + "a");
                    elements.add(elements.size() / 2 + 1, "-" + count + "a");
                    break;

                }
                if (elements.get(numAtIndex).equals(elements.get(numTwoAtIndex))) {
                    System.out.printf("Congrats! You have found matching elements - %s!\n", elements.get(numAtIndex));

                    if (numAtIndex > numTwoAtIndex) {
                        countTryToWin++;
                        elements.remove(numAtIndex);
                        count++;
                        elements.remove(numTwoAtIndex);
                        count++;
                        if (elements.isEmpty()) {
                            System.out.printf("You have won in %d turns!", count);
                            return;
                        }
                        break;
                    }
                    if (numTwoAtIndex > numAtIndex) {
                        countTryToWin++;
                        elements.remove(numTwoAtIndex);
                        count++;

                        elements.remove(numAtIndex);
                        count++;

                        if (elements.isEmpty()) {
                            System.out.printf("You have won in %d turns!", countTryToWin);
                            return;
                        }
                        break;

                    }


                } else if (!elements.get(numAtIndex).equals(elements.get(numTwoAtIndex))) {
                    System.out.println("Try again!");
                    break;

                }


            }


            command = scanner.nextLine();

        }

        if (command.equals("end")) {
            System.out.println("Sorry you lose :(");
            for (String element : elements) {
                System.out.print(element + " ");
            }


        }


    }
}
