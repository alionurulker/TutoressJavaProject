/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoressproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author stillLoading
 */
class StudentPointStatus {
    
    private int verbPoint;
    private int nounPoint;
    private int adjectivePoint;
    private int adverbPoint;
    private int getRegisterCountPoint;
    
    public StudentPointStatus() {
        verbPoint = 0;
        nounPoint = 0;
        adjectivePoint = 0;
        adverbPoint = 0;
    }
    

    public int getVerbPoint() {
        return verbPoint;
    }

    public int getNounPoint() {
        return nounPoint;
    }

    public int getAdjectivePoint() {
        return adjectivePoint;
    }

    public int getAdverbPoint() {
        return adverbPoint;
    }

    public int getGetRegisterCountPoint() {
        return getRegisterCountPoint;
    }

    public void setGetRegisterCountPoint(int getRegisterCountPoint, String WhichVocabulary) {
        if(WhichVocabulary.equals("Verbs")){
            verbPoint = getRegisterCountPoint;
        }
        if(WhichVocabulary.equals("Adjectives")){
            adjectivePoint = getRegisterCountPoint;
        }
        if(WhichVocabulary.equals("Adverbs")){
            adverbPoint = getRegisterCountPoint;
        }
        if(WhichVocabulary.equals("Nouns")){
            nounPoint = getRegisterCountPoint;
        }
    }
    
    public void getPoints() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.bin"))){
                        Profil userPoint = (Profil)in.readObject();
                        verbPoint = userPoint.getVerbPoint();
                        adjectivePoint = userPoint.getAdjectivePoint();
                        adverbPoint = userPoint.getAdverbPoint();
                        nounPoint = userPoint.getNounPoint();
                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {
                        System.out.println("IOException occurred while opening file...");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Class not found...");
                    }
    }
    public void PointKnowladgeRegister(){
            try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.bin"))){
                        
                Profil Point1 = new Profil(verbPoint ,nounPoint, adjectivePoint, adverbPoint);
                        
                out.writeObject(Point1);//writeObject gönderdiğim Point1 objesini en üst Object'e dönüştürecek daha sonra bunu Byte dizisine dönüştürüp ogrenci.bin dosyasına yazacaktır.
                        
            } catch (FileNotFoundException ex) {
                System.out.println("An error occurred while writing file......");
            } catch (IOException ex) {
                System.out.println("IOException occurred while opening file...");
            }    
    }
}
