import java.io.*;
import java.util.*;
import java.lang.*;
class KEVIN
{
    public void method() 
    {
        int num=0;
        int total=0;
        for(int i=1;i<=99;i++)
        {
            for(int j=1;j<=99;j++)
            {
                int x=i;
                int y=j;
                int sum=0;
                if(x!=y)
                {
                    sum+=x%10+y%10;
                    x/=10;
                    y/=10;
                    sum+=x+y;
                    if(sum<10)
                    {
                        num++;
                    }
                    total++;
                }
            }
        }
        System.out.println(num+" "+total);
    }
}