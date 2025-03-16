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
    public Stack<Node> topologicalSort = new Stack<>();
    public Boolean cyclical = false;

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
        addEdge(am, 1, 4);
        addEdge(am, 1, 5);
        addEdge(am, 2, 6);
        addEdge(am, 7, 8);
        addEdge(am, 7, 9);
        addEdge(am, 8, 10);
        addEdge(am, 9, 10);
        addEdge(am, 9, 11);
        addEdge(am, 12, 13);
        addEdge(am, 12, 14);
        addEdge(am, 13, 14);
        addEdge(am, 3, 7);
        addEdge(am, 6, 9);
        addEdge(am, 5, 12);
        addEdge(am, 11, 14);
        addEdge(am, 2, 8);
        addEdge(am, 4, 10);
        addEdge(am, 3, 14);
        addEdge(am, 6, 13);
        addEdge(am, 1, 11);
        addEdge(am, 0, 12);
        addEdge(am, 4, 8);
        addEdge(am, 5, 9);
        addEdge(am, 10, 13);
        addEdge(am, 7, 12);
        /*
        4->8->10->13->14->4
        addEdge(am, 14, 4); 
        */
    }

    void addEdge(ArrayList<ArrayList<Integer>> am, int u, int v) {
        am.get(u).add(v);
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
            if(nodeList.get(v).cor == Cor.CINZA){
                System.out.println("Foi encontrado um ciclo.");
                this.cyclical = true;
            }
            if(nodeList.get(v).cor == Cor.BRANCO){
                nodeList.get(v).parent = u;
                dfs_visit(v);
            } 
        }
        timestamp++;
        nodeList.get(u).finishTime = timestamp;
        nodeList.get(u).cor = Cor.PRETO;
        this.topologicalSort.push(nodeList.get(u));
    }
    //Se acíclico, garante que as dependências do fluxo sejam primeiramente executadas.
    void printTopologicalSort(Stack<Node> stack) {
       if(!this.cyclical){
        int size = stack.size();
        int count = 0;
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().numeroVertice);
            count++;
            if (count < size) {
                System.out.print("->");
            }
        }
        } else {
        throw new Error("Só é possível efetuar a classificação topológica em grafos direcionados acíclicos.");
        }    
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(15);
        
        dfs.dfs();
        dfs.printTopologicalSort(dfs.topologicalSort);
    }
}
