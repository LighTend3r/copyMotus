package project.motus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Motus {
	private String currentWord;
	private final String fileBDD = "bdd/word2.txt";

	//private Joueur joueur;
	
	public Motus() {
		this.currentWord="BANANE";
	}
	
	public String[] check(String checkWord) {
		/*
		 * T = True (bonne emplacement)
		 * F = False (false) (existe pas)
		 * A = Almost (exite mais pas a la bonen place
		 */
		checkWord = checkWord.toUpperCase();
		currentWord = currentWord.toUpperCase();
		
		if(checkWord.length() != this.currentWord.length()) {
			System.out.println("Le nombre de caractère est différent, c'est impossible !!");
			return null;
		}
		
		HashMap<String, Integer> checkValue = new HashMap<String, Integer>();
		
		String[] sortie = new String[checkWord.length()];
		
		for( int i = 0; i<checkWord.length(); i++) {
			String lettre = checkWord.substring(i, i+1);
			if(checkWord.charAt(i) == currentWord.charAt(i)) {
				sortie[i] = "T";
				if (!checkValue.keySet().contains(checkWord.substring(i, i+1))) {
					checkValue.put(lettre, 1);
				} else {
					checkValue.put(lettre, checkValue.get(lettre) + 1);
				}
			} else if (!currentWord.contains(lettre)) {
				sortie[i] = "F";
			}
		}
		for( int i = 0; i<checkWord.length(); i++) {
			String lettre = checkWord.substring(i, i+1);
			if (!(checkWord.charAt(i) == currentWord.charAt(i)) && currentWord.contains(lettre)) {
				int nb = 0;
				for( int j = 0; j<checkWord.length(); j++) {
					if (checkWord.charAt(i) == currentWord.charAt(j)) {
						nb++;
					}
				}
				if (checkValue.get(lettre) == null) {
					checkValue.put(lettre,  1);
					sortie[i] = "A";
				} else if ( checkValue.get(lettre) < nb){
					checkValue.put(lettre, checkValue.get(lettre) + 1);
					sortie[i] = "A";
				} else {
					sortie[i] = "F";
				}
			}
		}
		
		return sortie;
	}
	
	public void choiceWord() throws IOException {
		FileReader file = new FileReader(fileBDD);
		BufferedReader buffer = new BufferedReader(file);
		Random r = new Random();
		int ligne =  r.nextInt(7146);
		for (int i = 0; i < 7146; i++) {
			String mot = buffer.readLine();
			if (i == ligne) {
				this.currentWord = mot;
				return ;
			}
		}
		System.out.println("Aucun mot n'a était choisi");
		return ;
	}
	
	public String getCurrentWord() {
		return this.currentWord;
	}
	
	public int getLenWord() {
		return this.currentWord.length();
	}
	
}
