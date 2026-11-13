public class StrAssignment
{
    // print odd index char both char and String
    // for Char Array
    static void getOddIdxCharArray()
    {
        char ch[] = {'S','U','R','A','J'};
//        char ch[] = {'s'}; // test case for 1 element
//        char ch[] = {}; // test case for empty array
        System.out.print("Char Array Odd Index \t: ");
        for(int odd = 0; odd < ch.length; odd++)
        {
            if(odd % 2 == 1)
            {
                System.out.print(ch[odd] + " ");
            }
        }
        System.out.println();
    }

    // for Strings
    static void getOddIdxStrings()
    {
        String name = "SURAJ";
        System.out.print("Odd Index using Strings : ");
        for(int odd = 0; odd < name.length(); odd++)
        {
            if(odd % 2 == 1)
            {
                System.out.print(name.charAt(odd) + " ");
            }
        }
        System.out.println();
    }

    // print ASCII value of digits from 0 - 9 both char and String
    // for char Array
    static void printAsciiCodeCharArray()
    {
        char ch[] = {'0','1','2','3','4','5','6','7','8','9'};

        System.out.print("ASCII Value of 0 - 9 in Char Array  : " );
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print((int) ch[i] + " ");
        }
        System.out.println();
    }

    // for Strings
    static void printAsciiCodeInStrings()
    {
        String num = "0123456789";

        System.out.print("ASCII Value of 0 - 9 in Strings \t: " );
        for(int i = 0; i < num.length(); i++)
        {
            System.out.print((int) num.charAt(i) + " ");
        }
        System.out.println();
    }

    // count vowels both char and String
    // for char Array
    static void countVowelsInCharArray()
    {
        char ch[] = {'S','U','R','A','J'};
//        char ch[] = {'a','e','i','o','w','a','x',0}; // test case
//        char ch[] = {}; // test case
        int count = 0;

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U'
            || ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
            {
                count++;
            }
        }
        System.out.print("Count of Vowels in the Char Array : " + count);
        System.out.println();
    }

    // for Strings
    static void countVowelsinStrings()
    {
        String name = "Suraj";
        int count = 0;

        for(int i = 0; i < name.length(); i++)
        {
            switch (name.charAt(i))
            {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
                    break;
            }
        }
        System.out.print("Count of Vowels in Strings \t\t  : " + count);
        System.out.println();
    }

    // count uppercase letters both char and String
    // for char array
    static void countUpperCaseInCharArray()
    {
        int count = 0;
        char ch[] = {'S','u','R','J','s','P'};
//        char ch[] = {'a','e','i','o'}; // test case
//        char ch[] = {'1','W','0','S',0,'a','O'}; // test case
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] >= 'A' && ch[i] <= 'Z')
            {
                count++;
            }
        }
        System.out.println("Count of Upper Case letters in char Array : " + count);
    }

    // for Strings
    static void countUpperCaseInStrings()
    {
        String name = "Suraj S P";
        int count  = 0;

        for(int i = 0; i < name.length(); i++)
        {
            if(name.charAt(i) >= 'A' && name.charAt(i) <='Z')
            {
                count++;
            }
        }
        System.out.println("Count of Upper Case letters in Strings \t  : " + count);

    }

    // count digits [1,A,2,C,B,D,0,1,Z] both char and String
    // for char arrays
    static void countDigitsInCharArray()
    {
        char ch[] = {'1','A','a','4','6','d','G','0','t'};
//        char ch[] = {'A','a',1,'0','o','2',9,'5',7,'1'}; // test case
//        char ch[] = {'0','9','a','Z',' ','5'}; // test case
        int count = 0;

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] >= '0' && ch[i] <= '9')
            {
               count++;
            }
        }
        System.out.println("Count of Digits in Char Array : " + count);
    }

    //for Strings
    static void countDigitsInStrings()
    {
        String dig = "123Su77raj456";
        int count = 0;

        for(int i = 0; i < dig.length(); i++)
        {
            if(dig.charAt(i) >= '0' && dig.charAt(i) <= '9')
            {
                count++;
            }
        }
        System.out.println("Count of Digits in Strings \t  : " + count);
    }

    static void main(String[] args)
    {
        getOddIdxCharArray();
        getOddIdxStrings();
        System.out.println();
        printAsciiCodeCharArray();
        printAsciiCodeInStrings();
        System.out.println();
        countVowelsInCharArray();
        countVowelsinStrings();
        System.out.println();
        countUpperCaseInCharArray();
        countUpperCaseInStrings();
        System.out.println();
        countDigitsInCharArray();
        countDigitsInStrings();
    }
}
