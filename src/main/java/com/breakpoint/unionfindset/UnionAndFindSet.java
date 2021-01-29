package com.breakpoint.unionfindset;

import java.util.*;

/**
 * 并查集的相关操作
 *
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-29
 */
public class UnionAndFindSet<T> {

    /**
     * 创建并查集
     *
     * @param keys    数据集合
     * @param relates 数据之间的关系
     */
    public UnionAndFindSet(List<T> keys, List<SetRelate<T>> relates) {
        if (null != keys && keys.size() > 0) {
            unionCount = keys.size();
            for (T key : keys) {
                SetElement<T> element = new SetElement<>(key, 1);
                // 设置初始的情况
                unionMap.put(element, element);
            }
        }

        if (null != relates && relates.size() > 0) {
            for (SetRelate<T> relate : relates) {
                // 后面是前面的父节点
                SetElement<T> key1 = new SetElement<>(relate.getKey1(), 1);
                SetElement<T> key2 = new SetElement<>(relate.getKey2(), 1);
                // 找到父节点
                SetElement<T> parent1 = this.findParent(key1);
                SetElement<T> parent2 = this.findParent(key2);
                if (!parent1.equals(parent2)) {
                    this.unionMap.put(parent1, parent2);
                    parent2.setCount(parent2.getCount() + parent1.getCount());
                    unionCount--;
                }
            }
        }
    }

    // 并查集的缓存 key child value parent
    private final Map<SetElement<T>, SetElement<T>> unionMap = new HashMap<SetElement<T>, SetElement<T>>();
    // 集合的数量
    private Integer unionCount;

    // 找到最顶层的父节点
    public SetElement<T> findParent(SetElement<T> childElem) {
        // 判断是否是父节点
        if (!unionMap.get(childElem).equals(childElem)) {
            SetElement<T> parent = this.findParent(unionMap.get(childElem));
            unionMap.put(childElem, parent);
            return parent;
        } else {
            return childElem;
        }
    }

    // 找到最顶层的父节点
    public SetElement<T> findParent(T elem) {
        SetElement<T> key = new SetElement<>(elem, 1);
        return this.findParent(key);
    }

    // 查看是否在同一个集合里面
    private boolean isInCommonSet(SetElement<T> elemA, SetElement<T> elemB) {
        SetElement<T> parentA = this.findParent(elemA);
        SetElement<T> parentB = this.findParent(elemB);
        return parentA.equals(parentB);
    }

    // 是否在一个集合中
    public boolean isInCommonSet(T elemA, T elemB) {
        return this.isInCommonSet(new SetElement<>(elemA, 1), new SetElement<>(elemB, 1));
    }
}

// 两个之间的关系
class SetRelate<T> {
    private T key1;
    private T key2;

    public SetRelate(T key1, T key2) {
        this.key1 = key1;
        this.key2 = key2;
    }

    public T getKey1() {
        return key1;
    }

    public void setKey1(T key1) {
        this.key1 = key1;
    }

    public T getKey2() {
        return key2;
    }

    public void setKey2(T key2) {
        this.key2 = key2;
    }
}

// 并查集的基本元素
// 其中 key 要实现 equals 和 hashCode 的方法 供我们进行使用
class SetElement<T> {
    private T key; // 并查集的key
    private Integer count; // 并查集的数量

    public SetElement(T key, Integer count) {
        this.key = key;
        this.count = count;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetElement<T> that = (SetElement<T>) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
