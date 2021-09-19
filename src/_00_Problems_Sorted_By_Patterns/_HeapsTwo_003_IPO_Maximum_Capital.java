/* [ _TwoHeap_003_I ] [ IPO - find maximum capital ]
_______________________________________________________________________________
Initially, you have w capital. When you finish a project, you will obtain its pure profit and
the profit will be added to your total capital.
Pick a list of at most k distinct projects from given projects to maximize your final capital,
and return the final maximized capital.
Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
Output: 4
Explanation: Since your initial capital is 0, you can only start the project indexed 0.
After finishing it you will obtain profit 1 and your capital becomes 1.
With capital 1, you can either start the project indexed 1 or the project indexed 2.
Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
Idea: Basic Idea : how you will find all the project can be done using capital and if there are multiple projects
can be start with using capital how to pick the project which gives maxProfit

Time Complexity: For worst case, each project will be inserted and polled from both PriorityQueues once,
so the overall runtime complexity should be O(NlogN), N is number of projects.
*/
package _00_Problems_Sorted_By_Patterns;

import java.util.PriorityQueue;

public class _HeapsTwo_003_IPO_Maximum_Capital {
    /* Algorithm: O(NlogN), N is number of projects.
        1. Create (capital, profit) pairs and put them into PriorityQueue pqCap. This PriorityQueue sort by capital increasingly.
        2. poll all the pairs from pqCap which is lessThanEqual Capital. Put them into PriorityQueue pqPro which sort by profit decreasingly.
        3. Poll one from pqPro, it's guaranteed to be the project with max profit and within current capital capability. Add the profit to capital W.
        4. Repeat step 2 and 3 till finish k steps or no suitable project (pqPro.isEmpty()).
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //two pq
        PriorityQueue<pair> pqCapital = new PriorityQueue<>((a,b) -> a.capital-b.capital);//minCap first
        PriorityQueue<pair> pqProfit  = new PriorityQueue<>((a,b) -> b.profit-a.profit);//maxProfit first
        //profits = [1,2,3], capital = [0,1,1]
        //step1: put all the projects in pqCapital (min capital needs to start project first)
        for(int i =0; i < capital.length; i++){
            pqCapital.offer(new pair(capital[i], profits[i]));
        }

        //step 2: remove all pairs from pqCap which are lessThanEqualTo w and add to pqProfit
        while(k-->0){
            while(pqCapital.size()!=0 && pqCapital.peek().capital <= w){
                pqProfit.offer(pqCapital.poll());
            }
            //get the firs one from pqProfit as 1stOne will give the maxProfit with current capital
            if(pqProfit.size()==0) break;
            w+=pqProfit.poll().profit;
        }
        return w;
    }
    static class pair{
        int capital;
        int profit;
        public pair(int capital, int profit){
            this.capital = capital;
            
        }
    }

    public static void main(String[] args) {
        int[] profits = new int[]{1,2,3};
        int[] capitals = new int[]{0,1,1};
        int k=2;
        int w=0;
        System.out.println(findMaximizedCapital(k, w, profits, capitals));
    }


}
