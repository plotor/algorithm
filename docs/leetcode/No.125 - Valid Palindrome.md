### Valid Palindrome

> No.125, easy

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,

- "A man, a plan, a canal: Panama" is a palindrome.
- "race a car" is not a palindrome.

Note:  
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

#### 分析

题目的意思是给定一个字符串，忽略其中的非数字和字母字符，然后判断这个字符串是否是回文的。解题思路就是给定两个指正分别从左右往中间移动，遇到非期望字符则往前移动一格，并比较对应位置上的字符是否相同。

#### 实现

```java
if (null == s) return false;
    int i = 0, j = s.length() - 1;
    s = s.toLowerCase();
    while (i < j) {
        char left = s.charAt(i);
        if (!this.isAlphanumeric(left)) {
            ++i;
            continue;
        }
        char right = s.charAt(j);
        if (!this.isAlphanumeric(right)) {
            --j;
            continue;
        }
        if (left != right) return false;
        ++i; --j;
    }
    return true;
}

private boolean isAlphanumeric(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
}
```
