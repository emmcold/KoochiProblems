package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import binaryTrees.Tree.Node;

public class BinarySearchTree {
    Node root;
    
    class Node{
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
