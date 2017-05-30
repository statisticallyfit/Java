package semester1.chapter5.section_5_6_TO_5_9;

import javax.swing.JOptionPane;


public class NetApp {
    /**
     * List all nodes and tell how many there are.
     */

    public static void main(String[] args) {

        Network net = new Network();

        //Part 1
        int count = 0;
        for (Position pos = net.nodes(); pos.hasNext(); pos.moveOn()) {
            Node node = pos.getNext();
            System.out.println(node.getID() + " is a node");
            /*JOptionPane.showMessageDialog (null, node.getName() + " is one of the nodes.");*/

            if (node.isBlue()) {
                System.out.println(node.getID() + " is a blue node");
                /*JOptionPane.showMessageDialog(null, node.getName() + " is a blue node");*/
            }
            count++;
        }
        JOptionPane.showMessageDialog(null, "The total number of nodes is " + count);


        //Part 2
        String lastBlue = "no blues";
        for (Position pos = net.nodes(); pos.hasNext(); pos.moveOn()) {
            if (pos.getNext().isBlue()) {
                lastBlue = pos.getNext().getID() + "";
            }
        }
        System.out.println("The last blue is " + lastBlue);
        /*JOptionPane.showMessageDialog(null, lastBlue);*/


        System.exit(0);
    }
}

class Network {

    public static final int NUM_OF_NODES = 5; //originally 100

    public Position nodes() {
        return new Position(0, NUM_OF_NODES - 1);
    }
}

class Position {
    private int itsCurrent; // Node at current position on list
    private int itsLast;    // Node at last position on list

    public Position(int first, int last) {
        super();
        this.itsCurrent = first;
        this.itsLast = last;

    }

    /** Return the next Node in the sequence.  Return null
     *  if you have come to the end of the sequence. */

      public Node getNext() {

        if (itsCurrent > itsLast) {
            return null;
        } else {
            return new Node(itsCurrent % Network.NUM_OF_NODES); // basically same as itsCurrent alone -- since NUM_OF_NODES = 100 always
        }
    }

    /** Tell whether there is another Node in the sequence. */

    public boolean hasNext() {
        return itsCurrent <= itsLast;
    }

    /** Go one Node further in the sequence. */

    public void moveOn() {
        itsCurrent++;
    }

}

class Node {

    public static final int NODE_IS_REACHED = 1;
    public static final int NODE_IS_VISITED = 2;
    public static final int NODE_IS_NOT_REACHED = 0;

    private int itsID;     // ranges from 0 to NUM_OF_NODES - 1
    private int itsMark = 0;


    public Node(int index) {
        super();
        this.itsID = index;
        //System.out.println("Node created " + this.itsID);
    }

    public void setMark(int newMark) {
        System.out.println("Node " + this.itsID + " is now marked " + toString(newMark));
        this.itsMark = newMark;
    }

    public int getMark() {
        return this.itsMark;
    }

    private String toString(int newMark) {
        switch (newMark) {
            case NODE_IS_REACHED:
                return "REACHED";
            case NODE_IS_VISITED:
                return "VISITED";
            case NODE_IS_NOT_REACHED:
                return "NOT REACHED";
        }
        return null;
    }

    /** Return an object that can produce all Nodes that
     *  are connected to the executor, 1 at a time. */

      public Position nodes() {
        return new Position(itsID + 1, itsID + 4); //get itsCurrent, itsLast
    }

    public boolean equals(Node par) {
        return par != null && this.itsID == par.itsID;
    }

    public String getName() {
        return "Darryl";
    }

    public int getID() {
        return itsID;
    }

    public boolean isBlue() {
        return itsID % 2 == 1; // if odd, return true
    }
}


//----------section 5.7--------------------------------------

class SmartNet extends Network {


    /**
     * Tell whether par connects to all other nodes in this
     * network.
     */

