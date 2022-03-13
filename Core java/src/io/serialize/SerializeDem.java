package io.serialize;

import JUnitDemo.Caluclator;

import java.io.*;

public class SerializeDem {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        System.out.println("main start");
        Caluclator cal=new Caluclator(1234,"Sharukh");

        serialize(cal,Caluclator.class);
        System.out.println("serialized " );
        Caluclator o=(Caluclator)desirialize();
        System.out.println(o);
    }

    public static void serialize(Object o,Class classs) throws IOException {
        FileOutputStream fo=new FileOutputStream("cal.serialize");
        ObjectOutputStream oo=new ObjectOutputStream(fo);
        oo.writeObject(o);
        oo.flush();
        oo.close();

    }
    public static Object desirialize() throws IOException, ClassNotFoundException {
        FileInputStream fi=new FileInputStream("cal.serialize");
        ObjectInputStream oi=new ObjectInputStream(fi);
        Object o1=oi.readObject();
        return o1;
    }
}
