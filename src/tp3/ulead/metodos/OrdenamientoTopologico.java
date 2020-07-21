package tp3.ulead.metodos;

import java.util.Stack;

import tp3.ulead.entidades.MatrizAdyacencia;

public class OrdenamientoTopologico {

	private Stack<Integer> stack;
	
	public OrdenamientoTopologico() {
		  stack = new Stack<Integer>();
	}

	public int[] topological(MatrizAdyacencia m, int source) throws NullPointerException {
		int number_of_nodes =m.matriz[source].length - 1;
        int[] topological_sort = new int[number_of_nodes + 1];
        int pos = 1;
        int j;
        int visited[] = new int[number_of_nodes + 1];
        int element = 0;
        int i = 0;
        visited[source] = 1;
        stack.push(source);
        while (!stack.isEmpty())
        {
            element = stack.peek();
            while (i <= number_of_nodes)
            {
                if (m.matriz[element][i] == 1 && visited[i] == 1)
                {
                    if (stack.contains(i))
                    {
                        System.out.println("TOPOLOGICAL SORT NOT POSSIBLE");
                        return null;
                    }
                }
                if (m.matriz[element][i] == 1 && visited[i] == 0)
                {
                    stack.push(i);
                    visited[i] = 1;
                    element = i;
                    i = 1;
                    continue;
                }
                i++;
            }
            j = stack.pop();
            topological_sort[pos++] = j;
            i = ++j;
        }
        return topological_sort;
	}
}
