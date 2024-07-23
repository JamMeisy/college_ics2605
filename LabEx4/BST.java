/* Cauba, David Raniel C.
   Tan, Jam Meisy F.
   ICS2605
   1CSC
   Lab Exercise 4 */

public class BST<T> extends BT<T> {

    public BTNode<T> search(T el) {
        BTNode<T> ptr = root;
        while (ptr != null)
        {
            if (ptr.info == el)
                return ptr;

            if (((Comparable) el).compareTo((Comparable)(ptr.info)) < 0)
                ptr = ptr.left;
            else
                ptr = ptr.right;
        }
        return null;
    }
    public void insert(T el) {

        int level = 0; //Counts the level

        if (root == null) //Case 1
        {
            root = new BTNode<T>(el, null, null);
            root.level = level;
        }

        BTNode<T> ptr = root; //Marcher pointer until null
        BTNode<T> ptr2 = null; //Records the last pointer before ptr is null
        while (ptr != null)
        {
            ptr2 = ptr; //Update marcher
            if (((Comparable) el).compareTo((Comparable)(ptr.info)) == 0) //Case 2: Exists already
                return;

            if (((Comparable) el).compareTo((Comparable)(ptr.info)) < 0)
                ptr = ptr.left;
            else //(el > root.info)
                ptr = ptr.right;
            level++;
        }

        //Inserts value in left or right
        if (((Comparable) el).compareTo((Comparable)(ptr2.info)) < 0)
        {
            ptr2.left = new BTNode<T>(el);
            ptr2.left.level = level;
        }
        else
        {
            ptr2.right = new BTNode<T>(el);
            ptr2.right.level = level;
        }

        if (height < level)
            height = level;
    }
}
