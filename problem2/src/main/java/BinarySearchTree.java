public class BinarySearchTree {

    private static boolean contains(Node root, int value) {
        if (checkNode(root, value)) {
            return true;
        } else {
            //traverse into tree
            root = root.left;
            return checkNode(root, value);
        }
    }

    private static boolean checkNode(Node root, int value) {
        if (root.value == value) {
            return true;
        } else if (root.right != null && root.right.value == value) {
            return true;
        } else return root.left != null && root.left.value == value;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }

    static class Node {
        int value;
        Node left, right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
