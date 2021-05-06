package com.breakpoint.leetcode;

import com.breakpoint.annotation.Success;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 341. 扁平化嵌套列表迭代器
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/submissions/
 */

@Success
public class Solution341 {

    public static void main(String[] args) {

    }


}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {

    private int offset;

    private List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = new ArrayList<>();
        build(nestedList);
    }

    private void build(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                this.list.add(nestedInteger.getInteger());
            } else {
                build(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        offset++;
        return list.get(offset - 1);
    }

    @Override
    public boolean hasNext() {
        return offset < this.list.size();
    }
}
