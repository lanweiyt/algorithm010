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