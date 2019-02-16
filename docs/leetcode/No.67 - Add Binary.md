### Add Binary

> No.67, easy

Given two binary strings, return their sum (also a binary string).

For example,

a = `"11"`

b = `"1"`

Return `"100"`.

#### 分析

题目意思就是计算二进制sum，思路没啥好说的，属于细节题。

#### 实现

```java
public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int carry = 0;
    int i = a.length() - 1, j = b.length() - 1;
    for (; i >= 0 && j >= 0; i--, j--) {
        if (carry == 1) {
            // 有进位
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                result.insert(0, '1');
                carry = 1;
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                result.insert(0, '0');
                carry = 1;
            } else {
                result.insert(0, '1');
                carry = 0;
            }
        } else {
            // 无进位
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                result.insert(0, '0');
                carry = 1;
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                result.insert(0, '1');
                carry = 0;
            } else {
                result.insert(0, '0');
                carry = 0;
            }
        }
    }

    while (i >= 0) {
        if (carry == 1) {
            if (a.charAt(i) == '1') {
                result.insert(0, '0');
                carry = 1;
            } else {
                result.insert(0, '1');
                carry = 0;
            }
        } else {
            if (a.charAt(i) == '1') {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
        }
        i--;
    }

    while (j >= 0) {
        if (carry == 1) {
            if (b.charAt(j) == '1') {
                result.insert(0, '0');
                carry = 1;
            } else {
                result.insert(0, '1');
                carry = 0;
            }
        } else {
            if (b.charAt(j) == '1') {
                result.insert(0, '1');
            } else {
                result.insert(0, '0');
            }
        }
        j--;
    }
    // 处理最后一次进位
    if (carry == 1) result.insert(0, '1');
    return result.toString();
}
```