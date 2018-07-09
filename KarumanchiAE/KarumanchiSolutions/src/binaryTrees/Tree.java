package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	
	public class Node{
		int data;
		Node left;
		Node right;
		public Node(int d){
			data=d;
			left=null;
			right=null;
		}
	}
	Node root=null;
	/**
	 * InOrder Traversal of the tree
	 */
	public void inOrderTraversal(Node root){
		if(root==null) return;
		
		inOrderTraversal(root.left);
		System.out.print(root.data+"->");
		inOrderTraversal(root.right);
	}
	
	/**
	 * PostOrder Traversal of the tree
	 * @param args
	 */
	public void postOrderTraversal(Node root){
		if(root==null) return;
		
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+"->");
	}
	
	/** 
	 * PreOrder Traversal of the tree
	 * @param args
	 */
	public void preOrderTraversal(Node root){
		if(root==null) return;
		
		System.out.print(root.data+"->");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	/**
	 * Lever order Traversal of the tree
	 * @param args
	 */
	public void levelOrderTraversal(Node root){
		if(root==null) return;
		
		Queue<Node> queueNode=new LinkedList<Node>();
		queueNode.add(root);
		
		while(!queueNode.isEmpty()){
			Node n=queueNode.poll();
			System.out.print(n.data+"->");
			
			if(n.left!=null){
			queueNode.add(n.left);}
			if(n.right!=null){
			queueNode.add(n.right);}			
		}
		
	}
	
	/** 
	 * Insert an element in a tree.
	 * The element is inserted in the right most branch of the binary tree.
	 */
	 public void insertElementTree(Node root, int element){
		 if(root==null) return;
			
			Queue<Node> queueNode=new LinkedList<Node>();
			queueNode.add(root);
			Node n=null;
			while(!queueNode.isEmpty()){
				n=queueNode.poll();
				//System.out.print(n.data+"->");
				
				if(n.left!=null){
				queueNode.add(root.left);}
				if(n.right!=null){
				queueNode.add(root.right);}			
			}
			Node newN=new Node(element);
			n.right=newN;
			//print the tree with the new inserted node
			preOrderTraversal(root); 
	 }
	
	/**
	 * Find an element in  a tree.
	 */
	
	public Node findNode(Node root, int element){
		if (root==null){ return null;}
		
		if(root.data==element){return root;}
	
		if(findNode(root.left,element)!=null){return root.left;}
		if(findNode(root.right,element)!=null){return root.right;}
		return null;
	}
	
	/**
	 * Create a sample tree to use for testing.
	 */
	public void createTree(){
	    root=new Node(62);
	    root.left=new Node(4);
	    root.right=new Node(49);
	    root.left.left=new Node(69);
	    root.left.right=new Node(-109);
	    root.left.left.left=new Node(-102);
	    root.left.left.right=new Node(-40);
	    root.right.left=new Node(22);
	    root.right.left.right = new Node(-38);
	    root.right.right=new Node(0);
	    root.right.right.left=new Node(629);
	    root.right.right.left.left=new Node(44);
	    root.right.right.left.right=new Node(100);
	}
}
