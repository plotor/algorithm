### Compare Version Numbers

> No.165, medium

Compare two version numbers version1 and version2.

- If version1 > version2 return 1,
- if version1 < version2 return -1,
- otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the `.` character.
The `.` character does not represent a decimal point and is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

```
0.1 < 1.1 < 1.2 < 13.37
```

#### 分析

#### 实现

```java
public int compareVersion(String version1, String version2) {
    if (null == version1 || version1.length() == 0
            || null == version2 || version2.length() == 0) {
        return 0;
    }
    String[] items1 = version1.split("\\.");
    String[] items2 = version2.split("\\.");
    int len = Math.max(items1.length, items2.length);
    for (int i = 0; i < len; i++) {
        if (i < items1.length && i < items2.length) {
            int v1 = Integer.parseInt(items1[i]);
            int v2 = Integer.parseInt(items2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v2 > v1) return -1;
        } else if (i < items1.length) {
            if (Integer.parseInt(items1[i]) > 0) return 1;
        } else if (i < items2.length) {
            if (Integer.parseInt(items2[i]) > 0) return -1;
        }
    }
    return 0;
}
```
