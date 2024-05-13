package com.cnpm.frm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ShowStatisticsManagerFrm89 extends JFrame{

    private JPanel panel;
    private JButton button1;
    private JButton btnShowSubjectStatistics;
    private JButton button3;

    public ShowStatisticsManagerFrm89(){
        super("Statistics Manager");

        button1.setText("Thống kê 1");
        btnShowSubjectStatistics.setText("Thống kê môn học theo tỉ lệ sinh viên qua");
        button3.setText("Thống kê 3");

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        btnShowSubjectStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowTeacherListFrm89 teacherListFrm = null;
                try {
                    teacherListFrm = new ShowTeacherListFrm89();
                    teacherListFrm.setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
