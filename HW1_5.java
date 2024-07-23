import java.util.Arrays;
import java.util.Random;

public class HW1_5
{
    static Random rng = new Random();

    public static void main(String[] args) {

        //Sample array of 20 loaded with 12 random numbers from 1-5
        //Since index starts at 1, add one to n to simulate size 20
        //m represents current content
        int n = 21, content = 12;
        int[] array = new int[n];
        for (int i = 1; i <= content; i++) {
            array[i] = rng.nextInt(5) + 1;
        }
        sort(array, content);

        System.out.println(Arrays.toString(array) + "\t(Original)"); //Display original array

        HW1_5ab hw5 = new HW1_5ab();
        content = hw5.insert(array, 2, content);
        System.out.println(Arrays.toString(array) + "\t(Inserted 2 from original array)"); // Display array with inserted value

        content = hw5.delete(array, 2, content);
        System.out.println(Arrays.toString(array) + "\t(Deleted 2 from previous array)"); //Display array with deleted value

        hw5.delete(array, 4, content);
        System.out.println(Arrays.toString(array) + "\t(Deleted 4 from original array)"); //Display array with deleted value

    }

    public static void sort(int[] array, int content) //Simple bubble sort, modified for index starting at 1
    {
        int temp;
        for (int i = 1; i < content; i++)
            for (int j = 1; j < content; j++)
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    static class HW1_5ab {
        public int insert(int[] A, int value, int m) {
            for (int i = m; i > 0; i--) {
                A[i + 1] = A[i];
                if (A[i - 1] < value) {
                    A[i] = value;
                    break;
                }
            }
            return m + 1;
        }

        public int delete(int[] A, int value, int m) {
            for (int i = 1; i <= m; i++) {
                if (A[i] > value) {
                    A[i - 1] = A[i];
                    value = A[i];
                }
            }
            A[m] = 0;
            return m - 1;
        }
    }
}