/*
ID: alexstar11
LANG: JAVA
TASK: rocks
*/
import java.io.*;
import java.util.*;

class rocks1 {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("rocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rocks.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num=Integer.parseInt(st.nextToken());
        char[][] ans=new char[(int)Math.pow(2,num)][num];
        for(int i=0;i<Math.pow(2,num);i++)
        {
            int temp=i;
            for(int j=num-1;j>=0;j--)
            {
                if(temp>=(int)Math.pow(2,j))
                {
                    ans[i][j]='X';
                    temp-=Math.pow(2,j);
                }
                else
                {
                    ans[i][j]='O';
                }
            }
        }
        System.out.println(helper(ans,0,num,new boolean[(int)Math.pow(2,num)],ans[0]));
        out.close();
        System.exit(0);
    }
    private static String helper(char[][] ans,int n,int num,boolean[] done,char[] curr)
    {
        if(n>Math.pow(2,num))
            return "fail";
        else if(n==Math.pow(2,num)&&curr==ans[0])
        {
            String a="";
            for(int i=0;i<num;i++)
            {
                a+=ans[0][i];
            }
            return a+"\n";
        }
        else
        {
            char[][] pos=new char[num][num];
            for(int i=0;i<num;i++)
            {
                char[] temp=new char[num];
                if(temp[i]=='X')
                {
                    temp[i]='O';
                }
                else
                {
                    temp[i]='X';
                }
                pos[i]=temp;
            }
            for(int i=0;i<num;i++)
            {
                int x=0;
                for(int j=0;j<num;j++)
                {
                    if(pos[i][j]=='X')
                        x+=Math.pow(2,j);
                }
                if(!done[num])
                {
                    boolean[] t=done;
                    t[num]=true;
                    String a = "";
                    for(int k=0;k<num;k++)
                        a+=pos[i][k];
                    a+="\n";
                    String b=helper(ans,n+1,num,t,pos[i]);
                    if(!b.equals("fail"))
                        return a+b;
                }
            }
            return "fail";
        }
    }
}
