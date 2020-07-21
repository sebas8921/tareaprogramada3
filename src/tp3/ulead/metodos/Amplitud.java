package tp3.ulead.metodos;

import java.util.LinkedList;

import tp3.ulead.entidades.MatrizAdyacencia;
import tp3.ulead.entidades.Nodo;

public class Amplitud {

	String resultado = "";
	LinkedList<Integer> q = new LinkedList<Integer>();

	public String bfs(MatrizAdyacencia adjm, Nodo[] listaNodos) {
		listaNodos[0].setVisited(true);

		this.resultado = this.resultado + listaNodos[0].getData() + "->";
		q.add(0);
		int v2;
		while (!q.isEmpty()) {
			int v1 = q.remove();
			while ((v2 = getAdjUnvisitedVertex(v1, adjm, listaNodos)) != -1) {
				listaNodos[v2].setVisited(true);
				this.resultado = this.resultado + listaNodos[v2].getData() + "->";
				// displayVertex(v2);
				q.add(v2);
			}
		}

		return this.resultado;
	}

	private int getAdjUnvisitedVertex(int v, MatrizAdyacencia adjm, Nodo[] listaNodos) {
		for (int j = 0; j < listaNodos.length; j++) {
			if (adjm.matriz[v][j] == 1 && listaNodos[j].isVisited() == false) {
				return j;
			}
		}
		return -1;
	}
}
