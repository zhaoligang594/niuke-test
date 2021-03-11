package com.breakpoint.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2021-03-08
 */
public class LruCacheTest {

    public static void main(String[] args) {
        LruCache<String, String> lruCache = new LruCache<>(3);
        lruCache.put("1", "1");
        lruCache.put("2", "2");
        lruCache.put("3", "3");
        lruCache.put("4", "4");
        String value = lruCache.getValue("1");
        System.out.println(1);
    }

    public static final class LruCache<K, V> {

        private final Map<K, Node<K, V>> map = new ConcurrentHashMap<>();

        private final Node<K, V> head;
        private final Node<K, V> tail;

        private final int maxSize;

        public LruCache(int maxSize) {
            this.maxSize = maxSize;
            head = new Node<K, V>(null, null);
            tail = new Node<K, V>(null, null);
            head.next = tail;
            tail.pre = head;
        }

        public void put(K key, V value) {
            Node<K, V> kvNode = map.get(key);
            if (null == kvNode) {
                if (maxSize < map.size() + 1) {
                    // 超过了最大的空间
                    Node<K, V> tail = this.tail.pre;
                    this.tail.pre = tail.pre;
                    tail.pre.next=this.tail;
                    map.remove(tail.key);
                }
                Node<K, V> cur = new Node<>(key, value);
                map.put(key, cur);
                head.next.pre = cur;
                cur.next = head.next;
                head.next = cur;
                cur.pre = head;
            } else {
                // 提前
                Node<K, V> pre = kvNode.pre;
                pre.next = kvNode.next;
                kvNode.next.pre = pre;
                // 插入开始位置
                head.next.pre = kvNode;
                kvNode.next = head.next;
                head.next = kvNode;
                kvNode.pre = head;
                // 更新对象
                kvNode.value = value;
            }
        }

        public V getValue(K key) {
            Node<K, V> kvNode = map.get(key);
            if (null != kvNode) {
                // 提前
                Node<K, V> pre = kvNode.pre;
                pre.next = kvNode.next;
                kvNode.next.pre = pre;
                // 插入开始位置
                head.next.pre = kvNode;
                kvNode.next = head.next;
                head.next = kvNode;
                kvNode.pre = head;
                return kvNode.value;
            }
            return null;
        }

        private final class Node<T, V> {

            private T key;
            private V value;

            private Node<K, V> pre;
            private Node<K, V> next;

            public Node(T key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
