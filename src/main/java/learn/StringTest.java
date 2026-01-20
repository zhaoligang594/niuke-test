package learn;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class StringTest {

    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "Hello World";
        System.out.println(str1 == str2);
        System.out.println(str1==str2.intern());
        System.out.println(str1==new String("Hello World"));
        System.out.println(str1==new String("Hello World").intern());
        System.out.println(str1=="Hello"+" World");
        System.out.println("Hello W"+"orld"=="Hello"+" World");
    }
}
