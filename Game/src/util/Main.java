package util;


import java.util.Scanner;

import com.google.gson.Gson;

import modele.Deck;
import modele.Question;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scan =new Scanner(System.in);
		System.out.println("Temps en secondes entre chaque indice :\n");
		int lecture;
		do {
			 lecture=scan.nextInt();
		}while(lecture<=0);
		
		
		Deck deck1=new Deck();
		deck1.ajouterQuestion("Roxane", "cuisine", "cupcake", "clue1", "clue2", "clue3");
		deck1.ajouterQuestion("Roxane", "géographie", "Belgique", "clue1", "clue2", "clue3");
		
		System.out.println("Affichage des questions du deck\n");
//		deck1.afficherQuestions(lecture);
		
		// écrire cette représentation dans un fichier, la lire et la convertir en objet
//		System.out.println("Ecriture et lecture du deck au format Json\n");
		Gson gson=new Gson();
//		String toJson=gson.toJson(deck1);
//		System.out.println(toJson);
		
		Question q1=new Question("Roxane", "cuisine", "cupcake");
		q1.ajoutClue("clue1");
		q1.ajoutClue("clue2");
		q1.ajoutClue("clue3");
		
//		System.out.println(q1.getAnswer().equalsIgnoreCase("séquoïa"));
//		
		System.out.println("Ecriture et lecture d'une question au format Json\n");
		String toJson2=gson.toJson(q1);
		String fichier="question.txt";
		Serialisation.ecrire(toJson2, fichier);
		Question qLecture=gson.fromJson(Serialisation.lire(fichier), Question.class);	
		qLecture.afficher(lecture);
		
	}
	
	

}
