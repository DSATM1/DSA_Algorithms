public class QueueSM
{
    int size;
    int front;
    int rear;
    int queue[];

    QueueSM(int size)
    {
        this.size = size;
        front = -1;
        rear = -1;
        queue = new int[size];
    }

    // enque()
    public void enqueue(int value)
    {
        if(isFull())
        {
            System.out.println("Queue is Full");
            return;
        }
        rear++;
        queue[rear] = value;
        System.out.println(value + " is Inserted");
    }

    // dequeue()
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        front++;
        int value = queue[front];
        return value;
    }

    // isEmpty()
    public boolean isEmpty()
    {
        return front == rear;
    }

    // isFull()
    public boolean isFull()
    {
        return rear - front == size;
    }

    // first()
    public int first()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front + 1];
    }

    // last()
    public int last()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[rear];
    }

    // display()
    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Front -> ");
        for(int i = front + 1; i <= rear ; i++)
        {
            System.out.print(queue[i] + " ");
        }
        System.out.print("<- Rear");
    }

}
