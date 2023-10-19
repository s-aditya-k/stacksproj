package org.kompella;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Grid {
    private GridVal[][] grid;

    public Grid(int length) {
        GridVal[][] grid = new GridVal[length][length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = GridVal.Empty;
            }
        }
        this.grid = grid;
    }

    public Grid(@NotNull GridVal[][] grid) {
        this.grid = grid;
    }

    public void modify(int row, int col, GridVal val) {
        grid[row][col] = val;
    }

    public @Nullable ArrayList<Direction> navigate(Point start, Point stop) {
    }

    // assumes grid[row][col] is empty
    private @NotNull Stack<Direction> possible_directions(int row, int col) {
        Stack<Direction> stack = new Stack<>();
        if (row >= 1) {
            if (grid[row - 1][col] == GridVal.Empty) {
                stack.push(Direction.Up);
            }
        }
        if (row <= grid.length - 1) {
            if (grid[row + 1][col] == GridVal.Empty) {
                stack.push(Direction.Down);
            }
        }
        if (col >= 1) {
            if (grid[row][col - 1] == GridVal.Empty) {
                stack.push(Direction.Left);
            }
        }
        if (col <= grid.length - 1) {
            if (grid[row][col + 1] == GridVal.Empty) {
                stack.push(Direction.Right);
            }
        }
        return stack;
    }



    public @Nullable ArrayList<Direction> navigate() {
        Point startPos = find(GridVal.Start);
        Point stopPos = find(GridVal.Start);
        if (stopPos == null || startPos == null) {
            System.out.println("invalid grid!");
            return null;
        }
        return navigate(startPos, stopPos);
    }

    public @Nullable Point find(GridVal val) {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                if (this.grid[i][j].equals(val)) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(grid);
    }
}
