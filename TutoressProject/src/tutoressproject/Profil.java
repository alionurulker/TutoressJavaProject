/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoressproject;

import java.io.Serializable;

/**
 *
 * @author stillLoading
 */
class Profil implements Serializable{
    private static final long serialversionUID = 1000;
    private int vocabularyLevel;
    private int verbPoint;
    private int nounPoint;
    private int adjectivePoint;
    private int adverbPoint;

    public Profil(int verbPoint ,int nounPoint, int adjectivePoint, int adverbPoint) {
        this.vocabularyLevel = vocabularyLevel;
        this.verbPoint = verbPoint;
        this.nounPoint = nounPoint;
        this.adjectivePoint = adjectivePoint;
        this.adverbPoint = adverbPoint;
    }

    

    public int getVocabularyLevel() {
        return vocabularyLevel;
    }

    public void setVocabularyLevel(int vocabularyLevel) {
        this.vocabularyLevel = vocabularyLevel;
    }

    public int getVerbPoint() {
        return verbPoint;
    }

    public void setVerbPoint(int verbPoint) {
        this.verbPoint = verbPoint;
    }

    public int getNounPoint() {
        return nounPoint;
    }

    public void setNounPoint(int nounPoint) {
        this.nounPoint = nounPoint;
    }

    public int getAdjectivePoint() {
        return adjectivePoint;
    }

    public void setAdjectivePoint(int adjectivePoint) {
        this.adjectivePoint = adjectivePoint;
    }

    public int getAdverbPoint() {
        return adverbPoint;
    }

    public void setAdverbPoint(int adverbPoint) {
        this.adverbPoint = adverbPoint;
    }
}
