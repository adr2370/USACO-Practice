/*
ID: alexstar11
LANG: JAVA
TASK: candy
*/
import java.io.*;
import java.util.*;
class candy 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("candy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("candy.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int Nopt=Integer.parseInt(st.nextToken());
        int F=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] C=new int[Nopt];
        for(int i=0;i<Nopt;i++)
        {
            st = new StringTokenizer(f.readLine());
            C[i]=Integer.parseInt(st.nextToken());
        }
        int[] FN=new int[F];
        for(int i=0;i<Nopt;i++)
        {
            st = new StringTokenizer(f.readLine());
            FN[i]=Integer.parseInt(st.nextToken());
        }
        out.println(ans(N,M,C,FN,0));
        /*int[] maxes=new int[N];
        for(int i=0;i<N;i++)
        {
            max(i,M,C,FN,maxes);
        }
        System.out.println(max(N,M,C,FN,maxes));*/
        out.close();
        System.exit(0);
    }
    public static int max(int N,int M,int[] C,int[] FN,int[] maxes)
    {
        if(N>maxes.length)
        {
            return -1;
        }
        int m=0;
        for(int i=0;i<C.length;i++)
        {
            if(N>=C[i])
            {
                int next=findNext(N-C[i],FN,M);
                int curr=C[i]+max(next,M,C,FN,maxes);
                if(curr>m)
                {
                    m=curr;
                }
            }
        }
        return m;
    }
    public static int findNext(int N,int[] FN,int M)
    {
        for(int i=0;i<FN.length;i++)
        {
            if(N==FN[i])
            {
                return N+M;
            }
        }
        return N;
    }
    public static int ans(int N,int M,int[] C,int[] FN,int curr)
    {
        if(N<=0)
        {
            return curr;
        }
        else if(curr>=40000)
        {
            return -1;
        }
        else if(fav(N,FN))
        {
            N+=M;
            return ans(N,M,C,FN,curr);
        }
        else
        {
            int max=0;
            for(int i=0;i<C.length;i++)
            {
                N-=C[i];
                if(N<0)
                {
                    if(max<curr)
                    {
                        max=curr;
                    }
                }
                else
                {
                    int next=ans(N,M,C,FN,curr+C[i]);
                    if(next>max)
                    {
                        max=next;
                    }
                }
            }
            return max;
        }
    }
    public static boolean fav(int N,int[] FN)
    {
        for(int i=0;i<FN.length;i++)
        {
            if(N==FN[i])
            {
                return true;
            }
        }
        return false;
    }
}
