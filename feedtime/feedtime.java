/*
ID: alexstar11
LANG: JAVA
TASK: feedtime
*/
import java.io.*;
import java.util.*;

class feedtime {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("feedtime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feedtime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] food=new int[H][W][2];
        int max=0;
        for(int i=0;i<H;i++)
        {
            st = new StringTokenizer(f.readLine());
            String ab=st.nextToken();
            for(int j=0;j<W;j++)
            {
                String blah=ab.substring(j,j+1);
                if(blah.equals("."))
                {
                    food[i][j][0]=1;
                }
                else
                    food[i][j][0]=0;
            }
        }
        int count=1;
        for(int i=H-1;i>=0;i--)
        {
            for(int j=W-1;j>=0;j--)
            {
                if(food[i][j][0]==1)
                {
                    if(food[i][j][1]==0)
                    {
                        set(i,j,count,food);
                        count++;
                    }
                }
            }
        }
        int[] ans=new int[count];
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
            {
                if(food[i][j][0]==1)
                {
                    ans[food[i][j][1]-1]++;
                }
            }
        }
        for(int i=0;i<count;i++)
        {
            if(ans[i]>max)
                max=ans[i];
        }
        out.println(max);
        out.close();
        System.exit(0);
    }
    private static void set(int i, int j, int val, int[][][] food)
    {
        if(food[i][j][0]==1&&food[i][j][1]==0)
        {
            food[i][j][1]=val;
                    boolean a=i>0;
                    boolean b=j>0;
                    boolean c=i<food.length-1;
                    boolean d=j<food[0].length-1;
                    if(a)
                    {
                        set(i-1,j,val,food);
                    }
                    if(b)
                    {
                        set(i,j-1,val,food);
                    }
                    if(c)
                    {
                        set(i+1,j,val,food);
                    }
                    if(d)
                    {
                        set(i,j+1,val,food);
                    }
                    if(a&&b)
                    {
                        set(i-1,j-1,val,food);
                    }
                    if(b&&c)
                    {
                        set(i+1,j-1,val,food);
                    }
                    if(c&&d)
                    {
                        set(i+1,j+1,val,food);
                    }
                    if(d&&a)
                    {
                        set(i-1,j+1,val,food);
                    }
                }
    }
}
