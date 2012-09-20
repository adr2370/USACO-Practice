/*
ID: alexstar11
LANG: JAVA
TASK: scavhunt
*/
import java.io.*;
import java.util.*;

class scavhunt {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("scavhunt.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scavhunt.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] pF=factors(P);
        int[] qF=factors(Q);
        for(int i=0;i<pF.length;i++)
        {
            for(int j=0;j<qF.length;j++)
            {
                out.println(pF[i]+" "+qF[j]);
            }
        }
        out.close();
        System.exit(0);
    }
    public static int[] factors(int y)
    {
        int[] primeF=new int[y+1];
        int x=y;
        while(x>1)
        {
            for(int i=2;i<=x;i++)
            {
                while(x%i==0)
                {
                    primeF[i]++;
                    x/=i;
                }
            }
        }
        int count=1;
        for(int i=2;i<=y;i++)
        {
            int a=1+primeF[i];
            count*=a;
        }
        int[] ans=new int[count];
        count=0;
        for(int i=1;i<=y;i++)
        {
            if(y%i==0)
            {
                ans[count]=i;
                count++;
            }
        }
        return ans;
    }
}
