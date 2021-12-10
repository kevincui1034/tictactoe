import java.util.Scanner;
import java.util.Stack;
import java.util.*;
import java.io.*;

public class Main {
	
	// Player1 is X Player2 is O
	private static Game game;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int p1wincount = 0;
		int p2wincount = 0;
                
                PlayerList list = new PlayerList();

                // two queues that store names for players X and O
                Queue<String> playersX = new Queue<>();
                Queue<String> playersO = new Queue<>();
                
                // two stacks that store winners and losers
                Stack<String> winners = new Stack<>();
		Stack<String> losers = new Stack<>();
                
		System.out.print("Play Tic Tac Toe? (Yes or No): ");
		String answer = input.next().toLowerCase();
		
		while(!answer.equals("no") && !answer.equals("yes")) {
			
			System.out.println();
			System.out.print("Huh? (Yes or No): ");
			answer = input.next().toLowerCase();
			
		}
		
		while(answer.equals("yes")) {
			System.out.println();
			System.out.print("Enter Name of First Player(X): ");
			String name1 = input.next();
                        System.out.print("Enter Age of First Player(X): ");
			int age1 = input.nextInt();
                        
                        // adding name to queue and name and age to player list
                        list.insert(name1, age1);
                        playersX.enqueue(name1);
                        
			System.out.println();
			System.out.print("Enter Name of Second Player(O): ");
			String name2 = input.next();
                        System.out.print("Enter Age of Second Player(O): ");
			int age2 = input.nextInt();
                        
                        // adding name to queue and name and age to player list
                        list.insert(name2, age2);
                        playersO.enqueue(name2);
                        
			System.out.println();
			
			game = new Game(name1, name2);
			
			System.out.println("Game Start!");
			System.out.println();
			
			game.printBoard();
			System.out.println();
			System.out.print(name1 + "'s Turn \nChoose a spot: ");
			int spot = input.nextInt();
			System.out.println();
			
			boolean win = false;
			boolean p1win = false;
			boolean p2win = false;

			
			while(win == false) {
				
				//checks if the spot is taken
				boolean choice = game.player1Turn(spot);
				while(choice == false) {
					
					System.out.print("Choose a different spot: ");
					spot = input.nextInt();
					System.out.println();
					choice = game.player1Turn(spot);
					
				}
				System.out.println();
				
				if (game.isWin()) {
					p1win = true;
					p1wincount++;
					break;
				}
				
				if (game.isTie()) {
					break;
				}
				
				//Player 2's Turn
				game.printBoard();
				System.out.println();
				System.out.print(name2 + "'s Turn \nChoose a spot: ");
				spot = input.nextInt();
				System.out.println();
				
				//checks if the spot is taken
				choice = game.player2Turn(spot);
				while(choice == false) {
					
					System.out.print("Choose a different spot: ");
					spot = input.nextInt();
					System.out.println();
					choice = game.player2Turn(spot);
					
				}
				System.out.println();
				
				if (game.isWin()) {
					p2win = true;
					p2wincount++;
					break;
				}
				
				if (game.isTie()) {
					break;
				}
				
				//Player 1's Turn
				game.printBoard();
				System.out.println();
				System.out.print(name1 + "'s Turn \nChoose a spot: ");
				spot = input.nextInt();
				System.out.println();
				
			}
			
			if (p1win == true) {
				System.out.println(name1 + " has won!");
                                
                                // adding winners and losers to their corresponding stack
                                winners.push(name1);
                                losers.push(name2);
                        }
			else if (p2win == true) {
				System.out.println(name2 + " has won!");
                                
                                // adding winners and losers to their corresponding stack
                                winners.push(name2);
                                losers.push(name1);       
                        }
			else 
				System.out.println("There is a Tie!");
			
			
			System.out.println();
			game.printBoardWin();
			System.out.println();
                        
			System.out.print("Would you like to play again? (Yes or No): ");
			answer = input.next().toLowerCase();
			
			while(!answer.equals("no") && !answer.equals("yes")) {
				
				System.out.println();
				System.out.print("Huh? (Yes or No): ");
				answer = input.next().toLowerCase();
				
			}
			
		}
                
                // print the players and their ages
                System.out.println();
                list.printPlayerList();
                        
		System.out.println();
		System.out.println("Goodbye!");


		
		
		int[] arr = new int[2];
		arr[0] = p1wincount;
		arr[1] = p2wincount;

		int[] sortarr = new int[10];
		System.out.print("Player 1 Wins: " + arr[0]);
		System.out.print("Player 2 Wins: " + arr[1]);

		GenericSort ob = new GenericSort();
		ob.mergeSort(sortarr, 0, arr.length - 1);

		
		
	}
	
}
