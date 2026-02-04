public class MazeSolver {
    public static void main(String[] args) {
        // 2D Array to represent initial maze layout (0 = path, 1 = wall)
        int[][] maze = {
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0}
        };

        printMaze(maze);

        solveMaze(maze, 0, 0);

        System.out.print("\n\n\n");
        printMaze(maze);
    }

    public static boolean solveMaze(int[][] maze, int row, int column) {

        // Returns false if function reaches a row or column that is out of bounds of the maze dimensions
        if(row >= (maze.length) || column >= maze[0].length || row < 0 || column < 0) {
            return false;
        }

        // Returns false if the index being checked is anything but a path
        // Handles walls (1) and previously checked spaces (2)
        if(maze[row][column] != 0) {
            return false;
        }

        // Returns true if the exit is found (assuming exit is always at bottom right corner of maze)
        // Marks exit index with 3 to indicate being part of the final path
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
                System.out.print(index);
            }
            System.out.println();
        }
    }
}
