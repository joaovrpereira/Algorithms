import java.util.*;

class Edge implements Comparable<Edge> {
    public Integer u;
    public Integer v;
    public Integer weight;

    public Edge(Integer u, Integer v, Integer weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
    }
}
public class Kruskal_MST extends DisjointSet {
    public List<Edge> A;
    public Integer vertices;
    List<Edge> mstByWeight = new ArrayList<>();
    
    public Kruskal_MST(int qtdVertices){
        super(qtdVertices);
        this.vertices = qtdVertices;
        A = new ArrayList<Edge>();

        for(int i = 0; i < this.vertices; i++){
            setList.add(new TreeSet<>());
            makeSet(i);
        }
        addEdge(0,1,4);
        addEdge(0,2,8);
        addEdge(1,2,11);
        addEdge(1, 4, 8);
        addEdge(2,3,7);
        addEdge(2,5,1);
        addEdge(3, 5, 6);
        addEdge(3, 4, 2);
        addEdge(4, 6,4);
        addEdge(4, 7, 7);
        addEdge(5, 6, 2);
        addEdge(6, 7, 14);
        addEdge(7, 8, 9);
        addEdge(6, 8, 10);
    }
    void addEdge(int u, int v, int weight){
        mstByWeight.add(new Edge(u, v, weight));
    }

    public List<Edge> kruskal(){

        Collections.sort(mstByWeight);
        for(Edge edge : mstByWeight){
            //Não estando no mesmo conjunto, adicionando a aresta na árvore, não se forma um ciclo
            if(!setList.get(edge.u).equals(setList.get(edge.v))){
                    
                TreeSet<Integer> setU = setList.get(edge.u);
                TreeSet<Integer> setV = setList.get(edge.v);
                A.add(edge);
                
                //Union entre conjuntos
                setU.addAll(setV);
    
                //Sincronização dos sets para apontar para o novo conjunto
                for(int x : setV){
                    setList.set(x, setU);
                }
            }
        }
        printMST();
        return A;
    }
    public void printMST(){
        System.out.println("Árvore Geradora Mínima: ");
        for(Edge edge : A){
            System.out.println("u: " + edge.u + " v: " + edge.v + " weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        Kruskal_MST mst = new Kruskal_MST(9);
        mst.kruskal();
    }
}
