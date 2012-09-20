/*
ID: alexstar11
LANG: JAVA
TASK: pprime
*/
import java.io.*;
import java.util.*;
class pprime
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int min=Integer.parseInt(st.nextToken());
        int max=Integer.parseInt(st.nextToken());
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int d1=5;d1<=9;d1+=2) 
        {
            int palindrome=d1;
            if(isPrime(palindrome))
            {
                ans.add(palindrome);
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            int palindrome=10*d1+d1;
            if(isPrime(palindrome))
            {
                ans.add(palindrome);
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                int palindrome=100*d1+10*d2+d1;
                if(isPrime(palindrome))
                {
                    ans.add(palindrome);
                }
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                int palindrome=1000*d1+100*d2+10*d2+d1;
                if(isPrime(palindrome))
                {
                    ans.add(palindrome);
                }
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                for(int d3=0;d3<=9;d3++) 
                {
                    int palindrome=10000*d1+1000*d2+100*d3+10*d2+d1;
                    if(isPrime(palindrome))
                    {
                        ans.add(palindrome);
                    }
                }
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                for(int d3=0;d3<=9;d3++) 
                {
                    int palindrome=100000*d1+10000*d2+1000*d3+100*d3+10*d2+d1;
                    if(isPrime(palindrome))
                    {
                        ans.add(palindrome);
                    }
                }
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                for(int d3=0;d3<=9;d3++) 
                {
                    for(int d4=0;d4<=9;d4++) 
                    {
                        int palindrome=1000000*d1+100000*d2+10000*d3+1000*d4+100*d3+10*d2+d1;
                        if(isPrime(palindrome))
                        {
                            ans.add(palindrome);
                        }
                    }
                }
            }
        }
        for(int d1=1;d1<=9;d1+=2) 
        {
            for(int d2=0;d2<=9;d2++) 
            {
                for(int d3=0;d3<=9;d3++) 
                {
                    for(int d4=0;d4<=9;d4++) 
                    {
                        int palindrome=10000000*d1+1000000*d2+100000*d3+10000*d4+1000*d4+100*d3+10*d2+d1;
                        if(isPrime(palindrome))
                        {
                            ans.add(palindrome);
                        }
                    }
                }
            }
        }
        for(Integer a:ans)
        {
            if(a>=min&&a<=max)
            {
                out.println(a);
            }
        }
        out.close();
        System.exit(0);
    }
    public static boolean isPrime(int n) {
		boolean prime = true;
		for (int i = 3; i <= Math.sqrt(n); i += 2)
		{
			if (n % i == 0)
			{
				prime = false;
				break;
			}
        }
		if (( n%2 !=0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}
}