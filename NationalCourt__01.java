import java.util.Scanner;

public class NationalCourt__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstWorker = Integer.parseInt(scanner.nextLine());
        int secondWorker = Integer.parseInt(scanner.nextLine());
        int thirdWorker = Integer.parseInt(scanner.nextLine());

        int people = Integer.parseInt(scanner.nextLine());

        int sum = firstWorker + secondWorker + thirdWorker;

        int count = 0;


        while (people != 0) {


            if (count % 4 == 0 && count != 0) {
                people = people;
                count++;
            } else {
                people = people - sum;
                count++;
            }

            if (count % 4 == 0 && count != 0) {
                people = people;
                count++;
            }

            if (people <= 0) {
                break;
            }


        }

        System.out.printf("Time needed: %dh.", count);
    }


}