    public boolean connectsToAll(Node par) {  //in the for loop, increment itsCurrent and itsID of overall obj (the 0, 99 one)
        for (Position pos = this.nodes() /*returns pos obj with itsCurrent = 0 and itsLast = 99*/; pos.hasNext(); pos.moveOn()) {
            Node currentNode = pos.getNext(); //returns the itsID of (this) pos object - then compare ids of this and and par in connected()
            if (!(currentNode.equals(par) || NodeOp.connected(currentNode, par))) { //if !True, then, keep going - find more true ones!
                return false;
            }
        }
        return true;
    }

    /**
     * Return the total number of nodes in this network.
     */

    public int getNumNodes() {
        int count = 0;
        for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
            count++;
        }
        return count;
    }

    /**
     * List all nodes in this network that connect to
     * some node of the same color.
     */

    public void printSameColorConnections() {
        for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
            Node currentNode = pos.getNext();
            if (NodeOp.seesSameColor(currentNode)) {
                System.out.println(currentNode.getID());
                /*JOptionPane.showMessageDialog(null, node.getName());*/
            }
        }
    }

    public boolean noLoners() {
        for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
            if (!pos.getNext().nodes().hasNext()) {
                return false; //keep looking for more
            }
        }
        return true;
    }

    public boolean atLeastOneNonBlue() {
        for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
            if (!pos.getNext().isBlue()) {
                return false; //keep looping to find if there are more non blues
            }
        }
        return true;
    }






    /**
     * Methods for the reachability problem
     */

    /*public boolean allReachableFrom(Node source) {
        checkOut(source); //marks 2 on source, 1 on others that are reachable from those marked 2
        boolean foundNodeToCheckOut;

        do {
            foundNodeToCheckOut = false; //initializing
            for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
                Node current = pos.getNext();

                if (current.getMark() == Node.NODE_IS_REACHED) {
                    foundNodeToCheckOut = true;
                    checkOut(current);
                }
            }
        } while (foundNodeToCheckOut);
        //if using recursion, can take out all the above except first line

        return allNodesAreMarked();
    }*/


    private static void checkOut(Node nodeToCheckout){

        if(nodeToCheckout.getMark() == Node.NODE_IS_VISITED)
            return; //to get out of method

        System.out.println("Visiting node " + nodeToCheckout.getID());
        nodeToCheckout.setMark(Node.NODE_IS_VISITED);

        for(Position pos = nodeToCheckout.nodes(); pos.hasNext(); pos.moveOn()){
            Node currentNode = pos.getNext();
            if(currentNode.getMark() == Node.NODE_IS_NOT_REACHED){
                currentNode.setMark(Node.NODE_IS_REACHED);
                //checkOut(currentNode);
            }
        }
    }

    public boolean allReachableFrom(Node sourceNode){
        checkOut(sourceNode);
        return allNodesAreMarked();
    }

    private boolean allNodesAreMarked() {
        boolean areMarked = true;

        for (Position pos = nodes(); pos.hasNext(); pos.moveOn()) {
            if (pos.getNext().getMark() == Node.NODE_IS_NOT_REACHED)
                areMarked = false;
            else
                pos.getNext().setMark(Node.NODE_IS_NOT_REACHED);
        }
        return areMarked;
    }


    /** Tell whether it is possible to travel through n nodes,
     *  all different and all marked 0, starting from Node base.
     *  Precondition:  base is marked 0.  */

    public static boolean canTravelFrom(Node baseNode, int n){
        if(n <= 1)
            return true;

        baseNode.setMark(Node.NODE_IS_REACHED); //1
        for(Position pos = baseNode.nodes(); pos.hasNext(); pos.moveOn()){
            Node currentNode = pos.getNext();
            if(currentNode.getMark() == Node.NODE_IS_NOT_REACHED && canTravelFrom(currentNode, n - 1)){
                baseNode.setMark(Node.NODE_IS_NOT_REACHED); //restore original state
                return true;
            }
            baseNode.setMark(Node.NODE_IS_NOT_REACHED); //0
        }
        return false;
    }


    public static void main(String[] args) {
        //canTravelFrom(new Node(3), 3);
        checkOut(new Node(3));
    }
}