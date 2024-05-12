package com.cnpm.frm;

import com.cnpm.dao.TeacherDAO89;
import com.cnpm.entity.Teacher89;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ShowStatisticsManagerFrm89 extends JFrame{

    private JPanel panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public ShowStatisticsManagerFrm89(){
        super("Statistics Manager");

        button1.setText("Thống kê 1");
        button2.setText("Thống kê môn học theo tỉ lệ sinh viên qua");
        button3.setText("Thống kê 3");

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        button2.addActionListener(new ActionListener() {
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
