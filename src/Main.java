public class Main {
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(43);
		tree.insert(253);
		tree.insert(33);
		tree.insert(20);
		tree.insert(35);
		tree.insert(100);
		tree.insert(300);
		tree.insert(10);
		tree.insert(25);
		tree.insert(34);
		tree.insert(36);
		tree.insert(90);
		tree.insert(110);
		tree.insert(290);
		tree.insert(310);
		System.out.println(tree.inOrder());
		// System.out.println(tree.contains(253));
		System.out.println(tree.remove(10));
		// tree.remove(290);

		System.out.println("");
	}
}