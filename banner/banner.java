/*
ID: alexstar11
LANG: JAVA
TASK: banner
*/
import java.io.*;
import java.util.*;
class banner 
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("banner.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("banner.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int W=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());
        int L1=Integer.parseInt(st.nextToken());
        int L2=Integer.parseInt(st.nextToken());
        W++;
        H++;
        long ans=0;
        ArrayList<LinkedList<Integer>> allowed=new ArrayList<LinkedList<Integer>>();
        for(int i=1;i<W;i++)
        {
            for(int j=1;j<H;j++)
            {
                if(GCD(i,j)==1)
                {
                    double length=i*i+j*j;
                    if(length>=L1*L1&&length<=L2*L2)
                    {
                        LinkedList<Integer> curr=new LinkedList<Integer>();
                        curr.add(i);
                        curr.add(j);
                        allowed.add(curr);
                    }
                }
            }
        }
        for(int i=0;i<W;i++)
        {
            for(int j=0;j<H;j++)
            {
                int left=i;
                int right=W-i-1;
                int up=j;
                int down=H-j-1;
                for(LinkedList<Integer> curr:allowed)
                {
                    int x=curr.get(0);
                    int y=curr.get(1);
                    if(x<=left&&y<=up)
                    {
                        ans++;
                    }
                    if(x<=right&&y<=up)
                    {
                        ans++;
                    }
                    if(x<=left&&y<=down)
                    {
                        ans++;
                    }
                    if(x<=right&&y<=down)
                    {
                        ans++;
                    }
                }
            }
        }
        ans/=2;
        if(L1==1)
        {
            ans+=(W-1)*H;
            ans+=(H-1)*W;
        }
        out.println(ans);
        out.close();
        System.exit(0);
    }
    public static int GCD(int x,int y)
    {
        if(x==0)
        {
            return y;
        }
        else if(y==0)
        {
            return x;
        }
        else
        {
            if(x>y)
            {
                return GCD(x-y,y);
            }
            else
            {
                return GCD(x,y-x);
            }
        }
    }
}
