package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import util.Serialisation;

public class Question implements Serializable{
	 // pas d'accès aux fichiers 
	private String author;
	private String theme;
	private List<String> clues;
	private String answer;
	
	public Question(String author, String theme, String answer) {
		this.author = author;
		this.theme = theme;
		this.answer = answer;
		this.clues=new ArrayList<>();
	}
	
	
	public void ajoutClue(String clue) {
		if(!clues.contains(clue) && clues.size()<3) clues.add(clue);
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author==null || author.length()<0) return;
		this.author = author;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		if(theme==null || theme.length()<0) return;
		this.theme = theme;
	}

	public List<String> getClues() {
		return clues;
	}

	public void setClues(List<String> clues) {
		if(clues==null) return;
		this.clues = clues;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		if(answer==null || answer.length()<0) return;
		this.answer = answer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "clues=" + clues + ", answer=" + answer +"\n";
	}
	
	public void afficher() throws InterruptedException {
		// réglage par défaut sur 5 sec
		this.afficher(5);
	}
	
	public void afficher(int temps) throws InterruptedException {
		for(String clue:clues) {
			System.out.println(clue);
			Thread.sleep(temps*1000);
		}
		System.out.println(answer);
	}
	
	// évaluer l'utilité
	
	// classe Question ne gère pas les fichiers
	// pas de flux objets
	
	public String toJson() {
		Gson json=new Gson();
		return json.toJson(this);
	}
	
	// on passe la chaine de car lue par la sérialisation
	public static Question fromJson(String lectureFichier) {
		Gson json=new Gson();
		return json.fromJson(lectureFichier, Question.class);
	}
	
	
}
