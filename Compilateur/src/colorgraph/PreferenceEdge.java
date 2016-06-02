package colorgraph;

/**
 * Representing a preference edge
 * @author Johan Brunet - Charlène Pizzoni
 *
 */
public class PreferenceEdge extends Edge {

	/**
	 * Create a new preference edge from super constructor (Edge)
	 * @param v1 first vertex associated
	 * @param v2 second vertex associated
	 */
	public PreferenceEdge(Vertex v1, Vertex v2) {
		super(v1, v2);
	}
}
