public class DemoArray
{
    static void main(String[] args)
    {
        MyArray arr = new MyArray();

        System.out.println("Initial Array : ");
        arr.printElements();
        arr.insertAtEnd(50);
        arr.insertAtEnd(60);
        System.out.println("After inserting 50 and 50");
        System.out.println();
        arr.printElements();

        arr.insertAtStart(100);
        arr.insertAtStart(200);
        System.out.println("After inserting at start ");
        System.out.println();
        arr.printElements();

        arr.insertAtAnyPosition(2345,3);
        System.out.println("After inserting at position :");
        arr.printElements();

    }
}
