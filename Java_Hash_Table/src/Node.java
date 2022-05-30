public class Node {
    Object data;
    Object key;
    Node next;

    public Node(Object data){
        this.data = data;
    }

    @Override
    public String toString(){
        return this.data == null? "null" : this.data.toString();
    }

}
