public class Board {
  Symbol[][] grid;
  Board(int size){
    this.grid = new Symbol[size][size];
    for(int i=0;i<size;i++){
      for(int j=0;j<size;j++){
        grid[i][j] = Symbol.NA;
      }
    }
  }

  public boolean fillBoard(int x, int y, Symbol sym){
    if(x-1 < 0 || y-1 < 0 || x-1 >= grid.length || y-1 >= grid.length){
      return false;
    }
    if(grid[x-1][y-1] != Symbol.NA){
      return false;
    }
    grid[x-1][y-1] = sym;
    return true;
  }
}