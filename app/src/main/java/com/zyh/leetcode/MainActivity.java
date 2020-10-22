package com.zyh.leetcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 首先来了解一下时间复杂度和空间复杂度
     *
     * 时间复杂度：
     * 假设执行一遍代码的时间度量为1，时间复杂度就是执行了多少遍，称之为O()
     * O(1):只有基本运算，没有循环等复杂结构
     * O(n):例如单层for循环，代码会执行n遍，所以就是O(n)
     * O(logN):一般在循环中乘法比较多，假设一个while循环，2要>8才跳出循环，即2^4会跳出，如果让8为n，则要执行以2为底，logN才能跳出循环，去掉底数，时间复杂度则为O(logN)
     * O(nlogN):按照上面的条件，外面再套一层for，即满足
     * O(n²):例如双层for
     * O(m*n):外层for循环m次，内层循环n次
     */
    private void time() {

    }


    /**
     * 空间复杂度：
     * 空间复杂度也不是用来计算程序实际占用的空间的,而是对一个算法在运行过程中临时占用存储空间大小的一个量度
     * 也就是说我定义四4个变量，但是之后变量的数量一直不变，空间不在开辟，则一直为O(1)
     * O(1):临时空间不随着变量的大小变化，例如变量为10和变量为10000000
     * O(n):例如最初定义了一个长度为n的数组，还有递归，比如递归一次占用1，n次占用n
     */
    private void space(){

    }
}