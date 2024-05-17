public class Remove_LeafNode_GivenValue {

  public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

  }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
      //only if the root is not null
        if(root != null) {
            //traversing the left tree part and seting the left value
            root.left = removeLeafNodes(root.left, target);
            //traversing right tree part and seting the right value
            root.right = removeLeafNodes(root.right, target);
            //if the root is leave and its value is equal to target then return null otherwise root
            if(root.left == null && root.right == null && root.val == target){
                return null;
            }
            return root;
        }
        return null;
    }




}
