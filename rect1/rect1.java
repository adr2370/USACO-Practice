/*
ID: alexstar11
LANG: JAVA
TASK: rect1
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.PriorityQueue;
class rect1
{
    public static void main (String [] args) throws Exception 
    {
        BufferedReader f = new BufferedReader(new FileReader("rect1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rect1.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> rectangles=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> base=new ArrayList<Integer>();
        base.add(0);
        base.add(0);
        base.add(A);
        base.add(B);
        base.add(1);
        rectangles.add(base);
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(f.readLine());
            ArrayList<Integer> currRect=new ArrayList<Integer>();
            for(int j=0;j<5;j++) {
                currRect.add(Integer.parseInt(st.nextToken()));
            }
            int smallX=currRect.get(0);
            int smallY=currRect.get(1);
            int bigX=currRect.get(2);
            int bigY=currRect.get(3);
            int color=currRect.get(4);
            for(int j=0;j<rectangles.size();j++) {
                int sX=rectangles.get(j).get(0);
                int sY=rectangles.get(j).get(1);
                int bX=rectangles.get(j).get(2);
                int bY=rectangles.get(j).get(3);
                int currColor=rectangles.get(j).get(4);
                if(bX<=sX||bY<=sY) {
                    rectangles.remove(j);
                    j--;
                } else if(bigY<=sY||bigX<=sX||smallY>=bY||smallX>=bX) {
                } else if(smallX<=sX&&smallY<=sY&&bigX>=bX&&bigY>=bY) {
                    rectangles.remove(j);
                    j--;
                } else {
                    if(smallX<sX&&smallY<sY&&bigX>bX) {
                        rectangles.get(j).set(1,bigY);
                    } else if(smallX<sX&&smallY<sY&&bigY>bY) {
                        rectangles.get(j).set(0,bigX);
                    } else if(smallX<sX&&bigX>bX&&bigY>bY) {
                        rectangles.get(j).set(3,smallY);
                    } else if(smallY<sY&&bigX>bX&&bigY>bY) {
                        rectangles.get(j).set(2,smallX);
                    } else {
                        if(smallX<sX&&smallY<sY) {
                            rectangles.get(j).set(0,bigX);
                            ArrayList<Integer> newRect1=new ArrayList<Integer>();
                            newRect1.add(sX);
                            newRect1.add(bigY);
                            newRect1.add(bigX);
                            newRect1.add(bY);
                            newRect1.add(currColor);
                            rectangles.add(j,newRect1);
                        } else if(smallY<sY&&bigX>bX) {
                            rectangles.get(j).set(2,smallX);
                            ArrayList<Integer> newRect1=new ArrayList<Integer>();
                            newRect1.add(smallX);
                            newRect1.add(bigY);
                            newRect1.add(bX);
                            newRect1.add(bY);
                            newRect1.add(currColor);
                            rectangles.add(j,newRect1);
                        } else if(smallX<sX&&bigY>bY) {
                            rectangles.get(j).set(0,bigX);
                            ArrayList<Integer> newRect1=new ArrayList<Integer>();
                            newRect1.add(sX);
                            newRect1.add(sY);
                            newRect1.add(bigX);
                            newRect1.add(smallY);
                            newRect1.add(currColor);
                            rectangles.add(j,newRect1);
                        } else if(bigX>bX&&bigY>bY) {
                            rectangles.get(j).set(2,smallX);
                            ArrayList<Integer> newRect1=new ArrayList<Integer>();
                            newRect1.add(smallX);
                            newRect1.add(sY);
                            newRect1.add(bX);
                            newRect1.add(smallY);
                            newRect1.add(currColor);
                            rectangles.add(j,newRect1);
                        } else {
                            if(smallX<sX) {
                                rectangles.get(j).set(3,smallY);
                                ArrayList<Integer> newRect1=new ArrayList<Integer>();
                                newRect1.add(sX);
                                newRect1.add(bigY);
                                newRect1.add(bX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(bigX);
                                newRect1.add(smallY);
                                newRect1.add(bX);
                                newRect1.add(bigY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                            } else if(smallY<sY) {
                                rectangles.get(j).set(2,smallX);
                                ArrayList<Integer> newRect1=new ArrayList<Integer>();
                                newRect1.add(bigX);
                                newRect1.add(sY);
                                newRect1.add(bX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(smallX);
                                newRect1.add(bigY);
                                newRect1.add(bigX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                            } else if(bigX>bX) {
                                rectangles.get(j).set(3,smallY);
                                ArrayList<Integer> newRect1=new ArrayList<Integer>();
                                newRect1.add(sX);
                                newRect1.add(bigY);
                                newRect1.add(bX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(sX);
                                newRect1.add(smallY);
                                newRect1.add(smallX);
                                newRect1.add(bigY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                            } else if(bigY>bY) {
                                rectangles.get(j).set(2,smallX);
                                ArrayList<Integer> newRect1=new ArrayList<Integer>();
                                newRect1.add(bigX);
                                newRect1.add(sY);
                                newRect1.add(bX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(smallX);
                                newRect1.add(sY);
                                newRect1.add(bigX);
                                newRect1.add(smallY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                            } else {
                                rectangles.get(j).set(2,smallX);
                                ArrayList<Integer> newRect1=new ArrayList<Integer>();
                                newRect1.add(bigX);
                                newRect1.add(sY);
                                newRect1.add(bX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(smallX);
                                newRect1.add(sY);
                                newRect1.add(bigX);
                                newRect1.add(smallY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                                newRect1=new ArrayList<Integer>();
                                newRect1.add(smallX);
                                newRect1.add(bigY);
                                newRect1.add(bigX);
                                newRect1.add(bY);
                                newRect1.add(currColor);
                                rectangles.add(j,newRect1);
                            }
                        }
                    }
                }
            }
            rectangles.add(currRect);
        }
        int[] counts=new int[2501];
        for(int i=0;i<rectangles.size();i++) {
            if(rectangles.get(i).get(2)>rectangles.get(i).get(0)&&rectangles.get(i).get(3)>rectangles.get(i).get(1)) {
                int size=rectangles.get(i).get(2)-rectangles.get(i).get(0);
                size*=rectangles.get(i).get(3)-rectangles.get(i).get(1);
                counts[rectangles.get(i).get(4)]+=size;
            }
        }
        for(int i=0;i<counts.length;i++) {
            if(counts[i]>0) {
                System.out.println(i+" "+counts[i]);
                out.println(i+" "+counts[i]);
            }
        }
        out.close();
        System.exit(0);
    }
}