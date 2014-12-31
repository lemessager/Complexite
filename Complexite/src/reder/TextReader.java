package reder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.Problem;
import model.Rectangle;

/**
 * 
 * Modelise le probleme a partir d'un fichier texte
 * 
 * @author Benjamin
 *
 */
public class TextReader  {



	public static Problem createProblem(String textLink) {
		
		Problem p = new Problem();

		// Loadind the file
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(textLink));

			try {
				String line = br.readLine();
				
					firstLine(line, p);
					
				
					line = br.readLine();
				
					secondLine(line, p);
					
					return p;
			} catch (ReadingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				br.close();
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * Dans le format choisi, la premiere ligne du texte correspond au dimension de la bin
	 * 
	 * la hauteur et la largeur sont separes par la lettre x
	 * 
	 * @param st
	 * @param p
	 * @throws ReadingException envoit une exception si le texte n'est pas correctement formate
	 */
	private static void firstLine(String st, Problem p) throws ReadingException {
		
		String[] elements = st.split("x");
		try {
			p.setHeight(Integer.parseInt(elements[0]));
			p.setWidth(Integer.parseInt(elements[1]));
			//System.out.println(""+p.getHeight()+","+p.getWidth());
		} catch (NumberFormatException e) {
			throw new ReadingException("impossible de lire la premiere ligne du fichier");
		}
	}
	
	/**
	 * 
	 * La seconde ligne est une enumeration des rectangles que contient le probleme
	 * 
	 * 
	 * @param st
	 * @param p
	 * @throws ReadingException
	 */
	private static void secondLine(String st, Problem p) throws ReadingException {
		String[] elements = st.split(" ");
		for (String element : elements){
			p.addRectangle(readRectangle(element));
		}
	}
	
	/**
	 * Prend en parametre une chaine de charactere de la forme ixj
	 * 
	 * ou i et j sont convertibles en entiers
	 * 
	 * renvoit un rectangle de dimensions i j
	 * 
	 * @param element
	 * @return
	 * @throws ReadingException
	 */
	private static Rectangle readRectangle(String element) throws ReadingException{
		
		String[] elements = element.split("x");
		
		try {
			
			int i=Integer.parseInt(elements[0]);
			int j= Integer.parseInt(elements[1]);
			
			return new Rectangle(i, j);
		} catch (NumberFormatException e) {
			throw new ReadingException("rectangle invalid dans le fichier");
		}
		
		
	}
	
	
	
	
}
