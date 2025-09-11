import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int v) { val = v; }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        input = input.substring(1, input.length() - 1);
        if (input.isEmpty()) {
            System.out.println(true);
            return;
        }

        String[] arr = input.split(",");
        TreeNode root = buildTree(arr);
        System.out.println(isSym(root));
    }

    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null") || arr[0].isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0].trim()));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (i < arr.length && !arr[i].trim().equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i].trim()));
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && !arr[i].trim().equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i].trim()));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static boolean isSym(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
