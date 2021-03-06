package com.code2016.book.datadtructures.part3.table;

import java.util.Iterator;


/**
 ******************************************************************
 * Created on 201609010pm2:02:03
 * @author wutongpeng
 * 功能描述:LinkedLish实现
 * 功能说明
 * 
 * 修改历史
 * Revision 1.0.1 201609010pm2:02:03
 * Update: ------ empty log -----
 * *****************************************************************
 */
public class MyLinkedList<T> implements Iterable<T> {
	
	private int theSize;
	private int modCount = 0;
	private Node<T> beginMarker;
	private Node<T> endMarker;

	public MyLinkedList(){
		doClear();
	}
	
	public void clear(){
		doClear();
	}
	
	public void doClear(){
		beginMarker = new Node<T>(null,null,null);
		endMarker = new Node<T>(null,beginMarker,null);
		beginMarker.next = endMarker;
		
		theSize = 0;
		modCount++;
	}
	public int size(){
		return theSize;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

	public boolean add(T x){
		add(size(),x);
		return true;
	}

	public void add(int idx,T x){
		addBefore(getNode(idx,0,size()),x);
	}

	public T get(int idx){
		return getNode(idx).data;		
	}

	public T set(int idx, T newVal){
		Node<T> p = getNode(idx);
		T oldVal = p.data;
		p.data = newVal;
		return oldVal;		
	}

	public T remove(int idx){
		return remove(getNode(idx));		
	}

	private void addBefore(Node<T> p,T x){
		Node<T> newNode = new Node<T>(x,p.prev,p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;		
	}
	
	private T remove(Node<T> p){
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		return p.data;		
	}
	
	private Node<T> getNode(int idx){
		return getNode(idx,0,size()-1);			
	}
	
	private Node<T> getNode(int idx, int lower, int upper){
		Node<T> p;
		if(idx < lower || idx > upper){
			throw new IndexOutOfBoundsException();
		}
		if(idx < size() / 2){
			p = beginMarker.next;
			for(int i=0;i<idx;i++){
				p = p.next;
			}
		}else{
			p = endMarker;
			for(int i=size();i>idx;i++){
				p=p.next;
			}
		}
		return p;	
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>
	{

		private Node<T> current = beginMarker;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}

		@Override
		public T next() {
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}			
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			
			T nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		
		public void remove(){
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}			
			if(!okToRemove){
				throw new IllegalStateException();
			}
			
			MyLinkedList.this.remove(current.prev);
			expectedModCount++;
			okToRemove = false;
		}
		
	}
	
	private class Node<T>
	{

		public T data;
		public Node<T> prev;
		public Node<T> next;
		
		public Node(T d,Node<T> p,Node<T> n){
			data=d;
			prev=p;
			next=n;
		}
		
	}

}
