import java.util.Scanner;

public class SoftUniReception__01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstWorker = Integer.parseInt(scanner.nextLine());
        int secondWorker = Integer.parseInt(scanner.nextLine());
        int thirdWorker = Integer.parseInt(scanner.nextLine());

        int student = Integer.parseInt(scanner.nextLine());

        int sum = firstWorker + secondWorker + thirdWorker;
        int count = 0;

        while (true) {
            if (student <= 0) {
                break;
            }

            student = student - sum;
            count++;
            if (count % 4 == 0) {
                student = student;
                count++;
            }


        }

        System.out.printf("Time needed: %dh.", count);
    }
}
