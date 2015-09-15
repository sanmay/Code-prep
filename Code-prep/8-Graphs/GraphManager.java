import java.util.*;

class Vertex{
    ArrayList<Integer> edges;
    int marked;
    
    Vertex(){
        edges=new ArrayList<Integer>();
        marked=0;
    }
    
    void addEdge(int ref){
        edges.add(ref);
    }
    
    ArrayList<Integer> getEdges(){
        return edges;
    }
    
    void print(int vertex){
        System.out.println("Vertex id="+vertex+" marked="+marked);
        for(int i=0;i<edges.size();i++)
            System.out.print("\t"+edges.get(i));
        System.out.println();
    }
    
    void mark(){
        marked=1;
    }
}

class Edge{
    int v1,v2,w;
    
    Edge(int v1, int v2, int w){
        this.v1=v1;
        this.v2=v2;
        this.w=w;
    }
    
    void print(){
        System.out.println("Edge: V1="+v1+" V2="+v2+" W="+w);
    }
    
    int getWeight(){
        return w;
    }
}
class GraphManager{
    Vertex[] vertices;
    Edge[] edges;
    int cnt;
    
    GraphManager(int vertices, int edges){
        this.vertices=new Vertex[vertices];
        this.edges=new Edge[edges];
        cnt=0;
    }
    
    void insert(int v1, int v2, int w){
        if(vertices[v1]==null){
            Vertex temp=new Vertex();
            vertices[v1]=temp;
        }
        
        if(vertices[v2]==null){
            Vertex temp=new Vertex();
            vertices[v2]=temp;
        }
            
        edges[cnt]=new Edge(v1,v2,w);
        vertices[v1].addEdge(cnt);
        vertices[v2].addEdge(cnt);
        cnt++;
    }
    
    void print(){
        System.out.println("Printing Vertices");
        for(int i=0;i<vertices.length;i++){
            if(vertices[i]!=null)
                vertices[i].print(i);
        }
        
        System.out.println("Printing Edges");
        for(int i=0;i<cnt;i++){
           edges[i].print();
        }
    }

    void MST(){
        System.out.println("MST");
        Comparator <Edge> cmp=new Comparator<Edge>(){
            public int compare(Edge E1, Edge E2){
                return E1.w-E2.w;
            }
        };
        
        PriorityQueue <Edge> pq=new PriorityQueue<Edge>(11,cmp);
        Vertex temp=vertices[1];
        vertices[1].mark();
        for(int i=0;i<temp.getEdges().size();i++){
            pq.add(edges[temp.getEdges().get(i)]);
            edges[temp.getEdges().get(i)].print();
        }
        
        while(pq.size()>0){
            Edge e=pq.poll();
            e.print();
            if(vertices[e.v1].marked==0 || vertices[e.v2].marked==0){
                System.out.print("In MST");
                e.print();
                int idx;
                if(vertices[e.v1].marked==0)
                    idx=e.v1;
                else
                    idx=e.v2;
                    
                for(int i=0;i<vertices[idx].getEdges().size();i++){
                    pq.add(edges[vertices[idx].getEdges().get(i)]);
                }
                vertices[idx].mark();
            }
            
        }
    }
}