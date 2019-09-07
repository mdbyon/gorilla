public class MajorityElement{

  public int majorityElement(int[] nums) {
      TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

      for(int i = 0; i< nums.length; i++){
          map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
      }


      int maxOccurrences = Integer.MIN_VALUE;
      int maxKey = Integer.MIN_VALUE;

      for(Integer curr : map.keySet()){
          if(map.get(curr) > maxOccurrences){
              maxOccurrences = map.get(curr);
              maxKey = curr;
          }
      }

      return maxKey;
  }

}
