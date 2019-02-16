### Simplify Path

> No.71, medium

Given an absolute path for a file (Unix-style), simplify it.

For example,

path = `"/home/", => "/home"`

path = `"/a/./b/../../c/", => "/c"`

#### 分析

属于细节题，主要考虑两点：

1. 当计算得到的路径已经前置溢出时，即已经在根路径之前时，直接以 “/” 代替
2. 如果存在多个联系的路径分隔符，则等同于一个

#### 实现

```java
public String simplifyPath(String path) {
    // 格式化处理
    path = path.replaceAll("/+", "/");
    if (path.length() > 1 && path.endsWith("/")) path = path.substring(0, path.length() - 1);

    // 遍历处理每个元素
    String[] elements = path.substring(1).split("/");
    List<String> list = new ArrayList<String>();
    for (final String element : elements) {
        if (".".equals(element)) continue;
        if ("..".equals(element)) {
            if (list.size() == 0) {
                // 当前置溢出时，算作“/”
                continue;
            }
            list.remove(list.size() - 1);
        } else {
            list.add(element);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (final String str : list) {
        sb.append(str).append("/");
    }
    return "/" + (sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "");
}
```