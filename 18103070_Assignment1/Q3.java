import java.util.*; 
 
class Q3 
{ 
	class Edge 
	{ 
		int source, destination, weight; 
		Edge() 
		{ 
			source = 0;
			destination = 0;
			weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	Q3(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		
		for(int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 
	
	void BellmanFord(Q3 graph, int source) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[source] = 0; 

		for (int i = 1; i < V; ++i) 
		{ 
			for (int j = 0; j < E; ++j) 
			{ 
				int u = graph.edge[j].source; 
				int v = graph.edge[j].destination; 
				int weight = graph.edge[j].weight; 
				if (dist[u]!= Integer.MAX_VALUE && dist[u]+weight<dist[v])
				{
					dist[v]=dist[u]+weight;
				}
			} 
		} 

		for (int j = 0; j < E; ++j) 
		{ 
			int u = graph.edge[j].source; 
			int v = graph.edge[j].destination; 
			int weight = graph.edge[j].weight; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
			{ 
				System.out.println("Negative cycles Exist"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	void printArr(int dist[], int V) 
	{ 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	public static void main(String[] args) 
	{ 
		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of vertices:");
		int V = input.nextInt();
		System.out.println("Enter no. of edges:");
		int E = input.nextInt();  

		Q3 graph = new Q3(V, E); 
		System.out.println("Enter the source vertex, destination vertex and weight of each edge:");
		for(int i=0;i<E;i++)
		{
			graph.edge[i].source = input.nextInt(); 
			graph.edge[i].destination = input.nextInt(); 
			graph.edge[i].weight = input.nextInt();
		}
		input.close();
		graph.BellmanFord(graph, 0); 
	} 
} 