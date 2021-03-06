import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[]args){
      String filename = "data1.dat";
      try{
        Maze f;
        f = new Maze(filename);//true animates the maze.
        System.out.println(f);

        //f.setAnimate(true);
        System.out.println(f.solve());
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

        //f2.setAnimate(true);
        System.out.println(f2.solve());
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

        //f3.setAnimate(true);
        System.out.println(f3.solve());
        System.out.println(f3);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename3);
      }


      String filename4 = "data.dat";
      try{
        Maze f4;
        f4 = new Maze(filename4);//true animates the maze.
        System.out.println(f4);

        f4.setAnimate(true);
        f4.solve();
        System.out.println(f4);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: "+filename4);
      }

      MazeGen m = new MazeGen(10,15);
      m.generate();
      try {
        m.writeToFile("mazegen.dat");
      }
      catch(IOException e){
        System.out.println("IO Exception");
      }

      String filename5 = "mazegen.dat";
      try{
        Maze f5;
        f5 = new Maze(filename5);
        System.out.println(f5);

        f5.setAnimate(true);
        System.out.println(f5.solve());
        System.out.println(f5);
      }
      catch(FileNotFoundException e){
        System.out.println("Invalid filename: " + filename5);
      }

    }
}
