public class Player {
  String name;
  Player(String name){
    this.name = name;
  }
}

public class Cell {
  int cellNumber;
  Impact snakeOrLadder;
  Cell(int num){
    this.cellNumber = num;
  }
}

public class Board {
  Cell board[10][10];
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
}
public class Dice {
  String name;
  int roll(){
    return (int)(Math.random()*6);
  }
}

// Snake and Ladder can be considered as a Impact common class because data objects are same (just start and end cells)
public class Impact {
  int start;
  int end;
  Impact(int start, int end){
    this.start = start;
    this.end = end;
  }
}

public class GameController {
  Deque<Player> q;
  Board board;
  void play(Player p1, Player p2, Board board){
    this.board = board
    q.addLast(p1);
    q.addLast(p2);
    
    Dice d1 = new Dice();
    while(1){
      if(gameOver()){
        return ;
      }
    }
  }
}

public class Game {
  public static void main(String[] args) {
    GameController game = new GameController();
    game.play()
  }
}