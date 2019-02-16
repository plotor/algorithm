### Valid Parentheses

> No.20, easy

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

#### 分析

简单的判定括号是否匹配的题目，在数据结构的课程上一般都会有，借助 __栈__ 实现。

#### 实现

```java
public boolean isValid(String s) {
    if (null == s || "".equals(s) || s.length() == 1) {
        return false;
    }

    Set<Character> left = new HashSet<Character>() {
        {
            add('{'); add('('); add('[');
        }
    };

    Map<Character, Character> pair = new HashMap<Character, Character>() {
        {
            put('{', '}'); put('(', ')'); put('[', ']');
        }
    };

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (left.contains(c)) {
            stack.add(c);
            continue;
        }

        if (stack.size() == 0 || !pair.get(stack.pop()).equals(c)) {
            return false;
        }

    }

    return stack.size() == 0 ? true : false;
}
```
