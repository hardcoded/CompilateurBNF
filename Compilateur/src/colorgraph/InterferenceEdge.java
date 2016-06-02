package colorgraph;

/**
 * Representing an interference edge
 * @author Johan Brunet - Charlene Pizzoni
 *
 */
public class InterferenceEdge extends Edge {

	/**
	 * Create a new interference edge from super constructor (Edge)
	 * @param v1 first vertex associated
	 * @param v2 second vertex associated
	 */
	public InterferenceEdge(Vertex v1, Vertex v2) {
		super(v1, v2);
	}
}
