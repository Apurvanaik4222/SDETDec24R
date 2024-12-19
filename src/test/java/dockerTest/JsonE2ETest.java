package dockerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONObject;
import pojo.Books;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JsonE2ETest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/business","root", "Destiny@1234");
       Statement statement =connection.createStatement();
       ResultSet set =statement.executeQuery("select * from customerinfo where purchasedate=current_date() and Location ='Asia';");

       List<Books> list =new ArrayList<Books>();
       List<String> stringList =new ArrayList<String>();

       while(set.next()){
           Books books = new Books();
              books.setCourseName(set.getString("CourseName"));
           books.setAmount(set.getInt("Amount"));
              books.setPurchasedate(set.getString("Purchasedate"));
              books.setLocation(set.getString("Location"));
              list.add(books);

        }

       for(int i=0;i<list.size();i++){
           ObjectMapper mapper = new ObjectMapper();
           mapper.writeValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\files\\books"+i+".json"),list.get(i));
           Gson gson =new Gson();
          String json = gson.toJson(list.get(i));
          stringList.add(json);


       }

        JSONObject object = new JSONObject();
       object.put("data",stringList);
       System.out.println(object.toJSONString());

      String formattedstring = StringEscapeUtils.unescapeJava(object.toJSONString());
     String finalString = formattedstring.replace("\"{","{").replace("}\"","}");
System.out.println(finalString);

        FileWriter file =new FileWriter(System.getProperty("user.dir")+"\\src\\test\\java\\files\\final.json");
        file.write(finalString);
        file.close();

    }
}
