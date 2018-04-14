package binaryTrees;

import binaryTrees.Tree;
import binaryTrees.Tree.Node;
public class Launcher {
	
	public static void main(String[] args){
		Tree tree=new Tree();
		tree.root=tree.new Node(5);
		tree.root.left=tree.new Node(4);
		tree.root.right=tree.new Node(3);
		
		System.out.println("In Order Traversal: ");
		tree.inOrderTraversal(tree.root);
		System.out.println("\nPre Order Traversal: ");
		tree.preOrderTraversal(tree.root);
		System.out.println("\nPost Order Traversal: ");
		tree.postOrderTraversal(tree.root);
		
		System.out.println("\nLevel Order Traversal: ");
		tree.levelOrderTraversal(tree.root);
		
		Node tree3=tree.findNode(tree.root, 3);
		
		System.out.println("\n In the above linked list if "
				+ "element 3 is found return the node or null: ");
		System.out.println("\n The result is: "+tree3);
		
		tree.insertElementTree(tree.root,89);
	}
}
