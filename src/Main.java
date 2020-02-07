public class Main {
    public static void main(String[] args) {
        Node A = new Node("a", 2, 1,1, "a", "a", "a", 'R');
        Node B = new Node("b", 7, 1,1, "a", "a", "a", 'R');
        Node C = new Node("c", 7, 3,1, "a", "a", "a", 'R');
        Node D = new Node("d", 6, 3,1, "a", "a", "a", 'R');
        Node E = new Node("e", 6, 5,1, "a", "a", "a", 'R');
        Node F = new Node("f", 4, 5,1, "a", "a", "a", 'R');
        Node G = new Node("g", 4, 7,1, "a", "a", "a", 'R');
        Node H = new Node("h", 2, 7,1, "a", "a", "a", 'R');
        A.addAnAdjacent(B);
        A.addAnAdjacent(H);
        B.addAnAdjacent(C);
        C.addAnAdjacent(D);
        D.addAnAdjacent(E);
        E.addAnAdjacent(F);
        F.addAnAdjacent(G);
        G.addAnAdjacent(H);
        aStar search = new aStar(A, E);
        search.findPath();
        search.displayQueue();
    }
}
