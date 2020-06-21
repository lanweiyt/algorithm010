//递归
public List<Integer> inorderTraversal(TreeNode root){
    if(root==null){
        return Collections.emptyList();
    }
    List<Integer> res=new ArrayList<>();
    if(root.left!=null){
        res.addAll(inorderTraversal(root.left));
    }
    res.add(root.val);
    if(root.right!=null){
        res.addAll(inorderTraversal(root.right));
    }
    return res;
}

//使用栈
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer>res=new LinkedList<>();
    Deque<TreeNode>stack=new LinkedList<>();
    while(root!=null||!stack.isEmpty()){
        if(root!=null){
            stack.push(root);
            root=root.left;
        }
        else {
            res.add(stack.peek().val);
            root=stack.pop().right;
        }
    }
    return res;
}