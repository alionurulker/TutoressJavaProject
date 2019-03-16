package tutoressproject;

import txtcreator.FileCreator;
import java.util.Scanner;

public class TutoressProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int girdi = 0;
        int id = 0;
        String devamEt ="";
        String ContinuingChoosen ="";
        int VerbPoint = 0;
        do {
            System.out.println("1. Instructor entrance");
            System.out.println("2. Student entrance");
            System.out.print("Entrance : ");
            girdi = scanner.nextInt();
            if(girdi == 1){
                System.out.println("1. List sentences");
                System.out.println("2. Create sentences");
                System.out.println("3. View student status");
                System.out.print("Entrance : ");
                girdi = scanner.nextInt();
                if(girdi == 1){
                    System.out.println("1. listing Verb");
                    System.out.println("2. listing Noun");
                    System.out.println("3. listing Adjective");
                    System.out.println("4. listing Adverb");
                    System.out.print("Entrance : ");
                    girdi = scanner.nextInt();
                    if(girdi == 1){
                            FileCreator FC = new FileCreator("Verbs");
                            FC.ListingFile();
                    }
                    if(girdi == 2){
                            FileCreator FC = new FileCreator("Nouns");
                            FC.ListingFile();
                    }
                    if(girdi == 3){
                            FileCreator FC = new FileCreator("Adjectives");
                            FC.ListingFile();
                    }
                    if(girdi == 4){
                            FileCreator FC = new FileCreator("Adverbs");
                            FC.ListingFile();
                    }
                    girdi = 0;
                }
                if(girdi == 2){
                    do {
                        System.out.println("1. Creating Verb");
                        System.out.println("2. Creating Noun");
                        System.out.println("3. Creating Adjective");
                        System.out.println("4. Creating Adverb");
                        System.out.print("Entrance : ");
                        id=0;
                        girdi = scanner.nextInt();
                        
                        if(girdi == 1){
                            FileCreator FC = new FileCreator("Verbs");
                            FC.CreateFile();
                        }
                        if(girdi == 2){
                            FileCreator FC = new FileCreator("Nouns");
                            FC.CreateFile();   
                        }
                        if(girdi == 3){
                            FileCreator FC = new FileCreator("Adjectives");
                            FC.CreateFile();   
                        }
                        if(girdi == 4){
                            FileCreator FC = new FileCreator("Adverbs");
                            FC.CreateFile();   
                        }
                            System.out.println("Would you like to add another question? (y or n)");
                            Scanner devamEtScanner = new Scanner(System.in);
                            devamEt = devamEtScanner.nextLine();
                    } while (devamEt.equals("y"));
                    girdi=0;
                }
                if(girdi == 3){
                    StudentPointStatus accountControl = new  StudentPointStatus();
                    accountControl.getPoints();
                    System.out.println("Verb Point : "+accountControl.getVerbPoint()+"\n"+
                            "Noun Point : "+accountControl.getNounPoint()+"\n"+
                            "Adjavtive Point : "+accountControl.getAdjectivePoint()+"\n"+
                            "Adverb Point : "+accountControl.getAdverbPoint()+"\n");
                }
                girdi=0;
            }
            if(girdi == 2)
            {
                System.out.println("1. Verb sentences");
                System.out.println("2. Noun sentences");
                System.out.println("3. Adjective sentences");
                System.out.println("4. Adverb sentences");
                System.out.print("Entrance : ");
                girdi = scanner.nextInt();
                if(girdi == 1){
                    Sentences createAsentence = new Sentences("Verbs");
                    createAsentence.ControlerSentences();    
                }
                if(girdi == 2){
                    Sentences createAsentence = new Sentences("Nouns");
                    createAsentence.ControlerSentences();    
                }
                if(girdi == 3){
                    Sentences createAsentence = new Sentences("Adjectives");
                    createAsentence.ControlerSentences();    
                }
                if(girdi == 4){
                    Sentences createAsentence = new Sentences("Adverbs");
                    createAsentence.ControlerSentences();    
                }
                
            }
            System.out.println("Would you like to end the Program? ( y , n )");
            Scanner Choosen = new Scanner(System.in);
            ContinuingChoosen=Choosen.nextLine();
        } while (ContinuingChoosen.equals("n"));
    }
    
}
