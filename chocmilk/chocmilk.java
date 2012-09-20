/*
ID: alexstar11
LANG: JAVA
TASK: chocmilk
*/
import java.io.*;
import java.util.*;
class chocmilk 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("chocmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("chocmilk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] starts=new int[N-1];
        int[] ends=new int[N-1];
        for(int i=0;i<N-1;i++)
        {
            st = new StringTokenizer(f.readLine());
            starts[i]=Integer.parseInt(st.nextToken())-1;
            ends[i]=Integer.parseInt(st.nextToken())-1;
        }
        quicksort(starts,ends,0,N-2);
        ArrayList<Integer> beg=new ArrayList<Integer>();
        boolean[] notBeg=new boolean[N];
        for(int i=0;i<N-1;i++)
        {
            notBeg[ends[i]]=true;
        }
        for(int i=0;i<N;i++)
        {
            if(!notBeg[i])
            {
                beg.add(i);
            }
        }
        int[] milk=new int[N];
        for(Integer i:beg)
        {
            milk[i]=1;
        }
        boolean[] spliter=new boolean[N];
        int[] numOut=new int[N];
        for(int i=0;i<N-1;i++)
        {
            numOut[starts[i]]++;
        }
        for(int i=0;i<N;i++)
        {
            if(numOut[i]>1)
            {
                spliter[i]=true;
            }
        }
        for(int i=0;i<N-1;i++)
        {
            if(spliter[starts[i]])
            {
                milk[ends[i]]=-1;
            }
            else
            {
                milk[ends[i]]+=milk[starts[i]];
            }
        }
        for(int i=0;i<N;i++)
        {
            if(milk[i]==beg.size())
            {
                out.println(""+(i+1));
            }
        }
        out.close();
        System.exit(0);
    }
    public static void quicksort(int[] array,int[] otherA,int low, int n)
    {
        int lo = low;
        int hi = n;
        if (lo >= n)
        {
          return;
        }
        int mid = array[(lo + hi) / 2];
        while (lo < hi)
        {
          while (lo<hi && array[lo] < mid)
          {
            lo++;
          }
          while (lo<hi && array[hi] > mid)
          {
            hi--;
          }
          if (lo < hi)
          {
            int T = array[lo];
            int T2=otherA[lo];
            array[lo] = array[hi];
            otherA[lo] = otherA[hi];
            array[hi] = T;
            otherA[hi] = T2;
          }
          if(array[lo]==array[hi])
          {
              break;
            }
        }
        if (hi < lo)
        {
          int T = hi;
          hi = lo;
          lo = T;
        }
        quicksort(array,otherA, low, lo);
        quicksort(array,otherA, lo == low ? lo+1 : lo, n);
  }
}
