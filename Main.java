import java.util.Scanner;
import java.util.Stack;
import java.util.*;
import java.io.*;

public class Main {
	
	// Player1 is X Player2 is O
	private static Game game;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int p1wincountsort = 0;
		int p2wincountsort = 0;
		String name1 = null;
		String name2 = null;
                
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
			name1 = input.next();
			System.out.print("Enter Age of First Player(X): ");
			try{
				int age1 = input.nextInt();
				list.insert(name1, age1);
				playersX.enqueue(name1);
			} catch (InputMismatchException e) {
				System.out.print("Please retry with an integer number!");
				boolean retry = true;;
				while (retry)
				{
					try{
						input.nextLine();			//Refreshes input
						System.out.println();
						System.out.print("Enter Age of First Player(X): ");
						int age1 = input.nextInt();	//Try block activates if it fails
						//Stops the loop
						retry = false;
						list.insert(name1, age1);
						playersX.enqueue(name1);
					} catch (InputMismatchException f) {
						System.out.print("Wrong again, please retry with an integer number!");
					}
				}
			}
                        // adding name to queue and name and age to player list
                        
			System.out.println();
			System.out.print("Enter Name of Second Player(O): ");
			name2 = input.next();
			System.out.print("Enter Age of Second Player(O): ");
			try{
				int age2 = input.nextInt();
				list.insert(name2, age2);
				playersX.enqueue(name2);
			} catch (InputMismatchException e) {
				System.out.print("Please retry with an integer number!");
				boolean retry = true;
				while (retry)
				{
					try{
						input.nextLine();			//Refreshes input
						System.out.println();
						System.out.print("Enter Age of First Player(0): ");
						int age2 = input.nextInt();	//Try block activates if it fails
						//Stops the loop
						retry = false;
						list.insert(name2, age2);
						playersX.enqueue(name2);
					} catch (InputMismatchException f) {
						System.out.print("Wrong again, please retry with an integer number!");
					}
				}
			}
                        
			System.out.println();
			
			game = new Game(name1, name2);
			
			System.out.println("Game Start!");
			System.out.println();
			
			game.printBoard();
			System.out.println();
			System.out.print(name1 + "'s Turn \nChoose a spot: ");
			int spot = 0;
			try {
				spot = input.nextInt();
			} catch(InputMismatchException e) {
				System.out.print("Please select a spot (1-9)");
				boolean retry = true;
				while (retry) {
					try {
						input.nextLine();            //Refreshes input
						System.out.println();
						System.out.print(name1 + "'s Turn \nChoose a spot: ");
						spot = input.nextInt();
						retry = false;
					} catch (InputMismatchException k) {
						System.out.print("Wrong again! Please select a spot (1-9)");
					}
				}
			}
			System.out.println();
			
			boolean win = false;
			boolean p1win = false;
			boolean p2win = false;

			
			while(win == false) {
				
				//checks if the spot is taken
				boolean choice = game.player1Turn(spot);
				while(choice == false) {
					System.out.print("Choose a different spot: ");
					try{
						spot = input.nextInt();
					} catch(InputMismatchException e) {
						System.out.print("Please select a spot (1-9)");
						boolean retry = true;
						while (retry) {
							try {
								input.nextLine();            //Refreshes input
								System.out.println();
								System.out.print(name1 + "'s Turn \nChoose a spot: ");
								spot = input.nextInt();
								retry = false;
							} catch (InputMismatchException k) {
								System.out.print("Wrong again! Please select a spot (1-9)");
							}
						}
					}
					System.out.println();
					choice = game.player1Turn(spot);
					
				}
				System.out.println();
				
				if (game.isWin()) {
					p1win = true;
					p1wincountsort++;
					break;
				}
				
				if (game.isTie()) {
					break;
				}
				
				//Player 2's Turn
				game.printBoard();
				System.out.println();
				System.out.print(name2 + "'s Turn \nChoose a spot: ");
				try {
					spot = input.nextInt();
				} catch(InputMismatchException e) {
					System.out.print("Please select a spot (1-9)");
					boolean retry = true;
					while (retry) {
						try {
							input.nextLine();            //Refreshes input
							System.out.println();
							System.out.print(name2 + "'s Turn \nChoose a spot: ");
							spot = input.nextInt();
							retry = false;
						} catch (InputMismatchException k) {
							System.out.print("Wrong again! Please select a spot (1-9)");
						}
					}
				}
				System.out.println();
				
				//checks if the spot is taken
				choice = game.player2Turn(spot);
				while(choice == false) {
					
					System.out.print("Choose a different spot: ");
					try {
						spot = input.nextInt();
					} catch(InputMismatchException e) {
						System.out.print("Please select a spot (1-9)");
						boolean retry = true;
						while (retry) {
							try {
								input.nextLine();            //Refreshes input
								System.out.println();
								System.out.print(name2 + "'s Turn \nChoose a spot: ");
								spot = input.nextInt();
								retry = false;
							} catch (InputMismatchException k) {
								System.out.print("Wrong again! Please select a spot (1-9)");
							}
						}
					}
					System.out.println();
					choice = game.player2Turn(spot);
					
				}
				System.out.println();
				
				if (game.isWin()) {
					p2win = true;
					p2wincountsort++;
					break;
				}
				
				if (game.isTie()) {
					break;
				}
				
				//Player 1's Turn
				game.printBoard();
				System.out.println();
				System.out.print(name1 + "'s Turn \nChoose a spot: ");
				try {
					spot = input.nextInt();
				} catch(InputMismatchException e) {
					System.out.print("Please select a spot (1-9)");
					boolean retry = true;
					while (retry) {
						try {
							input.nextLine();            //Refreshes input
							System.out.println();
							System.out.print(name2 + "'s Turn \nChoose a spot: ");
							spot = input.nextInt();
							retry = false;
						} catch (InputMismatchException k) {
							System.out.print("Wrong again! Please select a spot (1-9)");
						}
					}
				}
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

		int[] sortarr = new int[2];
		sortarr[0] = p1wincountsort;
		sortarr[1] = p2wincountsort;

		GenericSort ob = new GenericSort();
		ob.mergeSort(sortarr, 0, sortarr.length - 1);
		ob.reverse(sortarr);

		if(p2wincountsort > p1wincountsort)
		{
			System.out.println(name2 + " Wins With A Score Of: " + sortarr[0]);
			System.out.println();
			System.out.printf(name1 + " Score: " + sortarr[1] + "\n");
		}
		else
		{
			System.out.println(name1 + " Wins With A Score Of: " + sortarr[0]);
			System.out.println();
			System.out.printf(name2 + " Score: " + sortarr[1] + "\n\n");
		}

		System.out.println("Goodbye!");

		
		
	}
	
}
