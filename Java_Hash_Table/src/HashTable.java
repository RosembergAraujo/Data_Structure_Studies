public class HashTable {
    CreatedList[] positions = new CreatedList[99];

    public void add(Object key, Object value){
        int index = Utils.GetFirstTwo(key.hashCode());

        if(this.positions[index] == null){
            this.positions[index] = new CreatedList();
            this.positions[index].append(key, value);
        }

        else {
            Node node = this.positions[index].fistNode;
            while (node != null){
                if(node.key == key){
                    node.data = value;
                    return;
                }
                node = node.next;
            }
            this.positions[index].append(key ,value);
        }
    }

    public Object getValue(Object key){
        int index = Utils.GetFirstTwo(key.hashCode());

        if(this.positions[index] == null)
            return null;

        Node node = this.positions[index].fistNode;

        while(node != null){
            if(key == node.key)
                return node.data;
            node = node.next;
        }
        return null;
    }
}
