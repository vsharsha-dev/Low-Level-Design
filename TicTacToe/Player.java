public class Player {
  String playerName;
  Symbol playerSymbol;

  Player(String name, Symbol symbol){
    this.playerName = name;
    this.playerSymbol = symbol;
  }

  public void setName(String name){
    this.playerName = name;
  }
  public void setSymbol(Symbol symbol){
    this.playerSymbol = symbol;
  }
}