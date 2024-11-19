import java.util.LinkedList;
import java.util.Deque;

class Player {
  String name;
  int cellNum;
  Player(String name){
    this.name = name;
    this.cellNum = 0;
  }
}

class Cell {
  int cellNumber;
  Impact snakeOrLadder;
  Cell(int num){
    this.cellNumber = num;
  }
}

class Board {
  Cell[][] board = new Cell[10][10];
  void intitializeBoard(){
    for(int i=0;i<10;i++){
      for(int j=0;j<10;j++){
        if(i%2 == 0){
          board[i][j] = new Cell(10*i+(j+1));
        }
        else {
          board[i][j] = new Cell(10*i+(10-j));
        }
      }
    }
  }

  void createImpacts() {
    int impacts = 6;
    while(impacts > 0){
      int impactStart = (int)Math.random()*100;
      int impactEnd = (int)Math.random()*100;
      int x=0;
      int y=0;
      if((impactStart/10)%2 == 0){
        x = impactStart/10;
        y = impactStart%10;
      }
      else {
        x = impactStart/10;
        y = 10-impactStart%10;
      }
      board[x][y].snakeOrLadder = new Impact(impactStart, impactEnd);
      
      impacts--;
    }
  }
}
class Dice {
  String name;
  int roll(){
    return (int)(Math.random()*6);
  }
}

// Snake and Ladder can be considered as a Impact common class because data objects are same (just start and end cells)
class Impact {
  int start;
  int end;
  Impact(int start, int end){
    this.start = start;
    this.end = end;
  }
}

class GameController {
  Deque<Player> q = new LinkedList<>();
  Board board;
  void play(Player p1, Player p2, Board board){
    this.board = board;
    q.addLast(p1);
    q.addLast(p2);
    
    Dice d1 = new Dice();
    int count = 0;
    while(true){
      Player currPlayer = q.removeFirst();
      q.addLast(currPlayer);
      int diceNum = d1.roll();
      int currPosition = currPlayer.cellNum + diceNum;
      if(currPosition >= 100){
        count++;
        System.out.println(currPlayer.name + " is No. "+Integer.toString(count)+"!");
        q.removeLast();
        return;
      }
      int x = 0;
      int y = 0;
      if((currPosition/10)%2 == 0){
        x = currPosition/10;
        y = currPosition%10;
      }
      else {
        x = currPosition/10;
        y = 10-currPosition%10;
      }
      if(this.board.board[x][y].snakeOrLadder != null){
        currPlayer.cellNum = this.board.board[x][y].snakeOrLadder.end;
      }
    }
  }

  
}

public class Main {
  public static void main(String[] args) {
    GameController game = new GameController();
    Player p1 = new Player("P1");
    Player p2 = new Player("P2");
    Board b1 = new Board();
    b1.intitializeBoard();
    b1.createImpacts();
    game.play(p1, p2, b1);
  }
}