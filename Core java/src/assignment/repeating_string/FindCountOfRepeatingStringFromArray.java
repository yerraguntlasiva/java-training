package assignment.repeating_string;

import java.util.Arrays;

public class FindCountOfRepeatingStringFromArray {
    public static void main(String[] arg){
        String arr[]={"srk","abc","khan","pathan","srk","khan","srk"};
        //find1(arr);
        //System.out.println(Arrays.toString(findUniqueElement(arr)));
        find2(arr);
    }

    public static void find2(String[] arr){
        String[] arr2=findUniqueElement(arr);
        for(int i=0;i< arr2.length;i++){
            if(arr2[i]!=null){
                int count=1;
                for(int j=0;j< arr.length;j++){
                    if(arr2[i].equals(arr[j])){
                        count++;
                    }
                }
                System.out.println(arr2[i]+"-"+count);
            }
        }
    }
    public static String[] findUniqueElement(String[] arr){
        String outArr[]=new String[arr.length];
        for(int i=0;i< arr.length;i++){
            boolean b=true;
            for(int j=0;j<outArr.length;j++){
                if(outArr[j]!=null && outArr[j].equals(arr[i])){
                    b=false;
                    break;
                }
            }
            if(b){
                outArr[i]=arr[i];
            }
        }
        return outArr;
    }
    public static void findRepeatingByReplacingToNull(String[] arr){
        for(int i=0;i<arr.length;i++){
            int count=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].equals(arr[j])){
                    count++;
                    arr[j]="null";

                }

            }
            if(!arr[i].equals("null")){
                System.out.println(arr[i]+"-"+count);
            }
        }
    }
}
