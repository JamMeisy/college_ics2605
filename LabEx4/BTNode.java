/* Cauba, David Raniel C.
   Tan, Jam Meisy F.
   ICS2605
   1CSC
   Lab Exercise 4 */


public class BTNode<T>
{
    public T info;
    public int level;
    public BTNode<T> left, right;

    public BTNode(T el)
    {
        this(el,null,null);
    }
    public BTNode(T el, BTNode<T> l, BTNode<T> r)
    {
        info = el;
        left = l;
        right = r;
    }

    public String toString()
    {
        String s = "";
        if (info != null)
        {
            s += "K=" + info;
            if (left != null)
                s += " L=[" + left + "]";
            if (right != null)
                s += " R=[" + right + "]";
        }
        return s;
    }
}
