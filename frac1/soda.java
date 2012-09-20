/*
ID: alexstar11
LANG: JAVA
TASK: soda
*/
import java.io.*;
import java.util.*;
class soda 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("soda.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("soda.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] x=new int[1000000000];
        int min=0;
        int max=0;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            min=Integer.parseInt(st.nextToken());
            max=Integer.parseInt(st.nextToken());
            for(int j=min-1;j<max;j++)
            {
                x[j]++;
            }
        }
        max=0;
        for(int i=0;i<100000000;i++)
        {
            if(x[i]>max)
            {
                max=x[i];
            }
        }
        out.println(max);
        out.close();
        System.exit(0);
    }
}
