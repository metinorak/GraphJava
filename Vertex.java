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