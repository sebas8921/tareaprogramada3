package tp3.ulead.entidades;

public class Nodo {
	private int data;
	private boolean visited;
	
	public Nodo(int data) {
		this.data = data;
		this.visited = false;
		
	}
	
	public int getData() {
		return data;
	}
	public void setLabel(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	
}
