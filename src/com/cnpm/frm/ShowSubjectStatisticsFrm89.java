package com.cnpm.frm;

import com.cnpm.dao.SubjectDAO89;
import com.cnpm.entity.SubjectStatistic89;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

public class ShowSubjectStatisticsFrm89 extends JFrame {

    private JPanel panel;
    private JTable tblSubjectStatistics;

    public ShowSubjectStatisticsFrm89(Integer teacherId){
        super("Subject Statistics");

        //Vector chua header
        Vector vctHeader = new Vector();
        //Vector chua du lieu trong bang
        Vector vctData = new Vector();

        //Tao cac header
        vctHeader.add("Mã môn học");
        vctHeader.add("tên môn học");
        vctHeader.add("số tín chỉ");
        vctHeader.add("Điểm trung bình của các sinh viên trong môn");
        vctHeader.add("Tỉ lệ sinh viên qua môn (theo %)");

        //Lay du lieu tu database
        SubjectDAO89 subjectDAO89 = new SubjectDAO89();
        List<SubjectStatistic89> list = subjectDAO89.getSubjectStatistic(teacherId);
        //Tao cac dong du lieu
        for(SubjectStatistic89 subjectStatistic89 : list){
            Vector vector = new Vector();
            vector.add(subjectStatistic89.getId());
            vector.add(subjectStatistic89.getName());
            vector.add(subjectStatistic89.getCreditNumber());
            vector.add(subjectStatistic89.getAverageScore());
            vector.add(subjectStatistic89.getPassRate());
            vctData.add(vector);
        }

        tblSubjectStatistics.setModel(new DefaultTableModel(vctData, vctHeader));

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        tblSubjectStatistics.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Get index of selected row
                int selectedRow = tblSubjectStatistics.getSelectedRow();
                //get data of selected row
                Vector vctSelectedRow = (Vector)vctData.get(selectedRow);

                //Call subject statistics form to display
                ShowLearningOutcomeStatisticsFrm89 showLearningOutcomeStatisticsFrm89 = new ShowLearningOutcomeStatisticsFrm89(teacherId, (Integer)vctSelectedRow.get(0));
                showLearningOutcomeStatisticsFrm89.setVisible(true);
            }
        });
    }
}
