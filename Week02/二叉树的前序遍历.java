//递归
public List<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
        return Collections.emptyList();
    }
    List<Integer> res = new ArrayList<>();
    res.add(root.val);
    if (root.left != null) {
        res.addAll(preorderTraversal(root.left));
    }

    if (root.right != null) {
        res.addAll(preorderTraversal(root.right));
    }

    return res;
}

//使用栈
public List<Integer> preorderTraversal(TreeNode root) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();
    if (root == null) {
        return res;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
        TreeNode node = stack.pollLast();
        res.add(node.val);
        if (node.right != null) {
            stack.add(node.right);
        }
        if (node.left != null) {
            stack.add(node.left);
        }
    }
    return res;
}