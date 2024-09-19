package utils;

import java.util.Scanner;

public class ValidationLine {
    private Scanner scanner = new Scanner(System.in);


    public String validateLine() {
        while (!scanner.hasNext("\\D*$")) {
            System.out.println("Допускается ввод только символов, повторите попытку");
            scanner.next();
        }
        return scanner.next();
    }



}
