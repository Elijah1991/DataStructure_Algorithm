package cn.clay.datastructure.stack;

import java.util.Scanner;

/**
 * @author clay
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        //用于接收用户输入
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while(loop) {
            System.out.println("s(show): 显示栈中的元素");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到栈");
            System.out.println("g(get): 取出一个数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key)
            {
                case 's':
                    stack.showData();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stack.push(value);
                    break;
                case 'g':
                    try {
                        int reslut= (int) stack.pop();
                        System.out.printf("取出的数据是%d\n",reslut);
                    }catch (Exception e) {
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
