package binaryTrees;

import java.util.ArrayList;
import java.util.HashMap;
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
        
        /*Node lca = question33help(tree.root,tree.root.right.right, tree.root.right.left.right);
        System.out.println("\n"+lca.data);
        
        Node lca2 = question33(tree.root, tree.root.right.right, tree.root.right.left.right);
        System.out.println();
        System.out.println("\n"+lca2.data);*/
        System.out.println();
        question34(tree.root);
        /*System.out.println("\nAfter the inversion/mirror of the tree: ");
        question27(tree.root);
        tree.levelOrderTraversal(tree.root);
        
       Tree tree2 = new Tree();
       tree2.createTree();
       System.out.println(question28(tree2.root, tree.root));*/
       /*System.out.println();
       HashMap<Integer, Integer> map = question35b(tree.root);
       for(Integer k: map.keySet()){
           System.out.println(k + " "+ map.get(k) + "---");
       }
       System.out.println("\nThe vertical line sums: ");
       
       HashMap<Integer, Integer> horiztonalMapRecursion = new HashMap<>();
       question35c(tree.root, horiztonalMapRecursion, 0);
       for(Integer k: horiztonalMapRecursion.keySet()){
           System.out.println(k + " "+ horiztonalMapRecursion.get(k) + "---");
       }
       System.out.println();
       question32(tree.root, tree.root.right.left, new ArrayList<Node>());*/
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
        /*int max=question1(tree.root);
        System.out.println("\nThe maximum element in the above tree is: "+max);
        question9(tree.root);
        System.out.println("The minimum depth of the tree: "+question13(tree.root));
        
        int maxLevel = question22(tree.root);
        System.out.println("\nThe maximum level in the above tree is: "+maxLevel);
        question23(tree.root, new ArrayList<Node>());
        System.out.println(question24(tree.root, 95, 0));
        
        System.out.println(question25(tree.root));*/
        /*ArrayList<ArrayList<Node>> rootToPathSumList = new ArrayList<ArrayList<Node>>();
        question24b(tree.root, 95, 0, rootToPathSumList, new ArrayList<Node>());
        System.out.println("\nThe sum is: "+ question26(tree.root));
        */
        
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
     * Problem-17  Give an algorithm for finding the number of full nodes 
     * in the 
     * binary tree without using recursion.
     */
    public static int question17(Node root){
        if(root==null) return 0;

        Queue<Node> queueForNodeData = new LinkedList<Node>();

        int numberOfFullNodes = 0;
        queueForNodeData.add(root);

        while(!queueForNodeData.isEmpty()){

            Node workingNode=queueForNodeData.poll();

            if(workingNode.left != null && workingNode.right != null){
                numberOfFullNodes++;
            }

            if(workingNode.left != null){
                queueForNodeData.add(workingNode.left);
            }
            if(workingNode.right != null){
                queueForNodeData.add(workingNode.right);
            }
        }
        return numberOfFullNodes;
    }

    /**
     * Problem-18  Give an algorithm for finding the number of half nodes 
     * (nodes with only one child) in the binary tree without using recursion.
     */
    public static int question18(Node root){
        if(root==null) return 0;

        Queue<Node> queueForNodes =new LinkedList<Node>();
        queueForNodes.add(root);
        int numberOfHalfNodes=0;
        while(!queueForNodes.isEmpty()){
            Node checkingNode = queueForNodes.poll();

            if((checkingNode.right!=null && checkingNode.left==null) || 
                    (checkingNode.right==null && checkingNode.left!=null)){
                numberOfHalfNodes++;
            }
            if(checkingNode.left!=null){
                queueForNodes.add(checkingNode.left);
            }
            if(checkingNode.right!=null){
                queueForNodes.add(checkingNode.right);
            }
        }
        return numberOfHalfNodes;
    }

    /**
     * Problem-19  Given two binary trees, return true if they 
     * are structurally identical.
     */
    public static boolean question19(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root2==null || root1==null){
            return false;
        }

        return question19(root1.left,root2.left) && 
                question19(root1.right,root2.right);
        /*boolean leftSubtree=question19(root1.left, root2.left);

        boolean rightSubtree=question19(root1.right, root2.right);*/
    }

    /**
     * Problem-20  Give an algorithm for finding the diameter of the binary tree. 
     * The diameter of a tree (sometimes called the width) is the 
     * number of nodes on the longest path between two leaves in the tree.
     */
    public static int question20(Node root){
        if(root==null) return 0;

        int diameter = question10(root.left) + question10(root.right) + 1;

        return Math.max(Math.max(question20(root.left), question20(root.right)), diameter);
    }

    /** 
     * Solve Problem 20 with O(n) solution.
     */
    static class Height{
        int h;
    }
    public static int question20b(Node root, Height height){
        if(root == null){
            height.h = 0;
            return 0;
        }

        //initialize the leftHeight and rightHeight
        Height leftHeight = new Height();
        Height rightHeight = new Height();

        //calculate leftDiameter and rightDiameter
        int leftDiameter = question20b(root.left, leftHeight);
        int rightDiameter = question20b(root.right, rightHeight);
        
        //calculate actual height
        int currentHeight = Math.max(leftHeight.h, rightHeight.h) + 1;
        //store the currentHeight to the height
        height.h = currentHeight;
        //calculate current diameter
        int currentDiameter = leftHeight.h + rightHeight.h + 1;
        //compare against current diameter, left diameter and right diameter
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
    
    /** 
     * Problem-21  Give an algorithm for finding the width of the binary tree. 
     * The diameter of a treeis the maximum number of nodes at any level 
     * (or depth) in the tree.
     */
    
    public static int question21(Node root){
        if(root == null){
            return 0;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        
        Node empty = null;
        int maxSize = 0;
        int size = 0;
        queue.add(root);
        queue.add(empty);
        
        while(!queue.isEmpty()){
            
            Node popNode = queue.poll();
            
            if(popNode == empty){
                if(size > maxSize){
                    maxSize = size;
                }
                if(queue.isEmpty()){
                    break;
                }
                size = 0;
                queue.add(empty);
            }
            else {
            size ++;
            if(popNode.left != null){
                queue.add(popNode.left);
                }
            if(popNode.right != null){
                queue.add(popNode.right);
                }
            }
        }
        return maxSize;
    }
    /**
     * Problem-22  Give an algorithm for finding the level that has 
     * the maximum sum in the binary tree.
     */
    
    public static int question22(Node root){
        if(root == null) return 0;
        
        Queue<Node> queueNode = new LinkedList<Node>();
        int sum = 0;
        int maxSum = 0;
        int maxLevel = 0;
        int level = 0;
        
        Node empty = null;
        
        queueNode.add(root);
        queueNode.add(empty);
        
        while(!queueNode.isEmpty()){
            
           Node popNode = queueNode.poll();
           
           if (popNode == empty){
               level ++;
               if(sum > maxSum){
                   maxSum = sum;
                   maxLevel = level;
               }
               if(queueNode.isEmpty()){
                   break;
               }
               queueNode.add(empty);
               sum = 0;
           }
           else{
               sum = sum + popNode.data;
               if(popNode.left != null){
                   queueNode.add(popNode.left);
               }
               if(popNode.right != null){
                   queueNode.add(popNode.right);
               }
           }
        }
        return maxLevel;
    }
    
    /**
     *  Problem 23 Given a binary tree, print out all its root-to-leaf paths.
     */
    public static void question23(Node root, ArrayList<Node> list){
        if(root == null) return;
        
        list.add(root);
        
        if(root.left == null && root.right == null){
            for(Node temp: list){
                System.out.print(temp.data +"->");
            }
            System.out.print("\n");
            return;
        }
        // the two lines below are backtracking
        question23(root.left, list);
        list.remove(list.size() - 1);
        question23(root.right, list);
        list.remove(list.size() - 1);
    }
    
    /**
     * Problem-24  Give an algorithm for checking the existence of path 
     * with given sum. That means, given a sum, check whether there 
     * exists a path from root to any of the nodes
     */
    public static boolean question24(Node root, int requiredSum, int currentSum){
        if(root == null) return false;
        // you can get rid of currentSum by adding:
        // requiredSum -= root.data 
        //and by checking in the if condition if requiredSum has reached 0 
        currentSum += root.data;
        
        if(root.left == null && root.right == null && currentSum == requiredSum){
            return true;
        }
        
        return question24(root.left, requiredSum, currentSum) ||  question24(root.right, requiredSum, currentSum);
    }
    
    /**
     * Extend the above problem to return that path 
     */
    public static void question24b(Node root, int requiredSum, int currentSum, ArrayList<ArrayList<Node>>  storepathList,ArrayList<Node> backtrackList){
        backtrackList.add(root);
        if(root == null) return;
        currentSum += root.data;
 
        if(root.left == null && root.right == null && currentSum == requiredSum){
            storepathList.add(new ArrayList<Node>(backtrackList));
            System.out.println();
            for(Node temp: storepathList.get(storepathList.size()-1)){
                System.out.print(temp.data + "->");
            }
            System.out.println();
            return;
        }
        
        question24b(root.left, requiredSum, currentSum, storepathList, backtrackList);
        backtrackList.remove(backtrackList.size() -1);
        question24b(root.right,requiredSum, currentSum,storepathList, backtrackList);
        backtrackList.remove(backtrackList.size() -1);
    }
    
    /**
     * Problem-25  Give an algorithm for finding the sum of all 
     * elements in binary tree.

     */
    public static int question25(Node root){
        if(root == null) return 0;
        return question25(root.left) + question25(root.right) + root.data;
    }
    
    /**
     * Problem-26  Can we solve Problem-25 without recursion?
     */
    public static int question26(Node root){
        if (root == null) return 0;
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()){
            Node n = queue.poll();
            sum += n.data;
            
            if(n.left!=null){
                queue.add(n.left);
            }
            if(n.right!=null){
                queue.add(n.right);
            }
        }
        return sum;
    }
    
    /**
     * Problem-27  Give an algorithm for converting a tree to its mirror. 
     * Mirror of a tree is another tree with left and right children of 
     * all non-leaf nodes interchanged. The trees below are mirrors to each other.
     */
    // You are swapping the children of the root not the particular elements itself!!!
    public static void question27(Node root){
        if(root == null) return;
        
        question27(root.left);
        question27(root.right);
        
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        
    }
    
    /**
     * Problem-28  Given two trees, give an algorithm for checking whether 
     * they are mirrors of each other.
     */
    public static boolean question28(Node root1, Node root2){
        if(root1==null && root2==null) return true;
        if(root1 == null || root2 == null) return false;
 
        if(root1.data != root2.data){
            return false;
        }
        return question28(root1.left, root2.right) && question28(root1.right, root2.left); 
        
    }
    
    /**
     * Problem-35  Give an algorithm for finding the vertical sum of a binary tree.
     */
    
    public static void question35(Node root, HashMap<Integer, Integer> map, int level){
        if(root == null) return;
        int sum = 0;
        if(map.containsKey(level)){
            sum = map.get(level);
            sum += root.data;
            map.put(level, sum);
        }
        
        else{
            map.put(level, sum+root.data);
        }
        
        question35(root.left, map, level-1);
        question35(root.right, map, level+1);
    }
    /**
     * Problem 35b Calculate the sum of each horizontal(level) line in the tree.
     */
    public static HashMap<Integer, Integer> question35b(Node root){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(root == null) return map;
        
        Queue<Node> queue = new LinkedList<Node>();
        Node empty = null;
        
        int sum = 0;
        int level = 0;
        queue.add(root);
        queue.add(empty);
        
        while(!queue.isEmpty()){
            Node popNode = queue.poll();  
            if(popNode == empty){
                map.put(level, sum);
                level ++;
                sum = 0;
                if(!queue.isEmpty()) {
                queue.add(empty); }
            }
            else{
            sum += popNode.data;
            if(popNode.left != null){
                queue.add(popNode.left);
                }
            if(popNode.right != null){
                queue.add(popNode.right);
                }
            }
        }
        return map;
    }
    
    /**
     * Problem 35c horizontal line with recursion (because Koochi is on fire!!)
     */
     public static void question35c(Node root, HashMap<Integer, Integer> map, int level){
         if(root == null) return;
         int sum = 0;
         if(map.containsKey(level)){
             sum = map.get(level);
             sum += root.data;
             map.put(level, sum);
         }
         else{
             map.put(level, sum+root.data);
         }
         question35c(root.left, map, level +1);
         question35c(root.right, map, level+1);
     }
     /**
      * Problem-32  Give an algorithm for printing all the ancestors of a node 
      * in a Binary tree. 
      */
     public static void question32(Node root, Node desiredNode, ArrayList<Node> backtrackList){
         backtrackList.add(root);
         if(root == null ) return;
         if(root == desiredNode){
             for(Node temp: backtrackList){
                 System.out.print(temp.data+ "---");
             }
             return;
         }
         
         question32(root.left, desiredNode, backtrackList);
         backtrackList.remove(backtrackList.size() -1);
         question32(root.right, desiredNode, backtrackList);
         backtrackList.remove(backtrackList.size() -1);
     }
     
     /**
      * Problem-33  Give an algorithm for finding LCA (Least Common Ancestor) 
      * of two nodes in a Binary Tree.
      */
     public static void question33(Node root, Node node1, Node node2, ArrayList<ArrayList<Node>> storingList, ArrayList<Node> backtrackList){
         backtrackList.add(root);
         
         if(root == null) return;
         
         if(root == node1 || root == node2){
             storingList.add(new ArrayList<Node>(backtrackList));
         }
         
         question33(root.left, node1, node2, storingList, backtrackList);
         backtrackList.remove(backtrackList.size() -1);
         question33(root.right, node1, node2, storingList, backtrackList);
         backtrackList.remove(backtrackList.size() -1);
         
     }
     public static Node question33help(Node root, Node n1, Node n2){
         ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
         ArrayList<Node> backtrack = new ArrayList<>();
         question33(root, n1, n2,list, backtrack);
         ArrayList<Node> storedGCA=new ArrayList<>();
         int i=0;
         
         while(i<list.get(0).size() && i<list.get(1).size()){
             if(list.get(0).get(i) == list.get(1).get(i)){
                 storedGCA.add(list.get(0).get(i));
             }
             i++;
         }
         return storedGCA.get(storedGCA.size()-1);
     }
     
     public static Node question33(Node root, Node n1, Node n2){
         if(root == null) return null;
         
         if(root==n1 || root==n2) return root;
         
         Node left = question33(root.left, n1, n2);
         Node right = question33(root.right, n1, n2);
         
         if(left!=null && right!=null) return root;
         
         if(left!=null) 
             return left;
         else
             return right;
      }
     /**
      * Problem-34  Zigzag Tree Traversal: Give an algorithm to traverse 
      * a binary tree in Zigzag order.
      */
     public static void question34(Node root){
         if(root == null) return;
         Stack<Node> currentLevel = new Stack<Node>();
         Stack<Node> nextLevel = new Stack<Node>();
         currentLevel.add(root);
         
         boolean leftToRight = true;
         
         while(!currentLevel.isEmpty()){
             Node popNode = currentLevel.pop();
             
             System.out.print(popNode.data+" ===>");
             
             if(leftToRight==true){
                 if(popNode.left!=null){
                     nextLevel.push(popNode.left);
                 }
                 if(popNode.right!=null){
                     nextLevel.push(popNode.right);
                 }
             }
             else{
                 if(popNode.right!=null){
                     nextLevel.push(popNode.right);
                 }
                 if(popNode.left!=null){
                     nextLevel.push(popNode.left);
                 }
             }
             
             if(currentLevel.isEmpty()){
                 leftToRight=!leftToRight;
                 Stack<Node> temp = currentLevel;
                 currentLevel = nextLevel;
                 nextLevel = temp;
             }
         }
     }
     /**
      * Problem 36: How many different binary trees are possible with n nodes?
      */
     
     public static int question36(int n){
         return 2*n-n;
     }
     
     //TODO Problem 37 in BSTs
     //TODO Read Problem 38-40
}