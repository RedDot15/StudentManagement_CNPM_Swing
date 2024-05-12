package com.cnpm.dao;

import com.cnpm.entity.SubjectStatistic89;
import com.cnpm.entity.Teacher89;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAO89 {
    private Connection dbCon = null;

    public SubjectDAO89() {
        String dbUrl = "jdbc:mysql://localhost:3306/cnpm";
        String dbClass = "com.mysql.jdbc.Driver";

        try {
            dbCon = DriverManager.getConnection(dbUrl, "root", "quangminh1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SubjectStatistic89> getSubjectStatistic(Integer teacherId){
        ArrayList<SubjectStatistic89> list = new ArrayList<>();
        String sql = "WITH comp1 AS\n" +
                "  (SELECT a.subject_id,\n" +
                "          COUNT(DISTINCT b.student_id) cnt_1\n" +
                "   FROM course89 a,\n" +
                "        learning_outcome89 b\n" +
                "   WHERE a.teacher_id =" + teacherId + "\n" +
                "     AND a.status = 'done'\n" +
                "     AND a.id=b.course_id\n" +
                "     AND (b.status = 'pass'\n" +
                "          OR b.status = 'fail')\n" +
                "   GROUP BY a.subject_id),\n" +
                "     COMP2 AS\n" +
                "  (SELECT a.subject_id,\n" +
                "          COUNT(DISTINCT b.student_id) cnt_2,\n" +
                "          ROUND(AVG(b.overall_score), 2) diem_tb\n" +
                "   FROM course89 a,\n" +
                "        learning_outcome89 b\n" +
                "   WHERE a.teacher_id =" + teacherId + "\n" +
                "     AND a.status = 'done'\n" +
                "     AND a.id=b.course_id\n" +
                "     AND b.status = 'pass'\n" +
                "   GROUP BY a.subject_id)\n" +
                "SELECT COMP1.subject_id,\n" +
                "       ROUND(COMP2.cnt_2/COMP1.cnt_1*100, 2) ti_le,\n" +
                "       COMP2.diem_tb,\n" +
                "       subject89.name,\n" +
                "       subject89.credit_number\n" +
                "FROM COMP1,\n" +
                "     COMP2,\n" +
                "     subject89\n" +
                "WHERE COMP1.subject_id = COMP2.subject_id\n" +
                "  AND COMP1.subject_id = subject89.id";
        try {
            Statement statement = dbCon.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                SubjectStatistic89 subjectStatistic89 = new SubjectStatistic89(
                        rs.getInt(1),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getFloat(3),
                        rs.getFloat(2)
                );
                list.add(subjectStatistic89);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
