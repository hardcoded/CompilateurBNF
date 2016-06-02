package colorgraph;

public class Vertex {

	private String value;
	private int color;
	
	public Vertex(String val) {
		this.value = val;
		this.color = -1;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}	
}
