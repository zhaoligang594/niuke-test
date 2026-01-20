package leetcode2025;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/05
 */
public class Solution208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode((char) -11);
    }

    public void insert(String word) {
        insert(root, word);
    }

    private void insert(TrieNode root, String word) {
        if (word == null || word.isEmpty()) return;
        char c = word.charAt(0);
        TrieNode node = new TrieNode(c);
        boolean isEnd = false;
        if (word.length() == 1) {
            isEnd = true;
        }
        if (null == root.children[c - 'a']) {
            root.children[c - 'a'] = node;
        }
        root.children[c - 'a'].isEnd = isEnd||root.children[c - 'a'].isEnd;
        insert(root.children[c - 'a'], word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word == null || word.isEmpty()) return false;
        char c = word.charAt(0);
        if (null == root.children[c - 'a']) {
            return false;
        } else {
            if (word.length() == 1 && root.children[c - 'a'].isEnd) {
                return true;
            } else {
                return search(root.children[c - 'a'], word.substring(1));
            }
        }
    }

    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }

    private boolean startsWith(TrieNode root, String word) {
        if (word == null || word.isEmpty()) return true;
        char c = word.charAt(0);
        if (null == root.children[c - 'a']) {
            return false;
        } else {
            if (word.length() == 1) {
                return true;
            } else {
                return startsWith(root.children[c - 'a'], word.substring(1));
            }
        }
    }

    public static final class TrieNode {
        char ch;
        boolean isEnd;
        TrieNode[] children = new TrieNode[26];

        public TrieNode(char ch) {
            this.ch = ch;
        }
    }
}
