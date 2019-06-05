/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnet.adresse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hp
 */
public class FileManager {
    public static File ajoutPersonne(Produit p, File fichier) {
        List<Produit> produits = fetchall(fichier);
        produits.add(p);
        fichier = writeall(produits, fichier);

        return fichier;
    }
    
    public static File remove(int index, File fichier) {
        List<Produit> produits = fetchall(fichier);
        produits.remove(index);
        fichier = writeall(produits, fichier);

        return fichier;
    }
    
    public static File update(int index, Produit p, File fichier) {
        List<Produit> produits = fetchall(fichier);
        produits.set(index, p);
        fichier = writeall(produits, fichier);

        return fichier;
    }

    public static List<Produit> lire(File fichier) {
        List<Produit> produits = fetchall(fichier);
        return produits;
    }

    public static List<Produit> trier(File fichier) {
        List<Produit> produits = fetchall(fichier);
        Collections.sort(produits);
        return produits;
    }

/*    public static List<Produit> emailCorrect(List<Produit> liste) {
        List<Produit> correctEmail = new ArrayList<Produit>();
        String regex = "\\w{5,}@\\w{3,8}[.]\\w{3}";
        Pattern pattern;
        Matcher matcher;

        for (Produit produit : liste){
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(produit.getEmail());

            if(matcher.matches()){correctEmail.add(produit);}
        }

        return correctEmail;
    }

    public static List<Produit> numeroTelephoneCorrect(List<Produit> liste) {
        List<Produit> correctNum = new ArrayList<Produit>();
        String regex = "0{2}228[ .-][97]\\d{1}([ .-]\\d{2}){3}";
        Pattern pattern;
        Matcher matcher;

        for (Produit produit : liste){
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(produit.getNumPersonnel());

            if(matcher.matches()){correctNum.add(produit);}
        }

        return correctNum;
    }*/

    public static List<Produit> fetchall(File fichier) {
        List<Produit> produits = new ArrayList<Produit>();
        try{
            FileInputStream fileIn = new FileInputStream(fichier);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            do{
                Object obj = objectIn.readObject();
                if(obj==null)break;
                Produit etu = (Produit)(obj);
                produits.add( etu );
                // System.out.println(res);
            }while(true);
            objectIn.close();
        }
        catch(Exception e){
        }
        return produits;
    }

    public static File writeall(List<Produit> produits, File fichier) {
        try{
            FileOutputStream sortie = new FileOutputStream(fichier);
            ObjectOutputStream oos = new ObjectOutputStream(sortie);

            for(Iterator<Produit> it = produits.iterator(); it.hasNext();){
                Object etu = it.next();
                oos.writeObject(etu);
                oos.flush();
            }

            oos.close();

        }catch (Exception e) {
            
        }
        return fichier;
    }
    
    public static File writearray(List<Produit> produits, File fichier) {
        try{
            FileOutputStream sortie = new FileOutputStream(fichier);
            ObjectOutputStream oos = new ObjectOutputStream(sortie);
            
            oos.writeObject(produits);
            oos.flush();
            System.out.println("Yes");
            oos.close();

        }catch (Exception e) {
            
        }
        return fichier;
    }

    public static void main(String[] args) {
        System.out.println("Debut");
        File fichier = new File("ipnet.tmp");
        Produit p1 = new Produit("ASSEKOUDA", "samtou", "00228 93 87 03 35", "00228 93 87 03 35", "samtou1999da@gmail.com");
        Produit p2 = new Produit("TOHE", "wisdom", "00228 9 85 03 352", "00228 9 85 03 352", "samtou1999da@gmail");
        Produit p3 = new Produit("SAKIYE", "prosper", "228 93 87 03 352 sss", "00228 9 85 03 352", "samtou1999da@gmail");
        Produit p4 = new Produit("BALAKIM", "yakim", "00228 96 00 12 90", "00228 9 85 03 352", "balakim@gmail.com");
        fichier = ajoutPersonne(p1, fichier);
        fichier = ajoutPersonne(p2, fichier);
        fichier = ajoutPersonne(p3, fichier);
        fichier = ajoutPersonne(p4, fichier);
        List<Produit> res = new ArrayList<>();
//        List<Personne> res = lire(fichier);
        res.add(p1);
        res.add(p2);
        res.add(p3);
        res.add(p4);
        writearray(res, fichier);
//         System.out.println(res);
//         res = trier(fichier);
//         System.out.println(res);
//         res = numeroTelephoneCorrect(res);
//         res = emailCorrect(lire(fichier));
//         System.out.println(res);
        System.out.println("Fin");
    }
}
