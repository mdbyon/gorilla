import java.util.*;

public class SubArraySumK {
    public int subarraySum(int[] nums, int k) {
        //create a cumulative sum array in first pass
        //second pass, create a hashmap of <currCumulativeSum, count>
        // if(nums[curr] + exists a cumulativeSum[curr] - k in HashMap)
        //     result++

            int result = 0;
        //first pass
            int [] cumSum = new int[nums.length + 1];
            cumSum[0] = 0;
            for(int i = 0; i<nums.length; i++){
                cumSum[i + 1] = nums[i] + cumSum[i];
            }

        //second pass
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0; i<nums.length; i++){
            map.put(cumSum[i], map.getOrDefault(cumSum[i], 0) + 1);
            if(map.containsKey(nums[i] + cumSum[i] - k)){
                result+= map.get(nums[i] + cumSum[i] - k);
            }
        }
        return result;
    }
}
