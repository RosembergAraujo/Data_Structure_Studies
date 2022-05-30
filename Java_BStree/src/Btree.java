public class Btree {
    Node root;

    public Btree(){
        this.root = null;
    }

    public void Insert(int toBeAdded){
        if (this.root == null)
            this.root = new Node(toBeAdded);

        else {
            Node current = this.root;

            while (true){
                if(toBeAdded < current.data){

                    if(current.left == null){
                        current.left = new Node(toBeAdded);
                        return;
                    }
                    current = current.left;
                } else if (toBeAdded > current.data){

                    if(current.right == null){
                        current.right = new Node(toBeAdded);
                        return;
                    }

                    current = current.right;
                }else {
                    throw new Error("Duplicated value 🦆");
                }

            }
        }
    }

    public void Delete(int value){
        if (this.root == null) throw new Error("Empty tree 🌲"); //Árvore vazia


        Node[] nodes = FindNode(value);

        Node parent = nodes[0];
        Node nodeToBeDeleted = nodes[1];
        Node current = nodeToBeDeleted;
        Node previous;


        if (current.left == null && current.right == null){ //Caso já seja uma folha, basta remove-lo
            if (value < parent.data){
                parent.left = null;
            }else {
                parent.right = null;
            }
            return;
        }

        if (current.left == null){ //Caso só o nó a esquerda seja nulo
            if (value < parent.data){
                parent.left = nodeToBeDeleted.right;
            }
            if (value > parent.data){
                parent.right = nodeToBeDeleted.right;
            }
            return;
        }

        /*
        Como o objetivo é pegar a folha mais a direita do galho a esquerda do nó, já inicia
        indo pra esquerda, já que no while, ele só vai indo pra direita sempre que possivel
         */

        previous = current;
        current = current.left;

        while (current.left != null || current.right != null) { //Satisfeito quando ambos forem nulos

            /*
            Enquanto o nó atual não for uma uma folha.
            Para deletar um nó, você deverá substitui-lo pela maior folha (Esqueda e direita nulos, sem filhos)
            Que está a esquerda do nó que será deletado (Caso tenha)
             */
            if (current.right != null){
                previous = current;
                current = current.right;
            } else {
                previous = current;
                current = current.left;
            }
        }

        /*
        Encontramos o maior nó a esquerda do nó que será removido e o seu pai (para poder remover)
        Agora removemos este nó e ele continua guardado na var current
         */

        if (previous.right != null) //Removendo a folha para subtituir no nó a ser removido
            previous.right = null;
            //Como já sabemos que ele é o ultimo, se tiver nó a direita, sempre será ele o maior
        else
            previous.left = null;


        if (value < parent.data){
            /*
            Para substituir o nó a ser removido a priore, basta trocar o valores armazedados
            para manter seus filhos, por isso não troco o nó inteiro, somente os valores
             */
            parent.left.data = current.data;
        }else {
            parent.right.data = current.data;
        }

    }


    private Node[] FindNode(int value){
        Node current = this.root;
        while (true){ //Procurando o node com o valor que será deletado
            if (current == null) throw new Error("Value not found in the tree 🌳");

            if (( current.left != null && current.left.data == value) ||
                    (current.right != null && current.right.data == value)) {
                /* Ambas os retornos são iguais, porém a de baixo é mais elegante
                Node nodeToBeDeleted;

                if (current.left != null && current.left.data == value){
                    nodeToBeDeleted = current.left;
                }
                else{
                    nodeToBeDeleted = current.right;
                }

                Node[] nodes = {current, nodeToBeDeleted};

                return nodes;
                */

                return new Node[]{current, (current.left != null && current.left.data == value) ? current.left : current.right};
            }else {
                if(value < current.data){
                    current = current.left;

                } else{
                    current = current.right;
                }
            }
        }
    }



    public void InOrder(Node node) { //root
        if(node == null) return;

        InOrder(node.left);
        System.out.print(node.data + " ");
        InOrder(node.right);
    }

    public void PreOrder(Node node) { //root
        if(node == null) return;

        System.out.print(node.data + " ");
        PreOrder(node.left);
        PreOrder(node.right);
    }

    public void PostOrder(Node node) { //root
        if(node == null) return;

        PostOrder(node.left);
        PostOrder(node.right);
        System.out.print(node.data + " ");
    }
}
