package tp3.ulead.principal;

import tp3.ulead.entidades.MatrizAdyacencia;
import tp3.ulead.entidades.Nodo;
import tp3.ulead.metodos.Amplitud;
import tp3.ulead.metodos.Dijkstra;
import tp3.ulead.metodos.ImpresionDijkstra;
import tp3.ulead.metodos.Kruskal;
import tp3.ulead.metodos.OrdenamientoTopologico;
import tp3.ulead.metodos.Profundidad;

public class Principal {

	// static ArrayList<Nodo> ListaNodos = new ArrayList<>();
	static Nodo[] listaNodos = new Nodo[10];

	String resultado = "";

	public static void main(String[] args) {

		MatrizAdyacencia m = new MatrizAdyacencia(10);
		m.add(0, 1);
		m.add(0, 3);
		m.add(1, 2);
		m.add(1, 4);
		m.add(2, 5);
		m.add(4, 6);
		m.add(5, 8);
		m.add(6, 7);
		m.add(8, 9);
		Nodo nodo0 = new Nodo(0);
		Nodo nodo1 = new Nodo(1);
		Nodo nodo2 = new Nodo(2);
		Nodo nodo3 = new Nodo(3);
		Nodo nodo4 = new Nodo(4);
		Nodo nodo5 = new Nodo(5);
		Nodo nodo6 = new Nodo(6);
		Nodo nodo7 = new Nodo(7);
		Nodo nodo8 = new Nodo(8);
		Nodo nodo9 = new Nodo(9);
		listaNodos[0] = nodo0;
		listaNodos[1] = nodo1;
		listaNodos[2] = nodo2;
		listaNodos[3] = nodo3;
		listaNodos[4] = nodo4;
		listaNodos[5] = nodo5;
		listaNodos[6] = nodo6;
		listaNodos[7] = nodo7;
		listaNodos[8] = nodo8;
		listaNodos[9] = nodo9;
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Acontinucion un despliegue del grafo 1 utilizando el algoritmo de busqueda de PROFUNDIDAD");
		System.out.println("----------------------------------------------------------------------------------------");
		Profundidad p = new Profundidad();
		String rProfundidad = p.dfs(m, nodo0, listaNodos);
		System.out.println(rProfundidad.substring(0, rProfundidad.length() - 2));
		ClearVisits(listaNodos);
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Acontinucion un despliegue del grafo 1 utilizando el algoritmo de busqueda de AMPLITUD");
		System.out.println("----------------------------------------------------------------------------------------");
		Amplitud a = new Amplitud();
		String rAmplitud = a.bfs(m, listaNodos);
		System.out.println(rAmplitud.substring(0, rAmplitud.length() - 2));
		ClearVisits(listaNodos);
		MatrizAdyacencia mr = new MatrizAdyacencia(10);
		mr.add(0, 3, 5);
		mr.add(0, 1, 2);
		mr.add(1, 2, 8);
		mr.add(3, 4, 10);
		mr.add(4, 6, 3);
		mr.add(1, 4, 6);
		mr.add(2, 5, 7);
		mr.add(6, 5, 12);
		mr.add(6, 7, 4);
		mr.add(5, 8, 1);
		mr.add(7, 8, 3);
		mr.add(8, 9, 2);
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Acontinucion un despliegue del grafo 2 utilizando el algoritmo de Dijkstra");
		System.out.println("----------------------------------------------------------------------------------------");
		Dijkstra djk = new Dijkstra();
		djk.dijkstra(mr, 0);
		ImpresionDijkstra id = new ImpresionDijkstra(djk.startVertexP, djk.distancesP, djk.parentsP);
		MatrizAdyacencia mrk = new MatrizAdyacencia(10,"Max");
		mrk.add(0, 3, 5,"");
		mrk.add(0, 1, 2,"");
		mrk.add(1, 2, 8,"");
		mrk.add(3, 4, 10,"");
		mrk.add(4, 6, 3,"");
		mrk.add(1, 4, 6,"");
		mrk.add(2, 5, 7,"");
		mrk.add(6, 5, 12,"");
		mrk.add(6, 7, 4,"");
		mrk.add(5, 8, 1,"");
		mrk.add(7, 8, 3,"");
		mrk.add(8, 9, 2,"");
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Acontinucion un despliegue del grafo 2 utilizando el algoritmo de Kruskal");
		System.out.println("----------------------------------------------------------------------------------------");
		Kruskal kr = new Kruskal();
		System.out.print(kr.kruskalMST(mrk));
		System.out.println("");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Acontinucion un despliegue del grafo 3 utilizando el algoritmo de ordenamiento topologico:");
		System.out.println("----------------------------------------------------------------------------------------");
		
		MatrizAdyacencia mtp = new MatrizAdyacencia(8);
		mtp.add(7, 5);
		mtp.add(7, 6);
		mtp.add(6, 4);	
		mtp.add(5, 4);
		mtp.add(5, 2);
		mtp.add(6, 3);
		mtp.add(2, 1);
		mtp.add(3, 1);
		mtp.add(1, 0);
		OrdenamientoTopologico tp = new OrdenamientoTopologico();
		int[] gtopologico = null;
		gtopologico = tp.topological(mtp, 7);
		for (int i = gtopologico.length - 1; i > 0; i--)
        {
            if (gtopologico[i] != 0)
                System.out.print(gtopologico[i] + "->");
        }
		
	}

	private static void ClearVisits(Nodo[] listaNodos) {
		for (int i = 0; i < listaNodos.length; i++) {
			listaNodos[i].setVisited(false);
		}

	}

}
