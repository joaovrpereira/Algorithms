import java.util.*;

enum Cor {
    BRANCO,
    CINZA,
    PRETO
}

class Node {
    Integer numeroVertice;
    Integer parent;
    Double d = Double.NEGATIVE_INFINITY;
    Cor cor = Cor.BRANCO;
}

public class BreadthFirstSearch {

    int V = 15;

    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>();

    public BreadthFirstSearch(){
    
        for(int j = 0; j < V; j++){
            nodeList.add(new Node());
            nodeList.get(j).numeroVertice=j;
        }
    
        for(int i = 0; i < V; i++){
            am.add(new ArrayList<Integer>());
        }
         
        addEdge(am, 0, 1);
        addEdge(am, 0, 2);
        addEdge(am, 0, 3);
        addEdge(am, 0, 4);
        addEdge(am, 1, 5);
        addEdge(am, 1, 6);
        addEdge(am, 1, 7);
        addEdge(am, 2, 8);
        addEdge(am, 2, 9);
        addEdge(am, 2, 10);
        addEdge(am, 3, 11);
        addEdge(am, 3, 12);
        addEdge(am, 3, 13);
        addEdge(am, 4, 14);
        addEdge(am, 5, 6);
        addEdge(am, 5, 7);
        addEdge(am, 6, 8);
        addEdge(am, 7, 9);
        addEdge(am, 8, 10);
        addEdge(am, 9, 11);
        addEdge(am, 10, 12);
        addEdge(am, 11, 13);
        addEdge(am, 12, 14);
        addEdge(am, 13, 0);
        addEdge(am, 14, 1);
        addEdge(am, 6, 13);
        addEdge(am, 7, 14);
        addEdge(am, 4, 10);
    }

    void addEdge(ArrayList<ArrayList<Integer>> am, int u, int v) {
        am.get(u).add(v);
        am.get(v).add(u);
    }

    void bfs(){
        Queue<Integer> q = new LinkedList<>();
    
        Node s = nodeList.get(0);
        s.cor = Cor.CINZA;
        s.parent = null;
        s.d = 0.0;
    
        q.add(s.numeroVertice);
    
        while(!q.isEmpty()){
            Node u = nodeList.get(q.remove());
            for(Integer i : am.get(u.numeroVertice)){
                if(nodeList.get(i).cor == Cor.BRANCO){
                    nodeList.get(i).cor = Cor.CINZA;
                    nodeList.get(i).d = u.d + 1;
                    nodeList.get(i).parent = u.numeroVertice;
                    q.add(i);
                }
            }
            u.cor = Cor.PRETO;
        }
    }

    void printGraph() {
        for (int i = 0; i < am.size(); i++) {
            System.out.print("\nVértice: " + i + ":");
            for (int j = 0; j < am.get(i).size(); j++) {
                System.out.print(" " + am.get(i).get(j));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.bfs();
        
        System.out.println("\nGrafo: ");
        bfs.printGraph();
        System.out.println("\n");
        for (Node node : bfs.nodeList) {
            System.out.println("Vértice " + node.numeroVertice + " - Distância: " + node.d);
        }
    }
}