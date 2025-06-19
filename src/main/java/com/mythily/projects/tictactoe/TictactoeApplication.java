package com.mythily.projects.tictactoe;

import com.mythily.projects.tictactoe.controllers.GameController;
import com.mythily.projects.tictactoe.models.*;
import com.mythily.projects.tictactoe.strategies.ColWinningStrategy;
import com.mythily.projects.tictactoe.strategies.DiagonalWinningStrategy;
import com.mythily.projects.tictactoe.strategies.RowWinningStrategy;
import com.mythily.projects.tictactoe.strategies.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TictactoeApplication.class, args);

		//create models
		List<Player> players = new ArrayList<>();
		Player player1 = new HumanPlayer(1, "Mythily", new Symbol('X'));
		Player player2 = new BotPlayer(2, "Bot", new Symbol('O'), BotDifficultyLevel.EASY);
		players.add(player1);
		players.add(player2);

		List<WinningStrategy> winningStrategies = new ArrayList<>();
		WinningStrategy strategy1 = new RowWinningStrategy();
		WinningStrategy strategy2 = new ColWinningStrategy();
		WinningStrategy strategy3 = new DiagonalWinningStrategy();
		winningStrategies.add(strategy1);
		winningStrategies.add(strategy2);
		winningStrategies.add(strategy3);

		//create controllers
		GameController gameController = new GameController();

		//start the game
		Game game = gameController.startGame(3, players, winningStrategies);
		gameController.display(game);

		//make the move
		while(gameController.checkGameState(game) == GameState.IN_PROGRESS){
			gameController.makeMove(game);
			gameController.display(game);
		}
		//check for winner
		//declare winner and stop the game
		if(gameController.checkGameState(game) == GameState.SUCCESS){
			System.out.println(game.getWinner()+" is the winner.");
		}else if(gameController.checkGameState(game) == GameState.DRAW){
			System.out.println("Game is draw.");
		}






	}

}
