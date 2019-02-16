### Two Sum

> - No.1, easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

```text
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

#### 分析

题目的意思在于给定一个数 target 和一个数组 nums，然后从数组 nums 中找到两个数之和等于 target，返回这两个数的下标（__返回一组即可__）。

- 思路一

将数组中的数散列存储到一个map中（因为数组中可能存在多个相同的值，所以建议使用一键多值map），然后从头开始遍历数组，假设当前数值为x，那么就查询map中是否存在（target - x）,如果存在则返回这两个数的下标，否则继续向前遍历。空间复杂度为O(n)，时间复杂度为O(n)。

- 思路二

先将数组按从小到大排序，然后用两个指针，一个首指针和一个尾指针，然后从两边向中间遍历。因为排序后需要记录原先对应的下标，所以空间复杂度为 O(n)，时间复杂度 `MAX(O(n), O(排序))`。

#### 实现

- 公共接口

```java
class Node implements Comparable<Node> {

        int id;
        int val;

        public Node(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(Node other) {
            return this.val - other.val;
        }

    }
```

- 思路一

```java
public int[] twoSum(int[] nums, int target) {

    int[] results = new int[2];

    // Map映射
    Map<Integer, List<Node>> nodeMap = new HashMap<Integer, List<Node>>();
    for (int i = 0; i < nums.length; i++) {
        List<Node> nodes = nodeMap.get(Integer.valueOf(nums[i]));
        if (null == nodes) {
            nodes = new ArrayList<Node>();
        }
        nodes.add(new Node(i, nums[i]));
        nodeMap.put(Integer.valueOf(nums[i]), nodes);
    }

    // 遍历寻找
    for (int i = 0; i < nums.length; i++) {
        List<Node> nodes = nodeMap.get(Integer.valueOf(target - nums[i]));
        if (null == nodes) {
            continue;
        }
        if (nodes.size() == 1) {
            Node node = nodes.get(0);
            if (node.val == nums[i]) {
                continue;
            }
            results[0] = i;
            results[1] = node.id;
        } else {
            results[0] = i;
            results[1] = nodes.get(1).id;
        }
        return results;
    }

    return results;
}
```

- 思路二（基于排序）

```java
public int[] twoSum(int[] nums, int target) {

    int[] result = new int[2];
    Node[] nodes = new Node[nums.length];

    // 重新构造数组
    for (int i = 0; i < nums.length; i++) {
        nodes[i] = new Node(i, nums[i]);
    }

    // 从小到大排序
    Arrays.sort(nodes);

    // 查找
    int left = 0, right = nums.length - 1;
    int currentVal;
    while (left < right) {
        currentVal = nodes[left].val + nodes[right].val;
        if (currentVal == target) {
            result[0] = nodes[left].id;
            result[1] = nodes[right].id;
            return result;
        } else if (currentVal < target) {
            left++;
        } else {
            right--;
        }
    }

    return result;
}
```