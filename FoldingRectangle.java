
import java.util.*;

public class FoldingRectangle {

    // how many folds needed
    private static int foldingSheet(int a, int b) {
        if (a <= b) {
            return 0;
        }
        int count = 0;
        while (a > b) {
            a = (a + 1) / 2;
            count++;
        }
        return count;
    }

    // Calculate the minimum number of folds required to transform a rectangle of size h x w into a rectangle of size h1 x w1
    public static int minFolds(int h, int w, int h1, int w1) {
        int ans = Integer.MAX_VALUE;
        if (h1 <= h && w1 <= w) {
            ans = Math.min(ans, foldingSheet(h, h1) + foldingSheet(w, w1));
        }
        if (w1 <= h && h1 <= w) {
            ans = Math.min(ans, foldingSheet(h, w1) + foldingSheet(w, h1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("The initial height of the rectangle : ");
        int h = sc.nextInt();
        System.out.print("The initial width of the rectangle : ");
        int w = sc.nextInt();
        System.out.print("The final height of the rectangle : ");
        int h1 = sc.nextInt();
        System.out.print("The final width of the rectangle : ");
        int w1 = sc.nextInt();
        // Calculate the minimum number of folds required
        int result = minFolds(h, w, h1, w1);
        System.out.println("Minimum number of folds required : " + result);
        sc.close();
    }
}
