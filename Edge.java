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