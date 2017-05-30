package main.bookDataStructure;

import java.util.Scanner;
import java.util.Stack;

/** From Data Structures and Algorithms, schoelbeck book
 */



class Node {

    public int key;              // data item (key)
    public double dataItem;           // data item
    public Node leftChild;         // this node’s left child
    public Node rightChild;        // this node’s right child

    public void displayNode() {
        System.out.print("(");
        System.out.print(key);
        System.out.print(", ");
        System.out.print(dataItem);
        System.out.print(")");
    }
}


class Tree {
    private Node root;

    public Tree() {
        root = null;
    }


    public Node find(int key)      // find node with given key
    {                           // (assumes non-empty tree)
        Node current = root;               // start at root
        while (current.key != key)        // while no match,
        {
            if (key < current.key)         // go left?
                current = current.leftChild;
            else                            // or go right?
                current = current.rightChild;
            if (current == null)             // if no child,
                return null;                 // didn’t find it
        }
        return current;                    // found it
    }

    public void insert(int id, double dd){
        Node newNode = new Node();    // make new node
        newNode.key = id;           // insert data
        newNode.dataItem = dd;
        if (root == null)                // no node in root
            root = newNode;
        else                          // root occupied
        {
            Node current = root;       // start at root
            Node parent;
            while (true)                // (exits internally)
            {
                parent = current;
                if (id < current.key)  // go left?
                {
                    current = current.leftChild;
                    if (current == null)  // if end of the line,
                    {                 // insert on left
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else                    // or go right?
                {
                    current = current.rightChild;
                    if (current == null)  // if end of the line
                    {                 // insert on right
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) // delete node with given key
    {                           // (assumes non-empty list)
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.key != key)        // search for node
        {
            parent = current;
            if (key < current.key)         // go left?
            {
                isLeftChild = true;
                current = current.leftChild;
            } else                            // or go right?
            {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)             // end of the line,
                return false;                // didn’t find it
        }
        // found node to delete
        // if no children, simply delete it
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)             // if root,
                root = null;                 // tree is empty
            else if (isLeftChild)
                parent.leftChild = null;     // disconnect
            else                            // from parent
                parent.rightChild = null;
        }

        // if no right child, replace with left subtree
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        // if no left child, replace with right subtree
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else  // two children, so replace with inorder successor
        {
            // get successor of node to delete (current)
            Node successor = getSuccessor(current);
            // connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect successor to current’s left child
            successor.leftChild = current.leftChild;
        }
        // (successor cannot have a left child)
        return true;
    }


    /* Returns node with next-highest value after delNode
    goes to right child, then right child’s left descendants */

    private Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;   // go to right child
        while(current != null)               // until no more
        {                                 // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild;      // go to left child
        }
        // if successor not
        if(successor != delNode.rightChild)  // right child,
        {                                 // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }


    public void traverse(int traverseType){
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }


    private void preOrder(Node localRoot){
        if(localRoot != null)
        {
            System.out.print(localRoot.key + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }


    private void inOrder(Node localRoot){
        if(localRoot != null)
        {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.key + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot){
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.key + " ");
        }
    }


    public void displayTree(){
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while(!isRowEmpty) {

            Stack localStack = new Stack();
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');
            while(!globalStack.isEmpty())
            {
                Node temp = (Node)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.key);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while(!localStack.isEmpty())
                globalStack.push(localStack.pop());

        }
        System.out.println("......................................................");
    }
}

public class TreeApp {

    public static void main(String[] args) {

        Tree theTree = new Tree();
        int value;

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);


        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter first letter of show, insert, find, delete, or traverse: ");
            int choice = scan.next().charAt(0);

            switch(choice) {

                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = scan.nextInt();
                    theTree.insert(value, value + 0.9);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = scan.nextInt();
                    Node found = theTree.find(value);
                    if(found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    } else {
                        System.out.print("Could not find ");
                        System.out.print(value + '\n');
                    }
                    break;

                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = scan.nextInt();
                    boolean didDelete = theTree.delete(value);
                    if(didDelete) {
                        System.out.print("Deleted " + value + '\n');
                    } else {
                        System.out.print("Could not delete ");
                        System.out.print(value + '\n');
                    }
                    break;

                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = scan.nextInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }
}
