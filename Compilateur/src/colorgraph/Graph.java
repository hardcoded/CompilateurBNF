package colorgraph;

import java.util.ArrayList;

/**
 * Representing the graph to put colors on
 * @author Johan Brunet - Charlene Pizzoni
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
	 * Color a graph
	 * @param k is the number of registers (colors) we can use
	 */
	public void colorGraph(int k){
		Graph graph = new Graph(this.vertices, this.edges);
		Vertex vertex;
		ArrayList<Vertex> toColor = new ArrayList<Vertex>();
		// treat every vertices
		while (graph.getNumberOfVertices()>1){
			// remove first edge with a number of neighbors inferior to k
			vertex = graph.getAVertexWithLessThanKNeighbor(k);
			if (vertex == null){
				// spill the edge with the highest weight
				Vertex vertexToSpill = graph.getVertexWithHighestWeigh();
				this.getVertex(vertexToSpill).setColor(0);
				graph.removeVertex(vertexToSpill);
			} else {
				//TODO
				// supp the vertex from graph
				// add vertex into list for coloring
				// remove the vertex from graph because not found
			}
			toColor.add(vertex);
		}
		// color vertices in "this" Graphe
		
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
	
	public Vertex getVertexWithHighestWeigh(){
		Vertex res = null;
		int maxWeight = -1;
		for (Vertex v : this.vertices){
			int weight = this.getAdjacentEdges(v).size();
			if (weight > maxWeight){
				res = v;
				maxWeight = weight;
			}
		}
		return res;
	}
	
	/**
	 * return the vertex of the current graph equals to the given vertex
	 * @param vertex value we want to find
	 * @return a vertex of the current graph
	 */
	public Vertex getVertex(Vertex vertex){
		Vertex v = null;
		boolean found = false;
		int i = 0;
		while (!found){
			if (this.vertices.get(i).getValue().equals(vertex.getValue())){
				found = true;
				v =this.vertices.get(i);
			}
		}
		return v;
	}
	
	public Vertex getAVertexWithLessThanKNeighbor(int k){
		boolean found = false;
		int i = 0;
		Vertex vertex = null;
		while (!found){
			if (getVertexWeight(this.vertices.get(i)) < k){
				vertex = this.vertices.get(i);
				found = true;
			}
			i++;
		}
		return vertex;
	}
	
	/**
	 * return the number of vertices in this graph
	 * @return number of vertices in the graph
	 */
	public int getNumberOfVertices(){
		return this.vertices.size();
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
