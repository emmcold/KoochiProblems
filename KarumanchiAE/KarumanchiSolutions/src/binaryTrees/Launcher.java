package binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import binaryTrees.Tree;
import binaryTrees.Tree.Node;

public class Launcher {

    public static void main(String[] args){
        Tree tree=new Tree();
        tree.createTree();
        tree.levelOrderTraversal(tree.root);
        /*Tree tree=new Tree();
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

		tree.insertElementTree(tree.root,89);*/
        int max=question1(tree.root);
        System.out.println("\nThe maximum element in the above tree is: "+max);
        question9(tree.root);
        System.out.println("The minimum depth of the tree: "+question13(tree.root));
    }
    /**
     * Give an algorithm for finding maximum element in binary tree.
     */
    public static int findMax(int a, int b, int c){
        int max=a;
        if(b>a){
            max=b;
        }
        if(c>a){
            max=c;
        }
        return max;
    }

    public static int question1(Node root){
        if(root==null) return Integer.MIN_VALUE;
        return Integer.max(root.data, Integer.max(question1(root.left),question1(root.right)));
        //return findMax(root.data, question1(root.left), question1(root.right));


    }
    /**
     * Problem-2  Give an algorithm for finding maximum element in binary 
     * tree without recursion.
     */
    public static int question2(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        Queue<Node> queueData=new LinkedList<Node>();
        int max=root.data;
        queueData.add(root);
        while(!queueData.isEmpty()){
            Node n=queueData.poll();
            if(n.data>max){
                max=n.data;
            }
            if(n.left!=null){
                queueData.add(n.left);
            }
            if(n.right!=null){
                queueData.add(n.right);
            }
        }
        return max;
    }
    /**
     * Problem-3  Give an algorithm for searching an element in binary tree.
     */
    public static Node question3(Node root, int x){
        if(root==null) return null;
        if(root.data==x) return root;
        if(question3(root.left,x)!=null) return root.left;
        if(question3(root.right,x)!=null) return root.right;
        return null;
    }
    /**
     * Problem-4  Give an algorithm for searching an element in binary tree without recursion.
     */
    public static Node question4(Node root, int x){
        if(root==null) return null;
        Queue<Node> queueStoreData=new LinkedList<Node>();
        queueStoreData.add(root);
        while(!queueStoreData.isEmpty()){
            Node n=queueStoreData.poll();
            if(n.data==x){ 
                return n;
            }
            if(n.left!=null){
                queueStoreData.add(n.left);
            }
            if(n.right!=null){
                queueStoreData.add(n.right);
            }
        }
        return null;
    }
    /**
     * Problem-5  Give an algorithm for inserting an element into binary tree. 
     */
    public static void question5(Tree t,Node root, int element){
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
        Node newN=t.new Node(element);
        n.right=newN;
    }
    /**
     * Problem-6  Give an algorithm for finding the size of binary tree.
     */
    public static int question6(Node root){
        if (root==null) return 0;
        return question6(root.left)+question6(root.right)+1;
    }
    /**
     * Problem-7 Can we solve Problem-6 without recursion?
     */
    public static int question7(Node root){
        if(root==null) return 0;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        int size=0;
        while(!q.isEmpty()){
            Node n=q.poll();
            size++;
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
        return size;
    }
    /**
     * Problem-8  Give an algorithm for deleting the tree.
     */
    public static void question8(Node root){
        root=null;
    }
    
    /**
     * Problem-9  Give an algorithm for printing the level order data in reverse order. 
     * For example, the output for the below tree should be: 4 5 6 7 2 3 1
     */
    public static void question9(Node root){
        if (root==null) return;
        Queue<Node> q=new LinkedList<Node>();
        Stack<Node> s=new Stack<Node>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node n=q.poll();
            s.add(n);
            if(n.right!=null){
                q.add(n.right);
            }
            if(n.left!=null){
                q.add(n.left);
            }
        }
        while(!s.isEmpty()){
            System.out.println("\n"+s.pop().data+" ");
        }
    }
    /**
     * Problem-10   Give an algorithm for finding the height (or depth) of the binary tree.
     */
    public static int question10(Node root){
        if(root==null){
            return 0;
        }
        return Integer.max(question10(root.left), question10(root.right))+1;
    }
    /**
     * Problem-11   Can we solve Problem-10 with stack?
     */
    /*public static int question11(Node root){
        
    }*/
    /**
     * Can we solve Problem-10 without recursion?
     */
    
    public static int question12(Node root){
        if(root==null) return 0;
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        int depth=0;
        //Node no=null;
        while(!q.isEmpty()){
            Node n=q.poll();
            if(n==null){
                depth++;
                if(!q.isEmpty()){
                    q.add(null);
                    }
                else{ 
                    break;
                }
            }
            if(n.left!=null){
                q.add(n.left);
            }
            if(n.right!=null){
                q.add(n.right);
            }
        }
        return depth;
    }
    /**
     * Problem-13  Give an algorithm for finding the minimum depth of the binary tree.
     */
    public static int question13(Node root){
        if(root==null) return 0;
        return Integer.min(question13(root.left), question13(root.right))+1;
    }
    
    /**
     * Problem-14  Give an algorithm for finding the deepest node of the binary tree.
     */
    //the node accesses the last from the breadth first search in the binary tree
    public static Node question14(Node root){
       if(root==null) return null;
       
       Queue<Node> q=new LinkedList<Node>();
       q.add(root);
       Node n=null;
       while(!q.isEmpty()){
              n=q.poll();
              if(n.left!=null){
                  q.add(n.left);
              }
              if(n.right!=null){
                  q.add(n.right);
              }
       }
       return n;
    }
    /**
     * Problem-15  Give an algorithm for deleting an element (assuming data is given) 
     * from binary tree.
     */
    public static void question15(Node root, int deleteElement){
        if(root==null) return;
       /* Starting at root, find the node which we want to delete.
        • Find the deepest node in the tree.
        • Replace the deepest node’s data with node to be deleted.
        • Then delete the deepest node.*/
        //find the node you want to delete
        binaryTrees.Tree node=new Tree();
        Node nodeToDelete=node.findNode(root, deleteElement);
        //find the deepest node in the tree
        Node deepestNode=question14(root);
        //Replace the deepest node's data with node to be deleted.
        nodeToDelete.data=deepestNode.data;
        //delete the deepest node     
    }
    /***
     * Problem-16  Give an algorithm for finding the number of leaves in the binary tree 
     * without using recursion.
     */
    public static int question16(Node root){
        if (root==null) return 0;
        Queue<Node> q=new LinkedList<Node>();
        int count=0;
        q.add(root);
        while(!q.isEmpty()){
           Node n=q.poll();
           if(n.left!=null){
               q.add(n.left);
           }
           if(n.right!=null){
               q.add(n.right);
           }
           if(n.left==null && n.right==null){
               count++;
           }
           
        }
        return count;
    }
    /**
     * Problem-17  Give an algorithm for finding the number of full nodes in the 
     * binary tree without using recursion.
     */
    public static int question17(Node root){
        return 0;
    }
    public static int question18(){
        return 9;
    }
    public static void question19(){
        return;
    }
}