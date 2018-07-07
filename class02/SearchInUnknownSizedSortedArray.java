/**
Description
Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order, determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.

Assumptions

dictionary A is not null
dictionary.get(i) will return null(Java)/INT_MIN(C++)/None(Python) if index i is out of bounds
Examples

A = {1, 2, 5, 9, ......}, T = 5, return 2
A = {1, 2, 5, 9, 12, ......}, T = 7, return -1
*/

/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {

  public int search(Dictionary dict, int target) {
    // Write your solution here
    // xxxxxxxxxxxxxxxxxxxxxxxxx|NNNNNNN
    // 1. step out ->
    // 2. step in  <-
    if (dict == null || dict.get(0) == null) return -1;
    if (dict.get(0) == target) return 0;
    int index = 1;
    while (dict.get(index) != null) {
      if (dict.get(index) == target) return index;
      else if (dict.get(index) > target) return binarySearch(dict, 0, index - 1, target);
      else index = index * 2;
    }
    // xxxxxxxxxxxxxxxxxxxxx|xXxxxxxxxNN...NNNNNN|N
    // |2   4     8          2^i-1 ...          2 ^ i
    //                     index/2              index
    return binarySearch(dict, index/2, index, target);
  }

  private int binarySearch(Dictionary dict, int left, int right, int target) {
    if (dict == null || left == right) return -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null) right = mid - 1;
      else {
        if (dict.get(mid) > target) right = mid - 1;
        else if (dict.get(mid) == target) return mid;
        else left = mid + 1;
      }
    }
    return -1;
  }

}
