/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnet.adresse.verifier;

import carnet.adresse.FileManager;
import carnet.adresse.Produit;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Hp
 */
public class NumeroVerifier extends InputVerifier{
    
    

    @Override
    public boolean verify(JComponent input) {
        final JTextComponent source = (JTextComponent) input;
        String text = source.getText();
        if ((text.length() != 0) || !(isCorrect(text))) {
            JOptionPane.showMessageDialog(source, "Numéro incorrect.", "Error Dialog", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    public static boolean isCorrect(String numero) {
        File fichier = new File("produits.tmp");
        boolean isCorrect = true;
        List<Produit> produits = FileManager.lire(fichier);
        for(Produit p : produits) {
            if(numero.equals(p.getNumero())){
                return false;
            }
        }
        return isCorrect;
    }
    
}
