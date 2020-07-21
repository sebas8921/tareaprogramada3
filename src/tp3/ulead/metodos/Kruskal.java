package tp3.ulead.metodos;

import tp3.ulead.entidades.MatrizAdyacencia;

public class Kruskal {

	
	int V = 10; 
    int[] parent = new int[V]; 
	int INF = Integer.MAX_VALUE; 
	String resultado = "";
	
    int find(int i) 
	{ 
	    while (parent[i] != i) 
	        i = parent[i]; 
	    return i; 
	} 
	  
	// Does union of i and j. It returns 
	// false if i and j are already in same 
	// set. 
	void union1(int i, int j) 
	{ 
	    int a = find(i); 
	    int b = find(j); 
	    parent[a] = b; 
	} 
	
	public String kruskalMST(MatrizAdyacencia cost) 
	{ 
	    int mincost = 0; // Cost of min MST. 
	  
	    // Initialize sets of disjoint sets. 
	    for (int i = 0; i < V; i++) 
	        parent[i] = i; 
	  
	    // Include minimum weight edges one by one 
	    int edge_count = 0; 
	    while (edge_count < V - 1) 
	    { 
	        int min = INF, a = -1, b = -1; 
	        for (int i = 0; i < V; i++) 
	        { 
	            for (int j = 0; j < V; j++)  
	            { 
	                if (find(i) != find(j) && cost.matriz[i][j] < min)  
	                { 
	                    min = cost.matriz[i][j]; 
	                    a = i; 
	                    b = j; 
	                } 
	            } 
	        } 
	  
	        union1(a, b);  
	        this.resultado = resultado + "Arista " + edge_count++ + ": (" + a + ", "+b+") cost:"+ min +"\n";
	        //System.out.print("Arista " + edge_count++ + ": (" + a + ", "+b+") cost:"+ min +"\n");
	        mincost += min; 
	    } 
	    resultado = resultado + "\n Minimum cost= "+ mincost+ "\n"; 
	    //System.out.printf("\n Minimum cost= %d \n", mincost); 
	    return this.resultado;
	    
	}
}