package 基础面试.IO流;

import java.io.*;

public class FileCopy {
    // 文件复制代码
    public static void main(String[] args) {
        File source = new File("E:\\product\\fileCopy\\photo1.jpg");
        File target = new File("E:\\product\\fileCopy\\target\\photo1_copy.jpg");
        if (!target.getParentFile().exists()) {
            target.getParentFile().mkdir();
        }
        if (!target.exists()) {
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(target);
            byte[] bufferArray = new byte[1024];
            int len = 0;
            // -1代表读到文件末尾，固定写法
            while ((len = is.read(bufferArray)) != -1) {
                os.write(bufferArray, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
