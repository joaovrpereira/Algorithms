import java.util.*;

enum Cor {
    BRANCO,
    CINZA,
    PRETO
}

class Node {
    Integer numeroVertice;
    Integer parent = null;
    Integer discoveryTime = 0;
    Integer finishTime = 0;
    Cor cor = Cor.BRANCO;
}

public class DepthFirstSearch {
    

    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> am = new ArrayList<ArrayList<Integer>>();
    public int timestamp = 0;
    public static Integer vertices;

    public DepthFirstSearch(int qtdVertices){

        DepthFirstSearch.vertices = qtdVertices;

        for(int i = 0; i < DepthFirstSearch.vertices; i++){
            nodeList.add(new Node());
            nodeList.get(i).numeroVertice = i;
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

    void dfs(){
        for(Node i: nodeList){
            if(i.cor == Cor.BRANCO){
                dfs_visit(i.numeroVertice);
            }
        }
    }

    void dfs_visit(Integer u){
        timestamp++;
        nodeList.get(u).discoveryTime = timestamp;
        nodeList.get(u).cor = Cor.CINZA;

        for(Integer v : am.get(u)){
            if(nodeList.get(v).cor == Cor.BRANCO){
                nodeList.get(v).parent = u;
                dfs_visit(v);
            }
        }
        timestamp++;
        nodeList.get(u).finishTime = timestamp;
        nodeList.get(u).cor = Cor.PRETO;
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(15);
        dfs.dfs();
    }
}
