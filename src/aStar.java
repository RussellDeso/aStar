import java.util.PriorityQueue;

public class aStar {
    PriorityQueue<Node> openList;
    PriorityQueue<Node> closedList;
    Node start;
    Node end;
    public PriorityQueue<Node> path;

    public aStar(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public double findHeuristic(Node curNode){
        return(Math.abs(curNode.xcoord - end.xcoord) + Math.abs(curNode.ycoord - end.ycoord));
    }

    public void findPath(){
        openList = new PriorityQueue<Node>();
        closedList = new PriorityQueue<Node>();
        openList.add(start);
        while (!openList.isEmpty()){
            Node q = openList.poll();
            if(q.equals(end)){
                closedList.add(q);
                break;
            }
            for (Node n : q.adjacent){
                n.setCostFrom(q);
                n.f = n.cost + findHeuristic(n);
                if (n.equals(end)) {
                    closedList.add(n);
                    break;
                }
                else if (openList.contains(n)){}
                else if (closedList.contains(n)){}
                else {openList.add(n);}
            }
            closedList.add(q);
        }
        this.path = closedList;
    }

    public void displayQueue(){
        for(Node n : path){
            System.out.println(n.getNodeID());
        }
    }
}
