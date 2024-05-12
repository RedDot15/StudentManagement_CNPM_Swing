package com.cnpm.dao;

import com.cnpm.entity.LearningOutcome89;
import com.cnpm.entity.SubjectStatistic89;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LearningOutcomeDAO89 {
    private Connection dbCon = null;

    public LearningOutcomeDAO89() {
        String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
        String dbClass = "com.mysql.jdbc.Driver";

        try {
            dbCon = DriverManager.getConnection(dbUrl, "root", "quangminh1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<LearningOutcome89> getLearningOutcomeStatistic(Integer teacherId, Integer subjectId){
        ArrayList<LearningOutcome89> list = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM learning_outcome89\n" +
                "WHERE course_id IN\n" +
                "    (SELECT id\n" +
                "     FROM course89\n" +
                "     WHERE teacher_id = " + teacherId + "\n" +
                "       AND subject_id = " + subjectId + ")";
        try {
            Statement statement = dbCon.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                LearningOutcome89 learningOutcome89 = new LearningOutcome89(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6),
                        rs.getFloat(7),
                        rs.getFloat(8),
                        rs.getString(9)
                );
                list.add(learningOutcome89);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
