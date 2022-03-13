package io.serialize;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizationDemo {
    public static  void  main(String[] arg) throws IOException, ClassNotFoundException {
        Emp e1=new Emp(12,"srk","srk1");
        SerializeDem.serialize(e1,Emp.class);
        Emp e2= (Emp) SerializeDem.desirialize();
        System.out.println(e2);


    }

}

class Emp implements Externalizable{

    static int id;
    String username;
    String password;
    public Emp(){}
    public Emp(int id,String username, String password) {
        Emp.id=id;
        this.username = username;
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.write(id);
        out.writeObject(username);
        out.writeObject(password);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Emp.id=in.read();
        username= (String) in.readObject();
        password= (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id : "+id+"\\"+
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}