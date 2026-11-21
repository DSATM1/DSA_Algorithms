public class MyArray
{
    int array []; // place to store elements
    int length; // total size of the array
    int righrtIndex; // pointing at empty box

    // size = number of boxes

    public MyArray()
    {
        length = 5;
        array = new int[length]; // [0][0][0][0][0] -->> init array
        righrtIndex = 0;
    }

    // insert at end
    public void insertAtEnd(int value)
    {
        if(righrtIndex == length)
        {
            System.out.println("Array is full get lost ");
            return;
        }
        array[righrtIndex] = value;
        righrtIndex++; // after inserting at the end size go increased
    }

    // insert at start
    public void insertAtStart(int value)
    {
        if(righrtIndex == length)
        {
            System.out.println("Array is full");
            return;
        }
        else
        {
            // shift element one position to right
            for (int i = righrtIndex - 1; i >= 0; i--)
            {
                array[i+1] = array[i];
            }
        }
        // insert
        array[0] = value;
        righrtIndex++;
    }

    // insert at any position

    public void insertAtAnyPosition(int value, int position)
    {
        if(righrtIndex == length)
        {
            System.out.println("Array is full ");
            return;
        }

        if(position < 0 || position > righrtIndex)
        {
            System.out.println("Invalid Position");
            return;
        }
        // shift and insert
        for(int i = righrtIndex - 1; i > position; i--)
        {
            array[i+1] = array[i];
        }
        array[position] = value;
        righrtIndex++;
    }

    //print the elements in the array

    public void printElements()
    {
        System.out.println(" Index \t value ");
        for(int i = 0; i< length; i++)
        {
            System.out.println(i + " \t \t " + array[i] );
        }
        System.out.println("Size " + righrtIndex);
        System.out.println();
    }
}
