import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> houses = Arrays.stream(scanner.nextLine().split("@")).
                map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        // 10@10@10@2
        // Jump 1
        // Jump 2
        // Love!

        // 2@4@2
        // Jump 2
        // Jump 2
        // Jump 8
        // Jump 3
        // Jump 1
        // Love!

        int jump = 0;
        int count = 0;
        while (!command.equals("Love!")) {
            String[] operations = command.split(" ");

            switch (operations[0]) {
                case "Jump":
                    int len = Integer.parseInt(operations[1]);
                    jump += len;

                    if (jump >= houses.size()) {
                        jump = 0;

                    }


                    if (houses.get(jump) == 0) {
                        System.out.printf("Place %d already had Valentine's day.\n", jump);
                        break;
                    }

                    houses.set(jump, houses.get(jump) - 2);

                    if (houses.get(jump) == 0) {
                        count++;
                        System.out.printf("Place %d has Valentine's day.\n", jump);
                        break;
                    }


            }
            command = scanner.nextLine();
        }

        if (houses.size() != count) {
            System.out.printf("Cupid's last position was %d.\n", jump);
            System.out.printf("Cupid has failed %d places.", houses.size() - count);
        } else {
            System.out.printf("Cupid's last position was %d.\n", jump);
            System.out.println("Mission was successful.");
        }


    }
}
