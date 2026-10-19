package com.jeang.jdbcDemo;

import java.sql.*;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///school?useSSL=false";
        String user = "root";
        String password = "19001900";
        Connection conn = DriverManager.getConnection(url, user, password);
        while (true) {
            System.out.println("1. Show all items");
            System.out.println("2. Add an item");
            System.out.println("3. Update an item");
            System.out.println("4. Delete an item");
            int inp = sc.nextInt();
            switch (inp) {
                case 1 -> {System.out.println("Show all items"); showItem(conn);}
                case 2 -> {System.out.println("Add an item"); addItem(conn);}
                case 3 -> {System.out.println("Update an item"); updateItem(conn);}
                case 4 -> {System.out.println("Delete an item"); deleteItem(conn);}
            }
            // 释放资源
            sc.close();
            conn.close();
        }
    }

    private static void showItem(Connection conn) throws SQLException {
        String sql="select * from student order by id";
        ResultSet res = conn.createStatement().executeQuery(sql);
        while (res.next()) {
            System.out.println(res.getString("id") + " " + res.getString("name") + " " + res.getString("age"));
        }
    }

    private static void addItem(Connection conn) throws SQLException {
        String sql="insert into student (id,name,age) values (?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        pstmt.setString(1, sc.nextLine());
        System.out.println("Enter name:");
        pstmt.setString(2, sc.nextLine());
        System.out.println("Enter age:");
        pstmt.setString(3, sc.nextLine());
        pstmt.executeUpdate();
        System.out.println("Added successfully!");
    }
    private static void updateItem(Connection conn) throws SQLException {
        String sql="update student set name=?, age=? where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        String id = sc.nextLine();
//        判断id是否存在
        if (!conn.createStatement().executeQuery("select * from student where id=" + id).next()) {
            System.out.println("ID does not exist!");
            return;
        }
        System.out.println("Enter name:");
        pstmt.setString(1, sc.nextLine());
        System.out.println("Enter age:");
        pstmt.setString(2, sc.nextLine());
        pstmt.setString(3, id);
        pstmt.executeUpdate();
        System.out.println("Updated successfully!");
    }
    private static void deleteItem(Connection conn) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id:");
        String id = sc.nextLine();
//        判断id是否存在
        if (!conn.createStatement().executeQuery("select * from student where id=" + id).next()) {
            System.out.println("ID does not exist!");
            return;
        }
        String sql="delete from student where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.executeUpdate();
        System.out.println("Deleted successfully!");
    }
}
