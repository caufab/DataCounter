

/*	Autore: Fabrizio Cau (508700)
 *	Progetto Programmazione II 2017/18 Prima Parte
 *	Interfaccia Java DataCounter e specifica
 */

import java.util.Iterator;

public interface DataCounter<E> {
	//OVERVIEW: Una collezione modificabile di elementi ai quali è associato un valore intero che 
	// ne indica la quantità (ripetizione)  
	//TYPICAL ELEMENT: un insieme di coppie di dato-valore <K,V>
	
	
	public void incCount(E data);
	//REQUIRES: data != null
	//MODIFIES: this
	//THROWS: NullPointerException(unchecked) se data == null o se la collezione è null
	//EFFECTS: aggiunge data alla collezione, se è già presente incrementa il valore associato di 1
	
	
	public int getSize();
	//THROWS: NullPointerException(unchecked) se la collezione è null
	//EFFECTS: restituisce il numero degli elementi presenti nella collezione, 0 se questa è vuota.
	
	
	public int getCount(E data);
	//REQUIRES: data != null
	//THROWS: NullPointerException(unchecked) se data == null o se la collezione è null
	//EFFECTS: restituisce il valore associato all'elemento data della collezione, se data non appartiene alla 
	// collezione restituisce 0	
	
	
	public Iterator<E> getIterator();
	//THROWS: EmptyCollectionException(unchecked) se la collezione è vuota, o NullPointerException(Unchecked) se la collezione è null 
	//EFFECTS: restituisce un iteratore senza remove per le chiavi della collezione ordinate per valore non crescente
	// e a parità di valore per chiave non decrescente
	
	
}