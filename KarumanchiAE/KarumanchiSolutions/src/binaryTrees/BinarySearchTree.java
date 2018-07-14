package binaryTrees;

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
}
