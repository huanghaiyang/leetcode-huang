package rottingOrange;

import java.util.*;

/**
 * created by huang 6/1/19
 */
public class Solution {

    public static void main(String[] args) {
        //new Solution().orangesRotting(new int[][]{{1,2}});
        //new Solution().orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
        //new Solution().orangesRotting(new int[][]{{1},{1},{1},{1}});
        new Solution().orangesRotting(new int[][]{{2},{2},{1},{0},{1},{1}});
    }

    class Position{
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Position> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        Boolean foundLonely = false;
        int notEmptyCount = 0;
        for(int i = 0 ; i < grid.length ; i ++) {
            for(int j = 0 ; j < grid[0].length ; j ++) {
                if(grid[i][j] == 2) {
                    queue.add(new Position(i , j));
                    set.add(i + "_" + j);
                    notEmptyCount ++;
                }else if(grid[i][j] == 1) {
                    notEmptyCount ++;
                    foundLonely = check(grid, i , j);
                    if(foundLonely) {
                        break;
                    }
                }
            }
            if(foundLonely) {
                break;
            }
        }
        if(foundLonely) {
            return -1;
        }
        if(notEmptyCount == queue.size()) {
            return 0;
        }
        if(queue.size() == 0) {
            return -1;
        }
        int count = 0;
        if(!foundLonely) {
            int queueSize = queue.size();
            int queueCounter = 0;
            count ++;
            while (queue.size() > 0) {
                if(set.size() == notEmptyCount) {
                    break;
                }
                Position position = queue.poll();
                queueCounter ++;
                int x = position.x;
                int y = position.y;
                if(x != 0) {
                    String tag = (x - 1) + "_" + y;
                    if(!set.contains(tag)) {
                        if(grid[x - 1][y] == 1) {
                            queue.add(new Position(x - 1, y));
                            set.add(tag);
                        }
                    }
                }
                if(x != grid.length - 1) {
                    String tag = (x + 1) + "_" + y;
                    if(!set.contains(tag)) {
                        if(grid[x + 1][y] == 1) {
                            queue.add(new Position(x + 1, y));
                            set.add(tag);
                        }
                    }
                }
                if(y != 0) {
                    String tag = x + "_" + (y - 1);
                    if(!set.contains(tag)) {
                        if(grid[x][y - 1] == 1) {
                            queue.add(new Position(x, y -1));
                            set.add(tag);
                        }
                    }
                }
                if(y != grid[0].length - 1) {
                    String tag = x + "_" + (y + 1);
                    if(!set.contains(tag)) {
                        if(grid[x][y + 1] == 1) {
                            queue.add(new Position(x, y + 1));
                            set.add(tag);
                        }
                    }
                }
                if(queueCounter == queueSize) {
                    if(set.size() < notEmptyCount) {
                        count ++;
                    }
                    queueCounter= 0;
                    queueSize = queue.size();
                }
            }
        }
        if(queue.size() == 0 && set.size() < notEmptyCount) {
            return -1;
        }
        return count;
    }

    // 检测孤岛
    public Boolean check(int[][] grid, int i, int j) {
        Boolean foundLonely = false;
        Boolean topEmpty = false;
        Boolean bottomEmpty = false;
        Boolean leftEmpty = false;
        Boolean rightEmpty = false;
        if(i == grid.length - 1 && j == 0) {
            System.out.println();
        }
        if(i != 0) {
            if(grid[i - 1][j] == 0) {
                topEmpty = true;
            }
        }else {
            topEmpty = true;
        }
        if(i != grid.length - 1) {
            if(grid[i + 1][j] == 0) {
                bottomEmpty = true;
            }
        }else {
            bottomEmpty = true;
        }
        if(j != 0) {
            if(grid[i][j - 1] == 0) {
                leftEmpty = true;
            }
        }else {
            leftEmpty = true;
        }
        if(j != grid[0].length - 1) {
            if(grid[i][j + 1] == 0) {
                rightEmpty = true;
            }
        }else {
            rightEmpty = true;
        }
        foundLonely = topEmpty && bottomEmpty && leftEmpty && rightEmpty;
        return foundLonely;
    }

}
