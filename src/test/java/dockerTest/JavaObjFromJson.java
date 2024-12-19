package dockerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Finaljson;

import java.io.File;
import java.io.IOException;

public class JavaObjFromJson {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
       Finaljson finaljson = mapper.readValue(
               new File(System.getProperty("user.dir")+"\\src\\test\\java\\files\\final.json"), Finaljson.class);

       System.out.println(finaljson.getData().get(2).getCourseName());
        System.out.println(finaljson.getData().get(0).getLocation());
        System.out.println(finaljson.getData().get(1).getPurchasedate());
    }
}
