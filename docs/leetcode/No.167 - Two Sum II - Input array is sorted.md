### Two Sum II - Input array is sorted

> No.167, easy

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

> - Input: numbers={2, 7, 11, 15}, target=9
> - Output: index1=1, index2=2

#### 分析

这道题是 I 的简化版，输入的数组已经是有序的，所以不需要再进行排序，直接用两个指针由两端向中间遍历即可，因为数组已经是有序的，所以数组的下标就是我们期望的返回值，不需要再另外定义数据结构。

#### 实现

```java
public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int left = 0, right = numbers.length - 1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            result[0] = left + 1;
            result[1] = right + 1;
            break;
        }
    }
    return result;
}
```