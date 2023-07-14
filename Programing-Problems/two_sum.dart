// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order

class Solution {
  List<int> twoSum(List<int> nums, int target) {
  var map = <int, int>{};
  for (int i = 0; i < nums.length; i++) {
    var complement = target - nums[i];
    if (map.containsKey(complement)) {
      return [map[complement]!, i];
    } else {
      map[nums[i]] = i;
    }
  }
  return [];
}
}
