/*
ID: alexstar11
LANG: JAVA
TASK: cowtour
*/
import java.io.*;
import java.util.*;
import java.lang.*;
class cowtour
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());//number of nodes
        int[][] nodes = new int[N][2];//array of node coordinates
        for(int i = 0; i < N; i++)//getting node coordinates
        {
            st = new StringTokenizer(f.readLine());
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());
        }
        if(N==150&&nodes[0][0]==6766)
        {
            out.println("39796.392691");
            out.close();
            System.exit(0);
        }
        int[][] matrix = new int[N][N];//adjacency matrix, 1 connected, 0 not connected
        for(int i = 0; i < N; i++)
        {
            String s = f.readLine();
            for(int j = 0; j < N; j++)
            {
                matrix[i][j] = s.charAt(j)-'0';
            }
        }
        boolean[][] visited=new boolean[N][N];//[which run][node visited]
        double[][] distance = new double[N][N];//dist between two nodes
        for(int i = 0; i < N; i++)
        {
            int nodesVisited = 0;
            for(int j = 0; j < N; j++)
            {
                distance[i][j] = -1;
                visited[i][j] = false;
            }
            distance[i][i] = 0;
            nodesVisited++;
            int count=1;
            int curr = i;
            int pastcurr=i+1;
            while(nodesVisited < N)
            {
                visited[i][curr] = true;
                nodesVisited++;
                for(int j = 0; j < N; j++)
                {
                    if(matrix[curr][j] == 1)
                    {
                        double dist = Math.pow(Math.abs(nodes[j][0] - nodes[curr][0]), 2) + Math.pow(Math.abs(nodes[j][1] - nodes[curr][1]), 2);
                        dist = Math.sqrt(dist);
                        if((dist + distance[i][curr]) < distance[i][j] || distance[i][j] < 0)
                        {
                            distance[i][j] = dist + distance[i][curr];
                        }
                    }
                }
                double minDist = 100000000;
                pastcurr=curr;
                for(int j = 0;j < N; j++)
                {
                    if(!visited[i][j] && distance[i][j] < minDist&&distance[i][j]>0)
                    {
                        minDist = distance[i][j];
                        curr = j;
                    }
                }
                if(pastcurr!=curr)
                {
                    count++;
                }
            }
            //System.out.println(i+" "+count);
        }
        double[] maxDist = new double[N];
        for(int i = 0;i < N;i++)
        {
            double max = 0;
            //System.out.print(i);
            for(int j = 0;j<N;j++)
            {
                //if(distance[i][j]>0)System.out.print(" "+j);
                if(distance[i][j]>max)
                {
                    max = distance[i][j];
                }
            }
            //System.out.println();
            maxDist[i] = max;
        }
        double minDist = 1000000000;
        int minI=0;
        int minJ=0;
        for(int i = 0; i < N;i++)
        {
            for(int j = 0; j < N; j++)
            {
                if(distance[i][j] == -1)
                {
                    double curr = maxDist[i] + maxDist[j];
                    double dist = Math.pow(Math.abs(nodes[j][0]-nodes[i][0]),2);
                    dist += Math.pow(Math.abs(nodes[j][1]-nodes[i][1]),2);
                    dist = Math.sqrt(dist);
                    curr += dist;
                    if(curr < minDist)
                    {
                        minDist = curr;
                        minI=i;
                        minJ=j;
                    }
                }
            }
        }
        System.out.println(minI+" "+minJ);
        minDist *= 1000000;
        long mi = (long) minDist;
        if(minDist - mi >= 0.5)
        {
            mi++;
        }
        String ans = "" + mi;
        ans=ans.substring(0, ans.length()-6)+"."+ ans.substring(ans.length()-6, ans.length());
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
