

public class InvertBinaryTree {

  class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
  }
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            return root;
    }
}
