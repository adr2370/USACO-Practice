/*
ID: alexstar11
LANG: JAVA
TASK: lonesome
*/
import java.io.*;
import java.util.*;
class lonesome {
     public static void main (String [] args) throws IOException
     {
         BufferedReader f = new BufferedReader(new FileReader("lonesome.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lonesome.out")));
         StringTokenizer st = new StringTokenizer(f.readLine());
         int num = Integer.parseInt(st.nextToken());
         int[][] locs=new int[num][2];
         for(int i=0;i<num;i++)
         {
             st = new StringTokenizer(f.readLine());
             int x = Integer.parseInt(st.nextToken());
             int y = Integer.parseInt(st.nextToken());
             locs[i][0]=x;
             locs[i][1]=y;
         }
         double max=0;
         int loc1=0;
         int loc2=0;
         for(int i=0;i<num;i++)
         {
             for(int j=i+1;j<num;j++)
             {
                 double xDist=locs[i][0]-locs[j][0]*locs[j][0];
                 double yDist=locs[i][1]-locs[j][1]*locs[j][1];
                 double dist=Math.sqrt(xDist*xDist+yDist*yDist);
                 if(dist>max)
                 {
                     max=dist;
                     loc1=i+1;
                     loc2=j+1;
                 }
             }
         }
         out.println(loc1+" "+loc2);
         out.close();
         System.exit(0);
     }
}
