package colorgraph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Vertex> vertices;
	private List<Edge> edges;
	
	public Graph(ArrayList<Vertex> vertices, ArrayList<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public int getVertexWeight(Vertex vertex) {
		int i = 0;
		for (Edge edge : this.edges) {
			if (edge.containsVertex(vertex)) {
				i++;
			}
		}
		return i;
	}
	
	public boolean addVertex(Vertex vertex) {
		return this.vertices.add(vertex);
	}
	
	public boolean removeVertex(Vertex vertex) {
		return this.vertices.remove(vertex);
	}
	
	public boolean addEdge(Edge edge) {
		return this.edges.add(edge);
	}
	
	public boolean removeEdge(Edge edge) {
		return this.edges.remove(edge);
	}
	
	public List<Vertex> getVertices() {
		return vertices;
	}
	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
}
