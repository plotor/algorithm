### Decode String

> No.394, medium

Given an encoded string, return it's decoded string.

The encoding rule is: `k[encoded_string]`, where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like `3a` or `2[4]`.

Examples:

```
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
```

#### 分析

这是典型的对字符串进行解压缩的题目，这种类型的字符串组织应该马上想到 __栈__ 这个数据结构。

基本思路就是 __采用两个栈__，一个用来存放重复的次数，一个用来存放下一次重复操作的字符串片段。然后遇到 “[” 时执行入栈操作，遇到 “]” 时执行出栈操作。需要注意的是计算重复次数时可能存在超过个位数的情况。

#### 实现

```java
public String decodeString(String s) {
    StringBuilder decoded = new StringBuilder();
    Stack<String> ss = new Stack<String>(); // 存放字符串片段
    Stack<Integer> si = new Stack<Integer>(); // 存放重复的次数
    int index = 0;
    while (index < s.length()) {
        char c = s.charAt(index);
        if (c >= '0' && c <= '9') {
            // 当前为数字
            int count = 0;
            while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                count = count * 10 + (s.charAt(index) - '0');
                index++;
            }
            si.push(count);
        } else if ('[' == c) {
            // 如果是 '[' 则将对应的字符串入栈
            ss.push(decoded.toString());
            decoded = new StringBuilder();
            index++;
        } else if (']' == c) {
            // 如果是 ']' 则执行出栈拼接操作
            int repeat = si.pop();
            StringBuilder sb = new StringBuilder(ss.pop());
            for (int i = 0; i < repeat; i++) {
                sb.append(decoded);
            }
            decoded = sb;
            index++;
        } else {
            // 拼接字符串
            decoded.append(c);
            index++;
        }
    }
    return decoded.toString();
}
```
