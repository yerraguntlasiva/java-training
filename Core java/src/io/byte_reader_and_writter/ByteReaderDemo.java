package io.byte_reader_and_writter;

import java.io.*;

public class ByteReaderDemo {
    public static void main(String[] arg) throws IOException {

        File f=new File("W:\\Training\\frd1.PNG");
        InputStream inputStream=new FileInputStream(f);
        byte b[]=new byte[(int) f.length()];
        System.out.println("length of the file : "+b.length);
        inputStream.read(b);
        System.out.println(b);
        OutputStream os=new FileOutputStream("srk.PNG");
        os.write(b);
        os.flush();
        os.close();
    }
}
