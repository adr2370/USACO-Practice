/*
ID: alexstar11
LANG: JAVA
TASK: iguess
*/
import java.io.*;
import java.util.*;
class iguess 
{
    public static void main (String [] args) throws IOException 
    {
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream (System.out, true);
        int N=Integer.parseInt(in.nextLine());
        int guess=N/2;
        int low=0;
        int high=N;
        out.println(guess);
        while(true)
        {
            String next=in.nextLine();
            if(next.equals("L"))
            {
                low=guess;
            }
            else
            {
                high=guess;
            }
            guess=(low+high)/2;
            out.println(guess);
        }
    }
}
