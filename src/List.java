package aut.ir;

/**
 * Created by mahdis on 1/17/2018.
 */
public class List {

    public Node first;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }


    //LinkList constructor
    public List() {
        setFirst(null);
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //Inserts a new Link at the first of the list
    public void addNode(int j) {
        Node node = new Node(j);
        node.link = getFirst();
        setFirst(node);
    }



    }

class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        link = null;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}
