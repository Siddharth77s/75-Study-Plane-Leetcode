class Solution {
      public TreeNode searchBST(TreeNode root, int val) {
            TreeNode cur = root;

            while (cur != null) {
                  if (cur.val == val) {
                        return cur; // Return the current node if the value matches
                  } else if (cur.val > val) {
                        cur = cur.left; // Move to the left subtree if the value is smaller
                  } else {
                        cur = cur.right; // Move to the right subtree if the value is greater
                  }
            }

            return null; // Return null if the value is not found
      }

}