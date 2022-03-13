package mockito;

public class Student {

    StudentService studentService;
    //public Student(){}
    public Student(StudentService studentService){
        this.studentService=studentService;
    }
    public int getAverage(){
        int a=staticMethods();
        studentService.voidMethod();
        return studentService.getTotalStudent()/studentService.getTotalMarks();
    }
    public  int staticMethods(){
        return 10;
    }
}
