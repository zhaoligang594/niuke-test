package com.breakpoint.leetcode;

import com.breakpoint.annotation.Fail;

import java.util.PriorityQueue;

/**
 * @author breakpoint/赵先生
 * 2020/10/03
 */
@Fail
public class MedianFinder {

    private volatile int count = 0;

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(((o1, o2) -> o1 - o2));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(((o1, o2) -> o2 - o1));

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (count %2 == 0) {
            //当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {
            //当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public double findMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
//        medianFinder.addNum(4);
//        medianFinder.addNum(-1);
//        medianFinder.addNum(-2);
//        medianFinder.addNum(-3);
//        medianFinder.addNum(-4);
        //medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
