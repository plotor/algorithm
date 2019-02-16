### ZigZag Conversion

> No.6, medium

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`
Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string text, int nRows);
```

`convert("PAYPALISHIRING", 3)` should return `"PAHNAPLSIIGYIR"`.

#### 分析

这道题目是一道找规律的题目，只要找到每一行分布的字符在原字符串中对应的下标即可。

假设我们有25个字符，然后分成6行排列，对应的下标分布如下： 

![image](https://github.com/procyon-lotor/procyon-lotor.github.io/blob/master/images/2016/leetcode-6-1.png?raw=false)

左边图经过转换之后可以得到右边的图，这样就将垂直列作为一列（绿色），斜对角列作为一列（黄色），我们可以分开来处理上图中绿色列（奇数列）的坐标和黄色列（偶数列）的坐标：

```
以i表示行坐标，j表示列坐标
奇数列：i + (numRows - 1) * j
偶数列：i + (numRows - 1) * (j + 1) - 2 * i
```

#### 实现

```java
public String convert(String s, int numRows) {

    if(numRows == 1) {
        return s;
    }

    StringBuilder sb = new StringBuilder();

    // 顺序存放下标
    int[] indexs = new int[s.length()];

    int n = 0;
    for(int i = 0; i < numRows; i++) {
        // 一行一行来
        for(int j = 0; ; j++) {
            // 计算每个列的下标值
            if(j % 2 == 0) {
                // 偶数列
                int index = i + (numRows - 1) * j;
                if(index >= s.length()) {
                    break;
                }
                indexs[n++] = index;
            } else if(i > 0){
                // 奇数列
                int index = i + (numRows - 1) * (j + 1) - 2 * i;
                if(index >= s.length()) {
                    break;
                }
                if(index > indexs[n - 1]) {
                    indexs[n++] = index;
                }
            }
        }

    }

    for (final int i : indexs) {
        sb.append(s.charAt(i));
    }

    return sb.toString();

}
```

空间复杂度O(len(s))，时间复杂度O(len(s))