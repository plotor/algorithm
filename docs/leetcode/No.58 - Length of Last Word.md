### Length of Last Word

> No.58, easy

Given a string s consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example,   
Given s = "Hello World", return 5.

#### 分析

这道题目比较简单，推荐从后往前遍历，遇到空字符即退出。

#### 实现

```java
public int lengthOfLastWord(String s) {
    int len = 0;
    if (s == null) {
        return len;
    }
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ' && len != 0) {
            break;
        } else if (s.charAt(i) != ' ') {
            len++;
        }
    }

    return len;
}
```