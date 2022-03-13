package com.emp;

import java.util.Arrays;
import java.util.Scanner;

public class EmpManagementSystem {
    public static void main(String[] arg){
        showOptions();
        //Employee[] empArr=init();
        //System.out.println(Arrays.toString(empArr));

    }

    public static void showOptions(){
        Employee[] empArr=null;
        while (true){
            System.out.println("Please select option");
            System.out.println("1. Add Employees");
            System.out.println("2. Update Emploee");
            System.out.println("3. Delete Emploee");
            System.out.println("4. Displey Employee");
            System.out.println("5. Displey All  Employee");
            Scanner scanner=new Scanner(System.in);
            int option=scanner.nextInt();
            switch (option){
                case 1:
                    empArr=init();
                    break;
                case  2:
                    updateEmp(empArr);
                    break;
                case 3:
                    deleteEmp(empArr);
                    break;
                case 4:
                    showEmp(empArr);
                    break;
                case 5:
                    showAllEmp(empArr);
                    break;
                default:
                    System.out.println("Entered InValid, please Enter Again");
                    break;
            }
        }
    }

    public static int askId(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter Employee Id");
        int id= scanner.nextInt();
        return id;
    }

    public static Employee[] init(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter Number of Employees");
        int size=scanner.nextInt();
        Employee[] empArr=new Employee[size];
        for(int i=0;i<empArr.length;i++){
            System.out.println("asking emplyee detail count "+(i+1));
            Employee e=askEmployeeDetail();
            empArr[i]=e;

        }
        return empArr;
    }
    public static Employee askEmployeeDetail(){
        Scanner scanner=new Scanner(System.in);
        Employee employee=new Employee();
        System.out.println("please Enter ID");
        employee.id= scanner.nextInt();
        System.out.println("please enter Name");
        employee.name=scanner.next();
        System.out.println("Please Enter Email");
        employee.email=scanner.next();
        System.out.println("please enter Salary");
        employee.salary=scanner.nextFloat();
        return  employee;
    }


    public static int  findEmployee(Employee[] empArr){
        int id=askId();
        for(int i=0;i<empArr.length;i++){
            if(empArr[i].getId()==id){
                return  i;
            }
        }

        return -1;
    }

    public static Employee[] updateEmp(Employee[] empArr){
        int index=findEmployee(empArr);
        if(index==-1){
            System.out.println("No Empoyee Foand");
        }
        else{
            Employee e=askEmployeeDetail();
            empArr[index]=e;
        }

        return  empArr;
    }

    public static Employee[] deleteEmp(Employee[] empArr){
        int index=findEmployee(empArr);
        empArr[index]=null;
        return  empArr;
    }

    public  static  void  showEmp(Employee[] empArr){
        int index=findEmployee(empArr);
        System.out.println(empArr[index]);
    }
    public static void showAllEmp(Employee[] empArr){
        for(Employee e:empArr){
            System.out.println(e);
        }
    }
}
