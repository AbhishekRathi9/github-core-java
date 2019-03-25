import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Knapsack {

    public static void main(String[] args) {
        int numItems = 7;
        int maxCapacity=15;
        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        int[] profit = {10, 5, 15, 7, 6, 18, 3};
         DecimalFormat df2 = new DecimalFormat(".##");
        PriorityQueue<WeightProfitInfo> queue = new PriorityQueue<>(new Comparator<WeightProfitInfo>() {
            @Override
            public int compare(WeightProfitInfo o1, WeightProfitInfo o2) {
                return Double.compare(o2.getProfitWeightRatio(),o1.getProfitWeightRatio());
            }
        });

        for (int i = 0; i < numItems; i++) {

            queue.add(new WeightProfitInfo(weight[i],profit[i],(double)profit[i]/weight[i]));
        }

        double maxProfit =0;
        while(!queue.isEmpty() && maxCapacity>0){

            WeightProfitInfo info = queue.poll();
            if(maxCapacity-info.getWeight()<0){
                info.setWeight(maxCapacity);
                System.out.println("pri");
                System.out.println(maxCapacity);
            }
            maxProfit=maxProfit+(info.getProfitWeightRatio()*info.getWeight());
            maxCapacity=maxCapacity-info.getWeight();
        }
        System.out.println(maxProfit);

    }

    static class WeightProfitInfo {

        private int weight;
        private int profit;
        private double profitWeightRatio;

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }

        public double getProfitWeightRatio() {
            return profitWeightRatio;
        }

        public void setProfitWeightRatio(int profitWeightRatio) {
            this.profitWeightRatio = profitWeightRatio;
        }

        public WeightProfitInfo(int weight, int profit, double profitWeightRatio) {
            this.weight = weight;
            this.profit = profit;
            this.profitWeightRatio = profitWeightRatio;
        }
    }
}
