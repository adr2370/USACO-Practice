/*
ID: alexstar11
LANG: JAVA
TASK: claust
*/
import java.io.*;
import java.util.*;
class claust 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("claust.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("claust.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[][] locs = new int[Integer.parseInt(st.nextToken())][2];
        int min=1000000;
        int[] ans=new int[2];
        for(int i=0;i<locs.length;i++)
        {
            st = new StringTokenizer(f.readLine());
            locs[i][0]=Integer.parseInt(st.nextToken());
            locs[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<locs.length;i++)
        {
            for(int j=i+1;j<locs.length;j++)
            {
                double x=locs[j][0]-locs[i][0];
                double y=locs[j][1]-locs[i][1];
                int dist=(int)Math.sqrt(x*x+y*y);
                if(dist<min)
                {
                    min=dist;
                    ans[0]=i+1;
                    ans[1]=j+1;
                }
            }
        }
        out.println(ans[0]+" "+ans[1]);
        out.close();
        System.exit(0);
    }
}
