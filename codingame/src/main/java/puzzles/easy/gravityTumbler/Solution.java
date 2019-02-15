package puzzles.easy.gravityTumbler;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CodinGame.com Solutions
 * Puzzle: Gravity Tumbler
 * @author citizendiop
 * Difficulty: Easy
 * Date solved: 26.11.2018
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
public class Solution {

    public static void main(String args[]) {
	Scanner in = new Scanner(System.in);
	int width = in.nextInt();
	int height = in.nextInt();
	int count = in.nextInt();
	if (in.hasNextLine()) {
	    in.nextLine();
	}

	// Create empty grid.
	int[][] grid = new int[width][];

	for (int x = 0; x < width; x++) {
	    grid[x] = new int[height];
	}

	// Fill the grid. Replace blocks with 0 and 1.
	for (int y = 0; y < height; y++) {
	    String raster = in.nextLine();

	    for (int x = 0; x < width; x++) {
		grid[x][y] = (raster.charAt(x) == '.') ? 0 : 1;
	    }
	}

	// Rotate grid <count> times and move blocks down after each rotation.
	for (int i = 0; i < count; i++) {
	    grid = RotateGrid(grid);
	    grid = ApplyPhysics(grid);
	}

	// Print grid.
	for (int y = 0; y < grid[0].length; y++) {
	    for (int x = 0; x < grid.length; x++) {
		System.out.print(grid[x][y] == 0 ? '.' : '#');
	    }

	    System.out.println();
	}
    }

    // Rotates the grid counterclockwise by 90°.
    private static int[][] RotateGrid(int[][] grid) {
	int[][] gridRotated = new int[grid[0].length][];

	for (int x = 0; x < gridRotated.length; x++) {
	    gridRotated[x] = new int[grid.length];

	    for (int y = 0; y < gridRotated[0].length; y++) {
		gridRotated[x][y] = grid[y][x];
	    }
	}

	return gridRotated;
    }

    // Applies physics to let the blocks fall to the ground.
    private static int[][] ApplyPhysics(int[][] grid) {
	for (int x = 0; x < grid.length; x++) {
	    Arrays.sort(grid[x]);
	}

	return grid;
    }
}