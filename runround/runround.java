/*
ID: alexstar11
LANG: JAVA
TASK: runround
*/
import java.io.*;
import java.util.*;
class runround 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M=Integer.parseInt(st.nextToken());
        while(true)
        {
            M++;
            int[] curr=toDigits(M);
            boolean good=works(curr);
            if(good)
            {
                out.println(M);
                break;
            }
        }
        out.close();
        System.exit(0);
    }
    public static boolean works(int[] curr)
    {
        if(duplicates(curr))
        {
            return false;
        }
        int c=0;
        int x=curr[c];
        int l=curr.length;
        if(curr.length==1)
        {
            return true;
        }
        c=x%l;
        x=curr[c];
        int num=1;
        while(c!=0&&num<l)
        {
            c+=x;
            c=c%l;
            x=curr[c];
            num++;
        }
        System.out.println();
        return num==l&&c==0;
    }
    public static boolean duplicates(int[] curr)
    {
        for(int i=0;i<curr.length;i++)
        {
            for(int j=i+1;j<curr.length;j++)
            {
                if(curr[i]==curr[j]||curr[i]==0||curr[j]==0)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static int[] toDigits(int x)
    {
        int num=0;
        int temp=x;
        while(temp>0)
        {
            num++;
            temp/=10;
        }
        temp=x;
        int[] ans=new int[num];
        for(int i=0;i<num;i++)
        {
            ans[num-i-1]=temp%10;
            temp/=10;
        }
        return ans;
    }
}
