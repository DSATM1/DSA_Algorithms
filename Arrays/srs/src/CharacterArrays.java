public class CharacterArrays
{
//    Count the vowels and consonants. Return both as [vowels, consonants].
//    Input to the function: ['a','p','p','l','e']
//    Return from the function: [2, 3]

    static int[] countVowelsAndConsonents(char ch[]) {
        if (ch == null || ch.length == 0) {
            return new int[]{-1};
        }
        int vowels = 0;
        int cons = 0;

        for (int i = 0; i < ch.length; i++) {
            if ((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z')) {
                if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' ||
                        ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U') {
                    vowels++;
                } else {
                    cons++;
                }
            }
        }
        return new int[]{vowels, cons};
    }

    static void printCountVC() {
        char ch[] = {'@', 'p', 'p', 'l', 'e', '#', 'U', '1', '4', 'E'};
        int result[] = countVowelsAndConsonents(ch);

        System.out.print("1 --> Count of Vowels And Consonents : [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return how many times a given character appears.
//    Input to the function: ['b','a','n','a','n','a'] and 'a'
//    Return from the function: 3

    static int countCharacter(char ch[]) {
        int count = 0;
        for (char alpha : ch) {
            if (alpha == 'a') {
                count++;
            }
        }
        return count;
    }

    static void printAppearedCharacter() {
        char ch[] = {'b', 'a', 'n', 'a', 'n', 'a'};
        int result = countCharacter(ch);
        System.out.println("2 --> Character 'a' Appeared " + result + " Times ");
    }

//    Return the array with every letter in capitals.
//    Input to the function: ['c','o','d','e']
//    Return from the function: ['C','O','D','E']

    static char[] getCapital(char[] ch) {
        char result[] = new char[ch.length];

        for (int i = 0; i < ch.length; i++)
        {
            if (ch[i] >= 'a' && ch[i] <= 'z')
            {
                result[i] = (char) (ch[i] - 32);
            }
            else
            {
                result[i] = ch[i];
            }
        }
        return result;
    }

    static void printCapital() {
        char ch[] = {'c', 'o', 'd', 'e'};
        char res[] = getCapital(ch);

        System.out.print("3 --> Capital Letters : [");
        for (int i = 0; i < res.length; i++)
        {
            System.out.print(res[i]);
            if (i < res.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return true if the array contains at least one digit.
//    Input to the function: ['p','a','s','s','1']
//    Return from the function: true

    static boolean findDigit(char ch[]) {
        boolean digitFound = false;
        for(int i = 0; i < ch.length; i++)
        {
            int digit = ch[i] - '0';

            if(ch[i] >= '0' && ch[i] <= '9')
            {
                digitFound = true;
            }
        }
        return digitFound;
    }

    static void printDiscoveredDigit() {
        char ch[] = {'p','a','s','s','9'};
        boolean res = findDigit(ch);
        System.out.println("4 --> Array Contains Digit ? : " + res);
    }

//    Return the first and the last character as a new array.
//    Input to the function: ['m','a','n','g','o']
//    Return from the function: ['m','o']

    static char[] getfirstLastChar(char ch[]) {

        if(ch == null || ch.length == 0)
        {
            return new char[]{};
        }
        char firstElement = ch[0];
        char lastElement = ch[ch.length - 1];
        return new char[]{firstElement,lastElement};
    }

    static void printElementsFirstlast() {
        char ch[] = {'m','a','n','g','o'};
        char result[] = getfirstLastChar(ch);

        System.out.print("5 --> Print First And Last Elements in Array : [");
        for(int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
            if(i < result.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return how many capital letters are in the array.
//    Input to the function: ['I','n','d','i','a','N','o','1']
//    Return from the function: 2

    static int getCountOfCapital(char ch[]) {
        int count = 0;

        for(int i = 0; i< ch.length; i++)
        {
            if(ch[i] >= 'A' && ch[i] <= 'Z')
            {
                count++;
            }
        }
        return count;
    }

    static void printCountCapital() {
        char ch[] = {'I','A','A','a','a','N','o','1'};
        System.out.println("6 --> Count of Capitals in Array :  " + getCountOfCapital(ch));
    }

//    Password check: return true if the password has at least 8 characters and at least one digit.
//    Input to the function: ['s','e','c','r','e','t','9','x']
//    Return from the function: true

    static boolean validatePassword(char password[]) {
        boolean isPwdHas8Ch = false;
        boolean hasDigit = false;
        if(password.length <= 8)
        {
            isPwdHas8Ch = true;
        }

        for(int digit = 0; digit < password.length; digit++)
        {
            if(password[digit] >= '0' && password[digit] <= '9')
            {
                hasDigit = true;
            }
        }
        return isPwdHas8Ch && hasDigit;
    }

    static void printPassword() {
        char password[] = {'s','e','c','r','e','x'};
        System.out.println("7 --> Validating Password : " + validatePassword(password));
    }

//    Return the array with every space replaced by an underscore '_'.
//    Input to the function: ['h','i',' ','t','h','e','r','e']
//    Return from the function: ['h','i','_','t','h','e','r','e']

    static char[] replaceSpace(char [] ch) {
        for(int i = 0; i < ch.length; i++)
        {
            if(ch[i] == ' ')
            {
                ch[i] = '_';
            }
        }
        return ch;
    }

    static void printReplace() {
        char ch[] = {'h','i',' ','t','h','e','r','e'};
        char res[] = replaceSpace(ch);
        System.out.print("8 --> Replace the Space : [");
        for(int i = 0; i< res.length; i++)
        {
            System.out.print(res[i]);
            if(i < res.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

//    Return true if both arrays have exactly the same letters, in any order.
//    Input to the function: ['s','i','l','e','n','t'] and ['l','i','s','t','e','n']
//    Return from the function: true

    static boolean getSameElements(char ch1[], char ch2[]) {
        boolean sameElements = false;
        for(int i = 0; i < ch1.length; i++)
        {
            for(int j = 0; j < ch2.length; j++)
            {
                if(ch1[i] == ch2[j])
                {
                    sameElements = true;
                }
                else
                {
                    sameElements = false;
                }
            }
        }
        return sameElements;
    }

    static void printSameElements() {
        char ch1[] = {'s','i','l','e','n','q'};
        char ch2[] = {'l','i','s','t','e','n'};
        System.out.println("24 --> Same Letters in Both Array : " + getSameElements(ch1,ch2));
    }

//    Votes from three polling booths are given ('A' or 'B' for each voter). Return the candidate with the
//    most votes overall.
//    Input to the function: ['A','B','A'], ['B','B','A','B'] and ['A','A']
//    Return from the function: 'A'

    static char mostVotingCandidate(char a[],char b[], char c[]) {
        int voteA = 0;
        int voteB = 0;

        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == 'A')
            {
                voteA++;
            }
            else if(a[i] == 'B')
            {
                voteB++;
            }
        }

        for(int i = 0; i < b.length; i++)
        {
            if(b[i] == 'A')
            {
                voteA++;
            }
            else if(b[i] == 'B')
            {
                voteB++;
            }
        }

        for(int i = 0; i < c.length; i++)
        {
            if(c[i] == 'A')
            {
                voteA++;
            }
            else if(c[i] == 'B')
            {
                voteB++;
            }
        }

        if(voteA > voteB)
        {
            return 'A';
        }

        if(voteB > voteA)
        {
            return 'B';
        }

        return 'T';
    }

    static void printCandidate() {
        char a[] = {'A','B','A'};
        char b[] = {'B','B','A','B'};
        char c[] = {'A','A'};
        System.out.println("25 --> Most Vote Got Candidate : " + mostVotingCandidate(a,b,c));
    }


    static void main(String[] args) {
        printCountVC();                 // 1
        printAppearedCharacter();       // 2
        printCapital();                 // 3
        printDiscoveredDigit();         // 4
        printElementsFirstlast();       // 5
        printCountCapital();            // 6
        printPassword();                // 7
        printReplace();                 // 8
                                        // Balance
        printSameElements();            // 24
        printCandidate();               // 25

    }
}
