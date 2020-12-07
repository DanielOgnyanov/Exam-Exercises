import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> values = Arrays.stream(scanner.nextLine().split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());


        String command = scanner.nextLine();

        // 23 -2 321 87 42 90 -123
        // swap 1 3
        // swap 3 6
        // swap 1 0
        // multiply 1 2
        // multiply 2 1
        // decrease
        // end

        // 1 2 3 4
        // swap 0 1
        // swap 1 2
        // swap 2 3
        // multiply 1 2
        // decrease
        // end

        while (!command.equals("end")) {

            String[] operation = command.split(" ");

            switch (operation[0]) {

                case "swap":

                    int firstElementToSwap = Integer.parseInt(operation[1]);
                    int secondElementToSwap = Integer.parseInt(operation[2]);

                    Collections.swap(values, firstElementToSwap, secondElementToSwap);
                    break;

                case "multiply":

                    int firstMultiply = Integer.parseInt(operation[1]);
                    int secondMultiply = Integer.parseInt(operation[2]);

                    int calc = values.get(firstMultiply) * values.get(secondMultiply);

                    values.set(firstMultiply, calc);
                    break;

                case "decrease":

                    for (int i = 0; i < values.size(); i++) {
                        int decrease = values.get(i) - 1;
                        values.set(i, decrease);
                    }
                    break;
            }
            command = scanner.nextLine();

        }

        for (int i = 0; i < values.size(); i++) {
            if (values.size() - 1 == i) {
                System.out.print(values.get(values.size() - 1));
                return;
            }
            System.out.print(values.get(i) + ", ");

        }


    }
}
