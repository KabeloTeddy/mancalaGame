package game.mancala;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import game.mancala.Service.MancalaService;

@RestController
public class MancalaController {
    private MancalaService mancalaService;

    public MancalaController(MancalaService mancalaService) {
        this.mancalaService = mancalaService;
    }

    @PostMapping("/games")
    public ResponseEntity<String> startNewGame(@RequestBody Map<String, String[]> requestBody) {
        String[] players = requestBody.get("players");
        if (players != null && players.length >= 2) {
            // Generate a unique game ID (e.g., a UUID)
            String gameId = UUID.randomUUID().toString();

            // Store the game state along with the game ID for future reference
            // You might want to maintain a data structure or database to store game states with their IDs.

            // Start the new game
            mancalaService.startNewGame();

            // Return the game ID in the response
            return ResponseEntity.ok("Game started successfully with ID: " + gameId);
        } else {
            // Return a 400 Bad Request response with an error message
            return ResponseEntity.badRequest().body("Invalid request. Please provide at least 2 players.");
        }
    }

    @PostMapping("/games/{gameId}/sow")
    public ResponseEntity<String> sowSeeds(@PathVariable String gameId, @RequestBody Map<String, Integer> requestBody) {
        int playerId = requestBody.get("playerId");
        int pitIndex = requestBody.get("pitIndex");

        // Now you can use gameId, playerId, and pitIndex to perform the move in the game.

       
        return ResponseEntity.ok("Move performed successfully for gameId: " + gameId);
    }

    @GetMapping("/games/{gameId}/is-over")
    public boolean isGameOver(@PathVariable String gameId) {
        
        return mancalaService.isGameOver();
    }

    @GetMapping("/games/{gameId}/winner")
    public ResponseEntity<String> determineWinner(@PathVariable String gameId) {
       // Get the game state from the service
    List<Integer> gameState = mancalaService.getGameState();

    if (gameState.size() >= 14) {
        int player1Score = gameState.get(6);
        int player2Score = gameState.get(13);
        
        if (player1Score > player2Score) {
            return ResponseEntity.ok("Player 1 wins");
        } else if (player1Score < player2Score) {
            return ResponseEntity.ok("Player 2 wins");
        } else {
            return ResponseEntity.ok("It's a tie");
        }
    } else {
        // Handle the case where the gameState list is not of the expected size
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Game state is not in the expected format");
    }
}
}
