package com.cnpm.frm;

import com.cnpm.dao.LearningOutcomeDAO89;
import com.cnpm.entity.LearningOutcome89;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class ShowLearningOutcomeStatisticsFrm89 extends JFrame {
    private JTable tblLearningOutcomeStatistics;
    private JPanel panel;

    public ShowLearningOutcomeStatisticsFrm89(Integer teacherId, Integer subjectId){
        super("LearningOutcome Statistic");

        //Vector chua header
        Vector vctHeader = new Vector();
        //Vector chua du lieu trong bang
        Vector vctData = new Vector();

        //Tao cac header
        vctHeader.add("Mã sinh viên");
        vctHeader.add("Điểm số 1(10%)");
        vctHeader.add("Điểm số 2(10%)");
        vctHeader.add("Điểm số 3(10%)");
        vctHeader.add("Điểm thi(70%)");
        vctHeader.add("Điểm cuối cùng");
        vctHeader.add("Trạng thái");

        //Lay du lieu tu database
        LearningOutcomeDAO89 learningOutcomeDAO89 = new LearningOutcomeDAO89();
        List<LearningOutcome89> list = learningOutcomeDAO89.getLearningOutcomeStatistic(teacherId, subjectId);
        //Tao cac dong du lieu
        for(LearningOutcome89 learningOutcome89 : list){
            Vector vector = new Vector();
            vector.add(learningOutcome89.getId());
            vector.add(learningOutcome89.getSubscore1());
            vector.add(learningOutcome89.getSubscore2());
            vector.add(learningOutcome89.getSubscore3());
            vector.add(learningOutcome89.getTestScore());
            vector.add(learningOutcome89.getOverallScore());
            if (learningOutcome89.getStatus().equals("pass")) vector.add("Đỗ");
            else vector.add("Trượt");
            vctData.add(vector);
        }

        tblLearningOutcomeStatistics.setModel(new DefaultTableModel(vctData, vctHeader));

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
    }
}
