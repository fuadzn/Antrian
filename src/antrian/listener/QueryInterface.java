/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrian.listener;

/**
 *
 * @author ZuhdanNur
 */
public interface QueryInterface {
    void select(String table);
    void insert(String table);
    int getLastRow(String table);
}
