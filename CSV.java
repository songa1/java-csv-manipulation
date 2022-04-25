import java.io.*;
import java.util.*;
import java.nio.*;
import java.lang.*;

public class CSV {
    public static void main(String[] args) throws Exception{
        CSV obj = new CSV();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Reg Number: ");
        String reg = sc.nextLine();

        Map<String, String> sts = obj.getData("students.csv");
        Map<String, String> mks = obj.getData("marks.csv");

        System.out.println("Your name is " + sts.get(reg) + " and you have got " + mks.get(reg) + " marks!");

    }

    public Map<String, String> getData(String fileName){
        Map<String, String> datas = new HashMap<>();

        String line = "";
        String splitBy = ",";

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                datas.put(data[0], data[1]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return datas;
    }
}