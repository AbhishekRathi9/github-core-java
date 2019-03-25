import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSchedule {

    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList
                (new Job(1, 9, 15), new Job(2, 2, 2),
                        new Job(3, 5, 18), new Job(4, 7, 1),
                        new Job(5, 4, 25), new Job(6, 2, 20),
                        new Job(7, 5, 8), new Job(8, 7, 10),
                        new Job(9, 4, 12), new Job(10, 3, 5)
                );

        jobs.sort((a, b) -> b.getDuration() - a.getDuration());
        int maxDuration = jobs.get(0).getDuration();
        jobs.sort((a, b) -> b.getProfit() - a.profit);

        int[] slots = new int[maxDuration];
        int profit = 0;
        for (int i = 0; i < jobs.size(); i++) {
            int duration = jobs.get(i).getDuration();
            if (slots[duration - 1] == 0) {
                slots[duration - 1] = jobs.get(i).profit;
                profit = profit + jobs.get(i).profit;
            } else {
                int temp = duration - 1;
                while (temp >= 0 && slots[temp] != 0) {
                    temp--;
                }
                if (temp != -1) {
                    slots[temp] = jobs.get(i).profit;
                    profit = profit + jobs.get(i).profit;
                }
            }
        }

        System.out.println(profit);
    }

    static class Job {

        private int jobId;
        private int duration;
        private int profit;

        public Job(int jobId, int duration, int profit) {
            this.jobId = jobId;
            this.duration = duration;
            this.profit = profit;
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getProfit() {
            return profit;
        }

        public void setProfit(int profit) {
            this.profit = profit;
        }
    }
}
