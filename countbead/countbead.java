/*
ID: alexstar11
LANG: JAVA
TASK: countbead
*/
import java.io.*;
import java.util.*;
class countbead 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("countbead.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("countbead.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] string=new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i=0;i<N;i++)
        {
            string[i]=Integer.parseInt(st.nextToken());
        }
        int ans=0;
        for(int i=0;i<N-1;i++)
        {
            if(string[i]!=string[i+1])
            {
                ans++;
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
