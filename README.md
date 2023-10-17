# mancalaGame
Mancala game api

To interact with the Mancala game using the provided endpoints, you can follow these steps:

Start a New Game:

Send a POST request to create a new game:

curl -X POST -H "Content-Type: application/json" -d '{"players": ["Player 1", "Player 2"]}' http://localhost:8080/games
This request will create a new game and return a unique gameId.

Sow Seeds:

You can now send a POST request to sow seeds by specifying the gameId, playerId, and pitIndex:


curl -X POST -H "Content-Type: application/json" -d '{"playerId": 0, "pitIndex": 3}' http://localhost:8080/games/{gameId}/sow
Replace {gameId} with the unique game ID you received in step 1. The response will indicate whether the move was successful.

Check if the Game is Over:

To check if the game is over, send a GET request to:


curl http://localhost:8080/games/{gameId}/is-over
Again, replace {gameId} with the unique game ID. The response will be a boolean, indicating whether the game is over.

Determine the Winner:

To determine the winner, send a GET request to:


curl http://localhost:8080/games/{gameId}/winner
This will return the result, such as "Player 1 wins," "Player 2 wins," or "It's a tie."




>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
**Using Postman with the Mancala Game API**

Start a New Game:

Open Postman and create a new request.

Set the request type to "POST".
Enter the request URL: http://localhost:8080/games
Set the request header: "Content-Type" with the value "application/json".
In the request body, select the "raw" option and enter the JSON data:

{
  "players": ["Player 1", "Player 2"]
}
Click the "Send" button in Postman. You will receive a response with a unique gameId.

Sow Seeds:

Create another request in Postman to sow seeds.

Set the request type to "POST".
Enter the request URL by replacing {gameId} with the unique ID you received in step 1. For example, http://localhost:8080/games/your-game-id/sow.
Set the request header: "Content-Type" with the value "application/json".
In the request body, select the "raw" option and enter the JSON data for the move:

{
  "playerId": 0,
  "pitIndex": 3
}
Click the "Send" button in Postman to perform the move.

Check if the Game is Over:

To check if the game is over, create a GET request in Postman.

Set the request type to "GET".
Enter the request URL by replacing {gameId} with the unique game ID: http://localhost:8080/games/your-game-id/is-over.
Click the "Send" button to receive a response indicating whether the game is over (a boolean).

Determine the Winner:

Create a GET request in Postman to determine the winner.

Set the request type to "GET".
Enter the request URL by replacing {gameId} with the game ID: http://localhost:8080/games/your-game-id/winner.
Click the "Send" button to receive the result, such as "Player 1 wins," "Player 2 wins," or "It's a tie."

Remember to replace your-game-id with the actual unique game ID you received in step 


## Future Integrations

The primary aim of this project is to create a functional backend for the Mancala game. The next step is to integrate this backend with a user-friendly front-end interface. Here are our future goals:

- **HTML/CSS Integration**: We plan to create a web-based interface using HTML and CSS, making it accessible through a web browser. This will provide a simple and visually appealing way to play the game.

- **Angular Integration**: To enhance the user experience and add interactive features, we intend to build a front-end using the Angular framework. Angular will allow for dynamic updates and real-time gameplay.

