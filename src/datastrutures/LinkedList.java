package datastrutures;

/**
 *
 * @author jonh_
 */
import java.util.Comparator;

import Interface.Iterator;
import Interface.ListaEncadeada;
import Interface.Sort;
/**
 * Implementação de Lista Duplamente encadeada Utilizando Iterator e Insertion sort
 */
public class LinkedList<T> implements Iterable<T>, Sort<T> {

	
	private Dado head;
	private Dado tail;
	
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void append(T data) {
		Dado novo = new Dado(data);
		if (tail == null) {
			head = novo;
		} else {
			novo.previous = tail;
			tail.next = novo;
		}
		tail = novo;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Lista(this);
	}

	@Override
	public void efficientSort(Comparator<T> cmp) {
		if (head == null) return;
		Dado novo = head.next;
		while (novo != null) {
			Dado current = novo.previous, next = novo.next;
			while (current!=null && cmp.compare(current.data, novo.data) > 0)
				current = current.previous;
			stableSort(novo, current);
			novo = next;
		}
	}

	private void stableSort(Dado novo, Dado current) {
		if (current != null && current.next == novo)
			return;
		Dado previous = novo.previous;
		Dado next = novo.next;
		previous.next = next;
		// remove novo
		if (novo == tail)
			tail = previous;
		novo.remove();
		// Insere depois do current.
		if (current != null) {
			novo.insert(current,current.next);
		} else {
			novo.insert(null,head);
			head = novo;
		}
	}

        class Dado {
		T data;
		public Dado previous;
		public Dado next;
		
		Dado(T data) {
			this.data = data;
		}		
		void insert(Dado before, Dado after) {
			this.previous = before;
			this.next = after;
			if (before != null)
				before.next = this;
			if (after != null)
				after.previous = this;
		}
		void remove() {
			if (previous != null)
				previous.next = next;
			if (next != null)
				next.previous = previous;
			next = null;
			previous = null;
		}
	}
        
        class Lista implements ListaEncadeada<T> {

		LinkedList<T> container;
		Dado current;
		
		public Lista(LinkedList<T> container) {
			this.container = container;
			this.current = container.head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public boolean hasPrevious() {
			return current == null || current.previous != null;
		}

		@Override
		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}

		@Override
		public T previous() {
			if (current == null)
				current = container.tail;
			else
				current = current.previous;
			return current.data;
		}

		@Override
		public void insert(T data) {
			if (current == head)
				throw new IllegalStateException("Usage before next().");
			Dado novo = new Dado(data);
			Dado old, prev;
			if (current == null) {
				old = tail;
				prev = tail.previous;
			} else {
				old = current.previous;
				prev = old.previous;
			}
			novo.insert(prev, old);
			if (prev == null)
				head = novo;
		}

		@Override
		public void append(T data) {
			if (head == null) {
				
				throw new IllegalStateException("Iterador nao aceita lista vazia");
			}
			Dado novo = new Dado(data);
			if (current == null) {
				current = tail;
			}
			if (current.next == null)
				tail = novo;
			novo.insert(current, current.next);
			current = novo;
		}

		@Override
		public void remove() {
			if (current == head)
				throw new IllegalStateException("");
			if (tail == head || current == null) {
				Dado prev = tail.previous;
				tail.remove();
				if (tail == head)
					head = prev;
				tail = prev;
				return;
			}
			Dado next = current;
			current = current.previous;
			if (current == head)
				head = current.next;
			current.remove();
			current = next;
		}
	}
}