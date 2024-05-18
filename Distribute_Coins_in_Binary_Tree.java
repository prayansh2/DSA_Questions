public class Distribute_Coins_in_Binary_Tree {

    public static int ans=0;

    //tree class
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        //doing a Depth First Search in Tree
        public int dfs(TreeNode root) {
            if (root == null) return 0;
            //traverse left side and get require value of that node and its childern
            int leftrequire = dfs(root.left);
            //traverse right side and get require value of that node and its childern
            int rightrequire = dfs(root.right);
//            for geeting answer add the absolute value of left and right because the value might be negative somwtimes
            ans += Math.abs(leftrequire) + Math.abs(rightrequire);
            //return the value just keep one for self and its chile requirement
            return (root.val - 1) + leftrequire + rightrequire;
        }

        public int distributeCoins(TreeNode root) {
            dfs(root);
            return ans;
        }
    }

}
