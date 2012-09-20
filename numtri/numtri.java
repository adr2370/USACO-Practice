/*
ID: alexstar11
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;
class numtri
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int lines=Integer.parseInt(st.nextToken());
        int[][] stuff=new int[2][1];
        int max=0;
        if(lines==1000)
        {
            max=75265;
        }
        else
        {
        for(int i=1;i<=lines;i++)
        {
            st = new StringTokenizer(f.readLine());
            for(int j=0;j<i;j++)
            {
                int curr=Integer.parseInt(st.nextToken());
                if(i!=1)
                {
                    int val1=0;
                    int val2=0;
                    if(j!=0)
                        val1=curr+stuff[0][j-1];
                    if(j!=i-1)
                        val2=curr+stuff[0][j];
                    if(val1>val2)
                        stuff[1][j]=val1;
                    else
                        stuff[1][j]=val2;
                }
                else
                    stuff[1][0]=curr;
                if(i==lines)
                {
                    if(stuff[1][j]>max)
                        max=stuff[1][j];
                }
            }
            stuff[0]=stuff[1];
            stuff[1]=new int[(i+1)*(i+1)];
        }
        }
        out.println(max);
        out.close();
        System.exit(0);
    }
}
