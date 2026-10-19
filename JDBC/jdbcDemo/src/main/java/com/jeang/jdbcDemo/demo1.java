package com.jeang.jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///school";
        String user = "root";
        String password = "19001900";
        Connection conn = DriverManager.getConnection(url, user, password);
        String sql = "select * from jiayihang";
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        ArrayList<String> list = new ArrayList<>();
        while (res.next()) {
            list.add(res.getString("id") + " " + res.getString("name"));
        }
        list.forEach(System.out::println);
        res.close();
        stmt.close();
        conn.close();
    }
}
