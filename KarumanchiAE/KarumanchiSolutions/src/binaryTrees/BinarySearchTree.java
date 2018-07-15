package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.Tree.Node;

public class BinarySearchTree {
    Node root;
    
    static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int d){
            data = d;
            left = null;
            right = null;
        }
    }
    /**
     * Create a sample tree to use for testing.
     */
    public void createTree(){
        root=new Node(62);
        root.left=new Node(50);
        root.right=new Node(69);
        root.left.left=new Node(43);
        root.left.right=new Node(52);
        root.left.left.left=new Node(-102);
        root.left.left.right=new Node(47);
        root.right.left=new Node(67);
        root.right.left.right = new Node(68);
        root.right.right=new Node(78);
        root.right.right.left=new Node(72);
        root.right.right.left.left=new Node(62);
        root.right.right.left.right=new Node(75);
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
}
