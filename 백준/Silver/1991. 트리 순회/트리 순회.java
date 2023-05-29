

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Node root = new Node("A",null,null);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            insert(root, value,left,right);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);

    }

    private static void preOrder(Node cur) {

        if (cur == null)
            return;
        System.out.print(cur.value);
        preOrder(cur.left);
        preOrder(cur.right);
    }

    private static void inOrder(Node cur) {
        if (cur == null)
            return;
        inOrder(cur.left);
        System.out.print(cur.value);
        inOrder(cur.right);
    }

    private static void postOrder(Node cur) {
        if (cur == null)
            return;
        postOrder(cur.left);
        postOrder(cur.right);
        System.out.print(cur.value);
    }

    static void insert(Node current, String value, String left, String right) {

       if (current.value.equals(value)) {
           current.left = left.equals(".") ? null : new Node(left,null,null);
           current.right = right.equals(".") ? null : new Node(right,null,null);
       } else {
           if (current.left != null)
               insert(current.left,value,left,right);
           if (current.right != null)
               insert(current.right,value,left,right);
       }
    }

    static class Node {
        public String value;
        public Node left;
        public Node right;

        public Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
