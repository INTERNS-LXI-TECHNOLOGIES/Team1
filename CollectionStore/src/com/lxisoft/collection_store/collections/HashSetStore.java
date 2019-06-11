/**
 * 
 */
package com.lxisoft.collection_store.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import com.lxisoft.collection_store.exceptions.UnsupportedParameterExeption;

/**
 * @author anish
 *
 */
public class HashSetStore<T> implements CollectionRepository<T> {

	Set<T> hashSet = new HashSet<>();
	private String fieldName = "id";
	private Class<T> type;
	public HashSetStore(Class<T> type) {
		this.type = type;
	}
	@Override
	public void sort(String fieldName) {
		try {
			throw new UnsupportedParameterExeption("Sort by Field name not supported by HashSetStore");
		} catch (UnsupportedParameterExeption e) {
			e.printStackTrace();
		}
	}
	@Override
	public void create(T value) {
		hashSet.add(value);
		
	}

	@Override
	public Collection<T> readAll() {
		return hashSet;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort() {
		try {
	         Object[] a = hashSet.toArray();
	         Arrays.sort(a);
	         for(Object t:a) {
	        	 hashSet.add((T)t);
	         }
		}catch(ClassCastException e) {
			sort(fieldName);
		}
		
	}

	@Override
	public void delete(T element) {
		hashSet.remove(element);
		
	}

	@Override
	public void delete(int index) {
		try {
			throw new UnsupportedParameterExeption("Delete by index not supported by HashSetStore");
		} catch (UnsupportedParameterExeption e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(int index, T element) {
		try {
			throw new UnsupportedParameterExeption("Update by index not supported by HashSetStore");
		} catch (UnsupportedParameterExeption e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(T element0, T element1) {
		hashSet.remove(element0);
		hashSet.add(element1);
	}

}
