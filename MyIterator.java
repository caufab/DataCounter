

/*	Autore: Fabrizio Cau (508700)
 *	Progetto Programmazione II 2017/18 Prima Parte
 *	Implementazione MyIterator
 */


import java.util.Iterator;


public class MyIterator<E> implements Iterator<E> {
    private Iterator<E> myIt;

    public MyIterator(Iterator<E> it) {
    	myIt = it;
    }

    public void remove() {
    	// do nothing
    }

	@Override
	public boolean hasNext() {
		return myIt.hasNext();
	}

	@Override
	public E next() {
		return myIt.next();
	}

	
 }
 
