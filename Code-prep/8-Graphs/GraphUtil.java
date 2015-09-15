
import java.util.*;
 
class Node{
	public int data;
	public boolean visited;
	ArrayList <Node> edges;
	
	Node(int data){
		this.data=data;
		edges=new ArrayList<Node> ();
		visited=false;
	}
	
	void addEdge(Node temp){
		edges.add(temp);
	}
	
	ArrayList <Node> getEdges(){
		return edges;
	}
	
	void print(){
		System.out.println("Node="+data);
		for (int i=0;i<edges.size();i++){
			System.out.println(edges.get(i).data);
		}
		System.out.println("End of Node Data");
	}
}

class Graph{

	public ArrayList <Node> Vertices;
	
	
	Graph(){
		Vertices=new ArrayList <Node> ();
	}
	
	Node getNode(int data){
		for(int i=0;i<Vertices.size();i++){
			if (Vertices.get(i).data==data)
				return Vertices.get(i);
		}
		return null;
	}
	
	void insert(int data, int[] edges){
		Node vertex=getNode(data);
		if (vertex==null)
			vertex=new Node(data);
		Vertices.add(vertex);
		for (int i=0;i<edges.length;i++){
			Node temp=getNode(edges[i]);
			if (temp==null)
				temp=new Node(edges[i]);
			vertex.addEdge(temp);
		}
	}
	
	ArrayList <Node> getVertices(){
		return Vertices;
	}
	
	void print(){
		System.out.println("Printing Graph");
		for (int i=0;i<Vertices.size();i++){
			Node temp_node=Vertices.get(i);
			temp_node.print();
			//System.out.print(temp_node.data);
			//ArrayList <Node> temp_edges=temp_node.getEdges();
			//for (int j=0;j<temp_edges.size();j++){
			//	System.out.print("\t"+temp_edges.get(j).data);
			//}
			//System.out.println();
		}
		System.out.println("---------------");
	}

	void BFS(Graph G){
		System.out.println("BFS");
		Queue <Node> Q=new LinkedList<Node> ();
		ArrayList <Node> vertices=G.getVertices();
		Q.add(vertices.get(0));
		vertices.get(0).visited=true;
		
		while(Q.size()>0){
			//G.print();
			Node temp=Q.poll();
			System.out.println(temp.data);
			//temp.print();
			ArrayList <Node> edges=temp.getEdges();
			for(int i=0;i<edges.size();i++){
				Node temp2=getNode(edges.get(i).data);
				//temp2.print();
				 if(temp2.visited==false){
					 temp2.visited=true;
					 Q.add(temp2);
				 }
			}
			
		}
	}
	
	void DFS(Node n){
		System.out.println(n.data);
		ArrayList <Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if (temp.visited==false){
				temp.visited=true;
				DFS(temp);
			}
			
		}
		
	}
	
	boolean FindUndirectedCycle(Node n, Node parent){
		n.visited=true;
		ArrayList<Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if(temp.visited==true && temp.data!=parent.data)
				return false;
			else if(temp.visited!=true)
				return FindUndirectedCycle(temp,n);
		}
		return true;
	}
	
	boolean DFSUtil(Node n){
		ArrayList<Node> edges=n.getEdges();
		for(int i=0;i<edges.size();i++){
			Node temp=getNode(edges.get(i).data);
			if(temp.visited)
				return false;
			else
				return DFSUtil(temp);
		}
		return true;
	}
	
	boolean FindDirectCycle(){
		
		for(int i=0;i<Vertices.size();i++){
			Vertices.get(i).visited=true;
			if (!DFSUtil(Vertices.get(i)))
				return false;
			Vertices.get(i).visited=false;
		}
		return true;
	}
}

class GraphUtil{
	public static void main(String [] args){
		System.out.println("Graph and methods");
		Graph G=new Graph();
		G.insert(1,new int[]{3});
		G.insert(3,new int[]{});
		G.insert(5,new int[]{1});
		G.insert(7,new int[]{5,3});
		G.print();
		System.out.println(G.FindDirectCycle());
		
		
		
	}
	
}