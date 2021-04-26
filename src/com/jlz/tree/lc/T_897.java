/**
 * @author jlz
 * @className: T_897
 * @date 2021/4/26 9:34
 * @description todo
 **/
public class T_897 {


    //* Definition for a binary tree node.
    public class TreeNode {
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
    }

    TreeNode resNode = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
        //存储头节点
        TreeNode dummyNode;
        dummyNode  =  resNode;
        traverse(root);
        return dummyNode.right;
    }

    public void traverse(TreeNode root) {
            if (root == null){
                return;
            }
//            //中序遍历
            traverse(root.left);

            resNode.right = root;
            root.left = null;
            //迭代
            resNode = root;

            traverse(root.right);
    }

    public static void main(String[] args) {
        //
    }
}


