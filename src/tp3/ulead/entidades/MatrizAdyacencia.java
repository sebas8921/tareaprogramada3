package tp3.ulead.entidades;

public class MatrizAdyacencia {
	private int n;
    public int[][] matriz;

    public MatrizAdyacencia(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }            
        }
    }
    
    public MatrizAdyacencia(int n, String max) {
        this.n = n;
        matriz = new int[this.n][this.n];
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = Integer.MAX_VALUE;
            }            
        }
    }
    
    
    public void add(int i, int j, int v){
        matriz[i][j] += v;
    }
    
    public void add(int i, int j, int v, String s){
        matriz[i][j] = v;
    }
    
    public void add(int i, int j){
        matriz[i][j] += 1;
    }
    
    public void remove(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }
    
    public void print(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "  " );        
            }
            System.out.println();
        }  
    }
}