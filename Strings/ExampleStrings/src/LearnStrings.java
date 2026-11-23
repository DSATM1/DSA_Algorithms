public class LearnStrings
{
    // Task 1 = create char array size 5;
    // don't init the values leave as it is
    // print default values
    public static void demo1() {
        char ch[] = new char[5];

        System.out.print("Demo 1 Declaration \t\t\t\t: ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print((int) ch[i] + " ");
        }
        System.out.println();
    }

    // T2 = create and init the char Array
    // print those char
    public static void demo2() {
        char ch[] = {'S','u','r','a','j'};
        System.out.print("Demo 2 Init \t\t\t\t\t: ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] );
        }
        System.out.println();
    }

    // T3 = Find length of char array
    // create and get the length
    public static void demo3() {
        char ch[] = {'a','b','c','d'};
        System.out.println("Demo 3 Length \t\t\t\t\t: " + ch.length);
    }

    // T4 = Demonstrate ASCII values stored as characters
    // char[] temp = { 65, 66 , 67, 68 };
    // print temp[i]
    public static void demo4() {
        char ch[] = {65,66 ,67,68};
        System.out.print("Demo 4 Print ASCII value Code   : ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    // Demonstrate Partial init
    public static void demo5() {
        char ch[] = new char[5];
        ch[0] = 'A';
        ch[1] = 'B';

        System.out.print("Demo 5 Partial Creation \t\t: ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    public static void demo6() {
        char ch = 'A';
        System.out.println("Demo 6 A -> B \t\t\t\t\t: " + (char)(ch + 1));

        ch = 'B';
        System.out.println("Demo 6 B -> A \t\t\t\t\t: " + (char)(ch - 1));
    }

    public static void demo7() {
        char ch = 'A';
        System.out.println("Demo 7 A -> a \t\t\t\t\t: " + (char)(ch + 32));

        ch = 'a';
        System.out.println("Demo 7 a -> A \t\t\t\t\t: " + (char)(ch - 32));
    }

    // A - 65 Z - 90
    // a - 97 z - 122
    // 0 - 48 - 57 - 9
    public static void demo8() {
        char ch = 'S';
        if(ch >= 'A' && ch <= 'Z')
        {
            System.out.println("Demo 8 check the case \t\t\t: " + ch + " is Upper Case Letter ");
        }
        else
        {
            System.out.println("Demo 8 check the case \t\t\t: " + ch + " is Lower Case Letter ");
        }
    }

    // Print Char at even index
    public static char[] getEvenChar(char ch[]) {
        if(ch.length == 0)
        {
            return new char[]{};
        }

        char c[] = new char[(ch.length + 1) / 2] ;

        int j = 0;
        for(int i = 0; i < ch.length; i++)
        {
            if(i % 2 == 0)
            {
                c[j] = ch[i];
                j++;
            }
        }
        return c;
    }

    public static void printEvenChar() {
        char ch[] = {'J','A','V','A'};
//        char[] ch = {'p', 'q', 'r', 's'};
//        char ch[] = {};

        char res[] = getEvenChar(ch);

        System.out.print("Demo 9 Even Character \t\t\t: ");
        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static void stringDemo() {
        String name = "JAVA";

        System.out.print("Demo 10 Even using Strings      : ");
        for(int i = 0; i < name.length(); i++)
        {
            if(i % 2 == 0)
            {
                System.out.print(name.charAt(i) + " ");
            }
        }
        System.out.println();
    }

    // Print middle char if the str length is odd
    // otherwise print 2 middle char
    public static void printmiddleChar() {
        char ch[] = {'S','U','R','A','J'};

        if(ch.length % 2 == 1)
        {
            System.out.println("Demo 11 Middle \t\t\t\t\t: " + ch[ch.length/2]);
        }
        else
        {
            System.out.println("Demo 11 Middle 2 Ele \t\t\t\t\t: " + ch[ch.length/2 - 1] + " " + ch[ch.length/2]);
        }
    }

    // for Strings
    public static void printStrMiddle() {
        String str = "JAVA";
        if(str.length() % 2 == 1)
        {
            System.out.println("Demo 12 Middle \t\t\t: " + str.charAt(str.length()/2));
        }
        else {
            System.out.println("Demo 12 Middle 2 Ele \t\t\t: " + str.charAt(str.length()/2 - 1) + " " + str.charAt(str.length()/2));
        }

    }

    public static void getCountSpecialChar() {
        char sc[] = {'s','@','!','o','0','%','5'};
        int count = 0;

        for(int i = 0; i < sc.length; i++)
        {
            if(!((sc[i] >= 'A' && sc[i] <= 'Z') ||
                    (sc[i] >= '0' && sc[i] <= '9') ||
                    (sc[i] >= 'a' && sc[i] <= 'z') ||
                    (sc[i] == ' ')))
            {
                count++;
            }
        }
        System.out.println("Count of Special Character \t\t: " + count);
    }

    public static void searchElementInChar() {
        char ch[] = {'S','U','R','A','J'};
        boolean isPresent = false;
        char key = 'U';

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == key)
            {
                isPresent = true;
            }
        }
        System.out.println("Search Element in Char Array    : " + isPresent);
    }

    public static void countOccurance() {
        char ch[] = {'S','U','R','A','J','S','P',' '};
        char key = ' ';
        int count = 0;

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == key)
            {
                count++;
            }
        }
        System.out.println("Count of Character Occurance    : " + count);
    }

    public static void getLargestElement() {
        char ch[] = {'S','U','R','A','J'};
        char large = ch[0];

        for(int i = 1; i < ch.length; i++)
        {
            if(ch[i] > large)
            {
                large = ch[i];
            }
        }
        System.out.println("Largest Element is \t\t\t\t: " + large);
    }

    public static void stringGetLarge() {
        String name = "Suraj";
        char largest = name.charAt(0);
        for(int i = 1; i < name.length(); i++)
        {
            if(name.charAt(i) > largest)
            {
                largest = name.charAt(i);
            }
        }
        System.out.println("Largest Element is \t\t\t\t: " + largest + " In String ");
    }

    public static void replaceVowelswithStar() {
        char ch [] = {'S','U','R','A','J'};

        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U'
                    || ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
            {
                ch[i] = '*';
            }
        }
        System.out.print("Vowels Replaced By * \t\t\t: ");
        System.out.println(ch);
    }

    public static void strReplaceVowel()  {
        String str = "Suraj";

        String res = "";

        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
                    || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                res = res + '*';
            }
            else
            {
                res = res + ch;
            }
        }
        System.out.print("Vowels Replaced By * in String  : ");
        System.out.println(res);

    }

    public static void countLastWordLength() {
        String s = "Hello World ";
        int count = 0;
        int index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == ' ')
        {
            index--;
        }

        while (index >= 0 && s.charAt(index) != ' ')
        {
            count++;
            index--;
        }
        System.out.println("Length of last Word \t\t\t: " + count);
    }

    public static void reverseCharArray() {
        char ch[] = {'L','e','t','\'','s',' ','C','o','d','e'};
//        char ch[] = {'S','U','R','A','J'};

        int start = 0;

        for(int end = 0; end <= ch.length ; end++)
        {
            if(end == ch.length || ch[end] == ' ')
            {
                int left = start;
                int right = end - 1;

                while(left < right)
                {
                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;

                    left++;
                    right--;
                }
                start = end + 1; // this is for next word
            }
        }

        System.out.print("Reversed Char Array \t\t\t: ");
        for(char c : ch)
        {
            System.out.print(c);
        }
    }

    public static void main(String[] args)
    {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
        demo7();
        demo8();
        printEvenChar();
        stringDemo();
        printmiddleChar();
        printStrMiddle();
        getCountSpecialChar();   // 1
        searchElementInChar();   // 2
        countOccurance();        // 3
        getLargestElement();     // 4
        stringGetLarge();        // 4 String
        replaceVowelswithStar(); // 5
        strReplaceVowel();       // 5
        countLastWordLength();   // leetcode - 58
        reverseCharArray();      // leetcode 557
    }
}


// input
// int maxWord = 0
// for loop i = 0; i < len; i++
// int words = 1;
// int j loop j = 0; j < ch[i].len ; j++ (2d array)
// if condition ch[i][j] == ' '
// maxword++;
// if(words > maxwrods)
// print words