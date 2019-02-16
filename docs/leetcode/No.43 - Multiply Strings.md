### 题目

Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`.

Note:

1. The length of both num1 and num2 is < 110.
2. Both num1 and num2 contains only digits 0-9.
3. Both num1 and num2 does not contain any leading zero.
4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

### 分析

题目的意思是给定两个由非负数字构成的字符串，计算两个字符串所表示的整数的积。不允许用 BigInteger，也不能转换成整型再计算。

上述条件卡死了直接利用乘法计算两数和的念头，这个时候我们就需要逐位做乘法，再求和，考虑数字 135 × 246 的计算过程：

0 | 1 | 2 | 3 | 4 | 5
-- | --| -- | -- | -- | ---
| | |   | 1 | 3 | 5
| | | × | 2 | 4 | 6
| | |   |   |   |
| | |   | 6×1=6 | 6×3=18 | 6×5=30
| | | 4×1=4 | 4×3=12 | 4×5=20 |	
| | 2×1=2 | 2×3=6 | 2×5=10 | |		
| | 2 | 10 | 28 | 38 | 30
| | | | |38+3=41 | 0
| | | | 28+4=32 | 1 |	
| | | 10+3=13 | 2 | |		
| | 2+1=3 | 3 | | |			
| |3 | 3 | 2 | 1 | 0

看懂上面表格中的计算过程，也就明白了这道题的解法。

### 实现

```java
public String multiply(String num1, String num2) {
    int length = num1.length() + num2.length();
    int[] sum = new int[length];
    Arrays.fill(sum, 0);
    // 这里的逻辑就是日常笔算陈法的过程
    for (int i = num1.length() - 1; i >= 0; i--) {
        for (int j = num2.length() - 1; j >= 0; j--) {
            sum[i + j + 1] += (num1.charAt(i) - 48) * (num2.charAt(j) - 48);
        }
    }

    // System.out.println(Arrays.toString(sum));
    // 处理进位
    int carry = 0;
    for (int i = length - 1; i >= 0; i--) {
        sum[i] += carry;
        carry = sum[i] / 10;
        sum[i] %= 10;
    }

    // 去掉开头的0
    boolean flag = false;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
        if (sum[i] == 0 && !flag) {
            continue;
        }
        sb.append(sum[i]);
        flag = true;
    }
    return sb.length() == 0 ? "0" : sb.toString();
}
```