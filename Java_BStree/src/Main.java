public class Main {
    public static void main(String[] args) {
        Btree btree = new Btree();

        btree.Insert(61);
        btree.Insert(82);
        btree.Insert(100);
        btree.Insert(110);
        btree.Insert(90);
        btree.Insert(92);
        btree.Insert(91);
        btree.Insert(93);

        btree.Delete(100);

        System.out.print("Pre Order  =>  ");
        btree.PreOrder(btree.root);
        System.out.print("\nIn Order   =>  ");
        btree.InOrder(btree.root);
        System.out.print("\nPost Order =>  ");
        btree.PostOrder(btree.root);
    }
}
