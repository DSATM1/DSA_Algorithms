public class ValidPassword
{
    //    Valid Password Check
    static boolean validPassword(char ch[])
    {
        if(ch == null)
        {
            return false;
        }
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecialCharacter = false;

        for (char c = 0; c < ch.length; c++)
        {
            if(ch[c] >= 'A' && ch[c] <= 'Z')
            {
                isUpperCase = true;
            }
            else if(ch[c] >= 'a' && ch[c] <= 'z')
            {
                isLowerCase = true;
            }
            else if(ch[c] >= '0' && ch[c] <= '9')
            {
                isDigit = true;
            }
            else
            {
                isSpecialCharacter = true;
            }
        }

        if(!isUpperCase)
        {
            System.out.println("Upper Case Not Found A - Z");
        }

        if(!isLowerCase)
        {
            System.out.println("Lower Case Not Found a -z ");
        }

        if(!isDigit)
        {
            System.out.println("Digit Not Found 0 - 9");
        }

        if(!isSpecialCharacter)
        {
            System.out.println("Special Character Not Found !@#$%^&*");
        }

        if(ch.length < 8)
        {
            System.out.println("Passsword Must be 8 Characters ");
        }

        return isUpperCase && isLowerCase && isDigit && isSpecialCharacter;
    }

    static void main(String[] args)
    {
        char ch[] = {'S','u','r','j','7','@','1','S','P'};

        if (validPassword(ch))
        {
            System.out.println("Valid Password");
        }
        else
        {
            System.out.println("Invalid Password");
        }
    }
}
