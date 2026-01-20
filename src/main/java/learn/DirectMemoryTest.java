package learn;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵立刚 <zlgtop@163.com>
 * Created on 2025/05/10
 */
public class DirectMemoryTest {
    public static void main(String[] args) {
        List<ByteBuffer> buffers = new ArrayList<ByteBuffer>();
        while (true){
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
            buffers.add(byteBuffer);
        }
       // BufferPoolMXBean
    }
}
