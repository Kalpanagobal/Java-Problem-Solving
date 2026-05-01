class Solution {
    public int totalFruit(int[] fruits) {
        int last = -1;
        int secondLast = -1;

        int lastCount = 0;
        int currMax = 0;
        int max = 0;

        for(int fruit : fruits){

            
            if(fruit == last || fruit == secondLast){
                currMax++;
            } else {
                currMax = lastCount + 1;
            }

            
            if(fruit == last){
                lastCount++;
            } else {
                lastCount = 1;
            }

            
            if(fruit != last){
                secondLast = last;
                last = fruit;
            }

            
            max = Math.max(max, currMax);
        }

        return max;
    }
}