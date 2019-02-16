### Longest Valid Parentheses

> No.32, hard

Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

For `"(()"`, the longest valid parentheses substring is `"()"`, which has length = 2.

Another example is `")()())"`, where the longest valid parentheses substring is `"()()"`, which has length = 4.

#### 分析

题目的意思是给定一个由 `(` 和 `)` 组成的字符串，返回其中满足括号匹配的最长子串的长度。可以用动态规划的思想，不过这里还有更简单的方法，这种括号匹配肯定需要用到栈数据结构，我们定义一个类来记录当前字符和其对应的序号：

```java
private class Pair {
    char c;
    int index;

    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
```

然后从左到右遍历一遍字符串，依次处理每个字符：

1. 如果当前字符是 `(`，则直接入栈
2. 如果当前字符时 `)`，则分情况讨论：
> 1. 当前栈顶是 `(` 则出栈，`max = Math.max(max, i - stack.peek().index)`；
> 2. 否则 `stack.push(new Pair(')', i))`

#### 实现

```java
public int longestValidParentheses(String s) {
    Stack<Pair> stack = new Stack<Pair>();
    stack.push(new Pair(' ', -1));
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            // 如果是左括号，则直接入栈
            stack.push(new Pair('(', i));
        } else {
            // 如果是右括号
            if ('(' == stack.peek().c) {
                // 当前栈顶是“(”
                stack.pop();
                max = Math.max(max, i - stack.peek().index);
            } else {
                stack.push(new Pair(')', i));
            }
        }
    }
    return max;
}

private class Pair {
    char c;
    int index;

    public Pair(char c, int index) {
        this.c = c;
        this.index = index;
    }
}
```

更加精简的实现，不需要 `Pair` 数据结构：

```java
public int longestValidParentheses(String s) {
    int index = 0;
    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            // 如果是左括号，则直接入栈
            stack.push(i);
        } else {
            // 如果是右括号
            if (stack.isEmpty()) {
                index = i + 1;
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - index + 1);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
    }
    return max;
}
```