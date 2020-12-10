package com.breakpoint.meituan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author breakpoint/赵先生
 * 2020/09/07
 */
public class Test_2020_01 {
    /*
        给出一个布尔表达式的字符串，比如：true or false and false，表达式只包含true，false，and和or，
        现在要对这个表达式进行布尔求值，计算结果为真时输出true、为假时输出false，
        不合法的表达时输出error（比如：true true）。表达式求值是注意and 的优先级比 or 要高，
        比如：true or false and false，等价于 true or (false and false)，计算结果是 true。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String[] split = str.split(" ");
        cauculate(split);
    }

    // 真正的计算
    private static void cauculate(String[] values) {

        Deque<Boolean> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();
        outer:
        for (int i = 0; i < values.length; i++) {
            switch (values[i]) {
                case "or": {
                    stack2.addLast(values[i]);
                    if (i + 1 < values.length && ("true".equals(values[i + 1]) || "false".equals(values[i + 1]))) {
                        try {
                            stack1.addLast(Boolean.valueOf(values[i + 1]));
                            i++;
                        } catch (Exception e) {
                            System.out.println("error");
                            return;
                        }
                    } else {
                        System.out.println("error");
                        return;
                    }
                    break;
                }
                case "and": {
                    Boolean a, b;
                    if (!stack1.isEmpty()) {
                        a = stack1.pollLast();
                    } else {
                        System.out.println("error");
                        return;
                    }


                    if (i + 1 < values.length && ("true".equals(values[i + 1]) || "false".equals(values[i + 1]))) {
                        try {
                            b = Boolean.valueOf(values[i + 1]);
                            i++;
                        } catch (Exception e) {
                            System.out.println("error");
                            return;
                        }
                    } else {
                        System.out.println("error");
                        return;
                    }

                    if ((a && b) || (!a && !b)) {
                        stack1.addLast(true);
                    } else {
                        stack1.addLast(false);
                    }
                    break;
                }
                default: {
                    try {
                        stack1.addLast(Boolean.valueOf(values[i]));
                    } catch (Exception e) {
                        System.out.println("error");
                        return;
                    }
                    break;
                }
            }// end switch
        }// end for

        while (!stack2.isEmpty()) {
            String s = stack2.pollLast();
            Boolean a, b;
            if (!stack1.isEmpty()) {
                a = stack1.pollLast();
            } else {
                System.out.println("error");
                return;
            }

            if (!stack1.isEmpty()) {
                b = stack1.pollLast();
            } else {
                System.out.println("error");
                return;
            }
            if (a || b) {
                stack1.addLast(true);
            } else {
                stack1.addLast(false);
            }
        }

        if (stack1.size() > 1 || stack1.size() == 0) {
            System.out.println("error");
            return;
        } else {
            System.out.println(stack1.peekLast());
            return;
        }
    }
}
