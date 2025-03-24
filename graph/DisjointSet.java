import java.util.*;
//Comparator , TreeSet

public class DisjointSet{

    ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>();
    //Por ser TreeSet, já é ordenada. 
    ArrayList<TreeSet<Integer>> setList = new ArrayList<TreeSet<Integer>>();
    int vertices = 0;

    public DisjointSet(int vertices){
        this.vertices = vertices;

        for(int i = 0; i < this.vertices; i++){
            am.add(new ArrayList<>());
            setList.add(new TreeSet<>());
        }
    }
    public void addEdge(int u, int v) {
        am.get(u).add(v);
        am.get(v).add(u); 
    }

    void connectedComponents(){
        for(int i = 0; i < am.size(); i++){
            makeSet(i);
        }
        for(int i = 0; i < am.size(); i++){
            int edges = am.get(i).size();
            for(int j = 0; j < edges;j++){
                int v = am.get(i).get(j);
                if(!setList.get(i).equals(setList.get(v))){
                    
                    TreeSet<Integer> setU = setList.get(i);
                    TreeSet<Integer> setV = setList.get(v);
                    
                    //Union entre conjuntos
                    setU.addAll(setV);

                    //Sincronização dos sets para apontar para o novo conjunto
                    for(int x : setV){
                        setList.set(x, setU);
                    }
                }
            }
        }
    }
    //Inicialmente todos os vértices fazem parte de um conjunto composto cada um por um elemento
    void makeSet(Integer v){
        setList.get(v).add(v);
    }

    TreeSet<Integer> findSet(Integer vertice){
        return this.setList.get(vertice);
    }
    boolean sameComponent(Integer u, Integer v){
        if(setList.get(u).equals(setList.get(v))){
            return true;
        }
        else return false; 
    }
    void printComponents() {
        HashSet<TreeSet<Integer>> printed = new HashSet<>();
        for (TreeSet<Integer> comp : setList) {
            if (!printed.contains(comp)) {
                System.out.println(comp);
                printed.add(comp);
            }
        }
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(10);

        // Componente 1
        ds.addEdge(0, 1);
        ds.addEdge(1, 2);
        ds.addEdge(2, 3);
        // Componente 2
        ds.addEdge(4, 5);
        // Componente 3
        ds.addEdge(6, 7);
        ds.addEdge(7, 8);

        ds.connectedComponents();

        System.out.println("Componentes conectados:");
        ds.printComponents();

        System.out.println("\nTestes de sameComponent:");
        System.out.println("0 e 3: " + ds.sameComponent(0, 3)); // true
        System.out.println("4 e 5: " + ds.sameComponent(4, 5)); // true
        System.out.println("6 e 8: " + ds.sameComponent(6, 8)); // true
        System.out.println("0 e 6: " + ds.sameComponent(0, 6)); // false
        System.out.println("3 e 9: " + ds.sameComponent(3, 9)); // false
    }

}