/*
ID: alexstar11
LANG: JAVA
TASK: ttwo
*/
import java.io.*;
import java.util.*;
class ttwo 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
        String st;
        int ans=0;
        char[][] plot=new char[10][10];
        int FX=0;
        int FY=0;
        int CX=0;
        int CY=0;
        for(int i=0;i<10;i++)
        {
            st = f.readLine();
            for(int j=0;j<10;j++)
            {
                plot[i][j]=st.charAt(j);
                if(plot[i][j]=='F')
                {
                    FX=j;
                    FY=i;
                    plot[i][j]='.';
                }
                if(plot[i][j]=='C')
                {
                    CX=j;
                    CY=i;
                    plot[i][j]='.';
                }
            }
        }
        boolean done=false;
        char dirF='N';
        char dirC='N';
        while(!done)
        {
            if(dirF=='N')
            {
                if(FY==0||plot[FY-1][FX]=='*')
                {
                    dirF='E';
                }
                else
                {
                    FY--;
                }
            }
            else if(dirF=='E')
            {
                if(FX==9||plot[FY][FX+1]=='*')
                {
                    dirF='S';
                }
                else
                {
                    FX++;
                }
            }
            else if(dirF=='S')
            {
                if(FY==9||plot[FY+1][FX]=='*')
                {
                    dirF='W';
                }
                else
                {
                    FY++;
                }
            }
            else
            {
                if(FX==0||plot[FY][FX-1]=='*')
                {
                    dirF='N';
                }
                else
                {
                    FX--;
                }
            }
            if(dirC=='N')
            {
                if(CY==0||plot[CY-1][CX]=='*')
                {
                    dirC='E';
                }
                else
                {
                    CY--;
                }
            }
            else if(dirC=='E')
            {
                if(CX==9||plot[CY][CX+1]=='*')
                {
                    dirC='S';
                }
                else
                {
                    CX++;
                }
            }
            else if(dirC=='S')
            {
                if(CY==9||plot[CY+1][CX]=='*')
                {
                    dirC='W';
                }
                else
                {
                    CY++;
                }
            }
            else
            {
                if(CX==0||plot[CY][CX-1]=='*')
                {
                    dirC='N';
                }
                else
                {
                    CX--;
                }
            }
            ans++;
            if(ans>=1000000||ans<0)
            {
                ans=0;
                done=true;
            }
            if(CX==FX&&CY==FY)
            {
                done=true;
            }
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
}
