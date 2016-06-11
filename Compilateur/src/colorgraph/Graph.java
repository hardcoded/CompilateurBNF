package colorgraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Representing the graph to put colors on
 * @author Johan Brunet - Charlene Pizzoni
 *
 */
public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<InterferenceEdge> iedges;
	private ArrayList<PreferenceEdge> pedges;
	
	/**
	 * Constructor of Graph, instantiates a new graph with a list of vertices and edges
	 * @param vertices list of vertices
	 * @param edges list of edges
	 */
	public Graph(ArrayList<Vertex> vertices, ArrayList<InterferenceEdge> iedges, ArrayList<PreferenceEdge> pedges) {
		this.vertices = vertices;
		this.iedges = iedges;
		this.pedges = pedges;
	}
	
	/**
	 * Color a graph
	 * @param k is the number of registers (colors) we can use
	 */
	public void colorGraph(int k){
		Graph g = new Graph(new ArrayList<Vertex>(this.vertices), new ArrayList<InterferenceEdge>(this.iedges), new ArrayList<PreferenceEdge>(this.pedges));
		Vertex vertex;
		ArrayList<Vertex> toColor = new ArrayList<Vertex>();
		// treat every vertices
		while (g.getNumberOfVertices()>1){
			// select the first edge with a number of neighbors inferior to k
			vertex = g.getAVertexWithLessThanKNeighbor(k);
			if (vertex == null){
				// spill the edge with the highest weight
				vertex = g.getVertexWithHighestWeigh();
				this.getVertex(vertex).setColor(0);
			} else {
				// add vertex into list for coloring
				toColor.add(vertex);
			}
			// supp the vertex from graph
			g.removeVertex(vertex);
		}
		// color vertices in "this" Graph
		Collections.reverse(toColor);
		// add the vertex in g
		// choose a color
		// color the Graph threaten
		
		/*while (!toColor.isEmpty()) {
			System.out.println("start coloring");
			Vertex vertexToColor = toColor.get(0);
			int i;
			boolean available;
			for (i = 1; i <= k; i++) {
				available = true;
				for (Edge interf : this.iedges) {
					Vertex neighbor = interf.getNeighbor(vertexToColor);
					if (neighbor != null){
						if (neighbor.getColor() == i) {
							available = false;
						}
					}
				}
				if (available) {
					vertexToColor.setColor(i);
					break;
				}
				for (Edge pref : this.pedges) {
					Vertex neighbor = pref.getNeighbor(vertexToColor);
					if (neighbor != null) {
						if (neighbor.getColor() != -1 && neighbor.getColor() != 0) {
							available = true;
							for (Edge e : this.iedges) {
								Vertex v = e.getNeighbor(vertexToColor);
								if (v.getColor() == neighbor.getColor()) {
									available = false;
								}
							}
							if (available) {
								vertexToColor.setColor(neighbor.getColor());
								break;
							}
						}
					}
				}
			}
			toColor.remove(vertexToColor);
			System.out.println("Vertex colored and removed");
		}*/
		
		//--------------------------second try------------------------------
		while (!toColor.isEmpty()) {
			System.out.println("start coloring");
			Vertex vertexToColor = toColor.get(0);
			boolean available;
			ArrayList<Integer> preferenceColors = new ArrayList<Integer>();
			for (Edge pref : this.pedges) { // get preference colors
				Vertex neighbor = pref.getNeighbor(vertexToColor);
				if (neighbor != null) {
					if (neighbor.getColor() > 0) {
						preferenceColors.add(neighbor.getColor());
					}
				}
			}
			for (int i : preferenceColors){ // try preference colors
				available = true;
				for (Edge interf : this.iedges) {
					Vertex neighbor = interf.getNeighbor(vertexToColor);
					if (neighbor != null){
						if (neighbor.getColor() == i) {
							available = false;
						}
					}
				}
				if (available) {
					vertexToColor.setColor(i);
					break;
				}
			}
			if (vertexToColor.getColor() < 0) {
				for (int i = 1; i <= k; i++) { // choose another color
					available = true;
					for (Edge interf : this.iedges) {
						Vertex neighbor = interf.getNeighbor(vertexToColor);
						if (neighbor != null){
							if (neighbor.getColor() == i) {
								available = false;
							}
						}
					}
					if (available) {
						vertexToColor.setColor(i);
						break;
					}
				}
			}
			toColor.remove(vertexToColor);
			System.out.println("Vertex colored and removed");
		}
		
	}

	/**
	 * Get the weight of a vertex, the weight is the number of adjacent edges
	 * @param vertex the vertex to get the weight
	 * @return the weight of the vertex
	 */
	public int getVertexWeight(Vertex vertex) {
		int i = 0;
		for (Edge edge : this.iedges) {
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
		for (Edge edge : this.iedges) {
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
				v = this.vertices.get(i);
			}
		}
		return v;
	}
	
	public Vertex getAVertexWithLessThanKNeighbor(int k){
		boolean found = false;
		int i = 0;
		Vertex vertex = null;
		while (!found && i < this.vertices.size()){
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
	 * Remove a vertex from the list of vertices AND all this preferences Edges
	 * @param vertex the vertex to remove
	 * @return true if the vertex has been removed, false if not
	 */
	public boolean removeVertex(Vertex vertex) {
		for (Edge e : this.pedges){
			if (e.containsVertex(vertex)){
				this.removePreferenceEdge(e);
			}
		}
		return this.vertices.remove(vertex);
	}
	
	public boolean addInterferenceEdge(InterferenceEdge edge) {
		return this.iedges.add(edge);
	}
	
	public boolean addPreferenceferenceEdge(PreferenceEdge edge) {
		return this.pedges.add(edge);
	}
	
	public boolean removeInterferenceEdge(Edge edge) {
		return this.iedges.remove(edge);
	}
	
	public boolean removePreferenceEdge(Edge edge) {
		return this.iedges.remove(edge);
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
	

	public ArrayList<PreferenceEdge> getPreferenceEdges() {
		return pedges;
	}
	
	public ArrayList<InterferenceEdge> getInterferenceEdges() {
		return iedges;
	}
	

	public void setPreferenceEdges(ArrayList<PreferenceEdge> edges) {
		this.pedges = edges;
	}
	
	public void setInterferenceEdges(ArrayList<PreferenceEdge> edges) {
		this.pedges = edges;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vertex v : vertices) {
			sb.append(v.getValue());
			sb.append(" - ");
			sb.append(v.getColor());
			sb.append("\n");
		}
		return sb.toString();
	}
}
