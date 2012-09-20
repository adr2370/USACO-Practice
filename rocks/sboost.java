/*
ID: alexstar11
LANG: JAVA
TASK: sboost
*/
import java.io.*;
import java.util.*;

class sboost {
    public static void main (String [] args) throws IOException
    {
        BufferedReader x = new BufferedReader(new FileReader("sboost.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sboost.out")));
        StringTokenizer st = new StringTokenizer(x.readLine());
        int f=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] forces=new int[n];
        int[] masses=new int[n];
        double[] ratios=new double[n];
        int[] ind=new int[n];
        for(int i=0;i<n;i++)
        {
            st = new StringTokenizer(x.readLine());
            forces[i]=Integer.parseInt(st.nextToken());
            masses[i]=Integer.parseInt(st.nextToken());
            ratios[i]=((double)(forces[i]))/((double)(masses[i]));
            ind[i]=i;
        }
        for(int i=0;i<n;i++)
        {
            int max=i;
            for(int j=i;j<n;j++)
            {
                if(ratios[ind[j]]>ratios[ind[max]])
                {
                    max=j;
                }
            }
            int temp=ind[i];
            ind[i]=ind[max];
            ind[max]=temp;
        }
        double curr=((double)(f))/((double)(m));
        int k=0;
        while(ratios[ind[k]]>curr)
        {
            f+=forces[ind[k]];
            m+=masses[ind[k]];
            curr=((double)(f))/((double)(m));
            k++;
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=ind[i];
        }
        for(int i=0;i<k;i++)
        {
            int min=i;
            for(int j=i;j<k;j++)
            {
                if(ans[j]<ans[min])
                {
                    min=j;
                }
            }
            int temp=ans[i];
            ans[i]=ans[min];
            ans[min]=temp;
        }
        for(int i=0;i<k;i++)
        {
            out.println(ans[i]+1);
        }
        out.close();
        System.exit(0);
    }
}
