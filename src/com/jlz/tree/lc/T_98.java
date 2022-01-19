package com.jlz.tree.lc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author clearlove
 * @ClassName T_98.java
 * @Description 验证二叉搜索树
 * @createTime 2021年03月24日 23:13:00
 */
public class T_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    //需要将当前节点作为限制传入
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        //左子树不可以大于当前节点值
        //右子树不可以则必须大于当前值
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        String name = "123.jpg";
        String noSuc = name.substring(0, name.indexOf("."));
        System.out.println(noSuc);
    }


    public static void copyFile(String filePathA, String filePathB) throws IOException {
        File file = new File(filePathA);
        File[] tempList = file.listFiles();
        if (!Objects.isNull(tempList)) {
            for (File tmpFile : tempList) {
                if (tmpFile.isFile()) {
                    String name = tmpFile.getName();
                    String noSuc = name.substring(0, name.indexOf("."));
                    LocalDateTime parse = LocalDateTime.parse(noSuc);
                    String newPath = filePathB + "/" + parse.getYear() + "/" + parse.getMonth() + "/" + parse.getDayOfMonth() + "/" + name;
                    Path desPath = Paths.get(newPath);
                    Files.copy(tmpFile.toPath(), desPath);
                }
            }
        }
    }
}
