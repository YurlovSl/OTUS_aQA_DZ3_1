package utils;

import java.util.Scanner;

public class ValidationNumber {
    private Scanner scanner = new Scanner(System.in);

    public int validateNumber(String line) {
        while (!scanner.hasNext("([1-9]|[1-2][1-9]){1,2}$")) {
            System.out.println("Допускается ввод только цифр от 1 до 29, повторите попытку");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
