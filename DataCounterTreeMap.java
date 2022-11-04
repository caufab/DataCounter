

/*	Autore: Fabrizio Cau (508700)
 *	Progetto Programmazione II 2017/18 Prima Parte
 *	Implementazione tipo di dato DataCounter - TreeMap
 */

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
 

public class DataCounterTreeMap<E extends Comparable<E>> implements DataCounter<E> {
	/* Funzione di Astrazione e Invariante di Rappresentazione 
	 *
	 * AF: un insieme di associazioni chiave-valore <K,V> tale che dataC.get(K) = V 
	 * ordinate secondo l'ordinamento naturale delle chiavi K
	 *
	 * RI: dataC != null && per ogni chiave k della collezione => (k != null && dataC.get(k) != null && dataC.get(k) > 0 )
	 * && non esistono chiavi uguali
	 *
	 */
	 
	
	private TreeMap<E,Integer> dataC;
	
	public DataCounterTreeMap() { 
		//MODIFIES: this
		//EFFECTS: inizializza la collezione vuota	
		dataC = new TreeMap<E,Integer>(); 	
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