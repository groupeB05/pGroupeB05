package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Deck implements Serializable {
	
	private List<Question> questions;
	
	public Deck() {
		this.questions=new ArrayList<Question>();
	}
	
	public void ajouterQuestion(String author,String theme,String answer,String clue1,String clue2,String clue3) {
		Question q=new Question(author, theme, answer);
		
		q.ajoutClue(clue1);
		q.ajoutClue(clue2);
		q.ajoutClue(clue3);
		questions.add(q);
	}
	
	
	public void afficherQuestions() throws InterruptedException {
		this.afficherQuestions(5);
	}
	
	public void afficherQuestions(int temps) throws InterruptedException {
		for(Question qst:questions) {
			qst.afficher(temps);
		}
	}
	
	@Override
	public String toString() {
		return "Deck [questions=" + questions + "]";
	}

}
	
	
	
	

