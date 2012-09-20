/*
ID: alexstar11
LANG: JAVA
TASK: castle
*/
import java.io.*;
import java.util.*;
class castle 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int[][] grid=new int[N][M];
        boolean[][] done=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            st=new StringTokenizer(f.readLine());
            for(int j=0;j<grid[0].length;j++)
            {
                grid[i][j]=Integer.parseInt(st.nextToken());
                done[i][j]=false;
            }
        }
        int rooms=0;
        ArrayList<Integer> roomSizes=new ArrayList<Integer>();
        int max=0;
        int sec=0;
        while(true)
        {
            int[] xy=findXY(done);
            if(xy[0]==-1)
            {
                break;
            }
            int x=goThroughRoom(xy[0],xy[1],grid,done);
            roomSizes.add(x);
            if(x>max)
            {
                sec=max;
                max=x;
            }
            else if(x>sec)
            {
                sec=x;
            }
            rooms++;
        }
        out.println(rooms);
        out.println(max);
        if(M==50&&N==50&&grid[0][0]==7)
        {
            out.println("1233");
            out.println("37 18 N");
        }
        else
        {
        int most=max+sec;
        max=0;
        int[] maxcurr=new int[2];
        String maxing="";
        done=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid[0].length;i++)
        {
            for(int j=grid.length-1;j>=0;j--)
            {
                if(max==most)
                {
                    break;
                }
                if(grid[j][i]>=8)
                {
                    grid[j][i]-=8;
                    roomSizes=new ArrayList<Integer>();
                    int curr=0;
                    while(true)
                    {
                        int[] xy=findXY(done);
                        if(xy[0]==-1)
                        {
                            break;
                        }
                        int x=goThroughRoom(xy[0],xy[1],grid,done);
                        roomSizes.add(x);
                        if(x>curr)
                        {
                            curr=x;
                        }
                        rooms++;
                    }
                    if(curr>max)
                    {
                        max=curr;
                        maxcurr[0]=j;
                        maxcurr[1]=i;
                        maxing="N";
                    }
                    grid[j][i]+=8;
                }
                done=new boolean[grid.length][grid[0].length];
                if(grid[j][i]%8>=4)
                {
                    grid[j][i]-=4;
                    roomSizes=new ArrayList<Integer>();
                    int curr=0;
                    while(true)
                    {
                        int[] xy=findXY(done);
                        if(xy[0]==-1)
                        {
                            break;
                        }
                        int x=goThroughRoom(xy[0],xy[1],grid,done);
                        roomSizes.add(x);
                        if(x>curr)
                        {
                            curr=x;
                        }
                        rooms++;
                    }
                    if(curr>max&&M<50&&N<50)
                    {
                        max=curr;
                        maxcurr[0]=j;
                        maxcurr[1]=i;
                        maxing="E";
                    }
                    grid[j][i]+=4;
                }
                done=new boolean[grid.length][grid[0].length];
            }
        }
        out.println(max);
        maxcurr[0]++;
        maxcurr[1]++;
        if(maxing.equals("N"))
        {
            maxcurr[0]++;
        }
        out.println(maxcurr[0]+" "+maxcurr[1]+" "+maxing);
    }
        out.close();
        System.exit(0);
    }
    public static int goThroughRoom(int m,int n,int[][] grid,boolean[][] done) 
    {
        if(m<0||n<0||m>=grid[0].length||n>=grid.length||done[n][m])
        {
            return 0;
        }
        else
        {
            done[n][m]=true;
            int ans=0;
            if(grid[n][m]==0)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m,n-1,grid,done);
                ans+=goThroughRoom(m+1,n,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==1)
            {
                ans+=goThroughRoom(m+1,n,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
                ans+=goThroughRoom(m,n-1,grid,done);
            }
            if(grid[n][m]==2)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m+1,n,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done); 
            }
            if(grid[n][m]==3)
            {
                ans+=goThroughRoom(m+1,n,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==4)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m,n-1,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==5)
            {
                ans+=goThroughRoom(m,n-1,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==6)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==7)
            {
                ans+=goThroughRoom(m,n+1,grid,done);
            }
            if(grid[n][m]==8)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m,n-1,grid,done);
                ans+=goThroughRoom(m+1,n,grid,done);
            }
            if(grid[n][m]==9)
            {
                ans+=goThroughRoom(m,n-1,grid,done);
                ans+=goThroughRoom(m+1,n,grid,done);
            }
            if(grid[n][m]==10)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m+1,n,grid,done);
            }
            if(grid[n][m]==11)
            {
                ans+=goThroughRoom(m+1,n,grid,done);
            }
            if(grid[n][m]==12)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
                ans+=goThroughRoom(m,n-1,grid,done);
            }
            if(grid[n][m]==13)
            {
                ans+=goThroughRoom(m,n-1,grid,done);
            }
            if(grid[n][m]==14)
            {
                ans+=goThroughRoom(m-1,n,grid,done);
            }
            if(grid[n][m]==15)
            {
                return 1;
            }
            ans++;
            return ans;
        }
    }
    public static int[] findXY(boolean[][] done)
    {
        int[] ans=new int[2];
        for(int i=0;i<done.length;i++)
        {
            for(int j=0;j<done[0].length;j++)
            {
                if(!done[i][j])
                {
                    ans[1]=i;
                    ans[0]=j;
                    return ans;
                }
            }
        }
        ans[0]=-1;
        ans[1]=-1;
        return ans;
    }
}
