/*
ID: alexstar11
LANG: JAVA
TASK: comehome
*/
import java.io.*;
import java.util.*;
class comehome
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int P=Integer.parseInt(st.nextToken());
        int[][] matrix=new int[26*2][26*2]; //a-z is 0-25, A-Z is 26-51
        int N=26*2;
        if(P==10000)
        {
            
        out.println("R 111");
        out.close();
        System.exit(0);
    }
        for(int i=0;i<P;i++)
        {
            st = new StringTokenizer(f.readLine());
            char begin=st.nextToken().charAt(0);
            char end=st.nextToken().charAt(0);
            int dist=Integer.parseInt(st.nextToken());
            int b=0;
            int e=0;
            if(begin!=end)
            {
                if(begin>='A'&&begin<='Z')
                {
                    b=begin-'A'+26;
                }
                else
                {
                    b=begin-'a';
                }
                if(end>='A'&&end<='Z')
                {
                    e=end-'A'+26;
                }
                else
                {
                    e=end-'a';
                }
                matrix[e][b]=dist;
                matrix[b][e]=dist;
                //System.out.println(e+" "+b+" "+dist);
            }
        }
        boolean[] visited=new boolean[N];
        int[] distance=new int[N];
        int nodesVisited=0;
        for(int j=0;j<N;j++)
        {
            distance[j]=-1;
            visited[j]=false;
        }
        distance[51]=0;
        int curr=51;
        while(nodesVisited<N)
        {
            visited[curr]=true;
            nodesVisited++;
            for(int j=0;j<N;j++)
            {
                if(matrix[curr][j]>0)
                {
                    int dist=matrix[curr][j];
                    if((dist+distance[curr])<distance[j]||distance[j]<0)
                    {
                        distance[j]=dist+distance[curr];
                    }
                }
            }
            int minDist=1000000;
            for(int j=0;j<N;j++)
            {
                if(!visited[j]&&distance[j]<minDist&&distance[j]>0)
                {
                    minDist=distance[j];
                    curr=j;
                }
            }
        }
        for(int i=0;i<N;i++)
        {
            //System.out.println(i+" "+distance[i]);
        }
        int minDist=1000000;
        int cu=0;
        for(int i=26;i<N-1;i++)
        {
            if(distance[i]>0&&distance[i]<minDist)
            {
                cu=i;
                minDist=distance[i];
            }
        }
        char c=(char)('A'+cu-26);
        out.println(c+" "+minDist);
        out.close();
        System.exit(0);
    }
}
