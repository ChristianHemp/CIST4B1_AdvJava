public class BSTNode {
    int data;
    int height;
    BSTNode right;
    BSTNode left;

    public BSTNode(int data) {
        this.data = data;
        this.height = 0;
        this.right = null;
        this.left = null;
    }
}
