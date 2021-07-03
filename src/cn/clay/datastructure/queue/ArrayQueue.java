package cn.clay.datastructure.queue;

/**
 * 使用数组模拟队列
 * @author: clay
 * @date: 2021/07/03  15:32
 * @description:
 */
public class ArrayQueue {

    // 队列的最大容量,即能存放数据个数的最大值
    private int maxSize;

    // 数组,用来模拟队列里存放数据的
    private int[] arr;

    // 队列的头指针,随着数据的取出而改变
    private int head;

    // 队列的尾指针,随着数据的放入而改变
    private int tail;

    public ArrayQueue(int queueSize){

        // 队列的容量可以根据传入的queueSize灵活改变
        maxSize = queueSize;

        // 队列能存放多少个值,那么数组的长度就是多少
        arr = new int[queueSize];

        // 初始化头指针
        head = -1;

        // 初始化尾指针
        tail = -1;
    }
    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        // 初始化的时候它们的值都为-1
        return head == tail;
    }
    /**
     * 判断队列是否满了
     */
    public  boolean isFull(){
        /**
         *  数组的最大索引值是数组长度-1,
         *  所以当尾指针指向数组的最大索引处时则表示队列满
         */
        return tail == maxSize - 1;
    }
    /**
     * 向队列中添加数据
     */
    public void addDataToQueue(int data){
        // 添加元素之前先判断队列是否已满
        if (isFull()){
            throw new RuntimeException("队列已满,无法添加数据!");
        }
        tail++;
        arr[tail] = data;
    }
    /**
     * 从队列中取出数据
     */
    public int getDateToQueue(){
        /**
         * 取数据之前先判断队列是否为空
         */
        if (isEmpty()){
            throw new RuntimeException("队列为空,无数据可取!");
        }
        head++;
        return arr[head];
    }
    /**
     * 查看队列中的数据,其实就是遍历数组
     */
    public void showData(){
        /**
         * 先判断队列是否为空
         */
        if (isEmpty()){
            System.out.println("队列是空的！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    /**
     * 显示队列的头数据
     */
    public int showHeadData() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据！");
        }
        return arr[head + 1];
    }
}
