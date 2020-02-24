import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
    private String label;
    public Vertex(String label) {
            this.label = label;
    }
    public Vertex() {
        this("");
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("V: ");
        sb.append(label);
        return sb.toString();
    }
}

class Edge {
    private String label;
    private int cost;
    private Vertex v1, v2;

    public Edge(Vertex v1, Vertex v2, int cost, String label) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
        this.label = label;
    }

    public Edge(Vertex v1, Vertex v2, String label) {
        this(v1, v2, 1, label);
    }

    public Edge(Vertex v1, Vertex v2, int cost) {
        this(v1, v2, cost, "");
    }

    public Edge(Vertex v1, Vertex v2) {
        this(v1, v2, 1, "");
    }

    public String getLabel() {
        return label;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setV1(Vertex v1) {
        this.v1 = v1;
    }

    public void setV2(Vertex v2) {
        this.v2 = v2;
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("E: ");
        sb.append(v1);
        sb.append(" -- ");
        sb.append(v2);
        return sb.toString();
    }
}

public class Graph {
    private ArrayList<Vertex> V = new ArrayList<Vertex>();
    private ArrayList<Edge> E = new ArrayList<Edge>();

    public void addVertex(Vertex v) {
        V.add(v);
    }

    public void addEdge(Edge e) {
        E.add(e);
    }

    public void removeVertex(Vertex v) {
        V.remove(v);
    }

    public void removeEdge(Edge e) {
        E.remove(e);
    }

    public ArrayList<Vertex> getAdjacentVertices(Vertex v) {
        ArrayList<Vertex> adj = new ArrayList<Vertex>();
        for (Edge e: E) {
                if (e.getV1() == v) {
                        adj.add(e.getV2());
                        continue;
                }
                if (e.getV2() == v) {
                        adj.add(e.getV1());
                        continue;
                }
        }
        return adj;
    }

    public ArrayList<Edge> getAdjacentEdges(Vertex v) {
        ArrayList<Edge> adj = new ArrayList<Edge>();
        for (Edge e: E) {
                if (e.getV1() == v || e.getV2() == v) {
                        adj.add(e);
                }
        }
        Edge[] a = null;
        return adj;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V);
        sb.append("\n");
        sb.append(E);
        return sb.toString();
    }

    public ArrayList<Vertex> BFS(Vertex s) {
        if (!V.contains(s))
                return null;
        ArrayList<Vertex> bfs = new ArrayList<Vertex>();
        HashMap<Vertex, Integer> colours = new HashMap<>();
        Queue<Vertex> Q = new LinkedList<>();

        for (Vertex u: V) {
                colours.put(u, 0);
        }

        Q.offer(s);
        colours.put(s, 1);
        while (!Q.isEmpty()) {
                Vertex u = Q.poll();
                for (Vertex v: getAdjacentVertices(u)) {
                        if (colours.get(v) == 0) {
                                Q.offer(v);
                                colours.put(v, 1);
                        }
                }
                bfs.add(u);
                colours.put(u, 2);
        }
        return bfs;
    }
}
