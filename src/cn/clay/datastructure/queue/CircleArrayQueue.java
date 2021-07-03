package cn.clay.datastructure.queue;

/**
 * 使用数组模拟循环队列,保证队列可以复用
 */
public class CircleArrayQueue {
    private int maxSize;
    private int head;
    private int tail;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        head = 0;
        tail = 0;
    }
    /**
     * 判断队列是否为空
     */
    public boolean isEmpty(){
        return head == tail;
    }
    /**
     * 判断队列是否满
     */
    public boolean isFull(){
        return head == (tail + 1) % maxSize;
    }
    /**
     * 向队列中添加元素
     */
    public void addDate(int data){
        // 先判断队列是否满
        if (isFull()){
            throw new RuntimeException("队列满,无法添加元素!");
        }
        arr[tail] = data;
        // 添加完一个元素后让尾指针后移,但要保证队列能复用
        tail = (tail+1)% maxSize;
    }
    /**
     * 从队列中取出元素
     */
    public int getData(){
        // 先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空,无元素可取!");
        }
        int data = arr[head];
        head = (head + 1) % maxSize;
        return data;
    }
    /**
     * 查看队列头的数据
     */
    public int catHeadData(){
        // 先判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("队列为空!");
        }
        return arr[head];
    }
    /**
     * 获取队列中元素的个数
     */
    public int getSize(){
        return ( tail + maxSize - head ) % maxSize;
    }
    /**
     * 查看队列中的元素
     */
    public void showData(){
        for (int i = head; i <head + getSize() ; i++) {
            System.out.printf("arr[%d]=%d\n",i % maxSize,arr[i % maxSize]);
        }
    }
}
