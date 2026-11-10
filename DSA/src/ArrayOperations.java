public class ArrayOperations
{
    int array[]; // array init
    int length; // number of boxes
    int rightIndex; // --> pointing to empty box which is first box of array bcz all are empty

//    size means data in boxes if 1,2,3,0,0 so here size is 3 and length is 5

    public ArrayOperations()
    {
        length = 5; // array length
        array = new int[length]; // [][][][][] creating an array and giving the size of the array
        rightIndex = 0; // init to 0  [0] [0] [0] [0] [0]
    }

    // Insert at End
    public void insertAtEnd(int value)
    {
        if(rightIndex == length) // if array is full print array is full else go and print the array
        {
            System.out.println("Array is full at end  - 1");
            return;
        }
        array[rightIndex] = value;
        rightIndex++;
    }

    //insert at Start
    public void insertAtStart(int value)
    {
        if(rightIndex == length)
        {
            System.out.println("Array is full at start - 2");
            return;
        }
        else
        {
            //Shifting Elements 1 position to right
            for(int i = rightIndex - 1; i >= 0; i--)
            {
                array[i+1] = array[i];
            }
        }
        //insert
        array[0] = value;
        rightIndex++;
    }

    // insert at AnyPosition
    public void insertAtAnyPosition(int value, int position)
    {
        if(rightIndex == length)
        {
            System.out.println("Array is full at position - 3");
            return;
        }
        // checking edge case for position
        if (position < 0 || position > rightIndex)
        {
            System.out.println("Invalid Place for element at position - 3");
            return;
        }
        // shifting and insert from rightIndex to till position
        for(int i = rightIndex - 1; i >= position; i -- )
        {
            array[i+1] = array[i];
        }
        array[position] = value;
        rightIndex++;
    }

    // ==== Deletion ===== //
    // Delete at End
    public void deleteFromEnd()
    {
        if(rightIndex == 0)
        {
            System.out.println("Array is Empty First you fill the array - delete 1");
            return;
        }
        array[rightIndex - 1] = 0;
        rightIndex--;
    }

    // Delete at Start
    public void deleteFromStart()
    {
        if(rightIndex == 0)
        {
            System.out.println("Array is Empty First you fill the array - delete 2");
            return;
        }
        //shift elements from index = 0 (from start)
        for(int i = 0; i < rightIndex - 1; i++)
        {
            array[i] = array[i + 1];
        }
        rightIndex--;
        array[rightIndex] = 0; // it will be filled with array
    }

    // Delete at Any Position
    public void deleteFromAnyPosition(int position)
    {
        if(rightIndex == 0)
        {
            System.out.println("Array is Empty First you fill the array - delete 3");
            return;
        }
        if( position < 0 || position > rightIndex)
        {
            System.out.println("Invalid Position delete 3b");
            return;
        }

        for(int i = position; i < rightIndex - 1; i++)
        {
            array[i] = array[i+1];
        }
        rightIndex--; // we are reducing size bcz we del 1 element out
        array[rightIndex] = 0;
    }

    // print elements
    public void printElements()
    {
        System.out.println("\t Index \t Values");
        for(int i = 0; i < length; i++)
        {
            System.out.println(" \t " +i + " \t \t " + array[i]);
        }
        System.out.println("Size = " + rightIndex);
        System.out.println();
    }
}
