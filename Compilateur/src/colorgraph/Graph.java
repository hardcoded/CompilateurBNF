package colorgraph;

import java.util.ArrayList;

/**
 * Representing the graph to put colors on
 * @author Johan Brunet - Charlène Pizzoni
 *
 */
public class Graph {

	/**
	 * The list of all vertices in the graph
	 */
	private ArrayList<Vertex> vertices;
	
	/**
	 * The list of all edges in the graph
	 */
	private ArrayList<Edge> edges;
	
	/**
	 * Constructor of Graph, instantiates a new graph with a list of vertices and edges
	 * @param vertices list of vertices
	 * @param edges list of edges
	 */
	public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	/**
	 * Get the weight of a vertex, the weight is the number of adjacent edges
	 * @param vertex the vertex to get the weight
	 * @return the weight of the vertex
	 */
	public int getVertexWeight(Vertex vertex) {
		int i = 0;
		for (Edge edge : this.edges) {
			if (edge.containsVertex(vertex)) {
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Get the adjacent edges of a vertex
	 * @param vertex the vertex to retrieve the adjacent edges
	 * @return the list of adjacent edges
	 */
	public ArrayList<Edge> getAdjacentEdges(Vertex vertex) {
		ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
		for (Edge edge : this.edges) {
			if (edge.containsVertex(vertex)) {
				adjacentEdges.add(edge);
			}
		}
		return adjacentEdges;
	}
	
	/**
	 * Add a vertex to the list of vertices
	 * @param vertex the vertex to add
	 * @return true if the vertex has been added, false if not
	 */
	public boolean addVertex(Vertex vertex) {
		return this.vertices.add(vertex);
	}
	
	/**
	 * Remove a vertex from the list of vertices
	 * @param vertex the vertex to remove
	 * @return true if the vertex has been removed, false if not
	 */
	public boolean removeVertex(Vertex vertex) {
		return this.vertices.remove(vertex);
	}
	
	/**
	 * Add an edge to the list of edges
	 * @param edge the edge to add
	 * @return true if the edge has been added, false if not
	 */
	public boolean addEdge(Edge edge) {
		return this.edges.add(edge);
	}
	
	/**
	 * Remove an edge from the list of edges
	 * @param edge the edge to remove
	 * @return true if the edge has been removed, false if not
	 */
	public boolean removeEdge(Edge edge) {
		return this.edges.remove(edge);
	}
	
	/**
	 * Get the list of vertices of the graph
	 * @return the list of vertices
	 */
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
	/**
	 * Set the list of vertices of the graph
	 * @param vertices the list of vertices to set
	 */
	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}
	
	/**
	 * Get the list of edges of the graph
	 * @return the list of edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	/**
	 * Set the list of edges of the graph
	 * @param edges the list of edges
	 */
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
}
