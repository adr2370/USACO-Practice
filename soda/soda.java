/*
ID: alexstar11
LANG: JAVA
TASK: soda
*/
import java.io.*;
import java.util.*;
class soda
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("soda.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("soda.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        int[][] stuff=new int[N][2];        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            stuff[i][0]=Integer.parseInt(st.nextToken());
            stuff[i][1]=Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> nextMin=new ArrayList<Integer>();
        ArrayList<Integer> nextMax=new ArrayList<Integer>();
        ArrayList<Integer> number=new ArrayList<Integer>();
        int max=0;
        for(int i=0;i<N;i++)
        {
            nextMin.add(stuff[i][0]);
            nextMax.add(stuff[i][1]);
            number.add(1);
            while(nextMin.size()>0)
            {
                int currMin=nextMin.remove(0);
                int currMax=nextMax.remove(0);
                int currNum=number.remove(0);
                if(currNum>max)
                {
                    max=currNum;
                }
                for(int j=i+currNum;j<N;j++)
                {
                    if(stuff[j][0]<currMax&&currMax<stuff[j][1])
                    {
                        nextMin.add(stuff[j][0]);
                        nextMax.add(currMax);
                        number.add(currNum+1);
                    }
                    else if(stuff[j][0]<currMin&&currMin<stuff[j][1])
                    {
                        nextMin.add(currMin);
                        nextMax.add(stuff[j][1]);
                        number.add(currNum+1);
                    }
                }
            }
        }
        out.println(max);
        out.close();
        System.exit(0);
    }
}
