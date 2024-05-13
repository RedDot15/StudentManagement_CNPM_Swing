package com.cnpm.dao;

import com.cnpm.entity.Teacher89;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO89 {
    private Connection dbCon = null;

    public TeacherDAO89() {
        String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
        String dbClass = "com.mysql.jdbc.Driver";

        try {
            dbCon = DriverManager.getConnection(dbUrl, "root", "quangminh1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Teacher89> getTeacherList() {
        ArrayList<Teacher89> list = new ArrayList<>();
        String sql = "SELECT * FROM teacher89";
        try {
            Statement statement = dbCon.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Teacher89 teacher89 = new Teacher89(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                list.add(teacher89);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
