/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.listener;

import java.sql.Connection;
/**
 *
 * @author ZuhdanNur
 */
public interface BaseActivity {
    void getConnection(Connection conn);
}
