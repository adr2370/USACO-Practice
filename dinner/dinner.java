/*
ID: alexstar11
LANG: JAVA
TASK: dinner
*/
import java.io.*;
import java.util.*;
class dinner 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("dinner.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dinner.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] starts=new int[N][2];
        int[][] ends=new int[M][2];
        boolean[] gets=new boolean[N];
        boolean[] taken=new boolean[M];
        long[][] distances=new long[N*M][3];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            starts[i][0]=Integer.parseInt(st.nextToken());
            starts[i][1]=Integer.parseInt(st.nextToken());
            gets[i]=false;
        }
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(f.readLine());
            ends[i][0]=Integer.parseInt(st.nextToken());
            ends[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                long currDist=(long)Math.pow(ends[j][0]-starts[i][0],2)+(long)Math.pow(ends[j][1]-starts[i][1],2);
                distances[i*M+j][0]=currDist;
                distances[i*M+j][1]=i;
                distances[i*M+j][2]=j;
            }
        }
        for(int i=0;i<M*N;i++)
        {
            for(int j=i+1;j<M*N;j++)
            {
                if(distances[j][0]<distances[i][0])
                {
                    long temp1=distances[i][0];
                    long temp2=distances[i][1];
                    long temp3=distances[i][2];
                    distances[i][0]=distances[j][0];
                    distances[i][1]=distances[j][1];
                    distances[i][2]=distances[j][2];
                    distances[j][0]=temp1;
                    distances[j][1]=temp2;
                    distances[j][2]=temp3;
                    System.out.println("HI");
                }
            }
        }
        for(int i=0;i<M*N;i++)
        {
            if(!gets[(int)distances[i][1]]&&!taken[(int)distances[i][2]])
            {
                gets[(int)distances[i][1]]=true;
                taken[(int)distances[i][2]]=true;
            }
        }
        for(int i=0;i<gets.length;i++)
        {
            if(!gets[i])
            {
                out.println((i+1));
            }
        }
        out.close();
        System.exit(0);
    }
}
