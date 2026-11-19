public class StringsmethodJava
{
    public static void trimMethod()
    {
        String name = "   Suraj S P    ";
        System.out.println(name.trim());
        System.out.println();
    }

    public static void splitMethod()
    {
        String name = "Suraj S P";
        String hesaru[] = name.split(" ");
        for (String f : hesaru )
            System.out.print(f);
        System.out.println();
        System.out.println();
    }

    static void isEmptyMethod()
    {
        String str1 = "";
        String str2 = " ";
        String str3 = "Java";

        System.out.println(str1.isEmpty());
        System.out.println(str2.isEmpty());
        System.out.println(str3.isEmpty());
        System.out.println();
    }

    static void subStringMethod()
    {
        String sent = "Programming";
        System.out.println(sent.substring(2)); // n - 1 only 0 1 not inlcuded 2
        System.out.println(sent.substring(0,3)); // SubString Begin and End
        System.out.println();
    }

    public static void indexMethods()
    {
        String address = "www.Google.com";
        System.out.println(address.indexOf("."));
        System.out.println(address.lastIndexOf(".",4));
        System.out.println();
    }

    // join "Good" and "Morinig" using concat()
    public static void concateMethod()
    {
        String str1 = "Good ";
        String str2 = "Morning";
        System.out.println("Concatination : " + str1.concat(str2));
    }

    // print java 5 times using repeat()
    public static void repeatMethod()
    {
        String name = "Java ";
        System.out.println("5 times : " + name.repeat(5));
        System.out.println();
    }

    // convert integer 12345 to string using valueof
    public static void valueOfMethod()
    {
        int num = 12345;
        System.out.println((String.valueOf(num)));
        System.out.println();
    }

    // check if "", " " ,"Hello" are blank ?
    public static void blankMethod()
    {
        String str1 = "";
        String str2 = " ";
        String str3= "Hello";
        System.out.println(str1.isBlank());
        System.out.println(str2.isBlank());
        System.out.println(str3.isBlank());
        System.out.println();
    }

    // replace only the first "is" in "Java is Easy. Java is crazy, Java is Powerful" using replace()
    public static void replaceFirstMethod()
    {
        String sent = "Java is Easy. Java is crazy, Java is Powerful";
        System.out.println(sent.replaceFirst("is",""));
    }


    static void main(String[] args)
    {
        trimMethod();
        splitMethod();
        isEmptyMethod();
        subStringMethod();
        indexMethods();
        concateMethod();
        repeatMethod();
        valueOfMethod();
        blankMethod();
        replaceFirstMethod();
    }
}


// startwith() --> Boolean
// endwith() --> Boolean
// indexof() --> int
// lastIndexOf() --> int
// valueOf(int i) -- > converts any value float, double, long

// Explore by your own which to use when
// concat()
// join()
// repeat()
// format()
// isBlank() // Difference btw isEmpty and isBlank
// replaceFirst()


// HW Questions
// replace() repalceAll() replaceFirst() --> Difference

