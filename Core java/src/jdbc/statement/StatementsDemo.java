package jdbc.statement;

import java.sql.*;

public class StatementsDemo {
    public static void main(String[] arg) throws SQLException {
        //System.out.println("create emp table : "+ctreateTable("emp"));
       // String sqlInsert="insert into emp values(10,'Ameer')";
        String sqlInsert="update emp set email='changed name' where id=10";
        //System.out.println("inserOrUpdate  : "+insertOrUpdate(sqlInsert));
        showTableRecords();
    }

    public static void showTableRecords() throws SQLException {
        Connection con=null;
        Statement st=null;
        try{
            con=getConnection();
            st=con.createStatement();
            String sql="select * from emp";
            ResultSet rs=st.executeQuery(sql);

            while (rs.next()){
                System.out.println("id = "+rs.getInt("id")+" , email ="+rs.getString("email"));
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            if(con!=null) con.close();;
            if(st!=null) st.close();
        }
    }
    public static int ctreateTable(String tableName) throws SQLException {
        Connection con=null;
        Statement st=null;
        try{
            con=getConnection();
            st=con.createStatement();
            String sql="create table emp(id number,email varchar2(200))";
            int b=st.executeUpdate(sql);
            System.out.println("table is created or not : "+b);
            con.commit();
            return b;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            if(con!=null) con.close();;
            if(st!=null) st.close();
        }
        return  53;
    }

    public static int insertOrUpdate(String sql) throws SQLException {
        Connection con=null;
        Statement st=null;
        try{
            con=getConnection();
            st=con.createStatement();
            int b=st.executeUpdate(sql);
            System.out.println("table is created or not : "+b);
            con.commit();
            return b;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            if(con!=null) con.close();;
            if(st!=null) st.close();
        }
        return  53;
    }

    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");

            return con;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;

    }
}
