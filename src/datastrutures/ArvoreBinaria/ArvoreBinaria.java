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
public class ArvoreBinaria<T extends Comparable<T>> {

	private T value;
	private ArvoreBinaria<T> left;
	private ArvoreBinaria<T> right;

	public ArvoreBinaria(T value) {
		this.value = value;
	}

	public void insert(T value) throws ChaveDuplicada {
		int cmp = value.compareTo(this.value);
		if (cmp < 0)
			insertLeft(value);
		else if (cmp > 0)
			insertRight(value);
		else
			throw new ChaveDuplicada("Already inserted: "+value);
	}
	
	
	private void insertLeft(T value) throws ChaveDuplicada {
		if (left == null)
			left = new ArvoreBinaria<>(value);
		else
			left.insert(value);
	}

	private void insertRight(T value) throws ChaveDuplicada {
		if (right == null)
			right = new ArvoreBinaria<>(value);
		else
			right.insert(value);
	}

	public void print() {
		System.out.print("(" + value + " ");
		if (left != null)
			left.print();
		else
			System.out.print("_");
		if (right != null)
			right.print();
		else
			System.out.print(" _");
		System.out.print(")");
	}
}
