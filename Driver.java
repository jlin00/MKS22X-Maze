import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
      String filename = "data1.dat";
      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.
        System.out.println(f);

        f.setAnimate(true);
        f.solve();
        System.out.println(f);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename);
      }


      String filename2 = "data2.dat";
      try{
        Maze f2;
        f2 = new Maze(filename2);//true animates the maze.
        System.out.println(f2);

        f2.setAnimate(true);
        f2.solve();
        System.out.println(f2);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename2);
      }


      String filename3 = "data3.dat";
      try{
        Maze f3;
        f3 = new Maze(filename3);//true animates the maze.
        System.out.println(f3);

        f3.setAnimate(true);
        f3.solve();
        System.out.println(f3);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename3);
      }


    }
}
