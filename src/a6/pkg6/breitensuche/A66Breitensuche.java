
package a6.pkg6.breitensuche;

public class A66Breitensuche {

    public static void main(String[] args) {
        int startState[][] = {{1,2,7}, {4,0,3}, {5,8,6}}; // nicht lösbar
        int startState2[][] = {{1,2,3}, {4,0,6}, {7,5,8}};
        int startState3[][] = {{4,1,3}, {7,2,6}, {5,8,0}};
        int startState4[][] = {{1,0,7}, {4,2,3}, {5,8,6}};
        int startState5[][] = {{1,0,3}, {4,7,2}, {5,8,6}};
        int startState6[][] = {{4,1,3}, {7,0,2}, {5,8,6}};
        int startState7[][] = {{4,1,3}, {0,7,2}, {5,8,6}};
        
        int state[][] = {{2,0,4}, {6,7,1}, {8,5,3}};
        
        int goalState[][] = {{1,2,3}, {4,5,6}, {7,8,0}};
        
        boolean solutionFound = false;
        
        System.out.println("Starting BFS");
        Node solutionNode = BreadthFirstSearch.Breitensuche(startState5, goalState);
        // Node solutionNode = DepthFirstSearch.Tiefensuche(startState2, goalState);
        
        while(solutionNode != null){
            BreadthFirstSearch.printArrayInRows(solutionNode);
            solutionNode = solutionNode.parent;
        }
        
        System.out.println("done");
    }
    
}
