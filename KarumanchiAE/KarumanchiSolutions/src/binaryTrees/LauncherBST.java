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
        
        int max = findMaxElement(bst.root).data;
        System.out.println("\nThe max is: "+max);
        insertElement(bst.root, 2);
        bst.levelOrderTraversal(bst.root);
        int distance=distanceFromRoot(bst.root,47);
        System.out.println("\nThe distance is: "+distance);
        
        
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
    
    public static Node findMaxElementRec(Node root){
        if(root == null) return null;
        if(root.right == null) return root;
        else return findMaxElementRec(root.right);
    }
    
    public static Node findMaxElement(Node root){
        if (root == null) return null;
        Node traverse = root;
        while(traverse.right!=null){
            traverse = traverse.right;
        }
        return traverse;
    }
    public static Node insertElement(Node root, int el){
        
        if (root == null) {
            root = new Node(el);
            return root;
        }
 
        
        if (el < root.data)
            root.left = insertElement(root.left, el);
        else if (el > root.data)
            root.right = insertElement(root.right, el);
 
        
        return root;
    }
    //TODO delete operation
    /**
     * Problem 52 Give an algo for finding the shortest path between two nodes
     * in BST
     */
    public static int question52(Node root, Node n1, Node n2, int size){
        if(root == null) return 0;
        if(n1.data>root.data && n2.data>root.data){
            return question52(root.left, n1, n2, size);
        }
        if(n1.data < root.data && n2.data < root.data){
            return question52(root.left, n1, n2,size);
        }
        
        if(root.data >= n1.data && root.data <= n2.data) 
            return distanceFromRoot(root, n1.data) + distanceFromRoot(root, n2.data);
        return 0;
    }

    private static int distanceFromRoot(Node root, int n1) {
        if(root == null) return 0;
        int leftDistance=0;
        int rightDistance=0;
        if(root.data>n1){
            leftDistance = distanceFromRoot(root.left, n1)+1;
        }
        else if(root.data < n1){
            rightDistance = distanceFromRoot(root.right, n1)+1;
        }
        
        return leftDistance + rightDistance;
    }
    /**
     * Problem 53- TODO with Dynamic Programming
     */
    
    /**
     * Problem 54 Find Least common ancestor (LCA)
     */
    public static Node question54(Node root, Node n1, Node n2){
        if(root==null) return null;
        if(root == n1 || root ==n2) return root;
        if(root.data<n1.data && root.data<n2.data){
            return question54(root.right, n1, n2);
        }
        if(root.data>n1.data && root.data>n2.data){
            return question54(root.left, n1, n2);
        }
        return root;
    }
    /**
     * Problem 55 Give an algo to check if a given binary tree is
     * a binary search tree
     */
    
}
