import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolLibrary__03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> books = Arrays.stream(scanner.nextLine().split("\\&"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();


        // Don Quixote&The Great Gatsby&Moby Dick&Hamlet
        // Add Book | The Odyssey
        // Take Book | Don Quixote
        // Insert Book | Alice's Adventure in Wonderland
        // Check Book | 3

        // Anna Karenina&Heart of Darkness&Catch-22& The Stranger
        // Add Book | David Copperfield
        // Add Book | One Thousand and One Nights
        // Swap Books | One Thousand and One Nights | Catch-22
        // Take Book | David Copperfield
        // Insert Book | The Stories of Anton Chekhov
        // Check Book | 17
        // Done

        String[] operations = command.split(" \\| ");




        while (!command.equals("Done")) {

            switch (operations[0]) {
                case "Add Book":
                    if (books.contains(operations[1])) {
                        operations = command.split(" \\| ");
                    } else {
                        books.add(0, operations[1]);
                    }
                    break;
                case "Take Book":
                    if (books.contains(operations[1])) {
                        books.remove(operations[1]);
                    }
                    break;
                case "Swap Books":
                    if (books.contains(operations[1]) && books.contains(operations[2])) {



                        Collections.swap(books,books.indexOf(operations[1]),books.indexOf(operations[2]));
                    }
                    break;
                case "Insert Book":
                    books.add(operations[1]);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(operations[1]);

                    if (index > books.size()) {
                        break;
                    } else {
                        books.get(index);
                        System.out.println(books.get(index));
                    }
                    break;
            }
            command = scanner.nextLine();
            operations = command.split(" \\| ");
        }


        if (command.equals("Done")) {

            for (int i = 0; i < books.size(); i++) {
                if (books.size()-1 == i){
                    System.out.print(books.get(books.size()-1));
                    return;
                }
                System.out.print(books.get(i)+ ", ");
            }
        }
    }
}
