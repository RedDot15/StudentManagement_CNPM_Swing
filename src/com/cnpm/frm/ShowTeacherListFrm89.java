package com.cnpm.frm;

import com.cnpm.dao.TeacherDAO89;
import com.cnpm.entity.Teacher89;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class ShowTeacherListFrm89 extends JFrame{

    private JPanel panel;
    private JTable tblTeacherList;

    public ShowTeacherListFrm89() throws SQLException {
        super("Teacher List");

        //Vector chua header
        Vector vctHeader = new Vector();
        //Vector chua du lieu trong bang
        Vector vctData = new Vector();

        //Tao cac header
        vctHeader.add("id");
        vctHeader.add("password");
        vctHeader.add("name");
        vctHeader.add("dob");
        vctHeader.add("homeTown");
        vctHeader.add("address");

        //Lay du lieu tu database
        TeacherDAO89 teacherDAO89 = new TeacherDAO89();
        List<Teacher89> list = teacherDAO89.getTeacherList();
        //Tao cac dong du lieu
        for(Teacher89 teacher89 : list){
            Vector vector = new Vector();
            vector.add(teacher89.getId());
            vector.add(teacher89.getPassword());
            vector.add(teacher89.getName());
            vector.add(teacher89.getDob());
            vector.add(teacher89.getHomeTown());
            vector.add(teacher89.getAddress());
            vctData.add(vector);
        }

        tblTeacherList.setModel(new DefaultTableModel(vctData,vctHeader));

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

        tblTeacherList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Get index of selected row
                int selectedRow = tblTeacherList.getSelectedRow();
                //get data of selected row
                Vector vctSelectedRow = (Vector)vctData.get(selectedRow);

                //Call subject statistics form to display
                ShowSubjectStatisticsFrm89 showSubjectStatisticsFrm89 = new ShowSubjectStatisticsFrm89((Integer)vctSelectedRow.get(0));
            }
        });
    }
}
