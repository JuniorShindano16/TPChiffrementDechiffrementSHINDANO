# TravailChiffrementDechiffrement
Travail fait en java pure.
Nous avons premièrement écrit 5 Fonctions :
   1) Permutation qui reçcoit en parametre deux tableaux qui sont la fonction de permutation et le mot à permuter et renvoie un tableau;
   2) OU logique qui reçoit en parametre deux tableaux et renvoie un tableau ;
   3) OU exclusif qui reçoit en parametre deux tableaux et renvoie un tableau ;
   4) ET logique qui reçoit en parametre deux tableaux et renvoie un tableau ;
   5) Division du mot qui reçoit en parametre un tableaux et renvoie une liste.
Nous avons jugé bon de creer ces fonctions pour ne pas avoir à réecrire les mêmes codes par la suite.
Nous avons par la suite declarer notre H qui sera la fonction de permutation pour la clé et K qui sera notre clé pour générer les deux parties K1 et K2 que nous avons en definitif appellé K11 et K21.

Nous avons imposé à l'utilisateur d'entrer une suite de 0 et de 1 pour la clé et des nombres compris entre 0 et 7 sans repeter pour la fonction de permutation.
Après avoir appliqué tous les algorithme nous avons pu :
    1) Demander à l'utilisateur d'entrer les valeurs à manupiler avec une certaine structuration
    2) Effectuer les opérations sur les données telles que décrites dans l'annuaire du projet
    3) Generer les deux parties de la clé.
Nous avons par la suite entamer le processus de cryptage en procedant de la meme manière, càd demander à l'utilisateur d'entrer le mot à chiffrer et la fonction de permutation.
Nous avons par la suite generer les deux autres clé pour inverser avec la fonction de permutation de longeur 4.

voici le petit code qui decrit comment effectuer l'inverse de la fonction de permutation : 
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
 A la fin du processus de chiffrement, nous avons pu effectuer : 
       1) le chiffrement du mot en concatenant les deux parties 
       2) l'affichage de toutes les données manipuler.
 Nous avons par la suite pu effectuer le dechiffrement très facilement grace à nos fonction que nous avons juste appellé.
 
 Pour executer et voir le resultat, nous vous prions de bien pouvoir copier le code et de le coller dans un projet sur Netbeans ou Eclips.
