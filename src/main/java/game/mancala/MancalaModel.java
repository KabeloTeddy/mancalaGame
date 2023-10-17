package game.mancala;

public class MancalaModel {
    

    private int numberOfPitsPerSide;
    private int[][] stones;
    private int currentPlayerTurn;

    public MancalaModel(int numberOfPitsPerSide) {
        this.numberOfPitsPerSide = numberOfPitsPerSide;
        this.stones = new int[2][numberOfPitsPerSide];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < numberOfPitsPerSide; j++) {
                stones[i][j] = 6;
            }
        }
        this.currentPlayerTurn = 0;
    }

    // getters and setters for the fields

    public int getNumberOfPitsPerSide() {
        return numberOfPitsPerSide;
    }

    public void setNumberOfPitsPerSide(int numberOfPitsPerSide) {
        this.numberOfPitsPerSide = numberOfPitsPerSide;
    }

    public int[][] getStones() {
        return stones;
    }

    public void setStones(int[][] stones) {
        this.stones = stones;
    }

    public int getCurrentPlayerTurn() {
        return currentPlayerTurn;
    }

    public void setCurrentPlayerTurn(int currentPlayerTurn) {
        this.currentPlayerTurn = currentPlayerTurn;
    }
}
