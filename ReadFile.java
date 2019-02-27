import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
  public static void main(String args[]) throws FileNotFoundException {
    File text = new File("Maze1.txt");

    //inf stands for the input file
    Scanner inf = new Scanner(text);

    //stores lines from text file
    ArrayList<String> lines = new ArrayList<String>();

    //adds each line to text file
    while(inf.hasNextLine()){
      //String line = inf.nextLine();
      //System.out.println(line);
      lines.add(inf.nextLine());
    }

    int numLines = lines.size(); //number of lines
    int numChars = lines.get(0).length(); //number of chars in each line
    char[][] maze = new char[numLines][numChars]; //initializes array

    //adds to array
    for (int x = 0; x < numLines; x++){
      for (int y = 0; y < numChars; y++){
        maze[x][y] = lines.get(x).charAt(y);
      }
    }

    //convert array to String
    String output = "";
    for (int x = 0; x < numLines; x++){
      for (int y = 0; y < numChars; y++){
        output += maze[x][y];
      }
      output += "\n";
    }

    System.out.println(output);

  }
}
