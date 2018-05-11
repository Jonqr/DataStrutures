/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author jonh_
 */

public interface ListaEncadeada<T> extends Iterator<T> {
	
	boolean hasPrevious();
	
	T previous();
	
	void append(T data);
}