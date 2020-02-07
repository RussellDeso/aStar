import java.util.LinkedList;

public class Node implements Comparable<Node>{
    private String nodeID;
    int xcoord;
    int ycoord;
    int floor;
    double cost;
    double f;
    String nodeType;
    String longName;
    String shortName;
    char teamAssigned;
    LinkedList<Node> adjacent;
    private boolean blocked;

    public Node(String nodeID, int x, int y, int floor, String type, String longName, String shortName, char teamAssigned) {
        this.nodeID = nodeID;
        this.xcoord = x;
        this.ycoord = y;
        this.floor = floor;
        this.f = 0;
        this.cost = 0;
        this.nodeType = type;
        this.longName = longName;
        this.shortName = shortName;
        this.teamAssigned = teamAssigned;
        this.adjacent = new LinkedList<Node>();
        this.blocked = false;
    }
    public String getNodeID(){
        return this.nodeID;
    }

    public void setAdjacent(LinkedList<Node> nodeList){
        if (!this.adjacent.isEmpty()){this.adjacent = nodeList;}
        else {this.adjacent.addAll(nodeList);}
    }

    public void addAnAdjacent(Node aNode){
        this.adjacent.add(aNode);
    }

    public void setCostFrom(Node startNode){
        this.cost = startNode.cost + Math.abs(Math.sqrt((this.xcoord - startNode.xcoord)^2 + (this.ycoord - startNode.ycoord)));
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.f, o.f);
    }

    public boolean equals(Node o){
        return this.nodeID.equals(o.getNodeID());
    }
}
