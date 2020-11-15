import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class provided by Srini
 *
 * @param <T>
 */
public class BinaryTree<T> {
    private static int count;
    private static int leftHeight;
    private static int rightHeight;
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;


    public BinaryTree() {
        parent = left = right = null;
        data = null;

        leftHeight = 0;
        rightHeight = 0;
    }

    public void makeRoot(T data) {
        if (!isEmpty()) {
            System.out.println("Can't make root. Already exists");
        } else
            this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryTree<T> tree) {
        left = tree;
    }

    public void setRight(BinaryTree<T> tree) {
        right = tree;
    }

    public void setParent(BinaryTree<T> tree) {
        parent = tree;
    }

    public T getData() {
        return data;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void attachLeft(BinaryTree<T> tree) {
        if (tree == null) return;
        else if (left != null) {
            System.out.println("Can't attach - left already populated with " + left.getData());
            return;
        } else if (tree.getParent() != null) {
            System.out.println("Can't attach Left- " + tree.getData() + " already has a parent " + tree.getParent().getData());
            return;
        } else {
            tree.setParent(this);
            this.setLeft(tree);
        }

    }

    public void attachRight(BinaryTree<T> tree) {
        if (tree == null) return;
        else if (right != null) {
            System.out.println("Can't attach - right already populated with " + right.getData());
            return;
        } else if (tree.getParent() != null) {
            System.out.println("Can't attach Right- " + tree.getData() + " already has a parent " + tree.getParent().getData());
            return;
        } else {
            tree.setParent(this);
            this.setRight(tree);
        }
    }

    public BinaryTree<T> detachLeft() {
        if (this.isEmpty()) return null;
        BinaryTree<T> retLeft = left;
        left = null;
        if (retLeft != null) retLeft.setParent(null);
        return retLeft;
    }

    public BinaryTree<T> detachRight() {
        if (this.isEmpty()) return null;
        BinaryTree<T> retRight = right;
        right = null;
        if (retRight != null) retRight.setParent(null);
        return retRight;
    }

    public boolean isEmpty() {
        if (data == null)
            return true;
        else
            return false;
    }

    public void clear() {
        left = right = parent = null;
        data = null;
    }

    public BinaryTree<T> root() {
        if (parent == null)
            return this;
        else {
            BinaryTree<T> next = parent;
            while (next.getParent() != null)
                next = next.getParent();
            return next;
        }
    }

    public static <T> int nodes(BinaryTree<T> t) { //give how manny nodes in tree
        if (t == null) {
            return 0;
        }
        int count = 0;
        count++;//count the this node
        count += nodes(t.getLeft());//count the nodes in the left subtree
        count += nodes(t.getRight());//count all the nodes in the right subtree

        return count;
    }

    public static <T> int height(BinaryTree<T> t) {
        if (t == null) {//is the tree is null, then the tree is 0
            return 0;
        } else {
            //get the height of left and right trees
            leftHeight = height(t.getLeft());//get the height of the left subtree
            rightHeight = height(t.getRight()); //get the height of the right subtree

            // if the left subtree is larger...
            if (leftHeight > rightHeight)
                return (leftHeight + 1);//use the left  one
            else
                return (rightHeight + 1); //use the right one
        }
    }

    public static <T> boolean isBalanced(BinaryTree<T> t) {

        //If tree is empty then return true if there is nothing in it then its balance: nothing n nothing
        if (t == null) {
            return true;
        }
        //else...
        // Get the height of left and right sub trees
        leftHeight = height(t.left); // for height of the left subtree
        rightHeight = height(t.right); // for height of the right subtree

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(t.left) && isBalanced(t.right)) {
            return true;
        }
        return false;// tree is not height-balanced

    }

    public static <T> void preorder(BinaryTree<T> t) {
        if (t != null) {
            System.out.print(t.getData() + "\t");
            preorder(t.getLeft());
            preorder(t.getRight());
        }
    }

    public static <T> void inorder(BinaryTree<T> t) {
        if (t != null) {
            inorder(t.getLeft());
            System.out.print(t.getData() + "\t");
            inorder(t.getRight());
        }
    }

    public static <T> void postorder(BinaryTree<T> t) {
        if (t != null) {
            postorder(t.getLeft());
            postorder(t.getRight());
            System.out.print(t.getData() + "\t");
        }
    }


    public static <T> void levelorder(BinaryTree<T> t) {
        // You can use an ArrayList of type BinaryTree as your agenda,

        ArrayList<BinaryTree<T>> levelOrder = new ArrayList<BinaryTree<T>>();
        levelOrder.add(t.root());//adding your root node before iterating.

        // Traverse the tree by removing the first element from the agenda, printing, and adding the children of the node
        // removed to the agenda. Repeat until your agenda is empty
        while (!levelOrder.isEmpty()) {

            BinaryTree<T> node = levelOrder.remove(0);
            if (node != null) {
                System.out.print(node.getData() + "\t");

                if (node.getLeft() != null)
                    levelOrder.add(node.getLeft());

                if (node.getRight() != null)
                    levelOrder.add(node.getRight());
            }
        }

        // implement a simple breadth first search.
    }
}
//				if(t.height(t.getRight()) > t.height(t.getLeft())){
////
////				}