import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

class ValidInputs
{
    Scanner console = new Scanner(System.in);
    int inputValid(int[] a) throws InvalidInputException
    {
        int input = console.nextInt();
        if(!IntSearch(a,input))
            throw new InvalidInputException("Invalid Input. Please try again: ");
        else
            return input;
    }

    int validInt(int[] a)
    {
        boolean valid=false;
        int input='_';
        do {
            try {
                input = inputValid(a);
                valid = true;
            } catch(InvalidInputException e) {
                System.out.print("Invalid input. Try again: ");
            } catch(Exception e) {
                System.out.print("Input must be a number only: ");
                console.nextInt();
            }
        }while(!valid);
        return input;
    }

    //is used to assess if the user input value can be found in the given set of choices
    boolean IntSearch(int[] a,int x)
    {
        for(int i : a) if(x==i) return true;
        return false;
    }

    int inputValid(int min, int max) throws InvalidInputException
    {
        int input = console.nextInt();
        if(input<min || input >max)
            throw new InvalidInputException("Input can only be from "+ min +"-"+max+": ");
        else
            return input;
    }

    int validInt(int min, int max)
    {
        boolean valid=false;
        int input=0;
        do {
            try {
                input = inputValid(min,max);
                valid = true;
            } catch(InvalidInputException e) {
                System.out.print(e);
            } catch(InputMismatchException e) {
                System.out.print("Input is out of range: ");
                console.next();
            } catch(Exception e) {
                System.out.print("Input must be a number: ");
                console.next();
            }
        }while(!valid);
        return input;
    }

    int inputValid(int min) throws InvalidInputException
    {
        int input = console.nextInt();
        if(input<min)
            throw new InvalidInputException("Input can only be larger than "+ min+": ");
        else
            return input;
    }
    int validInt(int min) {

        boolean valid=false;
        int input=0;
        do {
            try {
                input = inputValid(min);
                valid = true;

            } catch(InvalidInputException e) {
                System.out.print(e);
            }
            catch(Exception e) {
                System.out.print("Input must be a number: ");
                console.next();
            }
        }while(!valid);
        return input;
    }

    String validString(String x){
        if(Objects.equals(x, ""))
            console.nextLine();
        return console.nextLine();
    }

}
class InvalidInputException extends Exception {
    InvalidInputException(String s)
    {
        super(s);
    }
}