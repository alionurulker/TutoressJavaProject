package tutoressproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

class Sentences {
    
    public String getTrueOption() {
        return trueOption;
    }

    public void setTrueOption(String trueOption) {
        this.trueOption = trueOption;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getaOption() {
        return aOption;
    }

    public void setaOption(String aOption) {
        this.aOption = aOption;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getbOption() {
        return bOption;
    }

    public void setbOption(String bOption) {
        this.bOption = bOption;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getcOption() {
        return cOption;
    }

    public void setcOption(String cOption) {
        this.cOption = cOption;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public String getdOption() {
        return dOption;
    }

    public void setdOption(String dOption) {
        this.dOption = dOption;
    }
    
    
    private String trueOption;
    private int a;
    private String aOption;
    private int b;
    private String bOption;
    private int c;
    private String cOption;
    private int d;
    private String dOption;
    private Random rnd;
    private int randomcreateASentence;
    private String question;
    private Set<String> Options = new HashSet<String>();
    StudentPointStatus accountControl = new  StudentPointStatus();
    private int[] dontCreateSameNumber;
    private String getterName;
    private String getterPassword;
    private int PointCounter;
    private String ContinuingChoice;
    private String FileName;
    public Sentences(String getFileName){
        FileName = getFileName;
        ContinuingChoice =""; 
        trueOption = null;
        a=0;
        aOption = null;
        b=0;
        bOption = null;
        c=0;
        cOption = null;
        d=0;
        dOption = null;
        rnd = new Random();
        question = null;
        randomcreateASentence = 0;
        PointCounter = 0;
    }
    
    private void createRandomOption(){ 
        randomcreateASentence = rnd.nextInt((5 - 1) + 1) + 1;
        do {                                    
            a = rnd.nextInt((5 - 1) + 1) + 1; 
        } while (a == randomcreateASentence);
        do {                                    
            b = rnd.nextInt((5 - 1) + 1) + 1;
        } while (b == randomcreateASentence || a == b);
        do {                                    
            c = rnd.nextInt((5 - 1) + 1) + 1;
        } while (c == randomcreateASentence || a == b ||  b == c ||  c == a);
        do {                                    
            d = rnd.nextInt((5 - 1) + 1) + 1;
        } while (d == randomcreateASentence || a == b ||  b == c ||  c == a || d == c || d == a || d == b);
    }
    private void nominateingFromDocument(){
        createRandomOption();
        
        try(Scanner verbsFileRead = new Scanner(new BufferedReader(new FileReader(FileName+".txt")))){
        while(verbsFileRead.hasNextLine()){

            String Line_knowladge = verbsFileRead.nextLine();
            String[] lineSplit = Line_knowladge.split(",");

            if(lineSplit[0].equals(Integer.toString(randomcreateASentence))){
                trueOption = lineSplit[2];
                question = lineSplit[1];
                Options.add(trueOption);
            }
            if(lineSplit[0].equals(Integer.toString(a))){
                Options.add(lineSplit[2]);
            }
            if(lineSplit[0].equals(Integer.toString(b))){
                Options.add(lineSplit[2]);
            }
            if(lineSplit[0].equals(Integer.toString(c))){
                Options.add(lineSplit[2]);
            }
            if(lineSplit[0].equals(Integer.toString(d))){
                Options.add(lineSplit[2]);
            }
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TutoressProject.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    private void writer() {
        createRandomOption();
        nominateingFromDocument();
        if(question == null){
            System.out.print("Please create a question about "+FileName+"...");
            System.exit(0);
        }
        System.out.println("Question : "+ question);
        
        for (String s: Options){
            System.out.println(s);
        }
        Options.clear();
        SentencesControl();
    }
    private void SentencesControl (){
        Scanner scannerCorrect = new Scanner(System.in);
        String CorrectChoise;
        System.out.print("Enter Correct Choise : ");
        do {            
            CorrectChoise = scannerCorrect.nextLine();
            if(CorrectChoise.equals(trueOption))
            {
                System.out.println("That's Correct!");
                
                PointCounter++;
                System.out.println("Your Point : "+PointCounter);
                
                accountControl.setGetRegisterCountPoint(PointCounter, FileName);
                accountControl.PointKnowladgeRegister();
            }else{
                if(PointCounter != 0){
                    System.out.print("Wrong the answer! Your point was reduced. Your Point : "+PointCounter+"\nEnter Again : ");
                    PointCounter--;
                }
                
                accountControl.setGetRegisterCountPoint(PointCounter, FileName);
                accountControl.PointKnowladgeRegister();
            }
        } while (!CorrectChoise.equals(trueOption));
    }
    public void ControlerSentences(){
        do {
            accountControl.getPoints();
            if(FileName.equals("Verbs"))
            {
                PointCounter = accountControl.getVerbPoint();
            }
            if(FileName.equals("Nouns"))
            {
                PointCounter = accountControl.getNounPoint();
            }
            if(FileName.equals("Adjectives"))
            {
                PointCounter = accountControl.getAdjectivePoint();
            }
            if(FileName.equals("Adverbs"))
            {
                PointCounter = accountControl.getAdverbPoint();
            }
            writer();
            System.out.println("Would you like another question? ( y , n )");
            Scanner ChoiseScanner = new Scanner(System.in);
            ContinuingChoice=ChoiseScanner.nextLine();
        } while (ContinuingChoice.equals("y"));
    }
}
