/* Cauba, David Raniel C.
   Tan, Jam Meisy F.
   ICS2605
   1CSC
   Lab Exercise 4
 */
public class Queue<T>
{
    private int maxQSize = 100;
    private int front=-1,rear=-1;
    private Object[] que;

    public Queue()
    {
        que = new Object[maxQSize];
    }
    public Queue(int n)
    {
        if(n>0)
            maxQSize = n;
        que = new Object[maxQSize];
    }
    public void clear()
    {
        front = rear = -1;
    }
    public boolean isEmpty()
    {
        return front == -1;
    }
    public boolean isFull()
    {
        return ((rear + 1) % maxQSize) == front;
    }
    public int enqueue(T el)
    {
        if(isFull())
            return -999;

        rear = (rear+1) % maxQSize;
        que[rear] = el;

        if(isEmpty())
            front = 0;
        return 1;
    }
    public T dequeue()
    {
        if(isEmpty())
            return null;

        T el = (T) que[front];
        if(front == rear)
            clear();
        else
            front = (front+1) % maxQSize;

        return el;
    }

    public T peek() {
        if(isEmpty()) return null;

        return (T) que[front];
    }
}

