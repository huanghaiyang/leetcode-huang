package candyCrush;

import java.util.*;

/**
 * created by huang 5/26/19
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().candyCrush(new int[][]{{
                110,5,112,113,114
        },{
                210,211,5,213,214
        },{
                310,311,3,313,314
        },{
                410,411,412,5,414
        },{
                5,1,512,3,3
        },{
                610,4,1,613,614
        },{
                710,1,2,713,714
        },{
                810,1,2,1,1
        },{
                1,1,2,2,2
        },{
                4,1,4,4,1014
        }});

//        new Solution().candyCrush(new int[][]{{
//            2,1,3
//        }, {
//            2,2,2
//        }, {
//            2,2,2
//        }});
    }

    class Position{
        int val;
        int rowIndex;
        int colIndex;

        public Position(int val, int rowIndex, int colIndex) {
            this.val = val;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

    }

    public int[][] candyCrush(int[][] board) {
        handle(board);
        return board;
    }

    public String addBlank(int n) {
        String s = "" + n;
        switch(s.length()) {
            case 4:
                return "";
            case 3:
                return " ";
            case 2:
                return "  ";
            case 1:
                return "   ";
            default:
                return "";
        }
    }

    public void print(int[][] board) {
        for(int i = 0 ; i < board.length ; i ++) {
            for(int j = 0 ; j < board[0].length; j ++) {
                int n = board[i][j];
                System.out.print(n + addBlank(n));
                System.out.print(",");
                if(j == board[0].length - 1) {
                    System.out.println();
                }
            }
        }
        System.out.println("-----------------");
    }

    public void handle(int[][] board) {
        List<Position> positionList = new ArrayList<>();
        for(int i = board.length - 1 ; i >= 0 ; i --) {
            for(int j = 0 ; j < board[0].length ; j ++) {
                if(board[i][j] != 0) {
                    find(board, i , j, positionList);
                }
            }
        }
        positionList.sort(new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if(o1.rowIndex != o2.rowIndex) {
                    return o1.rowIndex - o2.rowIndex;
                }else{
                    return o1.colIndex - o2.colIndex;
                }
            }
        });
        for(int i = 0 ; i < positionList.size() ; i ++) {
            findDown(board, positionList.get(i));
        }
        if(positionList.size() != 0) {
            handle(board);
        }else {
            System.out.print("done.");
        }
    }

    public Boolean isExist(int rowIndex , int colIndex, List<Position> positionList) {
        Boolean inRange = false;
        if(!positionList.isEmpty()) {
            for(int i = 0 ; i < positionList.size() ; i ++) {
                Position position = positionList.get(i);
                int pRowIndex = position.rowIndex;
                int pColIndex = position.colIndex;
                inRange = rowIndex == pRowIndex && colIndex == pColIndex;
                if(inRange) {
                    break;
                }
            }
        }
        return inRange;
    }

    public void find(int[][] board, int rowIndex , int colIndex, List<Position> positionList) {
        int val = board[rowIndex][colIndex];
        int topRowIndex = rowIndex;
        int bottomRowIndex = rowIndex;
        while(topRowIndex > 0) {
            if(board[topRowIndex - 1][colIndex] == val) {
                topRowIndex --;
            }else {
                break;
            }
        }
        while(bottomRowIndex < board.length - 1) {
            if(board[bottomRowIndex + 1][colIndex] == val) {
                bottomRowIndex ++;
            }else {
                break;
            }
        }
        int leftColIndex = colIndex;
        int rightColIndex = colIndex;
        while(leftColIndex > 0) {
            if(board[rowIndex][leftColIndex - 1] == val) {
                leftColIndex --;
            }else {
                break;
            }
        }
        while(rightColIndex < board[0].length - 1) {
            if(board[rowIndex][rightColIndex + 1] == val) {
                rightColIndex ++;
            }else {
                break;
            }
        }
        if(bottomRowIndex - topRowIndex >= 2) {
            for(int i = bottomRowIndex ; i >= topRowIndex ; i --) {
                Boolean isExist = isExist(i , colIndex , positionList);
                if(!isExist) {
                    positionList.add(new Position(board[i][colIndex], i , colIndex));
                }
            }
        }
        if(rightColIndex - leftColIndex >= 2) {
            for(int i = leftColIndex ; i <= rightColIndex ; i ++) {
                Boolean isExist = isExist(rowIndex , i , positionList);
                if(!isExist) {
                    positionList.add(new Position(board[rowIndex][i], rowIndex, i));
                }
            }
        }
    }

    public void findDown(int[][] board, Position position) {
        int rowIndex = position.rowIndex;
        int colIndex = position.colIndex;
        down(board, rowIndex, colIndex, 1);
    }

    public void down(int[][] board, int rowIndex , int colIndex , int count) {
        int topIndex = rowIndex - count;
        int size = topIndex + 1;
        for(int i = 0 ; i < size ; i ++) {
            board[rowIndex - i][colIndex] = board[topIndex - i][colIndex];
        }
        for(int i = rowIndex - size; i >= 0; i --) {
            board[i][colIndex] = 0;
        }
        print(board);
    }

}
