/*
ID: alexstar11
LANG: JAVA
TASK: rocks
*/
import java.io.*;
import java.util.*;

class rocks {
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("rocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rocks.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num=Integer.parseInt(st.nextToken());
        String[][] ans=new String[(int)Math.pow(2,num)][num];
        for(int i=0;i<Math.pow(2,num);i++)
        {
            int temp=i;
            for(int j=num-1;j>=0;j--)
            {
                if(temp>=(int)Math.pow(2,j))
                {
                    ans[i][j]="X";
                    temp-=Math.pow(2,j);
                }
                else
                {
                    ans[i][j]="O";
                }
            }
        }
        int[] blahs=new int[(int)Math.pow(2,num)];
        int i=1;
        blahs[0]=1;
            int count=1;
            while(count<num-1)
            {
                for(int j=0;j<count;j++)
                {
                    blahs[i]=j+2;
                    i++;
                }
                for(int j=0;j<count;j++)
                {
                    blahs[i]=count-j;
                    i++;
                }
                count++;
            }
                for(int j=0;j<num;j++)
                {
                    blahs[i]=j+2;
                    i++;
                }
                count=num-1;
                while(count>2)
                {
                for(int j=0;j<count-2;j++)
                {
                for(int k=0;k<count-1;k++)
                {
                    blahs[i]=count-k;
                    i++;
                }
                if(i<Math.pow(2,num)-1)
                {
                    for(int k=0;k<count-2;k++)
                {
                    blahs[i]=k+3;
                    i++;
                }
            }
            else
            {
                blahs[i]=1;
                i++;
            }
            }
            count--;
        }
        for(i=(int)Math.pow(2,num)-1;i>0;i--)
        {
            blahs[i]=blahs[i]-blahs[i-1];
        }
        boolean done=false;
            boolean[] don=new boolean[(int)Math.pow(2,num)];
            String a="";
            int curr=0;
            for( i=0;i<num;i++)
            {
                a+=ans[curr][i];
            }
            a+="\n";
            int n=0;
            while(n<Math.pow(2,num)-1)
            {
                int p=0;
                int blah=blahs[n];
                if(blah>0)
                {
                    while((Math.pow(2,p)+curr)<Math.pow(2,num)&&(don[(int)(Math.pow(2,p))+curr]||(ans[curr][p].equals("X"))))
                        p++;
                    if((Math.pow(2,p)+curr)<Math.pow(2,num))
                    {
                        curr=curr+(int)Math.pow(2,p);
                        for( i=0;i<num;i++)
                        {
                            a+=ans[curr][i];
                        }
                        a+="\n";
                        don[curr]=true;
                    }
                }
                else if(blah<0)
                {
                    while((curr-Math.pow(2,p))>=0&&(don[curr-(int)(Math.pow(2,p))]||ans[curr][p].equals("O")))
                        p++;
                    if((curr-Math.pow(2,p))>=0)
                    {
                        curr=curr-(int)Math.pow(2,p);
                        for( i=0;i<num;i++)
                        {
                            a+=ans[curr][i];
                        }
                        a+="\n";
                        don[curr]=true;
                    }
                }
                n++;
                System.out.println(curr);
            }
            if(curr==0)
            {
                done=true;
                System.out.print(a);
            }
        out.close();
        System.exit(0);
    }
}
