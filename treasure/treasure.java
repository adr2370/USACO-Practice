/*
ID: alexstar11
LANG: JAVA
TASK: treasure
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.PriorityQueue;
class treasure
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("treasure.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("treasure.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] coins=new int[N];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            coins[i]=Integer.parseInt(st.nextToken());
        }
        int min=0;
        int max=N-1;
        int ans=0;
        int other=0;
        int counter=0;
        while(min<max)
        {
            if(coins[min]>coins[max])
            {
                if(counter%2==0)
                {
                    ans+=coins[min];
                }
                else
                {
                    other+=coins[min];
                }
                min++;
            }
            else
            {
                if(counter%2==0)
                {
                    ans+=coins[max];
                }
                else
                {
                    other+=coins[max];
                }
                max--;
            }
            counter++;
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}