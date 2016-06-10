package colorgraph;

import java.util.ArrayList;

public class TestGraphColoring {

	public static void main(String[] args) {
		System.out.println("Creating vertices...");
		Vertex v = new Vertex("v");
		Vertex z = new Vertex("z");
		Vertex x = new Vertex("x");
		Vertex y = new Vertex("y");
		Vertex u = new Vertex("u");
		Vertex t = new Vertex("t");
		
		System.out.println("Creating edges...");
		InterferenceEdge zv = new InterferenceEdge(z, v);
		InterferenceEdge vx = new InterferenceEdge(v, x);
		InterferenceEdge yx = new InterferenceEdge(y, x);
		InterferenceEdge vt = new InterferenceEdge(v, t);
		InterferenceEdge yu = new InterferenceEdge(y, u);
		PreferenceEdge tu = new PreferenceEdge(t, u);
		
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v);
		vertices.add(z);
		vertices.add(x);
		vertices.add(y);
		vertices.add(u);
		vertices.add(t);
		
		ArrayList<InterferenceEdge> interfEdges = new ArrayList<InterferenceEdge>();
		interfEdges.add(zv);
		interfEdges.add(vx);
		interfEdges.add(yx);
		interfEdges.add(vt);
		interfEdges.add(yu);
		
		ArrayList<PreferenceEdge> prefEdges = new ArrayList<PreferenceEdge>(); 
		prefEdges.add(tu);
		
		System.out.println("Creating graph...");
		Graph graph = new Graph(vertices, interfEdges, prefEdges);
		System.out.println("Coloring graph...");
		graph.colorGraph(2);
		System.out.println(graph.toString());
		System.out.println("Done !");
	}

}
