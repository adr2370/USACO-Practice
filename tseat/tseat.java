/*
ID: alexstar11
LANG: JAVA
TASK: tseat
*/
import java.io.*;
import java.util.*;

class tseat {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("tseat.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tseat.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int W = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] priorities=new int[W][R];
        double[][] distances=new double[W][R];
        for(int i=0;i<W;i++)
        {
            for(int j=0;j<R;j++)
            {
                distances[i][j]=distance(i,j,W,R);
            }
        }
        int[][] sorted=new int[W*R][2];
        for(int i=0;i<W*R;i++)
        {
            double min=W*R;
            int nextX=0;
            int nextY=0;
            for(int j=0;j<R;j++)
            {
                for(int k=0;k<W;k++)
                {
                    if(distances[k][j]<min)
                    {
                        min=distances[k][j];
                        nextX=k;
                        nextY=j;
                    }
                }
            }
            distances[nextX][nextY]=W*R;
            sorted[i][0]=nextX;
            sorted[i][1]=nextY;
        }
        for(int i=0;i<W*R;i++)
        {
            priorities[sorted[i][0]][sorted[i][1]]=i+1;
        }
        for(int i=R-1;i>=0;i--)
        {
            for(int j=0;j<W;j++)
            {
                if(j>0)
                    out.print(" ");
                out.print(priorities[j][i]);
            }
            out.println();
        }
        out.close();
        System.exit(0);
    }
    public static double distance(int i,int j,int W,int R)
    {
        double x=(W+1)/2-i-1;
        double y=j;
        return Math.sqrt(x*x+y*y);
    }
}
