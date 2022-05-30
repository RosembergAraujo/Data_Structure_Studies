public class CreatedList {
    public Node fistNode;

    public void append(Object key, Object data){
        if(data == this) throw new Error("Cant do a recursive linked list, but can put a list in another list");

        Node newNode = new Node(data);
        newNode.key = key;
        if(this.fistNode != null)
            this.fistNode.next = newNode;
        else
            this.fistNode = newNode;
    }

    public void append(Object data){
        if(data == this) throw new Error("Cant do a recursive linked list, but can put a list in another list");

        Node newNode = new Node(data);
        if(this.fistNode != null)
            this.fistNode.next = newNode;
        else
            this.fistNode = newNode;
    }


    public CreatedList remove() {
        if (this.fistNode == null) throw new Error("List are empty");

        this.fistNode = this.fistNode.next;
        return this;
    }

    @Override
    public String toString() {
        if (this.fistNode == null) return "[]";
        StringBuilder resultString = new StringBuilder();
        Node node = this.fistNode;
        resultString.append("[ ");

        while (node != null) {
            resultString.append(node.data instanceof String ? "\""+node+"\"" : node);
            resultString.append(node.next != null ? ", " : "");
            node = node.next;
        };

        resultString.append(" ]");
        return resultString.toString();
    }

}
