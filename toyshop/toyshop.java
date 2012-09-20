/*
ID: alexstar11
LANG: JAVA
TASK: toyshop
*/
import java.io.*;
import java.util.*;

class toyshop {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("toyshop.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("toyshop.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        double[][] toys=new double[N][2];
        double[][] max=new double[3][2];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(f.readLine());
            toys[i][0] = Integer.parseInt(st.nextToken());
            toys[i][1] = Integer.parseInt(st.nextToken());
            toys[i][0]=toys[i][0]/toys[i][1];
        }
        for(int i=0;i<N;i++)
        {
            if(toys[i][0]>max[0][0])
            {
                max[2][0]=max[1][0];
                max[2][1]=max[1][1];
                max[1][0]=max[0][0];
                max[1][1]=max[0][1];
                max[0][0]=toys[i][0];
                max[0][1]=i;
            }
            else if(toys[i][0]>max[1][0])
            {
                max[2][0]=max[1][0];
                max[2][1]=max[1][1];
                max[1][0]=toys[i][0];
                max[1][1]=i;
            }
            else if(toys[i][0]>max[2][0])
            {
                max[2][0]=toys[i][0];
                max[2][1]=i;
            }
        }
        int sum=(int)(toys[(int)max[0][1]][1]+toys[(int)max[1][1]][1]+toys[(int)max[2][1]][1]);
        int val1=(int)max[0][1]+1;
        int val2=(int)max[1][1]+1;
        int val3=(int)max[2][1]+1;
        out.println(sum);
        out.println(val1);
        out.println(val2);
        out.println(val3);
        out.close();
        System.exit(0);
    }
}
