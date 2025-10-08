import java.util.Scanner;

public class InputHandler {
    public static Scanner sc = new Scanner(System.in);

    public InputHandler() {
    }

    public static String getString() {
        return sc.nextLine();
    }

    //check that input is a number
    public static int getInt() {
        while(!sc.hasNextInt()) {
            System.out.println("wrong input,please try writing a number");
            sc.nextLine();
        }
        int result = sc.nextInt();
        sc.nextLine();
        return result;
    }

    //check that input is in range
    public static int getInt(int min, int max) {
        while(true) {
            int input = getInt();
            if (input >= min && input <= max) {
                return input;
            }
            System.out.println("Wrong input write a number " + min + "-" + max);
        }
    }
}
