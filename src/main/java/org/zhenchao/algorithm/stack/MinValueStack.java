package org.zhenchao.algorithm.stack;

import org.zhenchao.algorithm.common.Stack;

/**
 * 设计一个具备 getMin 功能的栈
 *
 * 思路：
 * 可以用两个栈来实现，一个栈和普通栈一样存储数据，另外一个栈则用来存储栈中所有元素的最小值
 *
 * @author zhenchao.wang 2017-04-23 15:29
 * @version 1.0.0
 */
public class MinValueStack extends Stack<Integer> {

    /** 存放普通栈元素 */
    private Stack<Integer> data;

    /** 存放栈中元素的最小值 */
    private Stack<Integer> min;

    public MinValueStack() {
        this.data = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    /**
     * 入栈
     *
     * @param value
     */
    @Override
    public void push(Integer value) {
        data.push(value);
        if (min.isEmpty()) {
            min.push(value);
        } else {
            if (value <= min.peek()) {
                min.push(value);
            }
        }
    }

    /**
     * 出栈
     *
     * @return
     */
    @Override
    public Integer pop() {
        int value = data.pop();
        if (value == min.peek()) {
            min.pop();
        }
        return value;
    }

    /**
     * 获取当前栈最小值
     *
     * @return
     */
    public Integer getMin() {
        return min.peek();
    }

}
