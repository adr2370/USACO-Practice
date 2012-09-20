/*
ID: alexstar11
LANG: JAVA
TASK: holstein
*/
import java.io.*;
import java.util.*;
class holstein 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int V=Integer.parseInt(st.nextToken());
        int[] need=new int[V];
        st = new StringTokenizer(f.readLine());
        for(int i=0;i<V;i++)
        {
            need[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        int G=Integer.parseInt(st.nextToken());
        int[][] vit=new int[G][V];
        for(int i=0;i<G;i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j=0;j<V;j++)
            {
                vit[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int min=16;
        String ans="";
        for(int i=0;i<(int)Math.pow(2,G);i++)
        {
            int[] curr=new int[V];
            int num=0;
            int[] x=new int[100];
            for(int k=0;k<G;k++)
            {
                if(i%(int)Math.pow(2,k+1)>=(int)Math.pow(2,k))
                {
                    for(int j=0;j<V;j++)
                    {
                        curr[j]+=vit[k][j];
                    }
                    x[num]=k;
                    num++;
                }
            }
            boolean done=true;
            for(int j=0;j<V;j++)
            {
                if(curr[j]<need[j])
                {
                    done=false;
                }
            }
            if(num<min&&done)
            {
                min=num;
                ans=num+"";
                for(int j=0;j<num;j++)
                {
                    x[j]++;
                    ans+=" "+x[j];
                }
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
