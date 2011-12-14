
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph G = new Graph();
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");
		
		Edge AE = new Edge(A, E);
		Edge AC = new Edge(A, C);
		Edge BD = new Edge(B, D);
		Edge CD = new Edge(C, D);
		Edge DF = new Edge(D, F);
		
		G.addVertex(A);
		G.addVertex(B);
		G.addVertex(C);
		G.addVertex(D);
		G.addVertex(E);
		G.addVertex(F);
		
		G.addEdge(AE);
		G.addEdge(AC);
		G.addEdge(BD);
		G.addEdge(CD);
		G.addEdge(DF);
		
		System.out.println(G);
		System.out.println(G.BFS(A));
	}

}
