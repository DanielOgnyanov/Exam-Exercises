import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 24 50 36 70

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String command = scanner.nextLine();
        int count = 0;


        while (!command.equals("End")) {
            int shots = Integer.parseInt(command);


            if (shots >= targets.size()) {

            }

            if (shots < targets.size()) {
                int current = targets.get(shots);

                if (targets.get(shots) == -1) {
                    command = scanner.nextLine();
                }


                targets.set(shots, -1);
                count++;
                for (int i = 0; i < targets.size(); i++) {

                    if (targets.get(i) != -1 && targets.get(i) > current) {
                        targets.set(i, targets.get(i) - current);
                    } else if (targets.get(i) != -1 && targets.get(i) <= current) {
                        targets.set(i, targets.get(i) + current);
                    }
                }
            }


            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", count);
        for (int i = 0; i < targets.size(); i++) {

            System.out.printf("%d ", targets.get(i));
        }


    }
}
