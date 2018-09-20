/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazeproject;

import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class YourMazeWithPath
{       
    private InputGraphicMaze maze;
    private int R, C; 
    private boolean [][] V;
    
    

  public YourMazeWithPath() 
  {       
       // an R rows x C columns maze
       maze = new InputGraphicMaze();
       R=maze.Rows(); C=maze.Cols();   
       
       // Path holds the cells of the path
       V = new boolean [R][C]; //
       LinkedList<Point> Path = new LinkedList<Point>();
       // Create the path
      
       CreatePath(maze, 1, 1, R, C, Path);
       // show the path in the maze
       maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze maze,      
      int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {   
        L.push(new Point(srow, scol));
        V[srow-1][scol-1] = true; //sets the end value to true
       if(srow == erow && scol == ecol){ //if the beginning row is equal to the end row return true
           
           return true;
       }
       if(srow>1 && !V[srow-2][scol-1] && maze.can_go(srow, scol, 'U') && //while the value isn't visited, and the maze can go up a column and   
           CreatePath(maze, srow-1, scol, erow, ecol, L)){                //and can create a path from the previous row 
           return true;
       }
       if(srow < R && !V[srow][scol-1] && maze.can_go(srow, scol, 'D')&& //while the value isn't visited and the maze can go down one column
           CreatePath(maze, srow+1, scol, erow, ecol, L)){               
           
           return true;
       }
       if(scol < C && !V[srow - 1][scol] && maze.can_go(srow, scol, 'R') && 
               CreatePath(maze, srow, scol + 1, erow, ecol, L)){
           
           return true;
       }
       if(scol > 1 && !V[srow -1][scol-2] && maze.can_go(srow, scol, 'L') && 
               CreatePath(maze, srow, scol - 1, erow, ecol, L)){
           return true;
       }
      
           L.remove(); //removes point from queue and returns false
           return false;
       
    }

    public static void main(String[] args)
    {new YourMazeWithPath();}

}