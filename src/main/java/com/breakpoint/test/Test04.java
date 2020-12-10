package com.breakpoint.test;

/**
 * @author :breakpoint/赵立刚
 * @date : 2020/08/22
 */
public class Test04 {

    public static void main(String[] args) throws Exception {
        /**
         * c测试网络的加载类的方法
         */
        String filePath = "https://block-chain-001.oss-cn-beijing.aliyuncs.com/HelloInstance.class";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader(filePath);
        Object helloInstance = networkClassLoader.loadClass("com.breakpoint.test.HelloInstance").newInstance();
        System.out.println(helloInstance.getClass());
    }
}
