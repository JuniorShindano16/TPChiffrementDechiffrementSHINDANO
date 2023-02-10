/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travailsecuritecryptagedecryptage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author shindano
 */
public class TravailSecuriteCryptageDecryptage {

  /**
     * @param args the command line arguments
     */
    
    
    /////1)Definition des fonctions
          //1.1) FONCTION POUR APPLIQUER LES PERMUTATIONS SUR DES MOTS AVEC UN TABLEAU D'INDICES
    
      public static int [] permutation(int [] word, int [] permutation){
        int index=0; //index qui va recuperer les indices
        
        int[] tempo=new int[word.length];// la table temporelle qui nous permettra d'effectuer l'echange
         for (int i =0; i < permutation.length; i++) {
           index = permutation[i];
          tempo[i] = word[index];
          }
         word=tempo;
         return word;
    }
      
         //1.2) FONCTION POUR LA DIVISION D'UN MOT EN DEUX 
      
          public static List<int []> DividedWord(int [] MotDiviser){
        List<int []> list=new ArrayList<>();// LISTE QUI AURA POUR ELEMENTS LES DEUX PARTIES ET QUI SERA RENVOYER DANS LA FONCTION PRINCIPAL
        int taille = MotDiviser.length;
       int longeurK1 = MotDiviser.length/2;
      int longeurK2 = taille-longeurK1;
       int [] K1= new int[longeurK1]; //Premiere partie du mot à diviser 
       int [] K2 = new int[longeurK2]; // Deuxieme partie du mot à diviser
       
       //DEFINITION DE LA PREMIERE PARTIE DU MOT
        for (int i = 0; i < longeurK1; i++) {
            //la boucle part de 0 à la longueur de la moitié du tableau qui est la longueur des deux parties
            K1[i]=MotDiviser[i];
        }
       
        // DEFINITION DE LA DEUXIEME PARTIE DU MOT
        for (int i=longeurK1 ; i < taille; i++) {
            
            K2[i-longeurK1]=MotDiviser[i];
            
        }
        
        //AJOUT DES MOTS A LA LIST A RENVOYER
        list.add(K1);
        list.add(K2);
        return list;
    }
          //1.3) FONCTION QUI PRENDRA EN CHARGE L'APPLICATION DU "ET" LOGIQUE
          
          public static  int [] EtLOgique(int [] A,int [] B){
        int[] Tempo=new int[A.length];
        for (int i = 0; i < A.length; i++) {
        Tempo[i]= (A[i]==1&&B[i]==1)?1:0;//APPLICATION D'UNE FONCTION TERNAIRE : SI LES CONDITIONS SONT VERIFIEES ALORS 1 SINON 0
        }
        return Tempo;
    }
          
         //1.4) APPLICATION DU "OU" LOGIQUE
          
           public static  int [] OuLogique(int [] A,int [] B){
        int[] Tempo=new int[A.length];
        for (int i = 0; i < A.length; i++) {
        Tempo[i]= (A[i]==1||B[i]==1)?1:0;//APPLICATION D'UNE FONCTION TERNAIRE : SI LES CONDITIONS SONT VERIFIEES ALORS 1 SINON 0
        }
        return Tempo;
    }
          
          //1.5) APPLICATION DU "OUEXCLUSIF" 
          
           public static  int [] Ouexclusive(int [] A,int [] B){
        int[] Tempo=new int[A.length];
        for (int i = 0; i < A.length; i++) {
        Tempo[i]= (A[i]==B[i])?0:1;//APPLICATION D'UNE FONCTION TERNAIRE : SI LES CONDITIONS SONT VERIFIEES ALORS 1 SINON 0
        }
        return Tempo;
    }
                
          
          
