package programmers.dfsbfs;

import java.util.*;
class DivideElectronicNetwork {
    public int solution(int n, int[][] wires) {
        int diff = Integer.MAX_VALUE;
        Graph graph = new Graph(n);
        for (int i=0; i<wires.length; i++) {
            graph.addEdge(wires[i][0], wires[i][1]);
            graph.addEdge(wires[i][1], wires[i][0]);
        }
        
        for (int i=0; i<wires.length; i++) {
            graph.searched = 0;
            graph.deleteEdge(wires[i][0], wires[i][1]);
            graph.deleteEdge(wires[i][1], wires[i][0]);
            graph.dfs(wires[i][0]);
            diff = Math.min(diff, Math.abs(graph.searched - (n - graph.searched)));
            graph.addEdge(wires[i][0], wires[i][1]);
            graph.addEdge(wires[i][1], wires[i][0]);
        }
        
        
        return diff;
    }

    
    class Node {
        int vertex;
        LinkedList<Node> neighbors;
        boolean visited = false;
        
        Node (int vertex) {
            this.vertex = vertex;
            neighbors = new LinkedList<>();
        }
    }
    
    class Graph {
        Node[] nodes;
        int searched=0;
        
        Graph (int n) {
            nodes = new Node[n+1];
            for(int i=1; i<=n; i++) {
                nodes[i] = new Node(i);
            }
        }
        
        void addEdge(int n1, int n2) {
            if (!nodes[n1].neighbors.contains(nodes[n2])) {
                nodes[n1].neighbors.add(nodes[n2]);
            }
        }
        
        void deleteEdge(int n1, int n2) {
            nodes[n1].neighbors.remove(nodes[n2]);
        }
        
        void dfs(int i) {
            nodes[i].visited = true;
            searched++;
            
            for(Node neighbor : nodes[i].neighbors) {
                if (!neighbor.visited) {
                    dfs(neighbor.vertex);
                }
            }
            nodes[i].visited=false;
        }
    }
}