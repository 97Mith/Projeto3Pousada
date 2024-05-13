package org.example.service;

import org.example.entity.PersonEntity;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class MainService {
    public static DefaultTableModel createMainTable(List<PersonEntity> people) {
        String[] columnNames = {
                "Nome",
                "Telefone"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (PersonEntity peopleTable : people) {
            Object[] rowData = {
                    peopleTable.getName(),
                    peopleTable.getPhoneNumber()
            };

            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
