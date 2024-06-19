package leetcode.binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HCodec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return se(root,new StringBuilder()).toString();
    }

    private StringBuilder se(TreeNode root,StringBuilder str) {
        if (null == root) {
           str.append("None,");
        }else{
            str.append(root.val);
            str.append(",");
            str = se(root.left,str);
            str = se(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return  de(dataList);
    }

    private TreeNode de(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = de(dataList);
        root.right = de(dataList);
        return root;
    }
    public static void main(String[] args){
        HCodec q = new HCodec();
        TreeNode deserialize = q.deserialize("1,2,3,None,None,4,None,None,5,None,None");
        String serialize = q.serialize(deserialize);
        System.out.println(serialize);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
