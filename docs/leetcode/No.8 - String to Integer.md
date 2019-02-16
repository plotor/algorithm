### String to Integer (atoi)

> No.8, medium

Implement atoi to convert a string to an integer.

__Hint__: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

__Notes__: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

#### 分析

该题主要考察点在于是否仔细，需要注意以下几点：

> 1. 忽略首尾的空字符
> 2. 以唯一一个 “+” 或 “-” 开头字符串视为正常输入
> 3. 内部若有非数字字符，直接break
> 4. 越界

java 中的 String 的长度仅受内存大小限制，但是实现方面并不需要用 BigDecimal 来应对这种情况，可以在每次转换之后检查一下是否已经整数越界，这样利用 long 即可。

#### 实现

```java
public int myAtoi(String str) {
    if (null == str || str.matches("^\\s*$")) {
        return 0;
    }

    // 预处理
    str = str.trim();
    boolean isNeg;
    if (str.startsWith("+")) {
        isNeg = false;
        str = str.substring(1);
    } else if (str.startsWith("-")) {
        isNeg = true;
        str = str.substring(1);
    } else {
        isNeg = false;
    }

    long l = 0;  // long即可，检测到整数越界直接break
    for (int i = 0; i < str.length(); i++) {
        String s = String.valueOf(str.charAt(i));
        if (s.matches("[0-9]") && l <= Integer.MAX_VALUE) {
            l = l * 10 + Long.parseLong(s);
        } else {
            break;
        }
    }

    l = isNeg ? -l : l;
    int result;
    if (isNeg) {
        result = l < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) l;
    } else {
        result = l > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
    }

    return result;
}
```
