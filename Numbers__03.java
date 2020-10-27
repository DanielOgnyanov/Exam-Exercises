import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Numbers__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        // 10 20 30 40 50
        // 5 2 3 4 -10 30 40 50 20 50 60 60 51
        // -1 -2 -3 -4 -5 -6

        if (numbers.size() == 1) {
            System.out.println("No");
            return;
        }


        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }


        double average = (sum * 1.0 / numbers.size() * 1.0);

        int equals = 0;
        int count = 5;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(0).equals(numbers.get(i))) {
                equals++;

            }
            if (equals == numbers.size()) {
                System.out.println("No");
                return;
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            numbers.sort(Collections.reverseOrder());
            if (average < numbers.get(i)) {
                if (count == i) {
                    break;
                }
                System.out.print(numbers.get(i) + " ");
            }


        }


    }
}