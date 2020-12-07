import java.util.Scanner;

public class CounterStrike__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int count = 0;


        String command = scanner.nextLine();

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", count, energy);
                break;
            }

            if (energy >= distance) {
                energy = energy - distance;
                count++;
                if (count % 3 == 0) {
                    energy += count;
                }
            }


            command = scanner.nextLine();
        }

        if (command.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", count, energy);
        }

    }
}
