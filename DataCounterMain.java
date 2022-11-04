

/*	Autore: Fabrizio Cau (508700)
 *	Progetto Programmazione II 2017/18 Prima Parte
 *	Applicazione cliente DataCounter (main) per analisi documenti di testo
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;
 
public class DataCounterMain {
	
	public static void main(String[] args) throws IOException {
		
	//	DataCounterHashtable<String> dc = new DataCounterHashtable<String>();
		DataCounterTreeMap<String> dc = new DataCounterTreeMap<String>();
		
		// upload e decodifica del file
		File file = new File("Test\\testfile.txt");
		BufferedReader br  = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

		String curLine = "";
		String wholeDoc = "";
		
		// copia di ciascuna riga del file sulla stringa wholeDoc
		while (curLine != null) {
			wholeDoc = wholeDoc.concat(curLine);
			curLine = br.readLine();
		}
		
		// lenWspaces = n caratteri senza spazi, lenWOspaces = n caratteri senza spazi
		int lenWspaces = wholeDoc.length();
		int lenWOspaces = 0;
		
		// pulizia da punteggiatura e maiuscole e divisione della stringa in un array di parole
		String[] words  = wholeDoc.trim().replaceAll("\\p{Punct}", " ").toLowerCase().split(" ");
		
		// popolamento della collezione 
		for(String w : words) {
			if(!w.equals("")) {
				dc.incCount(w);
				lenWOspaces+=w.length();
			}
		}
		
	
		Iterator<String> it = dc.getIterator();
		
		int i = 1;
		System.out.format("[%5s] [%-21s] [%11s] \n", "Order", "word frequency count", "Occurrences");
		
		// stampa
	    while (it.hasNext())  {  
	    	String cur = it.next();
	        System.out.format("[%5s] [%-21s] [%-11s]\n", i, cur, dc.getCount(cur));
	        i++;
	    }
  
	    // stampa statistiche
	    System.out.println("Number of characters (including spaces): "+lenWspaces);
	    System.out.println("Number of characters (without spaces): "+lenWOspaces);
	    System.out.println("Number words: "+words.length);
	    

	}
}





