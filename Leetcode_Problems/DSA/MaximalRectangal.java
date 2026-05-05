class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, LargestRecArea(heights));
        }

        return maxArea;
    }

    private int LargestRecArea(int[] heights){
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= n; i++){
            int CurrentHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && CurrentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}