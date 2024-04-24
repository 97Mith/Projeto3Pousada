package org.example.service;

import javax.swing.*;

public class Methods {
    public static boolean isNullOrEmpty(String value, String error){
        if(value == null || value.trim().isEmpty()){
                JOptionPane.showMessageDialog(
                        null, "O "+ error +" não pode ficar nulo",
                        "Aviso", JOptionPane.ERROR_MESSAGE
                );
                return false;
        }
        return true;
    }
    public static boolean minimumStringSize(int minimum, String string, String field){
        if(string.length() < minimum){
            JOptionPane.showMessageDialog(
                    null, "O "+field+" deve ter no minimo " + minimum + " caracteres",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return  true;
    }
    public static boolean maximumStringSize(int maximum, String string, String field){
        if(string.length() > maximum){
            JOptionPane.showMessageDialog(
                    null, "O "+field+" deve ter no máximo " + maximum + " caracteres",
                    "Aviso", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return  true;
    }

}
