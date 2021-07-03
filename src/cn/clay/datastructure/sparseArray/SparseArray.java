package cn.clay.datastructure.sparseArray;

import java.io.*;

/**
 * @author clay
 * 原二维数组:             转换为稀疏数组后:
 * 0  0  0  0   0   0           6   6   6
 * 0  1  0  0   0   0           1   1   1
 * 0  0  1  0   0   0    =====> 2   2   1
 * 0  0  0  2   0   0           3   3   2
 * 0  0  1  0   2   0           4   2   1
 * 0  0  0  2   0   0           4   4   2
 *                              5   3   2
 */
public class SparseArray {
    public static void main(String[] args) {
        // 存放文件的路径
        String  path = "E:\\2021workSpace\\DataStructure_Algorithm\\sparseArray.txt";
        // 定义一个二维数组(将该二维数组看成是一个棋盘)
        int[][] arr =new int[6][6];
        //给元素赋值(将1看成是白子,2看成是黑子)
        arr[1][1]=1;
        arr[2][2]=1;
        arr[3][3]=2;
        arr[4][2]=1;
        arr[4][4]=2;
        arr[5][3]=2;
        // 打印原二维数组
        printArray(arr);
       // 打印稀疏数组
        System.out.println("======打印稀疏数组=========");
        printArray(arrToSparseArr(arr));
        // 存盘
        saveContent(arrToSparseArr(arr),path);
        // 打印还原后的二维数组
        System.out.println("======打印还原后的二维数组=========");
        restoreArray(path);
    }
    /**
     * 获取二维数组中的有效元素个数(除0以外的值)
     */
    public static int getEffectiveEleCount(int[][] arr){
        // 记录不为0的元素的个数
        int sum=0;
        //遍历二维数组
        for (int[] row : arr) {
            for (int data : row) {
                //不为0就sum自增1
                if (data!=0) {
                    sum++;
                }
            }
        }
        return sum;
    }
    /**
     * 打印二维数组的方法,按照几行几列的方式打印
     */
    public static void printArray(int[][] arr){
        for (int[] row : arr) {
            for (int data : row) {
                System.out.print(data+"\t");
            }
            System.out.println();
        }
    }
    /**
     * 将二维数组转换为稀疏数组
     */
    public static int[][] arrToSparseArr(int[][] arr){
        /**
         * 稀疏数组永远都是N行3列的,第一行存的是原二维数组的行、列和有效的元素个数,
         * 比如一个6行10列的二维数组,有效的元素个数为3个,那么第一行存的是
         * 6 10 3.所以稀疏数组可以表示为int[][]sparseArr=int[3+1][3],
         * 3是原二维数组有效元素的个数,加1是因为第一行存的是原二维数组是几行几列及几个有效元素的信息的,从第二行开始则存元素
         * 原二维数组的几行几列和对应的值
         */
        // 1.定义一个稀疏数组
        // 获取原二维数组的有效元素个数
        int sum = getEffectiveEleCount(arr);
        int[][] sparseArr = new int[sum+1][3];

        // 1.第一行存原二维数组行数、列数和有效的元素个数
        // 存原二维数组的长度
        sparseArr[0][0] = arr.length;
        // 存原二维数组的列数
        sparseArr[0][1] = arr[0].length;
        // 有效元素的个数
        sparseArr[0][2] = sum;

        // 2.遍历二维数组给稀疏数组赋值
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                // 只存不为0的元素值
                if (arr[i][j]!=0){
                    count++;
                    // 原二维数组对应的元素所在的行
                    sparseArr[count][0]=i;
                    // 原二维数组对应的元素所在的列
                    sparseArr[count][1]=j;
                    // 存元素值
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }
        return sparseArr;
    }
    /**
     * 将稀疏数组存盘的方法
     */
    public static void saveContent(int[][] sparseArr,String path){
        File file = new File(path);
        try {
            FileWriter fw =new FileWriter(file);
            for(int i=0;i<sparseArr.length;i++){
                for(int j=0;j<sparseArr[i].length;j++){
                    fw.write(sparseArr[i][j]+"\t");
                }
                //写完一行就换行
                fw.write("\r\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  将存盘的文件还原成原来的二维数组
     * @param path 存盘文件的路径
     */
    public static void restoreArray(String path){
        //定义一个数组用来存放数据
        int[][] arr=null;
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader reader =new BufferedReader(fileReader);
            String str;
            int count =0;
            while ((str=reader.readLine())!=null){
                String[] temp = str.split("\t");
                if (count==0){
                    arr = new int[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])];
                }else {
                    arr[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])]=Integer.parseInt(temp[2]);
                }
                count++;
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //打印还原后的二维数组
        printArray(arr);
    }
}
