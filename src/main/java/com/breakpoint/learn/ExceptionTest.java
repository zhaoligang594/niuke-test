package com.breakpoint.learn;

import javax.xml.xpath.XPathException;
import java.sql.SQLException;

/**
 * 异常的实现原理
 */
public class ExceptionTest {

    public void testA() {
        try {
            testFunc(20);
        } catch (SQLException e) {
            System.out.println("我是SQLException");
        } catch (NullPointerException e) {
            System.out.println("我是NullPointerException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("我是IndexOutOfBoundsException");
        } finally {
            System.out.println("我是finally");
        }
    }

    public void testFunc(int i) throws NullPointerException, IndexOutOfBoundsException, SQLException {
        if (i == 3) {
            throw new IndexOutOfBoundsException("");
        }
        if (i == 4) {
            throw new SQLException();
        }
        if (i == 5) {
            throw new NullPointerException();
        }
    }
}
