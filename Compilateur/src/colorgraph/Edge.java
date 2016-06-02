package colorgraph;

public abstract class Edge {

	private Vertex v1;
	private Vertex v2;
	
	public Edge(Vertex v1, Vertex v2) {
		this.setV1(v1);
		this.setV2(v2);
	}
	
	public boolean containsVertex(Vertex vertex) {
		if (vertex.equals(v1) || vertex.equals(v2)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}
}
