public class LearnStrings
{
    static void demo1()
    {
        char ch[] = new char[5];

        System.out.print("Demo 1 Declaration : ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print((int) ch[i] + " ");
        }
        System.out.println();
    }

    static void demo2()
    {
        char ch[] = {'S','u','r','a','j'};
        System.out.print("Demo 2 Init : ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] );
        }
        System.out.println();
    }

    static void demo3()
    {
        char ch[] = {'a','b','c','d'};
        System.out.println("Demo 3 Length : " + ch.length);
    }

    static void demo4()
    {
        char ch[] = {65,66 ,67,68};
        System.out.print("Demo 4 Print ASCII value : ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    static void demo5()
    {
        char ch[] = new char[5];
        ch[0] = 'A';
        ch[1] = 'B';

        System.out.print("Demo 5 Partial Creation : ");
        for(int i = 0; i < ch.length; i++)
        {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
    }

    static void demo6()
    {
        char ch = 'A';
        System.out.println("Demo 6 A -> B : " + (char)(ch + 1));

        ch = 'B';
        System.out.println("Demo 6 B -> A : " + (char)(ch - 1));
    }

    static void demo7()
    {
        char ch = 'A';
        System.out.println("Demo 7 A -> a : " + (char)(ch + 32));

        ch = 'a';
        System.out.println("Demo 7 a -> A : " + (char)(ch - 32));
    }

    static void demo8()
    {
        char ch = 'S';
        if(ch >= 'A' && ch <= 'Z')
        {
            System.out.println("Demo 7 check the case : " + ch + " Upper Case Letter ");
        }
        else
        {
            System.out.println("Demo 7 check the case : " + ch + " Lower Case Letter ");
        }
    }

    static char[] getEvenChar(char ch[])
    {
        for(int i = 0; i < ch.length; i++)
        {
            if(i % 2 == 0)
            {
                
            }
        }
        return ch;
    }

    static void printEvenChar()
    {
        char ch[] = {'J','A','V','A'};
        char res[] = getEvenChar(ch);

        for(int i = 0; i < res.length; i++)
        {
            System.out.print(res[i] + " ");
        }
    }

    static void stringDemo()
    {
        String name = "JAVA";

        for(int i = 0; i < name.length(); i++)
        {
            if(i % 2 == 0)
            {
                System.out.print(name.charAt(i) + " ");
            }
        }
        System.out.println();
    }

    // Print middle char if the str length is odd otherwise print 2 middle char

    static void printmiddleChar()
    {
        char ch[] = {'S','U','R','A','J'};

        if(ch.length % 2 == 1)
        {
            System.out.println("Middle : " + ch[ch.length/2]);
        }
        else
        {
            System.out.println("Middle 2 Ele : " + ch[ch.length/2 - 1] + " " + ch[ch.length/2]);
        }
    }

    // for Strings

    static void printStrMiddle()
    {
        String str = "JAVA";
        if(str.length() % 2 == 1)
        {
            System.out.println("Middle : " + str.charAt(str.length()/2));
        }
        else {
            System.out.println("Middle 2 Ele : " + str.charAt(str.length()/2 - 1) + " " + str.charAt(str.length()/2));
        }

    }

    public static void main(String[] args)
    {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();
//        demo8();
        printEvenChar();
//        stringDemo();
//        printmiddleChar();
//        printStrMiddle();
    }
}



// Task 1 = create char array size 5;
// don't init the values leave as it is
// print default values

// T2 = create and init the char Array
// print those char

// T3 = Find length of char array
// create and get the length

// T4 = Demonstrate ASCII values stored as characters
// char[] temp = { 65, 66 , 67, 68 };
//print temp[i]

// A - 65 Z - 90
// a - 97 z - 122
// 0 - 48 - 57 - 9

// Demonstrate Partial init
// declare array of size 5
// put values only int 0th and 1st index
// print {'a','b',0,0,0};

// Print Char at even index

// print odd index char both char and String
// print ASCII value of digits from 0 - 9 both char and String
// count vowels both char and String
// count uppercase letters both char and String
// count digits [1,A,2,C,B,D,0,1,Z] both char and String