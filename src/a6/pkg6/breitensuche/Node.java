
package a6.pkg6.breitensuche;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Node {
    int state [][] = new int[3][3];
    boolean visited;
    Node parent;
    String identity;

    // Konstruktor
    List<Node> adjacenciesList;

    // Konstruktor
    public Node (int state[][], Node parent){
        this.state = state;
        this.parent = parent;
        visited = false;
        identity = null;
        this.adjacenciesList = new ArrayList<>();
    }
    
    public Node(){
        this.adjacenciesList = new ArrayList<>();
    }
    
    public void addNeighbour(Node node){
        this.adjacenciesList.add(node);
    }
    
    
    // ---------------------------
    
    
    public int getNum(int posX, int posY) {
        return state[posX][posY];
    }
    
    public void setNum(int num, int x, int y) {
        state[x][y] = num;
    }
    
    public int getX(int num) {
        int positionX = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    positionX = x;
                    break;
                }
            }
        }

        return positionX;
    }
    
    public int getY(int num) {
        int positionY = 0;

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    positionY = y;
                    break;
                }
            }
        }

        return positionY;
    }
    
    public void getCoordinate(int coordinate[], int num) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == num) {
                    coordinate[0] = x;
                    coordinate[1] = y;
                    break;
                }
            }
        }
    }
    
    public int[][] getState(int state[][]) {
        return this.state;
    }
    
    /*
    public String toString() {
        String output = "";

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                output += state[x][y];
            }
            output += "\n";
        }

        return output;
    }
    */
    
    public String makeIdentity(){
        StringJoiner joiner = new StringJoiner(".");
        
        for(int i=0; i <3; i++){
            for(int j=0; i <3; i++){
                joiner.add(Integer.toString(state[i][j]));
            }
        }
        return joiner.toString();
    }
}



