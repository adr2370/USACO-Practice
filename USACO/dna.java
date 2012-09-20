/*
ID: alexstar11
LANG: JAVA
TASK: dna
*/
import java.io.*;
import java.util.*;

class dna {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("dna.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dna.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        String[] bulls=new String[M];
        String[] cows=new String[F];
        String[] combined=new String[M+F];
        for(int i=0;i<M;i++)
        {
            bulls[i]=f.readLine();
            combined[i]=bulls[i];
        }
        for(int i=0;i<F;i++)
        {
            cows[i]=f.readLine();
            combined[i+M]=cows[i];
        }
        for(int currBull=0;currBull<M;currBull++)
        {
            for(int currCow=0;currCow<F;currCow++)
            {
                int num=0;
                for(int currChild=0;currChild<M+F;currChild++)
                {
                    String dad=bulls[currBull];
                    String mom=cows[currCow];
                    String child=combined[currChild];
                    if(currChild!=currBull&&currChild!=(currCow+M))
                        if(checker(dad,mom,child))
                            num++;
                }
                if(currCow==0)
                    out.print(num);
                else
                    out.print(" "+num);
            }
            out.println();
        }
        out.close();
        System.exit(0);
    }
    public static boolean checker(String dad,String mom,String child)
    {
        for(int i=0;i<25;i++)
        {
            int d=dad.charAt(i);
            int m=mom.charAt(i);
            int c=child.charAt(i);
            if(c!=d&&c!=m)
                return false;
        }
        return true;
    }
}
