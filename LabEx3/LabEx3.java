//Insert comment

public class LabEx3
{
    public static void main(String[] args)
    {
        ValidInputs in = new ValidInputs();
        int[] T = {1,2}; //valid input options for t
        char[] alphabet = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // "_" is used to fill the 0 index.
        String s1="", s2;
        System.out.println("""
                
                * = = = = = = = = = = L a b E x 3 = = = = = = = = = = *
                |                                                     |
                |               Alvarez, Aaron Jetro                  |
                |                  Tan, Jam Meisy                     |
                |                                                     |
                * = = = = = = = = = = = = = = = = = = = = = = = = = = *
                """);

        System.out.print("Enter value of t: ");
        int t = in.validInt(T);

        if (t==1) 
        {
            System.out.print("Enter value of s: ");
            int s = in.validInt(0);
            System.out.print("Enter value of n: ");
            int n = in.validInt(1,26);
            System.out.println();

            Queue<String> q = new Queue<>(n);
            Stack<String> st = new Stack<>(n);

            for(int i=1; i<=n;i++)
                q.enqueue(String.valueOf(alphabet[i])); ///used to queue the nth letter in the alphabet

            System.out.print("Children: \" ");
            for(int i = 0; i < n; i++) 
            {
                System.out.printf("%-2s",q.peek());
                q.enqueue(q.dequeue());
            }
            System.out.print("\"\n");

            int r = 1; //used to count the round number
            int stackEl= -1; //used to track the number of elements added to the stack

            while(!q.isEmpty()) {
                for(int i = 0; i < s; i++)
                    q.enqueue(q.dequeue());
                stackEl += st.push(q.dequeue()); // updates the number of elements in the stack and dequeues the last letter

                System.out.printf("After round %-2d: ",r);

                if(q.isEmpty())
                    System.out.print("Empty");
                for (int z = 0; z < n - stackEl; z++) 
                {
                    System.out.printf("%-2s",q.peek());
                    q.enqueue(q.dequeue());
                }
                System.out.println();
                r++;
            }

            System.out.print("Winning order: \" ");
            while(!st.isEmpty())
                System.out.printf("%-2s",st.pop());
            System.out.print("\"\n");
        }

        if (t==2)
        {
            System.out.print("Enter s1 (delimited by spaces): ");
            s1 = in.validString(s1);

            System.out.print("Enter s2 (delimited by spaces): ");
            s2 = in.validString(s1);

            String[] a1 = s1.split(" ");
            String[] a2 = s2.split(" ");


            SLL<Integer> l1 = new SLL<>();
            SLL<Integer> l2 = new SLL<>();

            System.out.println("\nFirst Linked List Contents: ");

            for(int i = 0; i < a1.length; i++){
                l1.insertDesc(Integer.valueOf(a1[i]));
                System.out.println(l1);
            }

            System.out.println("\n\nSecond Linked List Contents: ");

            for(int i=0;i<a2.length;i++){
                l2.insertDesc(Integer.valueOf(a2[i]));
                System.out.println(l2);
            }
            SLL<Integer> l3 = l1.mergeWithoutDups(l2);
            System.out.println("\n\nThirdLinked List Contents: ");

            System.out.println(l3.toString());
            }
        }
    }
