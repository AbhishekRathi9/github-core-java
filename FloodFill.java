import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1;
        int sc = 1;
        int newColor = 2;

        floodFill(image, sr, sc, newColor);
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {


        if (image[sr][sc] == newColor) {
            return image;
        }

        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private static void fill(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, newColor, color);
        fill(image, sr - 1, sc, newColor, color);
        fill(image, sr, sc + 1, newColor, color);
        fill(image, sr, sc - 1, newColor, color);
    }
}
