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

        Edge AB = new Edge(A, B, 4);
        Edge AC = new Edge(A, C, 1);
        Edge BE = new Edge(B, E, 4);
        Edge CD = new Edge(C, D, 4);
        Edge CB = new Edge(C, B, 2);
        Edge DE = new Edge(D, E, 4);

        G.addVertex(A);
        G.addVertex(B);
        G.addVertex(C);
        G.addVertex(D);
        G.addVertex(E);

        G.addEdge(AB);
        G.addEdge(AC);
        G.addEdge(BE);
        G.addEdge(CD);
        G.addEdge(CB);

        //System.out.println(G);
        //System.out.println(G.BFS(A));
        System.out.println(G.getShortestPath(A, E));
        System.out.println(G.DFS(A));
    }

}
