/*
ID: alexstar11
LANG: JAVA
TASK: kcow
*/
import java.io.*;
import java.util.*;
class kcow 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("kcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kcow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[][][] grid=new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())][2];
        
        out.println(w);
        out.close();
        System.exit(0);
    }
}
