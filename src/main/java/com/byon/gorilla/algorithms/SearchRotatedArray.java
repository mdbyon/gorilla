public class SearchRotatedArray{

  public SearchRotatedArray(){}

  public int search(int [] nums, int target){

    int low = 0;
    int high = nums.length - 1;

    while(low <= high){

      if(nums[low] < nums[high]) return binarySearch(nums, target, low, high);

      if(target > nums[high] && target < nums[low]) return -1;

      int mid = low + (high - low)/2;

      if(nums[mid] == target) return mid;

      if(nums[mid] < target && target > nums[low] || target < nums[low]) low = mid + 1;

      if(nums[mid] > target && target > nums[low] || target > nums[high]) high = mid - 1;

    }

    return -1;

  }

  public int binarySearch(int [] nums, int target, int low, int high){
      int lower = low;
      int higher = high;

      while(lower <= higher){
        int mid = lower + (higher - lower)/2;

        if(nums[mid] == target) return mid;

        if(target > nums[mid]){

          lower = mid + 1;
        }else{
          higher = mid - 1;
        }

      }

      return -1;
  }



}
