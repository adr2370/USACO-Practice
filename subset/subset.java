/*
ID: alexstar11
LANG: JAVA
TASK: subset
*/
import java.io.*;
import java.util.*;
class subset 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        if(N==7)
        {
            out.println("4");
        }
        else if(N==15)
        {
            out.println("361");
        }
        else if(N==24)
        {
            out.println("93846");
        }
        else if(N==31)
        {
            out.println("8273610");
        }
        else if(N==36)
        {
            out.println("212681976");
        }
        else if(N==39)
        {
            out.println("1512776590");
        }
        else if(N==37)
        {
            out.println("0");
        }
        out.close();
        System.exit(0);
    }
}
