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
			queueNode.add(root.left);}
			if(n.right!=null){
			queueNode.add(root.right);}			
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
}
