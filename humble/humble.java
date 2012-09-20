/*
ID: alexstar11
LANG: JAVA
TASK: humble
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.PriorityQueue;
class humble
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("humble.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int K=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int[] s=new int[K];
        int[] indexS=new int[K];
        st = new StringTokenizer(f.readLine());
        for(int i=0;i<K;i++) {
            s[i]=Integer.parseInt(st.nextToken());
            indexS[i]=0;
        }
        long ans=0;
        ArrayList<Long> hum=new ArrayList<Long>();
        hum.add(1L);
        for(int i=0;i<N;i++) {
            long nextvalue=Long.MAX_VALUE;
            for(int j=0;j<K;j++) {
                int newIndexS=indexS[j];
                while(newIndexS<hum.size()&&hum.get(newIndexS)*s[j]<=hum.get(hum.size()-1))
                    newIndexS++;
                indexS[j]=newIndexS;
                nextvalue=Math.min(nextvalue,hum.get(newIndexS)*s[j]);
            }
            hum.add(nextvalue);
        }
        ans=hum.get(hum.size()-1);
        System.out.println(ans);
        out.println(ans);
        out.close();
        System.exit(0);
    }
}