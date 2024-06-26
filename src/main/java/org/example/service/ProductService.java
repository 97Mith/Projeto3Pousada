package org.example.service;

import org.example.entity.PersonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.ProductRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static void insertProduct(ProductEntity productEntity, JButton btnAtualizate){
        try{
            ProductRepository.registerProduct(productEntity);
            btnAtualizate.doClick();
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Erro ao inserir ítem.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public static List<ProductEntity> getProductsInRoom(Integer bedroomNum, boolean isLaundry){
        try{
            return ProductRepository.findAllProductsWithFilter(bedroomNum, isLaundry);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static DefaultTableModel createProductTable(List<ProductEntity> product) {
        String[] columnNames = {
                "NR",
                "Qnt",
                "Descrição",
                "Observações",
                "ID",
                "V.Un",
                "S.Total"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (ProductEntity productTable : product) {
            Object[] rowData = {
                    productTable.getRegisterNum(),
                    productTable.getQnt(),
                    productTable.getDescription(),
                    productTable.getObs(),
                    productTable.getGuestId(),
                    productTable.getUnValue(),
                    productTable.getSubTotal()
            };

            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public static ProductEntity getByRegister(Integer register){
        try{
            return ProductRepository.findById(register);
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Erro ao buscar ítem.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }

    public static void delete(ProductEntity product){
        try{
            ProductRepository.deleteProduct(product);
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Erro ao excluir ítem.",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
