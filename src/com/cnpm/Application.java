package com.cnpm;

import com.cnpm.frm.ShowStatisticsManagerFrm89;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        ShowStatisticsManagerFrm89 showStatisticsManagerFrm89 = new ShowStatisticsManagerFrm89();
        showStatisticsManagerFrm89.setVisible(true);
    }
}
