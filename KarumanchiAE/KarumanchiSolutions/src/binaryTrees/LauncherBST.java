package binaryTrees;

import binaryTrees.BinarySearchTree.Node;

public class LauncherBST {
    
    public static void main(String[] args){
        BinarySearchTree bst=new BinarySearchTree();
        bst.createTree();
        bst.levelOrderTraversal(bst.root);
        
        Node findEl = findElement(bst.root, -33102);
        if(findEl!=null){
        System.out.println("\nThe element is: "+findEl.data);}
        else{
            System.out.println("\nThe element is not found!");
        }
       
        int min=findMinRec(bst.root);
        System.out.println("\nThe min is: "+min);
        
    }
    
    public static Node findElement(Node root, int el){
        if(root == null) return null;
        
        if(root.data == el) return root;
        
        if(root.data < el){
           // Node rightSubTree = findElement(root.right, el);
            return findElement(root.right, el);
        }
        else if(root.data > el){
            //Node leftSubTree = findElement(root.left, el);
            return findElement(root.left, el);
        }
       
        return root;
    }
    
    public static int findMinimumElement(Node root){
        if(root==null) return Integer.MAX_VALUE;
        
        Node traverse = root;
        while(traverse.left !=null){
            traverse = traverse.left;
        }
        return traverse.data;
                
        }
    //recursive approach to finding the minimum element
    public static int findMinRec(Node root){
        if(root == null) return Integer.MAX_VALUE;
        
        if(root.left == null) return root.data;
        else return findMinRec(root.left);
    }
}
