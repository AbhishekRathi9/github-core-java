import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hacher {

    public static void main(String[] args) {
        List<String> origItems = Arrays.asList("r","s","w","c");
       // List<Float> origPrices =Arrays.asList(16.89,56.92,20.89,345.99);

        ArrayList<Float> origPrices = new ArrayList<Float>();
        origPrices.add((float) 10.00);
        origPrices.add((float) 15.50);
        origPrices.add((float) 18.00);
        origPrices.add((float) 29.50);

        List<String> items = Arrays.asList("r","c");

        List<Float> prices = new ArrayList<Float>();
        prices.add((float) 10.00);
        prices.add((float) 400.89);

        System.out.println(verifyItems(origItems,origPrices,items,prices));
    }

    private static int verifyItems(List<String> origItems, ArrayList<Float> origPrices, List<String> items, List<Float> prices) {
        Map<String,Float> itemAndPriceMap = new HashMap<>();

        for(int i=0;i<origItems.size();i++){
            itemAndPriceMap.put(origItems.get(i),origPrices.get(i));
        }

        int counter=-1;
        int result=0;
        for(String item : items){
            if(itemAndPriceMap.containsKey(item)){
                counter++;
                Float origPrice = itemAndPriceMap.get(item);
                if(!origPrice.equals(prices.get(counter))){
                    result++;
                }
            }
        }
    return result;

    }
}
