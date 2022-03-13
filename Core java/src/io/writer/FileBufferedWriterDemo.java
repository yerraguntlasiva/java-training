package io.writer;
/*
both are capable of writting String to file
FileWriter write each char one by one to file
BufferWriter write chunk of char at once
 */
import java.io.*;
import java.util.*;
public class FileBufferedWriterDemo {
    public static  void main(String[] arg) throws IOException {
        /*File f=new File("demo.txt");
        FileWriter fw=new FileWriter(f,true);
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter text");
        String in=sc.nextLine();

        fw.write(in);
        fw.flush();
        fw.close();*/

        /*File f=new File("demo.txt");
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter bw=new BufferedWriter(fw);
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter text");
        String in=sc.nextLine();

        bw.write(in);
        bw.flush();
        fw.flush();
        fw.close();*/

        File f=new File("demo.txt");
        FileReader fw=new FileReader(f);
        int i=0;
        while((i=fw.read())!=-1)
        {

            System.out.print((char)i);
        }
        fw.close();
        /*File f=new File("demo.txt");
        FileReader fw=new FileReader(f);
        BufferedReader bw=new BufferedReader(fw);
        int i=0;
        String s=null;
        while((s=bw.readLine())!=null)
        {
            System.out.println(s);
        }

        fw.close();*/

    }
}

