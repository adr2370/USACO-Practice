/*
ID: alexstar11
LANG: JAVA
TASK: mkmoney
*/
import java.io.*;
import java.util.*;
class mkmoney 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("mkmoney.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mkmoney.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] C=new int[N];
        int[] R=new int[N];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            C[i]=Integer.parseInt(st.nextToken());
            R[i]=Integer.parseInt(st.nextToken());
        }
        out.println(ans(C,R,M));
        out.close();
        System.exit(0);
    }
    public static int ans(int[] C,int[] R,int M)
    {
        if(M==0)
        {
            return 0;
        }
        else
        {
            int max=0;
            for(int i=0;i<C.length;i++)
            {
                if(C[i]<=M)
                {
                    int x=R[i]-C[i]+ans(C,R,M-C[i]);
                    if(x>max)
                    {
                        max=x;
                    }
                }
            }
            if(max==0)
            {
                return M;
            }
            return max;
        }
    }
}
