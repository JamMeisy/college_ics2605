/* Cauba, David Raniel C.
   Tan, Jam Meisy F.
   ICS2605
   1CSC
   Lab Exercise 4 */

import java.util.Scanner;

public class LabEx4
{
    static Scanner sn = new Scanner(System.in);

    public static void main(String[] args)
    {
        //Variable Declarations
        int t;


        System.out.println("""
                = = = = = = = = = = = = = = =
                |      Lab Exercise 4       |
                |   Cauba, David Raniel C.  |
                |      Tan, Jam Meisy F.    |
                = = = = = = = = = = = = = = =
                
                1 - Build Trees
                2 - Build Binary Search Tree
                """);

        System.out.print("\nYour Input: ");
        t = validate();

        if(t == 1)
        {
            // Instantiate t0
            System.out.println("\n\nThe Empty tree t0");
            BT<String> t0 = new BT<>();
            System.out.println(t0);

            System.out.println("\n\nThe tree t1 above");
            // Instantiate t1
            BT<Integer> t1 = new BT<>();
            BTNode<Integer> bt2 = new BTNode<>(2);
            BTNode<Integer> bt4 = new BTNode<>(4);
            BTNode<Integer> bt1 = new BTNode<>(1,null,bt2);
            BTNode<Integer> bt5 = new BTNode<>(5,bt4,null);
            BTNode<Integer> bt3 = new BTNode<>(3,bt1,bt5);
            t1.setRoot(bt3);
            t1.computeLevels();
            System.out.println(t1);

            System.out.println("\n\nThe tree t2 below");
            // Instantiate t2
            BT<Character> t2 = new BT<>();
            BTNode<Character> btE = new BTNode<>('E');
            BTNode<Character> btZ = new BTNode<>('Z');
            BTNode<Character> btF = new BTNode<>('F');
            BTNode<Character> btG = new BTNode<>('G');
            BTNode<Character> btT = new BTNode<>('T');
            BTNode<Character> btV = new BTNode<>('V',null,btE);
            BTNode<Character> btD = new BTNode<>('D',btF,btG);
            BTNode<Character> btM = new BTNode<>('M',btT,null);
            BTNode<Character> btH = new BTNode<>('H',btV,btZ);
            BTNode<Character> btA = new BTNode<>('A',btD,null);
            BTNode<Character> btC = new BTNode<>('C',null,btH);
            BTNode<Character> btX = new BTNode<>('X',btA,btM);
            BTNode<Character> btS = new BTNode<>('S',btC,btX);
            t2.setRoot(btS);
            t2.computeLevels();
            System.out.println(t2);

            int count;
            count = t2.countLessPostOrder(t2.root, 'A');
            System.out.println("\nInfo Value : A, Number of nodes less than A : "+count);

            count = t2.countLessPostOrder(t2.root, 'E');
            System.out.println("Info Value : E, Number of nodes less than E : "+count);

            count = t2.countLessPostOrder(t2.root, 'K');
            System.out.println("Info Value : K, Number of nodes less than K : "+count);

            count = t2.countLessPostOrder(t2.root, 'W');
            System.out.println("Info Value : W, Number of nodes less than W : "+count);
        }
        if(t == 2)
        {
            // Instantiate bst1
            BST<String> bst1 = new BST<>();
            bst1.insert("F");
            bst1.insert("T");
            bst1.insert("D");
            bst1.insert("Q");
            bst1.insert("A");
            bst1.insert("L");
            bst1.insert("E");
            bst1.insert("P");
            bst1.insert("S");
            bst1.insert("M");
            bst1.insert("H");
            bst1.insert("C");
            System.out.println("Binary Search Tree 1");
            System.out.println(bst1);

            BTNode<String> ptr;
            String[] array = {"R", "A", "F", "L", "N", "D", "V"};
            for (String i : array) {
                if ((ptr = bst1.search(i)) != null)
                {
                    System.out.println();
                    System.out.println(i + " found! Displaying contents:");
                    System.out.println(ptr);
                    System.out.println("Level: " + ptr.level);
                }
                else
                    System.out.println("\n" + i + " not found in binary search tree 1");
            }



        }
    }
    public static int validate()
    {
        int x = sn.nextInt();

        while(x < 1 || x > 2)
        {
            System.out.print("\nNot valid, please try again\nYour Input: ");
            x = sn.nextInt();
        }
        return x;

    }
}
