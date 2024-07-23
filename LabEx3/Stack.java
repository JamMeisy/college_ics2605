//comment

public class Stack<T> {

    private int maxStkSize = 100;
    private int top = -1;
    private final Object[] stk;

    public Stack() {
        stk  = new Object[maxStkSize];
    }

    public Stack (int n) {
        if (n>0)
            maxStkSize = n;

        stk = new Object[maxStkSize];
    }

    public boolean isEmpty() {
        return (top==-1);
    }

    public boolean isFull() {
        return(maxStkSize-1==top);
    }

    public T pop() {
        if (isEmpty())
            return null;

        T el = (T) stk[top];
        --top;
        return el;
    }

    public int push(T el) {
        if(isFull())
            return -999;

        top = top+1;

        stk[top] = el;

        return 1;
    }

    public T peek() {
        if(isEmpty())
            return null;

        return (T) stk[top];
    }

}
