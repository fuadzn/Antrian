/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.connection;

import java.sql.Connection;
/**
 *
 * @author ZuhdanNur
 */
interface ConnectionListener {
    void createDB();
    void initial();
    void connectToDB();
    Connection getConnection();     
}
