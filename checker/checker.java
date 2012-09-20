/*
ID: alexstar11
LANG: JAVA
TASK: checker
*/
import java.io.*;
import java.util.*;
class checker
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("checker.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num=Integer.parseInt(st.nextToken());
        ArrayList<String> ans=recursion(new int[num][num],new ArrayList<String>(),-1,num,0,"");
        out.println(ans.size());
        out.close();
        System.exit(0);
    }
    public static ArrayList<String> recursion(int[][] grid,ArrayList<String> ans,int row,int max,int column,String curr)
    {
        System.out.println(curr);
        if(row==max-1)
        {
            for(int i=0;i<column;i++)
            {
                if(grid[row][column]==0)
                {
                    ans.add(curr+i);
                    return ans;
                }
            }
            return ans;
        }
        else if(row==-1)
        {
            ArrayList<String> temp=ans;
            for(int i=0;i<max;i++)
            {
                ans=combine(ans,recursion(grid,ans,i,max,0,i+" "));
            }
            return ans;
        }
        else
        {
            int[][] grid1=transfer(grid);
            grid1[column][row]=1;
            for(int i=column+1;i<max;i++)
            {
                grid1[i][row]=2;
                if(row+(i-column)<max)
                {
                    grid1[i][row+(i-column)]=2;
                }
                if(row-(i-column)>=0)
                {
                    grid1[i][row-(i-column)]=2;
                }
            }
            for(int i=0;i<max;i++)
            {
                if(grid1[column+1][i]==0)
                {
                    ans=combine(ans,recursion(grid1,ans,i,max,column+1,curr+i+" "));
                }
            }
            return ans;
        }
    }
    public static int[][] transfer(int[][] grid)
    {
        int[][] ans=new int[grid.length][grid[0].length];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                ans[i][j]=grid[i][j];
            }
        }
        return ans;
    }
    public static ArrayList<String> combine(ArrayList<String> a1,ArrayList<String> a2)
    {
        ArrayList<String> temp1=a1;
        ArrayList<String> temp2=a2;
        while(temp2.size()>0)
        {
            temp1.add(temp2.remove(0));
        }
        return temp1;
    }
}