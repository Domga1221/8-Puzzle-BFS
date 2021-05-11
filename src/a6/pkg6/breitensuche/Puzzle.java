
package a6.pkg6.breitensuche;

public class Puzzle {    
    
    private  void swap(Node newState, int newPosition[]) {
        int emptyTile[] = new int[2], tmpNum;                

        newState.getCoordinate(emptyTile, 0);
        tmpNum = newState.getNum(newPosition[0], newPosition[1]);
        
        newState.setNum(0, newPosition[0], newPosition[1]);
        newState.setNum(tmpNum, emptyTile[0], emptyTile[1]);
    }
        
    public  Node moveUp(Node currentState) {
        Node newState = new Node();
        //newState = null;
        int newPosition[] = new int[2];

        if (currentState.getX(0) - 1 >= 0) {
            //newState = currentState;
            newState.state = copyValues(currentState.state);
            newPosition[0] = newState.getX(0) - 1;
            newPosition[1] = newState.getY(0);

            swap(newState, newPosition);
            newState.identity = newState.makeIdentity();
            return newState;
        }

        return null;
    }        
        
    public  Node moveRight(Node currentState) {
        Node newState = new Node();
        //newState = null;
        int newPosition[] = new int[2];

        if (currentState.getY(0) + 1 <= 2) {
            //newState = currentState;
            newState.state = copyValues(currentState.state);
            newPosition[0] = newState.getX(0);
            newPosition[1] = newState.getY(0) + 1;

            swap(newState, newPosition);
            newState.identity = newState.makeIdentity();
            return newState;
        }

        return null;
    }        
        
    public  Node moveDown(Node currentState) {
        Node newState = new Node();
        //newState = null;
        int newPosition[] = new int[2];

        if (currentState.getX(0) + 1 <= 2) {
            //newState = currentState;
            newState.state = copyValues(currentState.state);
            newPosition[0] = newState.getX(0) + 1;
            newPosition[1] = newState.getY(0);

            swap(newState, newPosition);
            newState.identity = newState.makeIdentity();
            return newState;
        }

        return null;
    }        
        
    public  Node moveLeft(Node currentState) {
        Node newState = new Node();
        //newState = null;
        int newPosition[] = new int[2];

        if (currentState.getY(0) - 1 >= 0) {
            //newState = currentState;
            newState.state = copyValues(currentState.state);
            newPosition[0] = newState.getX(0);
            newPosition[1] = newState.getY(0) - 1;

            swap(newState, newPosition);
            newState.identity = newState.makeIdentity();
            return newState;
        }

        return null;
    } 
    
    public int[][] copyValues(int b[][]){
        int a[][] = new int[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                a[i][j] = b[i][j];
            }
        }
        return a;
    }
}

