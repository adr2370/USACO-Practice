/*
ID: alexstar11
LANG: JAVA
TASK: sort3
*/
import java.io.*;
import java.util.*;
class sort3 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[] rec=new int[N];
        int one=0;
        int two=0;
        int three=0;
        int ans=0;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            int next=Integer.parseInt(st.nextToken());
            if(next==1)
                one++;
            if(next==2)
                two++;
            if(next==3)
                three++;
            rec[i]=next;
        }
        int[][] num=new int[3][3];
        for(int i=0;i<one;i++)
        {
            if(rec[i]==1)
                num[0][0]++;
            if(rec[i]==2)
                num[0][1]++;
            if(rec[i]==3)
                num[0][2]++;
        }
        for(int i=one;i<one+two;i++)
        {
            if(rec[i]==1)
                num[1][0]++;
            if(rec[i]==2)
                num[1][1]++;
            if(rec[i]==3)
                num[1][2]++;
        }
        for(int i=one+two;i<one+two+three;i++)
        {
            if(rec[i]==1)
                num[2][0]++;
            if(rec[i]==2)
                num[2][1]++;
            if(rec[i]==3)
                num[2][2]++;
        }
        while(num[0][1]>0&&num[1][0]>0)
        {
            num[0][1]--;
            num[1][0]--;
            num[0][0]++;
            num[1][1]++;
            ans++;
        }
        while(num[0][2]>0&&num[2][0]>0)
        {
            num[0][2]--;
            num[2][0]--;
            num[0][0]++;
            num[2][2]++;
            ans++;
        }
        while(num[2][1]>0&&num[1][2]>0)
        {
            num[2][1]--;
            num[1][2]--;
            num[2][2]++;
            num[1][1]++;
            ans++;
        }
        ans+=(int)(2.0/3*(num[0][1]+num[0][2]+num[1][0]+num[1][2]+num[2][0]+num[2][1]));
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
