import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();


        // 52 74 23 44 96 110
        // Shoot 5 10
        // Shoot 1 80
        // Strike 2 1
        // Add 22 3
        // End


        // 47 55 85 78 99 20
        // Shoot 1 55
        // Shoot 8 15
        // Strike 2 3
        // Add 0 22
        // Add 2 40
        // Add 2 50
        // End

        while (!command.equals("End")) {
            String[] operation = command.split(" ");

            switch (operation[0]) {

                case "Shoot":
                    int indexOne = Integer.parseInt(operation[1]);
                    int indexTwo = Integer.parseInt(operation[2]);

                    if (indexOne < targets.size() && indexOne >= 0) {
                        targets.set(indexOne, targets.get(indexOne) - indexTwo);
                        if (targets.get(indexOne) <= 0) {
                            targets.remove(indexOne);

                        }
                    }
                    break;

                case "Add":
                    int indexOneToAdd = Integer.parseInt(operation[1]);
                    int indexTwoToAdd = Integer.parseInt(operation[2]);


                    if (indexOneToAdd < targets.size() && indexOneToAdd >= 0) {
                        targets.add(indexOneToAdd, indexTwoToAdd);
                    } else {
                        System.out.println("Invalid placement!");
                        break;
                    }

                    break;

                case "Strike":
                    int indexToRemove = Integer.parseInt(operation[1]);
                    int radius = Integer.parseInt(operation[2]);

                    if ((indexToRemove - radius) >= 0 && (indexToRemove + radius < targets.size())) {

                        for (int i = 1; i <= radius; i++) {
                            targets.remove(indexToRemove - 1);
                            targets.remove(indexToRemove);
                            indexToRemove--;
                        }
                        targets.remove(indexToRemove);
                    } else {
                        System.out.println("Strike missed!");
                    }

                    break;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            if (targets.size() - 1 == i) {
                System.out.print(targets.get(targets.size() - 1));
                return;
            }
            System.out.printf("%d|", targets.get(i));
        }
    }
}
