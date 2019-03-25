import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main(String[] args) {

        int[] tree = {3, 3, 3, 1, 2};
        totalFruit(tree);
    }

    private static int totalFruit(int[] tree) {

        int ans = 0;
        int low = 0;
        int high = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (high < tree.length) {

            map.put(tree[high], map.getOrDefault(tree[high], 0) + 1);
            high++;

            while (map.size() > 2) {
                map.put(tree[low], map.getOrDefault(tree[low], 0) - 1);
                if (map.get(tree[low]) == 0) {
                    map.remove(tree[low]);
                }
                low++;
            }
            ans = Integer.max(ans, high - low);
        }
        System.out.println(ans);
        return ans;
    }
}
