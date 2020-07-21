package tp3.ulead.metodos;

import tp3.ulead.entidades.MatrizAdyacencia;

public class Dijkstra {
	private static final int NO_PARENT = -1;
	public int startVertexP;
	public int[] distancesP;
	public int[] parentsP;

	public void dijkstra(MatrizAdyacencia m, int startVertex) {
		int nVertices = m.matriz[0].length;
		int[] shortestDistances = new int[nVertices];
		boolean[] added = new boolean[nVertices];
		for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
			shortestDistances[vertexIndex] = Integer.MAX_VALUE;
			added[vertexIndex] = false;
		}
		shortestDistances[startVertex] = 0;
		int[] parents = new int[nVertices];
		parents[startVertex] = NO_PARENT;
		for (int i = 1; i < nVertices; i++) {
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				if (!added[vertexIndex] && shortestDistances[vertexIndex] < shortestDistance) {
					nearestVertex = vertexIndex;
					shortestDistance = shortestDistances[vertexIndex];
				}
			}
			added[nearestVertex] = true;
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				int edgeDistance = m.matriz[nearestVertex][vertexIndex];

				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistances[vertexIndex])) {
					parents[vertexIndex] = nearestVertex;
					shortestDistances[vertexIndex] = shortestDistance + edgeDistance;
				}
			}
		}
		this.startVertexP = startVertex;
		this.distancesP = shortestDistances;
		this.parentsP = parents;
	}

}
