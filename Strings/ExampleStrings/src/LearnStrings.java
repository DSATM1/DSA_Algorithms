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
    }

    public static void main(String[] args)
    {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
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
