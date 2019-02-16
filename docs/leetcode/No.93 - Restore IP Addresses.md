### Restore IP Addresses

> No.93, medium

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:  
Given "25525511135",

return `["255.255.11.135", "255.255.111.35"]`. (Order does not matter)

#### 分析

题目要求将给定的一个纯数字字符串拆分成多个合法的 “点分十进制” IP 字符串。这题可以采用递归的思想来解决，同时设定一个函数来判断当前的 IP 元素是否合法，即是否在 0~255 范围之内，同时不能是以 0 开头的正数。

#### 实现

```java
private List<String> result = new ArrayList<String>();

public List<String> restoreIpAddresses(String s) {
    if (null == s || s.length() < 4 || s.length() > 12) return result;
    this.recursion(s, 0, "");
    return result;
}

private void recursion(String s, int count, String prefix) {
    if (count == 3 && this.isValid(s)) result.add(prefix.substring(1) + "." + s);
    for (int i = 0; i < 3 && i < s.length() - 1; i++) {
        String sub = s.substring(0, i + 1);
        if (this.isValid(sub)) {
            this.recursion(s.substring(i + 1, s.length()), count + 1, prefix + "." + sub);
        }
    }
}

/**
 * 判断是否是有效的 IP 元素值
 *
 * @param element
 * @return
 */
private boolean isValid(String element) {
    if (element.startsWith("0")) return element.equals("0");
    int value = Integer.parseInt(element);
    return value >= 0 && value <= 255;
}
```