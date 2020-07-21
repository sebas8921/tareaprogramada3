package tp3.ulead.metodos;

import java.util.ArrayList;

import tp3.ulead.entidades.MatrizAdyacencia;
import tp3.ulead.entidades.Nodo;

public class Profundidad {

	public Profundidad() {

	}

	String resultado = "";

	public String dfs(MatrizAdyacencia m, Nodo node, Nodo[] listaNodos) {
		
		this.resultado = this.resultado + String.valueOf(node.getData() + "->");
		ArrayList<Nodo> neighbours = findNeighbours(m, node, listaNodos);
		node.setVisited(true);
		for (int i = 0; i < neighbours.size(); i++) {
			Nodo n = neighbours.get(i);
			if (n != null && !n.isVisited()) {
				dfs(m, n, listaNodos);
			}
		}
		return resultado;
	}

	private ArrayList<Nodo> findNeighbours(MatrizAdyacencia m, Nodo node, Nodo[] listaNodos) {
		int nodeIndex = -1;

		ArrayList<Nodo> neighbours = new ArrayList<>();
		for (int i = 0; i < listaNodos.length; i++) {
			if (listaNodos[i].equals(node)) {
				nodeIndex = i;
				break;
			}
		}

		if (nodeIndex != -1) {
			for (int j = 0; j < m.matriz[nodeIndex].length; j++) {
				if (m.matriz[nodeIndex][j] == 1) {
					neighbours.add(listaNodos[j]);
				}
			}
		}
		return neighbours;
	}
}
