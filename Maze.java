import java.util.*;
import java.io.*;

public class Maze{

    private char[][] maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:
         throw a FileNotFoundException or IllegalStateException
    */
    public Maze(String filename) throws FileNotFoundException{
        animate = false; //sets animate to false

        File data = new File(filename); //input filename
        Scanner info = new Scanner(data);
        ArrayList<String> lines = new ArrayList<String>(); //stores each line of the file as a String

        while (info.hasNextLine()){ //loops through file
          lines.add(info.nextLine()); //add each line to arraylist
        }

        int numLines = lines.size(); //number of lines in file
        int numChars = lines.get(0).length(); //number of characters in each line
        maze = new char[numLines][numChars]; //initializes maze size

        int start = 0; //keeps track of number of starts
        int exit = 0; //keeps track of number of exits

        for (int x = 0; x < numLines; x++){
          for (int y = 0; y < numChars; y++){
            char character = lines.get(x).charAt(y);
            if (character == 'S') start++;
            if (character == 'E') exit++;
            maze[x][y] = character; //adds characters to array
          }
        }

        if (start != 1 || exit != 1) throw new IllegalStateException(); //exception

    }

    //toString
    public String toString(){
      String output = "";
      for (int x = 0; x < maze.length; x++){
        for (int y = 0; y < maze[0].length; y++){
          output += maze[x][y];
        }
        output += "\n";
      }
      return output;
    }

    private void wait(int millis){
      try {
          Thread.sleep(millis);
      }
      catch (InterruptedException e) {
      }
     }

    public void setAnimate(boolean b){
      animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
      System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
      //find the location of the S.
      int row = 0;
      int col = 0;

      for (int x = 0; x < maze.length; x++){
        for (int y = 0; y < maze[0].length; y++){
          if (maze[x][y] == 'S'){ //find S
            row = x;
            col = y;
          }
        }
      }

      //erase the S
      maze[row][col] = ' ';

      //and start solving at the location of the s.
      //return solve(???,???);
      return solve(row, col);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private
      //automatic animation! You are welcome.
      if(animate){
          clearTerminal();
          System.out.println(this);
          wait(20);
      }

      //COMPLETE SOLVE
      int output = 0;
      int[][] moves = {{0,1},{0,-1},{-1,0},{1,0}}; //up, down, left, right

      if (maze[row][col] == 'E') return output; //if exit found
      if (maze[row][col] != ' ') return -1;

      maze[row][col] = '@'; //mark this spot as traveled to
      int temp; //output
      for (int i = 0; i < moves.length; i++){ //loop through possible moves
        temp = solve(row + moves[i][0], col + moves[i][1]); //try move
        if (temp != -1) return temp + 1; // returns output, plus final step
        else if (maze[row + moves[i][0]][col + moves[i][1]] == 'E') return 1; //return one for each valid step in solution
      }
      maze[row][col] = '.'; //if solution fails
      return -1; //so it compiles
    }

}
