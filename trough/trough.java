/*
ID: alexstar11
LANG: JAVA
TASK: trough
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.PriorityQueue;
class trough
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("trough.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("trough.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[] troughs=new int[N];
        Map<Integer,String> guesses=new HashMap<Integer,String>();
        for(int i=0;i<Math.pow(2,N);i++)
        {
            String curr=Integer.toBinaryString(i);
            while(curr.length()<N)
            {
                curr="0"+curr;
            }
            guesses.put(i,curr);
        }
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(f.readLine());
            String next=st.nextToken();
            int num=Integer.parseInt(st.nextToken());
            ArrayList<Integer> removal=new ArrayList<Integer>();
            for(Integer x:guesses.keySet())
            {
                int c=0;
                for(int j=0;j<N;j++)
                {
                    if(next.charAt(j)=='1'&&guesses.get(x).charAt(j)=='1')
                    {
                        c++;
                    }
                }
                if(c!=num)
                {
                    removal.add(x);
                }
            }
            for(int j=0;j<removal.size();j++)
            {
                guesses.remove(removal.get(j));
            }
        }
        if(guesses.keySet().size()<1)
        {
            //System.out.println("IMPOSSIBLE");
            out.println("IMPOSSIBLE");
        }
        else if(guesses.keySet().size()>1)
        {
            //System.out.println("NOT UNIQUE");
            out.println("NOT UNIQUE");
        }
        else
        {
            for(Integer x:guesses.keySet())
            {
                //System.out.println(guesses.get(x));
                out.println(guesses.get(x));
            }
        }
        out.close();
        System.exit(0);
    }
}