public class largestRectangleArea84 {

    /*
    跟42题收集雨水可以使用同样的方法，但是那题用了dp，这题是遍历找height，如果变大了，那么从那个位置往前遍历，找到
    当前位置area的最大值，有点BF的意思

     */



    public int largestRectanleArea(int[] heights){

        int n = heights.length;
        int minH = heights[0];
        int res = 0;
        for(int i = 0; i < n ; i++){

            if(i + 1 < n && heights[i] <= heights[i+1]){
                continue;
            }
            minH = heights[i];
            for(int j = i; j >= 0; j--){
                int len = i - j +1;
                minH = Math.min(heights[j], minH);
                int area = minH * len;
                res = Math.max(res, area);
            }

        }
        return res;
    }

}
