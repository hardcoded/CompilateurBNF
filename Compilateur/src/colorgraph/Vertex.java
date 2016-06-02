package colorgraph;

/**
 * Representing a vertex of the graph
 * @author Johan Brunet - Charlene Pizzoni
 *
 */
public class Vertex {

	/**
	 * The value of the vertex
	 */
	private String value;
	/**
	 * The color of the vertex
	 */
	private int color;
	
	/**
	 * Creating a new vertex, its color is -1 by default
	 * @param val the value of the vertex
	 */
	public Vertex(String val) {
		this.value = val;
		this.color = -1;
	}

	/**
	 * Get the value of the vertex
	 * @return the value of the vertex
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Set the value of the vertex
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Get the color of the vertex
	 * @return the color of the vertex
	 */
	public int getColor() {
		return color;
	}

	/**
	 * Set the color of the vertex 
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}	
}
