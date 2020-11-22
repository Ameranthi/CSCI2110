
/**
Expands upon a framework provided by Srini (Dr. Srini Sampalli). Used from previous version for 2020.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args){

	    //ToDo

    }



    // the isBinarySearchTree method returns true if the tree passed (and
    // all subtrees) meet the criteria to be considered BSTs
    // use this code to verify your tree is a BST
    public static<T extends Comparable<T>> boolean isBinarySearchTree(BinaryTree<T> t){
        // base case
        if(t==null||t.isEmpty())
            return true;
            // recursive case
        else{
            boolean bst = true;
            T val = t.getData();

            // test left subtree data to ensure they are all less than val
            if(t.getLeft()!=null){
                BinaryTree<T> lt = t.getLeft();
                Queue<BinaryTree<T>> q = new LinkedList<BinaryTree<T>>();
                q.add(lt);

                while(!q.isEmpty()){
                    BinaryTree<T> r = q.poll();
                    if(val.compareTo(r.getData())<0){
                        bst = false;
                        break;
                    }
                    if(r.getLeft()!=null)
                        q.add(r.getLeft());
                    if(r.getRight()!=null)
                        q.add(r.getRight());
                }
            }

            // test right subtree data to ensure they are all greater than val
            if(t.getRight()!=null&&bst){
                BinaryTree<T> rt = t.getRight();
                Queue<BinaryTree<T>> q = new LinkedList<BinaryTree<T>>();
                q.add(rt);

                while(!q.isEmpty()){
                    BinaryTree<T> r = q.poll();
                    if(val.compareTo(r.getData())>0){
                        bst = false;
                        break;
                    }
                    if(r.getLeft()!=null)
                        q.add(r.getLeft());
                    if(r.getRight()!=null)
                        q.add(r.getRight());
                }
            }
            return bst&&isBinarySearchTree(t.getLeft())&&
                    isBinarySearchTree(t.getRight());
        }
    }




}
