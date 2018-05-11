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
public interface Iterator <T> extends java.util.Iterator{
    
    void insert(T value);
    
    void remove();
    
    T next();

    boolean hasNext();
    
}
