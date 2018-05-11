/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastrutures.ArvoreBinaria;

import datastrutures.ChaveDuplicada;

/**
 *
 * @author jonh_
 */

public class ArvoreBinariaPesquisa<T extends Comparable<T>> {

	private ArvoreBinaria<T> raiz;

	public void insert(T value) throws ChaveDuplicada {
		if (raiz == null) {
			raiz = new ArvoreBinaria<>(value);
		} else
			raiz.insert(value);
	}

	public void print() {
		if (raiz != null)
			raiz.print();
	}
}