public class GenerateRandomArray {

    //Math.random -> [0,1)
    //K, (int)(Math.random * K )-> [0,K]
    // (Math.random) * (Math.random)

    //返回[0,1)的一个小数
    //任意的x，x属于[0,1)，[0,x]范围上的数出现概率等于x平方
    //用max,里面两次取值都是随机行为，第一个random是在[0,x]概率是x，第二次也是x，但是max得满足都是概率为x情况下才能返回为x，所以概率x的平方
    public static double xToXPower2(){
        return Math.max(Math.random(), Math.random());
    }

    public static double xToXPower3(){
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

//    public int[] generateArray() {
//
//        Math.random()
//
//    }

    public static void main(String[] args) {

        int testTimes = 1000000;
        double x = 0.17;
        int count = 0;

        for (int i = 0; i < testTimes; i++) {
            if (xToXPower3() < x) {
                count++;
            }
        }
        System.out.println((double)count / (double) testTimes);
        System.out.println(Math.pow(x,3));
    }


}
