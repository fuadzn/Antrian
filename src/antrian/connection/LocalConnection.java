/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.connection;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import static antrian.constant.Constant.*;
/**
 *
 * @author ZuhdanNur
 */
public class LocalConnection implements ConnectionListener {
    Connection conn;
    
    public static void main(String[] args) {
        LocalConnection main = new LocalConnection();
        main.start();
    }
    
    private void start() {
        initial();
    }
    
    @Override
    public void initial() {
        String baseUrl = System.getProperty("user.dir") +"\\src\\database\\base.db";
        
        File dbFile = new File(baseUrl);
        if(!dbFile.exists()) {
            createDB();
        }
        
        connectToDB();
    }

    @Override
    public void createDB() {
        String fileName = "base.db";
                
        String url = "jdbc:sqlite:src/database/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                
                createTable();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void connectToDB() {
         try {         
            String url = "jdbc:sqlite:src/database/base.db";
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
         }catch(SQLException e){
              System.out.println(e.getMessage());
         } finally {
           
         }
    }

    @Override
    public Connection getConnection() {
        return conn;
    }
    
    private void createTable() {
        String url = "jdbc:sqlite:src/database/base.db";
        
        for(int i = 0; i < listTable.length; i++) {
            String sql = "CREATE TABLE IF NOT EXISTS "+listTable[i]+" (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text , \n"
                + "     no_antrian text NOT NULL, \n"
                + "     finish integer default 0"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            
            System.out.println(listTable[i]+" Table Created");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
        
    }
        
}
