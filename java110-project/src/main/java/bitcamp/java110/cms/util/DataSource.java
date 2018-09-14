package bitcamp.java110.cms.util;

import java.sql.Connection;
import java.sql.DriverManager;

import bitcamp.java110.cms.annotation.Component;


@Component
public class DataSource {//connection 달라하면 주는 객체를 만들 클래스다!
    Connection con;
    
    public Connection getConnection() throws Exception{
        if(con==null) {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/studydb", 
                    "study", "1111");
        }
        
        return this.con;
    }
}
// 이걸 DAO에 주입할겅다!
