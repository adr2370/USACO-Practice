
/**
 * Write a description of class nonRecursiveFibo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class nonRecursiveFibo
{
    public static int nonRecursiveFibo(int n) {
       int a=0;
       int b=1;
       int c=1;
       for (int i=0; i<n; i++)
       {
           int temp=a;
           a=b;
           b=c;
           c=temp+a;
       }
       return c;
   }
}