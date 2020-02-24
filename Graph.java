import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

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
    
    public Stack<Vertex> getShortestPath(Vertex initial, Vertex terminal){
        class VertexWithPriority implements Comparable<VertexWithPriority>{
            private Vertex v;
            private int cost;
            VertexWithPriority(Vertex v, int cost){
                this.v = v;
                this.cost = cost;
            }

            public Vertex getV() {
                return v;
            }

            public void setV(Vertex v) {
                this.v = v;
            }

            public int getCost() {
                return cost;
            }

            public void setCost(int cost) {
                this.cost = cost;
            }

            @Override
            public int compareTo(VertexWithPriority o) {
                if(this.cost < o.getCost()){
                    return -1;
                }
                else if(o.getCost() < this.cost){
                    return 1;
                }
                return 0;
            }

            public boolean equals(VertexWithPriority obj) {
                if(this.v == obj.getV()){
                    return true;
                }
                return false;
            }
            
        }
        
        HashMap<Vertex, Vertex> path = new HashMap<>();
        PriorityQueue<VertexWithPriority> queue = new PriorityQueue<>();
        HashMap<Vertex, Integer> distance = new HashMap<>();
        
        distance.put(initial, 0);
        queue.add(new VertexWithPriority(initial, 0));
        
        while(!queue.isEmpty()){
            Vertex v = queue.poll().getV();
            this.getAdjacentEdges(v).forEach((e) -> {
                Vertex w = e.getV2();
                int newDistance = distance.get(v) + e.getCost();
                VertexWithPriority newVP = new VertexWithPriority(w, newDistance);
                if(!distance.containsKey(w)){
                    distance.put(w, newDistance);
                    queue.add(newVP);
                    path.put(w, v);
                }
                if (newDistance < distance.get(w)) {
                    distance.put(w, newDistance);
                    path.put(w, v);
                    queue.remove(newVP);
                    queue.add(newVP);
                }
            });
            
        }
        
        Stack<Vertex> lastPath = new Stack<>();
        Vertex parentVertex = terminal;
        
        while(parentVertex != null){
            lastPath.add(parentVertex);
            parentVertex = path.get(parentVertex);
            
        }
        
        if(lastPath.firstElement() == terminal && lastPath.lastElement() == initial){
            return lastPath;
        }
        return null;
    }
    
}
