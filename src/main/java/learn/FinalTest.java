package learn;

/**
 * @author breakpoint
 * @email: zlgtop@163.com
 * create date: 2025/05/01
 */
public class FinalTest {

    public static class Father{
        public final Integer age=12;
    }

    public static class Son extends Father{
        public  Integer age=14;
    }

    public static void main(String[] args) {
        Father father=new Father();
        Son son=new Son();
        //System.out.println(father.age=12);
        System.out.println(son.age);
    }
}
