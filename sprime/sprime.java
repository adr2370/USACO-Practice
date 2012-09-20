/*
ID: alexstar11
LANG: JAVA
TASK: sprime
*/
import java.io.*;
import java.util.*;
class sprime
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num=Integer.parseInt(st.nextToken());
        Queue<Integer> ans=new LinkedList<Integer>();
        ans.add(2);
        ans.add(3);
        ans.add(5);
        ans.add(7);
        for(int i=0;i<num-1;i++)
        {
            int a=ans.size();
            for(int j=0;j<a;j++)
            {
                int x=ans.remove();
                for(int k=0;k<=9;k++)
                {
                    int n=x*10+k;
                    if(isPrime(n))
                    {
                        ans.add(n);
                    }
                }
            }
        }
        for(Integer a:ans)
        {
            out.println(a);
        }
        out.close();
        System.exit(0);
    }
    public static boolean isPrime(int n) {
        if(n==0||n==1)
            return false;
        boolean prime = true;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
            {
                prime = false;
                break;
            }
        }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }
}