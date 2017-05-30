package main.bookDataStructure;

import java.util.ArrayList;
import java.util.Stack;

//Definition for binary tree
class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        key = x;
    }
}

public class InorderTraversalWithStack {

    /* From TreeApp */

    private static void inOrder(TreeNode localRoot){
        if(localRoot != null)
        {
            inOrder(localRoot.left);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.right);
        }
    }



    public static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if(root == null)
            return lst;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;//define a pointer to track nodes

        while(!stack.empty() || p != null){

            /* if it is not null, push to stack and go down the tree to left */
            if(p != null){
                stack.push(p);
                p = p.left;
            /*if no left child pop stack, process the node then let p point to the right */
            }else{
                TreeNode t = stack.pop();
                lst.add(t.key);
                p = t.right;
            }
        }

        return lst;
    }


    public static void main(String[] args) {


        /*TreeNode root = new TreeNode(20);

        root.left = new TreeNode(18);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(19);
        root.right = new TreeNode(23);
        root.right.left = new TreeNode(22); //was 14
        root.right.left.left = new TreeNode(21);
        root.right.right = new TreeNode(34);*/

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println("List: " + inOrderTraversal(root));

        System.out.println("List from TreeApp: ");
        inOrder(root);
    }

//    void insertSorted(TreeNode root, List<Integer> list) {
//        if(list.size() < 1) {
//          return
//        }
//        Integer val = list.get(0);
//        if(key < root.key)
//        {
//            if(root.left != null) {
//                insertSorted(root.left, list.tail);
//            }
//
//        }
//    }
}
