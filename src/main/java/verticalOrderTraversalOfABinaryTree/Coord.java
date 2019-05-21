package verticalOrderTraversalOfABinaryTree;

/**
 * created by huang 5/21/19
 */
public class Coord extends TreeNode {

    int x;
    int y;

    public Coord(int x) {
        super(x);
    }
    public Coord(int x, int x1, int y, TreeNode left, TreeNode right) {
        super(x);
        this.x = x1;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}
