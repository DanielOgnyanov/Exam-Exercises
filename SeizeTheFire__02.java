import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeizeTheFire__02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> fires = Arrays.stream(scanner.nextLine().split("\\s+|#"))
                .collect(Collectors.toList());
        List<Integer> numSaved = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();


        // High = 89#Low = 28#Medium = 77#Low = 23
        // 1250
        // 2 4 6 8

        // High = 150#Low = 55#Medium = 86#Low = 40#High = 110#Medium = 77
        // 220


        int water = Integer.parseInt(scanner.nextLine());

        int totalFire = 0;

        double effort = 0;


        for (int i = 0; i < fires.size(); i++) {
            if (fires.get(i).equals("=")) {
                fires.remove(i);
            }
        }


        for (int i = 0; i < fires.size(); i++) {
            if (i % 2 == 0) {
                commands.add(fires.get(i));
            }
        }


        for (int i = 0; i < fires.size(); i++) {
            if (i % 2 == 1) {
                int num = Integer.parseInt(fires.get(i));
                numbers.add(num);
            }
        }

        int i = 0;
        while (i < commands.size()) {


            if (commands.get(i).equals("High")) {
                if (numbers.get(i) <= 125 && numbers.get(i) >= 81) {
                    if (numbers.get(i) > water) {
                        i++;
                        continue;
                    }

                    water -= numbers.get(i);

                    if (water < 0) {
                        break;
                    }
                    numSaved.add(numbers.get(i));
                    totalFire += numbers.get(i);
                    effort = effort + (numbers.get(i) * 1.0 / 4);
                }
            } else if (commands.get(i).equals("Medium")) {
                if (numbers.get(i) <= 80 && numbers.get(i) >= 51) {
                    if (numbers.get(i) > water) {
                        i++;
                        continue;
                    }

                    water -= numbers.get(i);

                    if (water < 0) {
                        break;
                    }
                    numSaved.add(numbers.get(i));
                    totalFire += numbers.get(i);
                    effort = effort + (numbers.get(i) * 1.0 / 4);

                }
            } else if (commands.get(i).equals("Low")) {
                if (numbers.get(i) <= 50 && numbers.get(i) >= 1) {
                    if (numbers.get(i) > water) {
                        i++;
                        continue;
                    }

                    water -= numbers.get(i);

                    if (water < 0) {
                        break;
                    }
                    numSaved.add(numbers.get(i));
                    totalFire += numbers.get(i);
                    effort = effort + (numbers.get(i) * 1.0 / 4);
                }
            }

            i++;
        }


        System.out.println("Cells:");
        for (int j = 0; j < numSaved.size(); j++) {
            System.out.printf("- %d\n", numSaved.get(j));
        }
        System.out.printf("Effort: %.2f\n", effort);
        System.out.printf("Total Fire: %d\n", totalFire);
    }
}
