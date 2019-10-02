package todo.app;

import java.util.Scanner;

public class UserInput
{
    public static void getInput(String args[])
    {
                Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("You entered string "+s);
        int a = in.nextInt();
        System.out.println("You entered integer "+a);
        float b = in.nextFloat();
        System.out.println("You entered float "+b);
    }
}
