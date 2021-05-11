
package a6.pkg6.breitensuche;
import java.util.*;

public class DepthFirstSearch {
    
    public static Node Tiefensuche(int[][] startState, int[][] goalState){
        Node startNode = new Node(startState, null);
        startNode.identity = startNode.makeIdentity();
        Node goalNode = new Node(goalState, null);
        goalNode.identity = goalNode.makeIdentity();
        
        Stack<Node> stack = new Stack<Node>();
        stack.add(startNode);
        startNode.visited = true;
        
        Queue<Node> queue = new LinkedList<>();
        
        Puzzle p = new Puzzle();
        
        Node current;
        Node tmp;
        
        queue.add(startNode);
        
        while(!stack.isEmpty()){
            current = stack.pop();
            
            BreadthFirstSearch.printArrayInRows(current);
            
            if(BreadthFirstSearch.isSolution(current, goalNode)){
                return current;
            }
            
            current.visited = true;
            
            for(Node a : queue){
                if(BreadthFirstSearch.isSolution(current,a)){
                    break;
                }
            }
            
            for(int i = 0; i < 4;  i++){
                
                // Up
                tmp = p.moveUp(current);
                if(tmp != null && !queue.contains(tmp)){
                    tmp.parent = current;
                    
                    stack.push(current);
                    stack.push(tmp);
                    queue.add(tmp);
                    break;
                }
                
                // Right
                tmp = p.moveRight(current);
                if(tmp != null && !queue.contains(tmp)){
                    tmp.parent = current;
                    
                    stack.push(current);
                    stack.push(tmp);
                    queue.add(tmp);
                    break;
                }
                
                
                // Down
                tmp = p.moveDown(current);
                if(tmp != null && !queue.contains(tmp)){
                    tmp.parent = current;
                    
                    stack.push(current);
                    stack.push(tmp);
                    queue.add(tmp);
                    break;
                }
                
                // Left
                tmp = p.moveLeft(current);
                if(tmp != null && !queue.contains(tmp)){
                    tmp.parent = current;
                    
                    stack.push(current);
                    stack.push(tmp);
                    queue.add(tmp);
                    break;
                }
                  
            }
        }
        return null;
    }
}
