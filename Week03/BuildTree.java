import org.omg.CORBA.TRANSACTION_MODE;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {
        BuildTree b = new BuildTree();
        TreeNode treeNode = b.buildTree(new int[]{9,3,4,2,7,1,8}, new int[]{4,3,2,9,1,7,8});
        System.out.println(treeNode);
    }



    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, map, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, Map<Integer, Integer> map, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootInIndex = map.get(rootVal);


        root.left = myBuildTree(preorder, map, preLeft + 1, rootInIndex - inLeft + preLeft,
                inLeft , rootInIndex - 1);
        root.right = myBuildTree(preorder, map, rootInIndex - inLeft + preLeft + 1, preRight,
                rootInIndex + 1, inRight);

        return root;
    }




}
