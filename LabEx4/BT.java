/* Cauba, David Raniel C.
   Tan, Jam Meisy F.
   ICS2605
   1CSC
   Lab Exercise 4 */

public class BT<T>
{
    public BTNode<T> root;
    public int height;

    public BT()
    {
        root = null;
        height = -1;
    }
    public boolean isEmpty()
    {
        return root == null;
    }
    public boolean isLeaf(BTNode<T> n)
    {
        if(n == null)
            return false;
        else
            return (n.left == null && n.right == null);
    }
    public BTNode<T> setRoot(T el)
    {
       root = new BTNode<>(el);
       return root;
    }
    public BTNode<T> setRoot(BTNode<T> n)
    {
        root = n;
        return root;
    }
    public BTNode<T> setLeft(BTNode<T> n, T el)
    {
        n.left = new BTNode<>(el);
        return n.left;
    }
    public BTNode<T> setRight(BTNode<T> n, T el)
    {
        n.right = new BTNode<>(el);
        return n.right;
    }

    public void computeLevels()
    {

        Queue<BTNode<T>> q = new Queue<>();
        BTNode<T> ptr = root;

        if(ptr == null)
            return;

        ptr.level = 0;
        q.enqueue(ptr);

        while(!q.isEmpty())
        {
            ptr = q.dequeue();
            System.out.println("K = "+ ptr.info + ", level = " + ptr.level); //Prints current node and level

            if(ptr.left!=null)
            {
                q.enqueue(ptr.left);
                ptr.left.level = ptr.level + 1; //Adds one level higher to the current children node
            }
            if(ptr.right!=null)
            {
                q.enqueue(ptr.right);
                ptr.right.level = ptr.level + 1;
            }
        }

        height = ptr.level; //Since breadth-first is level by level, the ptr level will be the maximum

    }
    public String toString()
    {
        if(isEmpty())
            return "ht=undefined (tree is empty)";
        return "ht=" + height + "  [" + root.toString() + "]";
    }

    public int countLessPostOrder(BTNode<T> ptr, T el)
    {
        if (ptr == null)
            return 0;
        else
        {
            int ctr = countLessPostOrder(ptr.left, el) + countLessPostOrder(ptr.right, el);

            //Post-order, compares the root to a given value K
            if (((Comparable) (ptr.info)).compareTo((Comparable) el) < 0)
                return ctr + 1;
            else
                return ctr;
        }

    }
}
