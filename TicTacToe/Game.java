import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
  Board boardObj;
  Deque<Player> playerQueue = new LinkedList<>();
  int count = 0;

  public void startGame() {
    // count++;
    Player p1 = new Player("P1", Symbol.X);
    Player p2 = new Player("P2", Symbol.O);
    playerQueue.addLast(p1);
    playerQueue.addLast(p2);
    this.boardObj = new Board(3);

    while(true){
      int n = boardObj.grid.length;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          System.out.print(boardObj.grid[i][j] + " ");
        }
        System.out.print("\n");
      }
      Player currentPlayer = playerQueue.removeFirst();

      System.out.print(currentPlayer.playerName + "'s Turn. Please provide the cell to fill in x,y format: ");
      Scanner scanner = new Scanner(System.in);
      String inputString = scanner.nextLine();

      int row = Integer.valueOf(inputString.split(",")[0]);
      int column = Integer.valueOf(inputString.split(",")[1]);
      if(!boardObj.fillBoard(row, column, currentPlayer.playerSymbol)){
        System.out.println("Invalid input. Please try again.");
        playerQueue.addFirst(currentPlayer);
        continue;
      }
      playerQueue.addLast(currentPlayer);
      if(isGameOver(boardObj)){
        System.out.println(currentPlayer.playerName + " is the winner!!");
        return;
      }
      // if(count == 5) break;
    }
  }

  public boolean isGameOver(Board boardObj){
    int n= boardObj.grid.length;
    // Check all rows
    for(int i=0;i<n;i++){
      Symbol s1 = boardObj.grid[i][0];
      int j=1;
      for(;j<n;j++){
        if(boardObj.grid[i][j] != s1 || s1 == Symbol.NA) break;
      }
      if(j==n) return true;
    }

    // Check all columns
    for(int i=0;i<n;i++){
      Symbol s1 = boardObj.grid[0][i];
      int j=1;
      for(;j<n;j++){
        if(boardObj.grid[j][i] != s1 || s1 == Symbol.NA) break;
      }
      if(j==n) return true;
    }

    // Check diagonals
    Symbol s1 = boardObj.grid[0][0];
    int i=1;
    for(;i<n;i++){
      if(boardObj.grid[i][i] != s1 || s1 == Symbol.NA) break;
    }
    if(i==n) return true;

    Symbol s2 = boardObj.grid[n-1][0];
    int j=1;
    for(;j<n;j++){
      if(boardObj.grid[n-1-j][j] != s2 || s2 == Symbol.NA) break;
    }
    if(j==n) return true;

    return false;
  }
}