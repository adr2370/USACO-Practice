/*
ID: alexstar11
LANG: JAVA
TASK: snotes
*/
import java.io.*;
import java.util.*;

class snotes {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("snotes.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snotes.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] song=new int[n];
        for(int i=0;i<n;i++)
        {
            st = new StringTokenizer(f.readLine());
            if(i==0)
            {
                song[0]=Integer.parseInt(st.nextToken());
            }
            else
            {
                song[i]=Integer.parseInt(st.nextToken())+song[i-1];
            }
        }
        for(int i=0;i<q;i++)
        {
            st=new StringTokenizer(f.readLine());
            int num=Integer.parseInt(st.nextToken())+1;
            if(song[0]>=num)
            {
                out.println(1);
            }
            else
            {
                out.println(index(0,n-1,song,num));
            }
        }
        out.close();
        System.exit(0);
    }
    public static int index(int a,int b,int[] song,int num)
    {
        if(b-a==1)
        {
            return b+1;
        }
        else
        {
            int middle=(int)((a+b)/2);
            if(song[middle-1]<num&&song[middle]>=num)
            {
                return middle+1;
            }
            if(song[middle]<num)
            {
                return index(middle,b,song,num);
            }
            else
            {
                return index(a,middle,song,num);
            }
        }
    }
}
