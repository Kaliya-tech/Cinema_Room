import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] str0 = input.split("[=&\\?]");

        String pass = "";

        for (int i = 1; i < str0.length; i++) {
            if (str0[i].contains("pass")) {
                pass = "password : " + str0[i + 1];
            }
            if (i == 0  || i % 2 != 0) {
                if (Objects.equals(str0[i + 1], "")) {
                    str0[i + 1] = "not found";
                }
                System.out.println(str0[i] + " : " + str0[i + 1]);
            }

        }
        System.out.println(pass);
    }
}