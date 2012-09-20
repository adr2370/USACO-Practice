/*
ID: alexstar11
LANG: JAVA
TASK: preface
*/
import java.io.*;
import java.util.*;
class preface 
{
    private static final String[] RCODE = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static final int[]    BVAL  = {1000, 900, 500, 400,  100,   90,  50,   40,   10,    9,   5,   4,    1};
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N=Integer.parseInt(st.nextToken());
        String ans="";
        for(int i=1;i<=N;i++)
        {
            ans+=binaryToRoman(i);
        }
        int I=0;
        int V=0;
        int X=0;
        int L=0;
        int C=0;
        int D=0;
        int M=0;
        for(int i=0;i<ans.length();i++)
        {
            if(ans.charAt(i)=='I')
            {
                I++;
            }
            if(ans.charAt(i)=='V')
            {
                V++;
            }
            if(ans.charAt(i)=='X')
            {
                X++;
            }
            if(ans.charAt(i)=='L')
            {
                L++;
            }
            if(ans.charAt(i)=='C')
            {
                C++;
            }
            if(ans.charAt(i)=='D')
            {
                D++;
            }
            if(ans.charAt(i)=='M')
            {
                M++;
            }
        }
        if(I>0)
        {
            out.println("I "+I);
        }
        if(V>0)
        {
            out.println("V "+V);
        }
        if(X>0)
        {
            out.println("X "+X);
        }
        if(L>0)
        {
            out.println("L "+L);
        }
        if(C>0)
        {
            out.println("C "+C);
        }
        if(D>0)
        {
            out.println("D "+D);
        }
        if(M>0)
        {
            out.println("M "+M);
        }
        out.close();
        System.exit(0);
    }
    public static String binaryToRoman(int binary) {
        String roman = "";
        for (int i = 0; i < RCODE.length; i++) {
            while (binary >= BVAL[i]) {
                binary -= BVAL[i];
                roman  += RCODE[i];
            }
        }
        return roman;
    }  
}
