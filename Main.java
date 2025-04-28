package MyProject;
import java.util.*;
	class TicTacToe{
		// declaration of array type char
		static char[][] board;

		public TicTacToe() {
			super();
			board=new char[3][3];
			initBoard();
			
		}
		void initBoard() {
			for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					 board[i][j]=' ';
				}
			}
		}
		static void displayBoard() {
			System.out.println("-------------");
			for(int i=0;i<=2;i++) {
				System.out.print("| ");
				for(int j=0;j<=2;j++) {
					System.out.print(board[i][j]+" | ");
				}
				System.out.println();
				System.out.println("-------------");
			}
		}
	   static void placeMark(int row,int col,char mark) {
	    	if(row>=0 && row<=2 && col>=0 && col<=2) {
	    		board[row][col]=mark;
	    	}
	    	else {
	    		System.out.println("Invalid Input");
	    	}
	    }
	   static  boolean checkRowWin() {
	    	for(int i=0;i<=2;i++) {
	    		if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	   static boolean checkColWin() {
	    	for(int j=0;j<=2;j++) {
	    		if(board[0][j]!=' ' &&board[0][j]==board[1][j] && board[1][j]==board[2][j]) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	   static boolean checkDiagonalWin() {
	    	if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2]) {
	    		return true;
	    	}
	    	else if(board[2][0]!=' ' &&board[2][0]==board[1][1]&&board[1][1]==board[0][2])  {
	    		return true;
	    	 }
	    	return false;
	    	}
	   static boolean checkDraw(){
		   for(int i=0;i<=2;i++) {
			   for(int j=0;j<=2;j++) {
				   if(board[i][j]==' ') {
					   return false;
				   }
			   }
		   }
		   return true;
	   }
	}
	abstract class Player{
		String name;
		char mark;
		abstract void makeMove();
		   boolean isValidMove(int row,int col) {
		    	if(row>=0&&row<=2 && col>=0&& col<=2) {
		    		if(TicTacToe.board[row][col]==' ') {
		    			return true;
		    		}
		    	}
		    	return false;
		    }
	}
	// for human player class is created
	class HumanPlayer extends Player{
	    public HumanPlayer(String name,char mark) {
			super();
			// TODO Auto-generated constructor stub
			this.name=name;
			this.mark=mark;
		}
		void makeMove() {
			Scanner scan= new Scanner(System.in);
			int row,col;
			do{System.out.println("Enter the row and column");
			 row=scan.nextInt();
			 col=scan.nextInt();
			}while(!isValidMove(row,col));
	    	TicTacToe.placeMark(row, col, mark);
	    }
	   
	}
	class AIPlayer extends Player{
	    public AIPlayer(String name,char mark) {
			super();
			// TODO Auto-generated constructor stub
			this.name=name;
			this.mark=mark;
		}
		void makeMove() {
			Scanner scan= new Scanner(System.in);
			int row,col;
			do{
				Random r = new Random();
				row=r.nextInt(3);
				col=r.nextInt(3);
			}while(!isValidMove(row,col));
	    	TicTacToe.placeMark(row, col, mark);
	    }
	 
	}

	public class Main {
	public static void main (String []args) {
        TicTacToe t = new TicTacToe();
        System.out.println("Welcome to TicTacToe");
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose with whom want to play Human or AI");
        String type=sc.nextLine().toLowerCase();
        System.out.println("Enter the Player1 Name");
        String Name_1=sc.nextLine();
        HumanPlayer p1=new HumanPlayer(Name_1,'X');
        Player p2=null;
       if(type.equals("human")) {
	     System.out.println("Enter the Player2 Name");
	     String Name_2=sc.nextLine();
		  p2=new HumanPlayer(Name_2,'O');
        }
        else if(type.equals("ai")) {
         p2=new AIPlayer("AI",'O');
        }
        else {
        	System.out.println("Enter the appropriate opponent");
        }
        
		Player cp;
		cp=p1;
		
		while(true) {
		System.out.println(cp.name+" Turn to play");
		cp.makeMove();
		TicTacToe.displayBoard();
		if(TicTacToe.checkColWin()||TicTacToe.checkRowWin()||TicTacToe.checkDiagonalWin()) {
			System.out.println(cp.name+" Won the game");
			break;
		}
		else if(TicTacToe.checkDraw()) {
			System.out.println("The game is Draw");
			break;
		}
		else {
		if(cp==p1) {
			cp=p2;
		}
		else {
			cp=p1;
		}
		}
	}
		}
		}




