

/*	Autore: Fabrizio Cau (508700)
 *	Progetto Programmazione II 2017/18 Prima Parte
 *	Implementazione tipo di dato DataCounter - HashTable
 */

import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

 
public class DataCounterHashtable<E extends Comparable<E>> implements DataCounter<E> {
	/* Funzione di Astrazione e Invariante di Rappresentazione 
	 * 
	 * AF: un insieme di associazioni chiave-valore <K,V> tale che dataC.get(K) = V
	 *
	 *
	 * RI: dataC != null && per ogni chiave k della collezione => (k != null && dataC.get(k) != null && dataC.get(k) > 0 )
	 * && non esistono chiavi uguali && dataC != null
	 *
	 */
	 
	
	private Hashtable<E,Integer> dataC;
	 
	public DataCounterHashtable() {		 
		//MODIFIES: this
		//EFFECTS: inizializza la collezione vuota	
		dataC = new Hashtable<E,Integer>(); 
	}

	public void incCount(E data) throws NullPointerException {
		if(data == null || dataC == null) 
			throw new NullPointerException();
		Integer newInt;
		if(dataC.containsKey(data)) {
			newInt = new Integer((dataC.get(data)).intValue()+1);
			dataC.put(data,newInt);
		} else {
			newInt = new Integer(1);
			dataC.put(data,newInt);			
		}
	}
	
	public int getSize() {	
		if(dataC == null)
			throw new NullPointerException();
		return dataC.size();
	}
			
	public int getCount(E data) {
		if(data == null || dataC == null)
			throw new NullPointerException();
		if(dataC.get(data) == null)
			return 0;
		else 
			return dataC.get(data).intValue();	
	}
		
	public Iterator<E> getIterator() { 
		if(dataC == null)
			throw new NullPointerException();
		if(dataC.isEmpty())
			throw new EmptyCollectionException();
		Set<E> sortedData = new TreeSet<E>(new Comparator<E>() {
	        @Override
	        public int compare(E o1, E o2) { 
	        	if(dataC.get(o1).compareTo(dataC.get(o2))==0)
	        		return o1.compareTo(o2);
	            else
	            	return dataC.get(o2).compareTo(dataC.get(o1));
		        }
			});
		sortedData.addAll(dataC.keySet());	
		Iterator<E> itr = new MyIterator<E>(sortedData.iterator());
		return itr;
	}	
	
 }