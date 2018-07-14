package binaryTrees;

import binaryTrees.BinarySearchTree.Node;

public class LauncherBST {
    
    public static void main(String[] args){
        BinarySearchTree bst=new BinarySearchTree();
        bst.createTree();
        bst.levelOrderTraversal(bst.root);
        
        Node findEl = findElement(bst.root, 62);
        if(findEl!=null){
        System.out.println("\nThe element is: "+findEl.data);}
        else{
            System.out.println("\nThe element is not found!");
        }
        
    }
    
    public static Node findElement(Node root, int el){
        if(root == null) return root;
        
        if(root.data == el) return root;
        Node leftSubTree = findElement(root.left, el);
        Node rightSubTree = findElement(root.right, el);
        
        if(leftSubTree != null) return leftSubTree;
        if(rightSubTree != null) return rightSubTree;
        return null;
    }
}
