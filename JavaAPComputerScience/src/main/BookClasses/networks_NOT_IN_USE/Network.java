package BookClasses.networks_NOT_IN_USE;


/*

//FULL CLASS from Chapter 7

public class Network
{
    */
/** Internal invariant:  The sequence of available Nodes is
     *  itsNode[0][k] for 0 <= k < itsNumNodes. The sequence of
     *  Nodes that itsNode[0][k] connects to is itsNode[k+1][j]
     *  for 0 <= j < n for some n <= itsNumNodes.  The null value
     *  comes after the last value of each such sequence. *//*


    private Node [][] itsNode;
    private int itsNumNodes;
    private java.util.Random randy = new java.util.Random();


    */
/** Return a Position object that produces all nodes 1 at a time. *//*


    public Position nodes()
    {    return new Position (itsNode[0]);
    }


    */
/** Create a random Network with 6 to 15 Nodes, about half
     *  blue, and with 3 connections per Node on average.  No Node
     *  connects to itself.  This is the only method you need to
     *  replace if you want to obtain Network data from a file. *//*


    public Network()
    {    itsNumNodes = 6 + randy.nextInt (10);
        itsNode = new Node [itsNumNodes + 1][itsNumNodes + 1];
        for (int k = 1;  k <= itsNumNodes;  k++)
            itsNode[0][k - 1] = new Node ("Node#" + k,
                    randy.nextInt(2) == 1, itsNode[k]);
        decideWhichConnectionsNodesHave();
    }


    */
/** Choose about 3 nodes at random for each node to connect to. *//*


    private void decideWhichConnectionsNodesHave()
    {    for (int k = 1;  k <= itsNumNodes;  k++)
    {    int j = 0;
        for (int conn = 1;  conn <= itsNumNodes;  conn++)
        {    if (randy.nextInt (itsNumNodes - 1) < 3 && conn != k)
        {    itsNode[k][j] = itsNode[0][conn - 1];
            j++;
        }
        }
    }
    }
}

*/





