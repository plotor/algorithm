### Evaluate Reverse Polish Notation

> No.150, medium

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are `+, -, *, /`. Each operand may be an integer or another expression.

Some examples:

```
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
```

#### 分析

题目要求计算 __后缀表达式__ 的值，这是栈结构的典型应用。

#### 实现

```java
public int evalRPN(String[] tokens) {
    if (null == tokens || tokens.length == 0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (final String token : tokens) {
        if (this.isOperator(token)) {
            this.operate(token, stack);
        } else {
            stack.push(Integer.valueOf(token));
        }
    }
    return stack.pop();
}

private boolean isOperator(String str) {
    return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
}

private void operate(String operator, Stack<Integer> stack) {
    int a = stack.pop(), b = stack.pop();
    if ("+".equals(operator)) {
        stack.push(a + b);
    } else if ("-".equals(operator)) {
        stack.push(b - a);
    } else if ("*".equals(operator)) {
        stack.push(a * b);
    } else if ("/".equals(operator)) {
        stack.push(b / a);
    }
}
```
