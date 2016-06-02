package colorgraph;

/**
 * Representing an edge of the graph
 * @author Johan Brunet - Charlène Pizzoni
 *
 */
public abstract class Edge {

	/**
	 * The two vertices associated to the edge
	 */
	private Vertex v1;
	private Vertex v2;
	
	/**
	 * Creating a new edge
	 * @param v1 the first vertex
	 * @param v2 the second vertex
	 */
	public Edge(Vertex v1, Vertex v2) {
		this.setV1(v1);
		this.setV2(v2);
	}
	
	/**
	 * See if the edge contains the specified vertex
	 * @param vertex the vertex we want to see if it's associated to the edge
	 * @return true if the vertex is associated to the edge, false if it's not
	 */
	public boolean containsVertex(Vertex vertex) {
		if (vertex.equals(v1) || vertex.equals(v2)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Get the first vertex associated to the edge
	 * @return the vertex
	 */
	public Vertex getV1() {
		return v1;
	}

	/**
	 * Set the first vertex
	 * @param v1 the vertex to set
	 */
	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	/**
	 * Get the second vertex associated to the edge
	 * @return the vertex
	 */
	public Vertex getV2() {
		return v2;
	}

	/**
	 * Set the second vertex
	 * @param v2 the vertex to set
	 */
	public void setV2(Vertex v2) {
		this.v2 = v2;
	}
}
