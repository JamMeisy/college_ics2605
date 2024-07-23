//comment

public class SLL<T>
{
    public T mergewithoutDups;
    private SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }

    public boolean isEmpty()
    {
        return (head == null);
    }

    public void addToHead(T el){
        head = new SLLNode<T>(el,head);
        if (tail==null)
            tail = head;
    }

    public void addToTail(T el){
        if(isEmpty())
            head = tail = new SLLNode<T>(el);
        else{
            tail.next = new SLLNode<T>(el,null);
            tail = tail.next;
        }
    }

    public T deleteFromHead(){
        if(isEmpty())
            return null;

        T el = head.info;
        if(head==tail)
            head = tail = null;
        else
            head = head.next;

        return el;
    }

    public T deleteFromTail(){
        if(isEmpty())
            return null;

        T el = tail.info;
        if (head == tail)
            head = tail = null;
        else
        {
            SLLNode<T> ptr = head;
            while (ptr.next != tail)
                ptr = ptr.next;
            tail = ptr;
            tail.next = null;
        }

        return el;
    }

    public T delete(T el) {
        if(isEmpty())
            return null;
        if(head.info == el)
            return deleteFromHead();
        if(tail.info == el)
            return deleteFromTail();

        SLLNode<T> ptr = head;
        SLLNode<T> t = head.next;

        while (t.info != el && t != null)
        {
            ptr = ptr.next;
            t = t.next;
        }

        if(t == null)
            return null;
        else
            ptr.next = t.next;

        return el;
    }

    public SLLNode<T> find(T el){
        SLLNode<T> ptr;

        for(ptr=head; ptr!=null && ptr.info!= el; ptr = ptr.next);

        return ptr;
    }

    public void insertDesc (T el)
    {
        if (isEmpty()) //Case 1: Empty
            head = tail = new SLLNode<T>(el);
        else if (((Comparable) head.info).compareTo(el) < 0) //Case 2: Inserted element is greater than head
        {
            addToHead(el);
        }
        else //Case 3: Inserting element as it traverses through the list
        {
            SLLNode<T> ptr = head;
            while (ptr.next != null && ((Comparable) ptr.next.info).compareTo(el) > 0)
            {
                ptr = ptr.next;
            }
            if (ptr.next == null)
                addToTail(el);
            else
                ptr.next = new SLLNode<T>(el, ptr.next);
        }
    }
    public SLL<T> mergeWithoutDups(SLL<T> component2)
    {
        SLL<T> merged = new SLL<>();
        SLLNode<T> ptr = this.head;
        SLLNode<T> ptr2 = component2.head;
        SLLNode<T> ptrMerge = merged.head;
        boolean flag = true;

        //First Linked List
        while (ptr != null)
        {
            /*
            while (ptrMerge != null && !merged.isEmpty())
            {
                if (((Comparable)ptr.info).compareTo(ptrMerge.info) == 0) {
                    flag = false;
                    break;
                }
                ptrMerge = ptrMerge.next;
            }
            */

            //if (flag)
            merged.insertDesc(ptr.info);
            //flag = true;
            ptr = ptr.next;
            //ptrMerge = merged.head; //Reset
        }

        //Second Linked List
        while (ptr2 != null)
        {
            /*
            while (ptrMerge != null && !merged.isEmpty())
            {
                if (((Comparable)ptr2.info).compareTo(ptrMerge.info) ==0)
                {
                    flag = false;
                    break;
                }
                ptrMerge = ptrMerge.next;
            }
            */

            //if (flag)
            merged.insertDesc(ptr2.info);
            //flag = true;
            ptr2 = ptr2.next;
            //ptrMerge = merged.head; //Reset
        }
        return merged;
    }

    public String toString() {
        SLLNode<T> p;
        String s = "";

        for (p=head;p!=null; p = p.next)
            s = s.concat(p.info.toString()+" ");
        return s;
    }
}
