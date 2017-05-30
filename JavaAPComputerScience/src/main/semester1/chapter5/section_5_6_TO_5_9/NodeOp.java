package semester1.chapter5.section_5_6_TO_5_9;


public class NodeOp {


    public static boolean seesOnlyBlue (Node par) {
        //Looping action type: "All-A-are-B"
        for (Position p = par.nodes();  p.hasNext();  p.moveOn()){
            if(!p.getNext().isBlue()){ //if get !True, keep going to check if others are blue too
                return false;
            }
        }
        return true;
    }


    //todo:Does this ever return true for biDirectional() ?

    public static boolean connected (Node origin, Node target){
        //Looping action type: "Some-A-are-B"
        for (Position pos = origin.nodes() /*get itsCurrent, itsLast with node(whichisthefromobj).nodes() formula*/;  pos.hasNext();  pos.moveOn()){
            if (pos.getNext().equals(target)){
                return true;
            }
        }
        return false;
    }


    public static boolean seesSameColor (Node par){
        return (par.isBlue() && ! seesOnlyNonBlue (par)) || (! par.isBlue() && ! seesOnlyBlue (par));
    }


    public static boolean seesOnlyNonBlue (Node par){
        for(Position p = par.nodes(); p.hasNext(); p.moveOn()){
            if(p.getNext().isBlue()){ //if node isn't blue
                return false;
            }
        } //else
        return true;
    }


   public static int getNumNodes(Node par){
        int count = 0;
       for(Position p = par.nodes(); p.hasNext(); p.moveOn()){
           count++;
       }
       return count;
   }

    public static boolean biDirectional(Node par){
        for(Position p = par.nodes(); p.hasNext(); p.moveOn()){
            if(!connected(p.getNext(), par)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        Node nodeFrom = new Node(4);
        Node nodeTarget = new Node(1);

        biDirectional(nodeFrom);
    }
}