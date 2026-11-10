public class ArrayOperationsDemo
{
    static void main(String[] args)
    {
        ArrayOperations arr = new ArrayOperations(); // ArrayOperations() is a Constructor

        System.out.println(" ===>> Initial Array");
        arr.printElements();

        System.out.println(" ===>> Inserting at End");
        arr.insertAtEnd(10);
        arr.insertAtEnd(20);
        arr.insertAtEnd(30);
        arr.insertAtEnd(40);
        arr.insertAtEnd(50);
        arr.printElements();

        // ==== Delete === //

//        arr.deleteFromEnd();
//        System.out.println("After deleting from end ");
//        arr.printElements();

//        arr.deleteFromStart();
//        System.out.println("After deleting from Start ");
//        arr.printElements();

        arr.deleteFromAnyPosition(2);
        System.out.println("After deleting from any position ");
        arr.printElements();






























//        System.out.println(" ===>> Inserting at Start");
//        arr.insertAtStart(5);
//        arr.printElements();
//
//        System.out.println(" ===>> Inserting at Position ");
//        arr.insertAtAnyPosition(2345,2);
//        arr.printElements();
//
//        System.out.println("Insert at End ");
//        arr.insertAtEnd(34);
//        arr.printElements();
//
//        System.out.println("Insert at -1");
//        arr.insertAtAnyPosition(7890, -1);
//        arr.printElements();
//
//        System.out.println("Just Displaying the array ");
//        arr.printElements();
//
//        System.out.println("insert at position 4 and value -12 ");
//        arr.insertAtAnyPosition(-12,1);
//        arr.printElements();
    }
}