/*
ID: alexstar11
LANG: JAVA
TASK: teststr
*/
import java.io.*;
import java.util.*;

class teststr {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("teststr.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("teststr.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int[] ks=new int[k];
        int max=0;
        int min=1000001;
        for(int i=0;i<k;i++)
        {
            st = new StringTokenizer(f.readLine());
            ks[i]=Integer.parseInt(st.nextToken());
            if(ks[i]>max)
            {
                max=ks[i];
            }
            if(ks[i]<min)
            {
                min=ks[i];
            }
        }
        int m=n-min;
        int blah=n-max;
        if(m>max)
            m=m;
        else
            m=max;
        if(blah>min)
            blah=blah;
        else
            blah=min;
        if(m>blah)
            out.println(blah);
        else
            out.println(m);
        out.close();
        System.exit(0);
    }
}
