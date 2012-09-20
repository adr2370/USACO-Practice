/*
ID: alexstar11
LANG: JAVA
TASK: hamming
*/
import java.io.*;
import java.util.*;
class hamming 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int D=Integer.parseInt(st.nextToken());
        int[] pos=new int[(int)Math.pow(2,B)];
        for(int i=0;i<pos.length;i++)
        {
            pos[i]=i;
        }
        int[][] bin=new int[pos.length][B];
        for(int i=0;i<bin.length;i++)
        {
            String next=int2bin(pos[i]);
            if(next.length()<B)
            {
                int x=B-next.length();
                for(int j=0;j<x;j++)
                {
                    next="0"+next;
                }
            }
            for(int j=0;j<B;j++)
            {
                bin[i][j]=next.charAt(j)-'0';
            }
        }
        boolean[] no=new boolean[pos.length];
        int num=0;
        int low=0;
        while(num<N)
        {
            for(int i=low;i<pos.length;i++)
            {
                if(!no[i])
                {
                    num++;
                    if(N!=2)
                    {
                        remove(no,i,bin,D);
                    }
                    out.print(i);
                    if(num<N&&num%10!=0)
                    {
                        out.print(" ");
                    }
                    if(num<N&&num%10==0)
                    {
                        out.println();
                    }
                    low=i;
                    if(N==2)
                    {
                        low=pos.length-1;
                    }
                    break;
                }
            }
        }
        out.println();
        out.close();
        System.exit(0);
    }
    public static void remove(boolean[] no,int removal,int[][] bin,int D)
    {
        if(D==0)
        {
            return;
        }
        else
        {
            no[removal]=true;
            for(int i=0;i<bin[0].length;i++)
            {
                int[] temp=bin[removal];
                if(temp[i]==0)
                {
                    temp[i]++;
                    remove(no,bin2int(temp),bin,D-1);
                    temp[i]--;
                }
                if(temp[i]==1)
                {
                    temp[i]--;
                    remove(no,bin2int(temp),bin,D-1);
                    temp[i]++;
                }
            }
        }
    }
    public static int bin2int(int[] s)
    {
        String str="";
        for(int i=0;i<s.length;i++)
        {
            str+=s[i];
        }
        return (Integer.parseInt(str,2));
    }
    public static String int2bin(int num) 
    {
        if(num>0)
        {
            return ""+int2bin(num/2)+num%2;
        }
        return "";
    }
}
