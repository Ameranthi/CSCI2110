/*
BinaryTreeDemo
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * This class tests the code for Lab 8: Exercise0. It creates a BinaryTree and
 * tests the methods of the  BinaryTree class.
 * It expands upon a framework provided by Srini (Dr. Srini Sampalli). Modified from previous version for 2020.
 */

public class Exercise1 {
    public static void main(String[] args) {
        //The most straightforward approach is to create single node binary tree from each String captured,
        // storing them in an ArrayList or Queue of type BinaryTree. You can then quickly build a larger binary tree
		// by assigning the first tree in your ArrayList to be the root node and attaching
		// subsequent elements to that root.
		// You may follow the steps below. Do an example with pen and paper first to see how the tree is built:


        String value;
        Scanner in = new Scanner(System.in);

		// 1. Create a AL called trees which will store binary trees of type String.
        ArrayList<BinaryTree<String>> trees = new ArrayList<BinaryTree<String>>();

        //accept input from a user (an arbitrary number of Strings) and build a binary tree with String data from that input.
        while (in.hasNext()) {

            //2. Read in the user input,
            value = in.next();
            //check if it's "done"
			if(value.equals("done")){
				break;
			}
            //store it in a binary tree
			BinaryTree<String> binaryTree = new BinaryTree<String>();
			binaryTree.makeRoot(value);

			//and store the tree in the ArrayList trees.
			trees.add(binaryTree);
			//System.out.print("added" + binaryTree);
        }
        //Create a arraylist called agenda to store binary trees of type String
		ArrayList<BinaryTree<String>> agenda = new ArrayList<BinaryTree<String>>();

        //Create a binary tree reference called trueroot.
		BinaryTree trueRoot;

        //a. Remove the first element from trees and store it in trueroot
		trueRoot = trees.remove(0);

        //b. Add trueroot to agenda
		agenda.add(trueRoot);

		//5. While trees is not empty...
		while(!(trees.isEmpty())){
			BinaryTree agendaElement;
			BinaryTree treesElement;

			//a. Remove the element at the front of agenda
			agendaElement = agenda.remove(0);

			//b. Remove the element at the front of trees
			treesElement = trees.remove(0);

			//c. Attach the element from trees to the left of the element from agenda
			agendaElement.attachLeft(treesElement);

			//d. Add the same element from trees that you just attached to agenda
			agenda.add(treesElement);

			//e. If trees is still not empty
			if(!(trees.isEmpty())){

                //i. Remove the first element from trees
                treesElement = trees.remove(0);

                //ii. Attach it to the right of the element from Agenda
                agendaElement.attachRight(treesElement);

                //iii. Add the same element from trees that you just attached to agenda
                agenda.add(treesElement);
			}
		}

        System.out.printf("Height of the tree is: %d\n",
                BinaryTree.height(trueRoot));

        System.out.printf("Number of nodes in the tree is: %d\n",
                BinaryTree.nodes(trueRoot));

        System.out.println();

        System.out.print("Inorder:\t");
        BinaryTree.inorder(trueRoot);
        System.out.println();

        System.out.print("Preorder:\t");
        BinaryTree.preorder(trueRoot);
        System.out.println();

        System.out.print("Postorder:\t");
        BinaryTree.postorder(trueRoot);
        System.out.println();


        System.out.print("Level order:\t");
        BinaryTree.levelorder(trueRoot);
        System.out.println();
        System.out.println();

        System.out.printf("The tree is height balanced... %s\n", BinaryTree.isBalanced(trueRoot) ? "Yes!" : "No.");

        System.out.println();


    }

}
