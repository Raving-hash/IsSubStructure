


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Solution {
    //对A做先序遍历，确定ROOT为A，然后开始递归
    public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A == null || B == null) return false;
            return dfs(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    //对A为B的ROOT进行递归，确定B是否为A的子树
    public boolean dfs(TreeNode A, TreeNode B ) {
            if(B == null) return true;
            if(A == null) return false;
            if(A.val != B.val){
                return false;
            }
            return dfs(A.left,B.left) && dfs(A.right,B.right);
        }


    public static void main(String[] args) {
        Solution so = new Solution();
        TreeNode A = new TreeNode(4);
        //[4,2,3,4,5,6,7,8,9]
        //[4,8,9]
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
       A.left.left = new TreeNode(4);
       A.left.right = new TreeNode(5);
        A.right.left = new TreeNode(6);
        A.right.right = new TreeNode(7);
        A.left.left.left = new TreeNode(8);
       A.left.left.right = new TreeNode(9);
        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(8);
        B.right = new TreeNode(9);
        boolean subStructure = so.isSubStructure(A, B);
        System.out.println("subStructure = " + subStructure);
    }
}