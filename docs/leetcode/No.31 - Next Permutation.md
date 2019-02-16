### 题目

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

`1,2,3` → `1,3,2`

`3,2,1` → `1,2,3`

`1,1,5` → `1,5,1`

### 分析

题目的意思是寻找比当前数列大的最小数列，如果当前已经是最大了，则首尾相接，下一个就是最小数列，对于最大数列存在一个特点，即当前数列中的数必然是 __非递增排序__，这种情况只需要将该数逆置即可，如果不满足这个条件，就说明肯定存在一个比当前数列更大的数，这个时候我们可以按照如下规则找到这个数：

1. 从右边往左边找到第一个不满足从右自左非递减的数 x，记录 x 的位置 i
2. 从该位置向右寻找比大于 x 的最小数 y
3. 交换 x 和 y，然后将 (i+1) 至最后的数逆置

此时已经得到我们期望的数列。

### 实现

```java
public void nextPermutation(int[] nums) {
    int i = nums.length - 1;
    for (; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            break;
        }
    }
    if (i == 0) {
        // 说明已经是最大了，逆置数组
        this.reverse(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return;
    }
    // 从i位置开始往后找比num[i]大的最小值
    int j = i + 1;
    for (; j < nums.length; j++) {
        if (nums[j] <= nums[i - 1]) {
            break;
        }
    }
    // 对调(i-1)和j处的值
    int tmp = nums[i - 1];
    nums[i - 1] = nums[j - 1];
    nums[j - 1] = tmp;
    // 将i之后的值逆置
    this.reverse(nums, i, nums.length - 1);
    System.out.println(Arrays.toString(nums));
}

/**
 * 逆置数组的指定区间
 *
 * @param nums
 * @param left
 * @param right
 */
private void reverse(int[] nums, int left, int right) {
    while (left < right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
        left++; right--;
    }
}
```