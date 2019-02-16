### Word Search II

> No.212, hard

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example, Given words = `["oath","pea","eat","rain"]` and board =

```
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
```

Return `["eat","oath"]`.

Note: You may assume that all inputs are consist of lowercase letters `a-z`.

#### 分析

相对于 I 的区别在于本题要求一次性判断多个单词，如果直接循环调用 I 的实现会超时，这里引入 __单词查找树__ 减少回溯的时间。

#### 实现

```java
/**
* 这道题目直接基于 I 的深度优先搜索会超时，这里引入单词查找树辅助实现
*
* @param board
* @param words
* @return
*/
public List<String> findWords(char[][] board, String[] words) {
   List<String> result = new ArrayList<String>();
   if (null == words || words.length == 0) return result;
   if (null == board || board.length == 0) return result;

   // 构建单词查找树
   Trie trie = new Trie();
   for (final String word : words) {
       trie.insert(word);
   }

   Set<String> set = new HashSet<String>();
   int m = board.length, n = board[0].length;
   boolean[][] visited = new boolean[m][n];
   for (int i = 0; i < m; i++) {
       for (int j = 0; j < n; j++) {
           this.dfs(board, visited, "", i, j, trie, set);
       }
   }
   result.addAll(set);
   return result;
}

private void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie, Set<String> set) {
   int m = board.length, n = board[0].length;
   if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;

   str += board[i][j];
   if (!trie.startsWith(str)) return;
   if (trie.search(str)) set.add(str);

   visited[i][j] = true;
   this.dfs(board, visited, str, i - 1, j, trie, set);
   this.dfs(board, visited, str, i + 1, j, trie, set);
   this.dfs(board, visited, str, i, j - 1, trie, set);
   this.dfs(board, visited, str, i, j + 1, trie, set);
   visited[i][j] = false;
}

/**
* 单词查找树
*/
class Trie {

   class Node {
       Node[] child = new Node[26];
       String item = "";
   }

   public Node root = new Node();

   public void insert(String word) {
       Node node = root;
       for (char c : word.toCharArray()) {
           if (node.child[c - 'a'] == null) {
               node.child[c - 'a'] = new Node();
           }
           node = node.child[c - 'a'];
       }
       node.item = word;
   }

   public boolean search(String word) {
       Node node = root;
       for (char c : word.toCharArray()) {
           if (node.child[c - 'a'] == null) {
               return false;
           }
           node = node.child[c - 'a'];
       }
       if (node.item.equals(word)) {
           return true;
       } else {
           return false;
       }
   }

   public boolean startsWith(String prefix) {
       Node node = root;
       for (char c : prefix.toCharArray()) {
           if (node.child[c - 'a'] == null) {
               return false;
           }
           node = node.child[c - 'a'];
       }
       return true;
   }
}
```