    public static void main(String[] args) {
        // TODO code application logic here
        int [] H = new int [8];
        int [] K = new int [8];
        Scanner valeur = new Scanner(System.in); // variable qui permet d'inserrer des valeurs dans H
        
        System.out.println("ENTRER LA FONCTION 'H'");
            
           
         int compteur1=0;
          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 7 : ");
          while (compteur1<H.length){
           int x= valeur.nextInt();
          
           if (x>=0 && x<=7){
           boolean seul = true;
             for (int i = 0; i < compteur1; i++) {
               if (H[i]==x){
                   System.out.println("cette valeur existe dans H");
                   seul =false;
                   break;
               }
           }
               if (seul) {
                    
           H[compteur1]=x;
           compteur1 ++;
               } 
           }
           else {
               
                System.out.println("La valeur doit être comprise entre 0 et 7.");
               }
       }
         System.out.println("Le H est :"+Arrays.toString(H));
         
         Scanner valeurCle = new Scanner(System.in);// variable qui permet d'inserrer des valeurs dans K
         
         System.out.println("ENTRER LA VALEUR DE LA CLE QUI EST UNE SUITE DE 0 ET 1");
         
            for (int i = 0; i < K.length; i++) {
            int x =  valeurCle.nextInt(); 
            //imposition à l'utilisateur d'entre que des 0 et 1
            while (x!=0&& x!=1) {                
                 System.out.println("ENTRER 1 ou 0");
                x=  valeurCle.nextInt();
            }
             K[i]=x;
        }
         
          System.out.println("'K'"+Arrays.toString(K));
          
          K= permutation(K, H); //Applicatio de la fonction H sur la clé K
          
           System.out.println("K Après permutation :"+Arrays.toString(K));
           
           //PROCESSUS DE GENERATION DES K1 ET K2 QUI SERONT RESPECTIVEMENT K11 et K21
        int taille = K.length;
        int longeurK1 = K.length/2;
        int longeurK2 = taille-longeurK1;
        int [] K1= new int[longeurK1];
        int [] K2 = new int[longeurK2];
        
        //DECLARATION DES K'1 e K'2
        
        K1=DividedWord(K).get(0);// Application de la fonction de division sur la clé K et recuperation de la Premiere partie
        K2=DividedWord(K).get(1);// Application de la fonction de division sur la clé K et recuperation de la deuxieme partie
        
        System.out.println("Première clé générée : " +Arrays.toString(K1));
        System.out.println("Deuxième clé générée : " +Arrays.toString(K2)); 
        
        
        //Application des  opérations logiques sur les deux portion de la clé K1 et K2
        
        int [] tempo; //Tableau temporelle qui nous permettre de garder des valeurs sans les ecraser
        int a=0;//variable temporelle qui nous permettra d'applique la permutation d'odre 1 à droite
        
        int[] K11=new int [K1.length];
        int [] K21= new int [K2.length];
        
        K11 = Ouexclusive(K1, K2);
        K21 = EtLOgique(K1, K2);
        
        System.out.println("Première clé générée avec opérations logique K11: " +Arrays.toString(K11));
        System.out.println("Deuxième clé générée avec opérations logique K21: " +Arrays.toString(K21)); 
        
         //Application du decalage pour generer les deux clés 
         
        //pour K11
        tempo=new int[K11.length];
         for (int i = 2; i < K11.length; i++) {
            tempo[i-2]=K11[i];
        }
         tempo[K11.length-1]=K11[1];
         tempo[K11.length-2]=K11[0];
         K11=tempo;
        
         System.out.println("Première clé applicative K1: " +Arrays.toString(K11));
         
         // Pour K21
         tempo=new int[K21.length];
        a= K21[K21.length-1]; //Nous gardons la dernière valeur du tableau dans a
          
          tempo[0]=a; // dans notre tableau temporel, nous plaçons à la premiere position a
          
         for (int i = 0; i < K21.length-1; i++) {//partant de 0 à l'avant derniere position 
            tempo[i+1]=K21[i]; //Nous plaçons les element de K21[i] à la position i+1 de la table temporelle
        }
        K21=tempo; //le tempo va dans la variable K21
        
         System.out.println("Deuxième clé applicative K2: " +Arrays.toString(K21));
        
         //CRYPTAGE DU MOT
         
       int [] mot = new int [8] ;
       int [] pi = new int [8];
       
       Scanner motEntre = new Scanner(System.in);
       Scanner piEntre = new Scanner(System.in);
       
       //saisi du mot et de la fonction de permutation pour le mot
       
       //MOT
       
        System.out.println("SAISISSEZ LE MOT A CRYPTER QUI EST UNE SUITE DES 1 ET DES 0: " ); 
        for (int i = 0; i < mot.length; i++) {
            int x = motEntre.nextInt(); 
            //imposition à l'utilisateur d'entre que des 0 et 1
            while (x!=0&& x!=1) {                
                 System.out.println("ENTRER 1 ou 0");
                x= motEntre.nextInt();
            }
            mot[i]=x;
        }
        
        System.out.println("Le mot à crypter :"+Arrays.toString(mot));
        
        
        //PERMUTATION Pi
         System.out.println("ENTRER LA FONCTION DE PERMUTTATION Pi");
         int compteur=0;
         
          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 7 : ");
          while (compteur<pi.length){    
           int x= piEntre.nextInt();
           if (x>=0 && x<=7){
           boolean seul = true;
             for (int i = 0; i < compteur; i++) {
               if (pi[i]==x){
                   System.out.println("cette valeur existe dans Pi");
                   seul =false;
                   break;
               }
           }
               if (seul) {
                    
           pi[compteur]=x;
           compteur++;
               } 
           }
           else {
               
                System.out.println("La valeur doit être comprise entre 0 et 7.");
               }
       }
         System.out.println("Le pi :"+Arrays.toString(pi));
         
         
       mot= permutation(mot, pi);
        System.out.println("MOT PERMUTER "+Arrays.toString(mot));
        
        //entrée de la foction de permutation sur les mots qui sortiront du message
         
         int compteur2=0;
         int [] p = new int [4];
         Scanner val= new Scanner(System.in);
          System.out.println("ENTRER UNE VALEUR COMPRISE ENTRE 0 et 3 : ");
          while (compteur2<p.length){
       
          
           int x= val.nextInt();
          
           if (x>=0 && x<=3){
           boolean seul = true;
             for (int i = 0; i < compteur2; i++) {
               if (p[i]==x){
                   System.out.println("cette valeur existe dans H");
                   seul =false;
                   break;
               }
           }
               if (seul) {
                    
           p[compteur2]=x;
           compteur2 ++;
               } 
           }
           else {
               
                System.out.println("La valeur doit être comprise entre 0 et 3.");
               }
       }
         
        System.out.println("P est :"+Arrays.toString(p));
        
        int [] Go=DividedWord(mot).get(0);// partie de gauche du mot
        int []Do=DividedWord(mot).get(1);// partie de droitr du mot
        System.out.println("Mot de gauche Go: " +Arrays.toString(Go));
        System.out.println("Mot de droite Do: " +Arrays.toString(Do));
        
        int [] D1=Ouexclusive(permutation(Go, p), K11);//partie de droite améliorée
        int [] G1=Ouexclusive(Do, OuLogique(Go, K11));// partie de gauche amélioré
        
        System.out.println("Mot de gauche amélioré G1: " +Arrays.toString(G1));
        System.out.println("Mot de droite amélioré D1: " +Arrays.toString(D1));
        
        
        int [] D2 = Ouexclusive((permutation(G1, p)), K21);
        int [] G2 = Ouexclusive(D1, OuLogique(G1, K21));
        System.out.println("Mot de gauche dernière amélioration G2: " +Arrays.toString(G2));
        System.out.println("Mot de droite dernière amélioration D2: " +Arrays.toString(D2));
        
        
        
         //Concatenation de G2 et D2 et application de l'inverse de permutation 
        
        int [] C = new int [D2.length+G2.length];
        
        System.arraycopy(G2,0, C, 0, G2.length);
        System.arraycopy(D2,0, C, G2.length, D2.length);
        
        System.out.println("C = "+Arrays.toString(C));
        tempo=new int[pi.length];
        for (int i = 0; i < pi.length; i++) {
            int j=0;
            boolean bl=false;
            do{
                if(pi[j]==i){
                    bl=true;
                }
                else j++;
            }while(!bl);
            tempo[i]=j;
        }
        int[] pi1=tempo;
        
        int [] inversePi= new int [pi.length];
        
        System.out.println("pi1 = "+Arrays.toString(pi1));
        
        C= permutation(C, pi1);
         System.out.println("Mot Crypter = "+Arrays.toString(C));
         
         // DEBUT PROCESSUS DE DECHIFFREMENT
      int [] textClaire = new int [8];
      
      int [] textChiffre= C;
      
       int [] textpermuter = permutation(textChiffre, pi);
       
       int [] textpermuterDroit = DividedWord(textpermuter).get(1);
       int [] textpermuterGauche = DividedWord(textpermuter).get(0);
       
        System.out.println("les deux parties du mot chiffré sont :"+Arrays.toString(textpermuterGauche)+" et "+Arrays.toString(textpermuterDroit));
        
        //Application Round 1 
        
        int [] Gauche1 = permutation(Ouexclusive(D2, K21), pi1);
        int [] Droit1= Ouexclusive(G2, OuLogique(Go, K1));
        
        //Application Round 2 
        
        int [] dernierGauche = permutation(Ouexclusive(D1, K1), pi1);
        int [] dernierDroit= Ouexclusive(G1, OuLogique(Go, K1));
        
 
        
         System.arraycopy(dernierGauche,0, textClaire, 0, dernierGauche.length);
        System.arraycopy(dernierDroit,0, textClaire, dernierGauche.length, dernierDroit.length);
        
        textClaire=permutation(textClaire, pi1);
        
        
        System.out.println("LE MESSAGE EN TEXTE CLAIRE :" +Arrays.toString(textClaire));
         
          
    }
}
