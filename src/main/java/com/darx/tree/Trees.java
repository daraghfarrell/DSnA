package com.darx.tree;

import java.util.ArrayList;
import java.util.List;

public class Trees {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {
        if(root != null) {
            // root
            result.add(Integer.valueOf(root.val));

            // left
            preorder(root.left, result);

            // right
            preorder(root.right, result);
        }
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorder(root, ret);
        return ret;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.val);
        }
    }



}
