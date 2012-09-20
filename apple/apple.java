/*
ID: alexstar11
LANG: JAVA
TASK: apple
*/
import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.PriorityQueue;
class apple
{
    public static void main (String [] args) throws IOException 
    {
        BufferedReader f = new BufferedReader(new FileReader("apple.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("apple.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int C=Integer.parseInt(st.nextToken());//number of paths
        int P=Integer.parseInt(st.nextToken());//number of nodes
        int PB=Integer.parseInt(st.nextToken())-1;//where cow starts
        int PA1=Integer.parseInt(st.nextToken())-1;//one apple drop off
        int PA2=Integer.parseInt(st.nextToken())-1;//other apple drop off
        Vertex[] vertexs=new Vertex[P];
        ArrayList<ArrayList<Edge>> edges=new ArrayList<ArrayList<Edge>>();
        for(int i=0;i<P;i++)
        {
            edges.add(new ArrayList<Edge>());
            vertexs[i]=new Vertex(""+i);
        }
        for(int i = 0; i < C; i++)//getting node coordinates
        {
            st = new StringTokenizer(f.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Edge(vertexs[s], dist));
            edges.get(s).add(new Edge(vertexs[u], dist));
        }
        for(int i=0;i<P;i++)
        {
            Edge[] curr=new Edge[edges.get(i).size()];
            for(int j=0;j<edges.get(i).size();j++)
            {
                curr[j]=edges.get(i).get(j);
            }
            vertexs[i].adjacencies=curr;
        }
        int ans=0;
        computePaths(vertexs[PA1]);
        ans+=vertexs[PB].minDistance;
        ans+=vertexs[PA2].minDistance;
        int a=0;
        for(Vertex v:vertexs)
        {
            v.minDistance=Double.POSITIVE_INFINITY;
            v.previous=null;
        }
        computePaths(vertexs[PA2]);
        a+=vertexs[PB].minDistance;
        a+=vertexs[PA1].minDistance;
        if(a<ans)
        {
            ans=a;
        }
        System.out.println(ans);
        out.println(ans);
        out.close();
        System.exit(0);
    }
    static class Vertex implements Comparable<Vertex>
  {
      public final String name;
      public Edge[] adjacencies;
      public double minDistance = Double.POSITIVE_INFINITY;
      public Vertex previous;
      public Vertex(String argName) { name = argName; }
      public String toString() { return name; }
      public int compareTo(Vertex other)
      {
          return Double.compare(minDistance, other.minDistance);
      }
  
  }
  
  
  static class Edge
  {
      public final Vertex target;
      public final double weight;
      public Edge(Vertex argTarget, double argWeight)
      { target = argTarget; weight = argWeight; }
  }
  
  
      public static void computePaths(Vertex source)
      {
          source.minDistance = 0.;
          PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
          vertexQueue.add(source);
  
          while (!vertexQueue.isEmpty()) {
                Vertex u = vertexQueue.poll();
  
              // Visit each edge exiting u
             for (Edge e : u.adjacencies)
             {
                  Vertex v = e.target;
                  double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
  		if (distanceThroughU < v.minDistance) {
  		    vertexQueue.remove(v);
  
  		    v.minDistance = distanceThroughU ;
  		    v.previous = u;
  		    vertexQueue.add(v);
  
  		}
  
              }
          }
      }
  
  
      public static List<Vertex> getShortestPathTo(Vertex target)
      {
          List<Vertex> path = new ArrayList<Vertex>();
          for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
              path.add(vertex);
  
          Collections.reverse(path);
          return path;
     }
}