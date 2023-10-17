package game.mancala.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import game.mancala.MancalaModel;


@Service
public class MancalaService {
 private MancalaModel board;


    public MancalaService() {
        this.board = new MancalaModel(6);
    }

    public void startNewGame() {
        // reset the game board
        board.setStones(new int[2][6]);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                board.getStones()[i][j] = 6;
            }
        }
        board.setCurrentPlayerTurn(0);
    }

    public void sowSeedsFromPit(int playerId, int pitIndex) {
        // implement the sowing logic
        int numberOfSeedsToSow = board.getStones()[playerId][pitIndex];
        board.getStones()[playerId][pitIndex] = 0;

        int currentPitIndex = pitIndex + 1;
        while (numberOfSeedsToSow > 0) {
            if (currentPitIndex == 6) {
                currentPitIndex = 0;
                // sow a seed in the player's store
                board.getStones()[playerId][6]++;
            } else {
                // sow a seed in the current pit
                board.getStones()[playerId][currentPitIndex]++;
            }
            currentPitIndex++;
            numberOfSeedsToSow--;
        }

        // check if the current player gets another turn
        if (board.getStones()[playerId][currentPitIndex - 1] == 1 && currentPitIndex - 1 != 6) {
            // the current player gets another turn
            board.setCurrentPlayerTurn(playerId);
        } else {
            // switch to the other player's turn
            board.setCurrentPlayerTurn((playerId + 1) % 2);
        }
    }

    public boolean isGameOver() {
        // check if the game is over
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (board.getStones()[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }

      public List<Integer> getGameState() {
        List<Integer> gameState = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                gameState.add(board.getStones()[i][j]);
            }
        }
        gameState.add(board.getStones()[0][6]); // Player 1's store
        gameState.add(board.getStones()[1][6]); // Player 2's store

        System.out.println("Game State: >>>>>>>>>>>>>>>>>" + gameState);
        System.out.println("Game State Size: ::::::" + gameState.size());
        return gameState;
    }

    

    public int determineWinner() {
        // determine the winner of the game
        int player1Score = board.getStones()[0][6];
        int player2Score = board.getStones()[1][6];

        if (player1Score > player2Score) {
            return 0;
        } else if (player2Score > player1Score) {
            return 1;
        } else {
            return -1; // tie
        }
    }

    
}