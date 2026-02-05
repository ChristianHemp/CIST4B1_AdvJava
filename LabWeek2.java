// Basic 2D array maze solving tool using recursion
// Assumes entrance at top left corner of 2D array and exit at bottom right corner of 2D array
// 0 = path, 1 = wall, 2 = checked space, 3 = final solved path

public class MazeSolver {
    public static void main(String[] args) {
        // 2D Array to represent initial maze layout (example, can be modified)
        int[][] maze = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0}
        };

        // Display initial maze
        System.out.println("Initial unsolved maze:");
        printMaze(maze);

        // Calls function to solve maze recursively starting at (0,0)
        // finished variable used for following print statement
        boolean finished = solveMaze(maze, 0, 0);

        // Displays message regarding maze solved status
        if(!finished) {
            System.out.println("\n\n\nNo path to the exit exists, the maze cannot be solved");
        } else {
            System.out.println("\n\n\nThe maze has been solved!");
        }

        // Display solved maze
        printMaze(maze);
    }

    // Core recursive function that checks and updates maze indexes
    public static boolean solveMaze(int[][] maze, int row, int column) {

        // Returns false if function reaches a row or column that is out of bounds of the maze dimensions
        if(row >= (maze.length) || column >= maze[0].length || row < 0 || column < 0) {
            return false;
        }

        // Returns false if the index being checked is anything but a path to handle walls and checked indexes
        if(maze[row][column] != 0) {
            return false;
        }

        // Returns true if the exit is reached marking it with 3 as part of the final path
        if(row == (maze.length - 1) && column == (maze[0].length - 1)) {

            maze[row][column] = 3;
            return true;
        }

        // Assuming previous conditions do not return a value now we mark the current cell as tried
        // This order assures that the tile would've been checked for out of bounds/walls beforehand
        maze[row][column] = 2;

        // Recursively call solveMaze function to solve maze
        // When if statemen condition returns true, we know its index is part of the final path, so we mark it
        // Checks indexes in the order up, left, down right
        if(solveMaze(maze, row - 1, column) || solveMaze(maze, row, column -1) || solveMaze(maze, row + 1, column) ||
        solveMaze(maze, row, column + 1)) {

            maze[row][column] = 3;
            return true;
        }

        // Handles exceptions and fulfills required return statement for the return type (boolean)
        return false;
    }

    public static void printMaze(int[][] maze) {
        // Nested for loop to iterate through 2D maze array and print output formatted properly
        for(int[] row : maze) {
            for(int index : row) {
                System.out.printf(" %d", index);
            }
            System.out.println();
        }
    }
}


// Test case maze layout storage
/*        
int[][] maze = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0},
        };
*/

/*
int[][] maze = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0}
        };
*/

/*
int[][] maze = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        };
*/
