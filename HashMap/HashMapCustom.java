package com.home.javaimplementation.HashMap;



public class HashMapCustom<K, V> {
	
	public HashMapCustom() {
		super();
		this.table = new Entry[10];
	}


	private Entry<K,V>[] table;
	 
    static class Entry<K,V>{
		
		K key;
		V value;
		Entry<K,V> next ;
		
		public Entry(K key, V value, Entry next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
    
    public void put(K newKey, V data){
    	int hash = hash(newKey);
    	Entry<K,V> newEntry = new Entry<K,V>(newKey, data,null);
    	Entry<K,V> existingEntry = table[hash];
    	if(existingEntry==null){
    		table[hash]=newEntry;
    	}else{
    		while(existingEntry!=null){
    			if(existingEntry.key.equals(newKey)){
    				existingEntry.value=data;
    				return;
    			}
    			existingEntry=existingEntry.next;
    		}
    		newEntry.next = table[hash];
    		table[hash] = newEntry;
    	}
    	
    }
    
    public V get(K key){
    	int hash = hash(key);
    	if(table[hash] == null){
            return null;
           }else{
        	   Entry<K,V> temp = table[hash];
        	   while(temp!=null){
        		   if(temp.key.equals(key)){
        			   return temp.value;
        		   }
        		   temp=temp.next;
        	   }
           }
		return null;
    	
    }

	private int hash(K newKey) {
		System.out.println(newKey.hashCode());
		return Math.abs(newKey.hashCode())%10;
	}
    
    

}
