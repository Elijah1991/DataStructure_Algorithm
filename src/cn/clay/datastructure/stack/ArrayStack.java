package cn.clay.datastructure.stack;

/**
 * @author  clay
 * 使用数组模拟栈
 */
public class ArrayStack {
    private int topPoint;

    private int capacity;

    private Object [] stack;

    public ArrayStack(int maxSize){
        capacity = maxSize;
        topPoint = -1;
        stack = new Object[maxSize];
    }
    public boolean isEmpty(){
        return topPoint == -1;
    }
    public boolean isFull(){
        return topPoint == capacity - 1;
    }
    /**
     * 往栈中添加数据
     */
    public void push(Object data){
        // 先判断栈是否满
        if (isFull()){
            throw new RuntimeException("栈满,无法添加数据!");
        }
        topPoint ++;
        stack[topPoint] = data;
    }
    /**
     * 从栈中取出数据
     */
    public Object pop(){
        // 先判断栈是否为空
        if(isEmpty()){
            throw new RuntimeException("栈空,无法取出数据!");
        }
        Object data = stack[topPoint];
        topPoint --;
        return data;
    }
    /**
     * 查看栈中的数据,从栈顶开始遍历
     */
    public void showData(){
        if(isEmpty()){
            throw new RuntimeException("栈空,没有数据!");
        }
        for (int i = topPoint; i >=0; i--) {
            System.out.printf("arr[%d]=%d\n",i,stack[i]);
        }
    }
}
