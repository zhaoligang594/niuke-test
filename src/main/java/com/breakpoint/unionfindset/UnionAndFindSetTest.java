package com.breakpoint.unionfindset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 赵立刚 <zhaoligang@kuaishou.com>
 * Created on 2021-01-29
 */
public class UnionAndFindSetTest {

    public static void main(String[] args) {
        List<Integer> set = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<SetRelate<Integer>> relates = Arrays.asList(
                new SetRelate<>(1, 2),
                new SetRelate<>(1, 3),
                new SetRelate<>(2, 3),
                new SetRelate<>(2, 4),
                new SetRelate<>(3, 5)
        );
        UnionAndFindSet<Integer> unionAndFindSet = new UnionAndFindSet<>(set, relates);
        System.out.println(unionAndFindSet.isInCommonSet(4, 5));
        System.out.println(unionAndFindSet.findParent(1).getKey());
    }
}
