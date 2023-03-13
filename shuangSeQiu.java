package level2;

import java.util.Random;
import java.util.Scanner;

public class shuangSeQiu {
    public static void main(String[] args) {
        //1.生成中奖号码
        int[] arr = creatNumber();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        //2.用户输入号码（红+蓝）
        int[] userInputArr = userInputNumber();
        /*for (int i = 0; i < userInputArr.length; i++) {
            System.out.print(userInputArr[i]);*/
        /*3.判断用户的中将情况
            分别判断红球和蓝球*/
            int redCount = 0;//初始值都为零
            int blueCount = 0;

            //仅仅判断红球
            for (int i = 0; i < userInputArr.length - 1; i++) {
                int redNumber = userInputArr[i];
                for (int j = 0; j < arr.length - 1; j++) {
                    if(redNumber == arr[j]) {
                        redCount++;
                        //
                        break;
                    }
                }
            }

            //判断蓝球
        int blueNumber = userInputArr[userInputArr.length - 1];
            if(blueNumber == arr[arr.length - 1]){
                blueCount++;
        }
            //统计红篮球中奖情况
        System.out.println(redCount);
        System.out.println(blueCount);
        //根据中奖颜色输出金额
        if (redCount == 6 && blueCount == 1){
            System.out.println("一等奖1000万");
        }else if (redCount == 6 && blueCount == 0){
            System.out.println("二等奖500万");
        }else if ((redCount == 5 && blueCount == 1)||redCount == 5 && blueCount == 0){
            System.out.println("三等奖3000");
        }else{
            System.out.println("未中奖");
        }
    }
    //此方法用于添加用户所买彩票
    public static int[] userInputNumber() {
        //6个红球1个蓝球
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        //用户输入红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("输入第"+(i+1)+"个红球号码");
            int redNumber = sc.nextInt();
            if(redNumber >=1 && redNumber<=33) {
                boolean flag = contains(arr, redNumber);
                if (!flag) {
                    //不存在，可添加
                    arr[i] = redNumber;
                    i++;
                } else {
                    //已经存在，不能再添加
                    System.out.println("已经存在该号码，不能再添加");
                }
            }
            else{
                System.out.println("当前红球号码已超出范围");
                }
        }
        //用户输入蓝球号码
        System.out.println("请输入蓝球号码");
        while(true) {
            int blueNumber = sc.nextInt();
            if(blueNumber >=1 && blueNumber <= 16){
                arr[arr.length - 1] = blueNumber;
                break;
            }else{
                System.out.println("当前蓝球号码超出范围");
            }
        }
        return arr;
    }
    //此方法用于创建中奖号码
    public static int[] creatNumber(){
        //6个红球1个蓝球
        int[] arr = new int[7];
        //随即生成号码添加到数组当中
        //红球：1-33，不能重复
        //蓝球:1-16,可以与红球号码重复

        //生成红球号码并添加到数组中
        Random r = new Random();
        for (int i = 0; i < 6;) {
            int redNumber = r.nextInt(33)+1;
            boolean flag = contains(arr,redNumber);
            if (!flag){
                arr[i] = redNumber;
                i++;//换下一个数字
            }
        }

        //生成蓝球号码并添加到数组中
            int blueNumber = r.nextInt(16) + 1;
            arr[arr.length - 1] = blueNumber;
        //返回数组
            return arr;
    }
    //此方法用于判断红球里面是否有相同的号码
    public static boolean contains(int[] arr,int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return true;
            }
        }
            return false;
        }
}