package leetcode.recall;

public class floodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(null == image || image[0].length <= 0 )
            return image;
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColer) {
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
            return;
        if(image[sr][sc] != oldColer || image[sr][sc] == newColor)
            return;
        image[sr][sc] = newColor;
        dfs(image,sr + 1,sc,newColor,oldColer);
        dfs(image,sr - 1,sc,newColor,oldColer);
        dfs(image,sr ,sc + 1,newColor,oldColer);
        dfs(image,sr,sc - 1,newColor,oldColer);
    }
}
