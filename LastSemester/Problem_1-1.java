public class Problem_1 {

    //Utility to get Size of
    private static int getSizeOfArray(long[] nums){
        return nums.length;
    }
    //Needed to do this to get row value.
    private static long calcRow(long[] nums){

        long Sum = 0;

        for(int i = 0; i < nums.length; i++){
            Sum += nums[i];
        }

        return Sum;
    }

    //Actual implementation of core problem logic
    private static long calcTotal(long[][] nums){

        long Answer = 0;

        for(int i = 0; i < nums.length; i++){
            Answer += calcRow(nums[i]);
        }

        return Answer;
    }

    private static double calcAverage(long[][] nums){

        double totalItems = 0;
        long Answer = calcTotal(nums);

        for(int i = 0; i < nums.length; i++){
            totalItems += getSizeOfArray(nums[i]);
        }

        return Answer / totalItems;
    }

    private static double calcRowAverage(long[][] nums, int row){

        double RowSize =  getSizeOfArray(nums[row]);
        double ValueOfRow = calcRow(nums[row]);

        return ValueOfRow / RowSize;
    }
    public static void main(String[] args) {
        long [] [] nums = {{1,2,3,4,5}, {6,7,8,9}, {10,11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};

        System.out.println(calcTotal(nums));
        System.out.println(calcAverage(nums));
        System.out.println(calcRowAverage(nums, 2));
    }
}