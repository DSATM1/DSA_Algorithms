import java.util.*;

public class UserInputDummy
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name : ");
        String name = sc.next();

        System.out.println("Enter your Age : ");
        int age = sc.nextInt();

        System.out.println("Hello " + name + " and You are " + age + " Years old ");


    }
}
