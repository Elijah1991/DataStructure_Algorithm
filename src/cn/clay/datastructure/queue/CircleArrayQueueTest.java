package cn.clay.datastructure.queue;

import java.util.Scanner;

public class CircleArrayQueueTest {
    public static void main(String[] args) {
        CircleArrayQueue cq = new CircleArrayQueue(5);// 只能添加4个元素
        char key=' ';//用于接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符

            switch (key)
            {
                case 's':
                    cq.showData();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    cq.addDate(value);
                    break;
                case 'g':
                    try {
                        int reslut=cq.getData();
                        System.out.printf("取出数据是%d\n",reslut);
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result=cq.catHeadData();
                        System.out.printf("队列头的元素为%d\n",result);
                    }catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序结束");
    }
}
