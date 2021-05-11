
package a6.pkg6.breitensuche;
import java.util.*;

public class BreadthFirstSearch {
    
    public static Node Breitensuche(int[][] startState, int[][] goalState){
        int it = 0;
        Puzzle p = new Puzzle();
                
        Node startNode = new Node(startState, null);
        startNode.identity = startNode.makeIdentity();
        Node goalNode = new Node(goalState, null);
        goalNode.identity = goalNode.makeIdentity();
        Node current;
        Node tmp;
        
        // Überprüfen ob startState schon der goalState ist
        if(isSolution(startNode, goalNode)){
            System.out.println("startState is already the goalState, returning...");
            return startNode;
        }
        
        // Listen für zu besuchende und besuchte Nodes
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        
        queue.add(startNode);
        
        
        while(!queue.isEmpty()){
            System.out.println("In while loop "+it);
            it++;
            current = queue.poll();
            printArray(current);
            if(current == null){
                System.out.println("Something exploded");
            }
            
            if(isSolution(current, goalNode)){
                System.out.println("Solution found");
                // System.out.println(explored);
                return current;
            }
            
            if(explored.contains(current)){
                continue;
            }
            
            else{
                
                // Up
                tmp = p.moveUp(current);
                if(tmp != null && !explored.contains(tmp)){
                    tmp.parent = current;
                    current.addNeighbour(tmp);
                    queue.add(tmp);
                }
                        
                // Right
                tmp = p.moveRight(current);
                if(tmp != null && !explored.contains(tmp)){
                    tmp.parent = current;
                    current.addNeighbour(tmp);
                    queue.add(tmp);
                }
                
                // Down
                tmp = p.moveDown(current);
                if(tmp != null && !explored.contains(tmp)){
                    tmp.parent = current;
                    current.addNeighbour(tmp);
                    queue.add(tmp);
                }
                        
                // Left
                tmp = p.moveLeft(current);
                if(tmp != null && !explored.contains(tmp)){
                    tmp.parent = current;
                    current.addNeighbour(tmp);
                    queue.add(tmp);
                }
            }
            explored.add(current);
        }
        return null;
    }
    
    
    public static boolean isSolution(Node a, Node b){       
        
        for(int i = 0; i < a.state[0].length; i++){
            for(int j = 0; j < a.state[0].length; j++){
                if(a.state[i][j] != b.state[i][j]){
                    return false;
                }
            }
        }       
        return true;
    }   
    
    public static boolean isSolutionByIdentity(Node a, Node b){
        return a.identity.equals(b.identity);
    }
    
    public static void printArray(Node a){
        for(int i = 0; i < a.state[0].length; i++){
            for(int j = 0; j < a.state[0].length; j++){
                System.out.print(a.state[i][j]);
            }
        }
        System.out.println();
    }
    
    public static void printArrayInRows(Node a){
        for(int i = 0; i < a.state[0].length; i++){
            for(int j = 0; j < a.state[0].length; j++){
                System.out.print(a.state[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
}
