package bombEnemy;

/**
 * created by huang 5/23/19
 */
public class Solution {

    public int maxKilledEnemies(char[][] grid) {
        int count = 0;
        for(int i = 0 ; i < grid.length ; i ++) {
            for(int j = 0 ; j < grid[i].length ; j ++) {
                char c = grid[i][j];
                if(c == '0') {
                    count = Math.max(count, count(grid, i , j));
                }
            }
        }
        return count;
    }

    public int count(char[][] grid, int i, int j) {
        return countLeft(grid, i , j) + countTop(grid, i , j) + countBottom(grid , i , j) + countRight(grid , i , j);
    }

    public int countLeft(char[][] grid, int i , int j) {
        if(j < 0) return 0;
        if(grid[i][j] == 'W') return 0;
        if(grid[i][j] == '0') return 0 + countLeft(grid, i, j - 1);
        if(grid[i][j] == 'E') return 1 + countLeft(grid, i, j - 1);
        else return 0;
    }

    public int countTop(char[][] grid, int i , int j) {
        if(i < 0) return 0;
        if(grid[i][j] == 'W') return 0;
        if(grid[i][j] == '0') return 0 + countTop(grid, i - 1, j);
        if(grid[i][j] == 'E') return 1 + countTop(grid, i - 1, j);
        else return 0;
    }

    public int countBottom(char[][] grid, int i , int j) {
        if(i > grid.length - 1) return 0;
        if(grid[i][j] == 'W') return 0;
        if(grid[i][j] == '0') return 0 + countBottom(grid, i + 1, j);
        if(grid[i][j] == 'E') return 1 + countBottom(grid, i + 1, j);
        else return 0;
    }

    public int countRight(char[][] grid, int i , int j) {
        if(j > grid[0].length - 1) return 0;
        if(grid[i][j] == 'W') return 0;
        if(grid[i][j] == '0') return 0 + countRight(grid, i, j + 1);
        if(grid[i][j] == 'E') return 1 + countRight(grid, i, j + 1);
        else return 0;
    }

}
