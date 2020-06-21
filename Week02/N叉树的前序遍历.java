//递归
public List<Integer> preorder(Node root) {
    List<Integer> res = new ArrayList<>();
    if (root != null) {
        res.add(root.val);
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                res.addAll(preorder(root.children.get(i)));
            }
        }
    }
    return res;
}

//栈
public List<Integer> preorder(Node root) {

    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
        return output;
    }

    stack.add(root);
        while (!stack.isEmpty()) {
        Node node = stack.pollLast();
        output.add(node.val);
        Collections.reverse(node.children);
        for (Node item : node.children) {
            stack.add(item);
        }
    }
    return output;

}