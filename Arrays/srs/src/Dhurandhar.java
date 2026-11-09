public class Dhurandhar
{
    static void greeting(char message[])
    {
        for(int i = 0; i < message.length; i++)
        {
            System.out.print(message[i]);
        }
    }
    // replace mini encryption
    // mini decryption
    // should replace all the vowels with *
    public static void miniEncryption(char message[])
    {
        // This is one Algorithm
//        for(int i = 0; i < message.length; i++)
//        {
//            if(message[i] == 'a' || message[i] == 'e' || message[i] == 'i' || message[i] == 'o' || message[i] == 'u' ||
//                    message[i] == 'A' || message[i] == 'E' || message[i] == 'I' || message[i] == 'O' || message[i] == 'U')
//            {
//                message[i] = '*';
//            }
//        }
//        System.out.print(message);
    }

    public static void miniDecryption(char message[])
    {

    }

    public static void main(String[] args)
    {
        String msg = "Hi Hamza How Are You?";
        char [] message = msg.toCharArray();
        greeting(message);
        System.out.println();
        miniEncryption(message);
    }
}