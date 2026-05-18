public class MyBinarySearchTree {
    public BSTNode root;

    public MyBinarySearchTree() {
        this.root = null;
    }

    public BSTNode addRecursive(int value, BSTNode current) {
        if(current == null) {
            return new BSTNode(value);
        }

        if(value <= current.data) {
            current.left = addRecursive(value, current.left);
        } else {
            current.right = addRecursive(value, current.right);
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(value, root);
    }

    // returns node that contains data value
    public BSTNode search(int target) {
        BSTNode curr = root;

        while(curr != null) {
            if(curr.data == target) {
                return curr;
            } else if(target < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        System.out.println("Value not in BinarySearchTree");
        return null;
    }

    // returns true if value exists in tree
    public boolean inTree(int target) {
        BSTNode curr = root;

        while(curr != null) {
            if(curr.data == target) {
                return true;
            } else if(target < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        System.out.println("Value not in BinarySearchTree");
        return false;
    }

    public boolean inTreeRecursive(int target) {
        BSTNode node = searchRecursive(target, root);
        if(node != null) {
            return true;
        }
        return false;
    }

    private BSTNode searchRecursive(int target, BSTNode curr) {
        if(curr == null) {
            return null;
        }

        if(target == curr.data) {
            return curr;
        } else if (target < curr.data) {
            return searchRecursive(target, curr.left);
        } else {
            return searchRecursive(target, curr.right);
        }
    }

    public void remove(int value) {
        // call helper
        root = removeRecursive(value, root);
    }

    private BSTNode removeRecursive(int value, BSTNode curr) {
        if(curr == null) {
            return null;
        }

        if(value == curr.data) {
            // case 1 no children
            if(curr.left == null && curr.right == null) {
                return null;
            }

            // case 2 1 child
            if(curr.left == null) {
                return curr.right;
            }
            if(curr.right == null) {
                return curr.left;
            }

            // case 3 2 children
            BSTNode successor = findSmallest(curr.right);
            curr.data = successor.data;
            curr.right = removeRecursive(successor.data, curr.right);
            /*
            Using findMinValue helper
            int inorderSuccessor = findMinValue(curr.right);
            curr.data = inorderSuccessor;
            curr.right = removeRecursive(inorderSuccessor, curr.right);
             */

        } else if (value < curr.data) {
            curr.left = searchRecursive(value, curr.left);
        } else {
            curr.right = searchRecursive(value, curr.right);
        }
        return curr;
    }

    // helper for case 3 removeRecursive
    private BSTNode findSmallest(BSTNode curr) {
        while(curr.left != null) {
                curr = curr.left;
            }
        return curr;
    }

    private int findMinValue(BSTNode subtreeRoot) {
        while(subtreeRoot.left != null) {
            subtreeRoot = subtreeRoot.left;
        }
        return subtreeRoot.data;
    }

    // ruins order if you are copying as it would just create a LL
    public void inorder(BSTNode curr) {
        if(curr != null) {
            inorder(curr.left);
            System.out.println(curr.data);
            inorder(curr.right);
        }
    }

    // allows for copy as it visits in the order that they are added
    public void preorder(BSTNode curr) {
        if(curr != null) {
            System.out.println(curr.data);
            preorder(curr.left);
            preorder(curr.right);
        }
    }

    // not useful in java due to garbage collector
    public void postorder(BSTNode curr) {
        if(curr != null) {
            postorder(curr.left);
            postorder(curr.right);
            System.out.println(curr.data);
        }
    }

    private int height(BSTNode current) {
        if(current == null) {
            return -1;
        } else if(current.right == null && current.left == null) {
            return 0;
        }
        return Math.max(height(current.left), height(current.right)) + 1;
    }

    private BSTNode rightRotate(BSTNode oldRoot) {
        BSTNode newRoot = oldRoot.left;
        oldRoot.left = newRoot.right;
        newRoot.right = oldRoot;

        height(oldRoot);
        height(newRoot);
        return newRoot;
    }

    private BSTNode leftRotate(BSTNode oldRoot) {
        BSTNode newRoot = oldRoot.right;
        oldRoot.right = newRoot.left;
        newRoot.left = oldRoot;

        oldRoot.height = height(oldRoot);
        newRoot.height = height(newRoot);
        return newRoot;
    }

    private BSTNode leftRightRotate(BSTNode oldRoot) {
        oldRoot.left = leftRotate(oldRoot.left);
        return rightRotate(oldRoot);
    }

    private BSTNode rightLeftRotate(BSTNode oldRoot) {
        oldRoot.right = rightRotate(oldRoot.right);
        return leftRotate(oldRoot);
    }

    // INSERTION, DELETION, REBALANCING, WHEN TO ROTATE, HEIGHT RECALC
    // EQUAL HEIGHTS ALWAYS DO SINGLE ROTATE SINCE MORE TIME EFFICIENT

    // Bags have counter class, where key is element and value is # of duplicates in bag
}
