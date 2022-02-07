package com.sen.collections.map;

import com.sen.collections.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The type Simple map collection which is backed by a LinkedList.
 * 
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022/02/06
 */

public class SimpleMapLL<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Map<K, V>
{

    // we need an array which will act as the buckets for the key value pairs stored in a tree.
    List<LinkedList<Entry<K, V>>> buckets;

    // the initial capacity of the buckets
    private int BUCKET_SIZE = 16;

    public SimpleMapLL()
    {
        initialize();
    }

    public SimpleMapLL(int bucketSize)
    {
        this.BUCKET_SIZE = bucketSize;
        initialize();
    }

    /**
     * Initialize the List with null elements, so that the size works.
     */
    private void initialize()
    {
        buckets = new ArrayList<>(this.BUCKET_SIZE);
        // initialize the list with null trees
        for (int i = 0; i < this.BUCKET_SIZE; i++) {
            buckets.add(null);
        }
    }

    @Override
    public void put(K key, V value)
    {
        // get the index of the bucket for the specified key
        int bucketIndex = getBucketIndex(key);

        // get the Tree at the index
        LinkedList<Entry<K, V>> entryLinkedList = buckets.get(bucketIndex);

        // check if tree already exist
        if (entryLinkedList == null)
        {
            // add a empty tree to the bucket
            entryLinkedList = new LinkedList<>();
            // add the tree to the bucket
            buckets.set(bucketIndex, entryLinkedList);
        }

        // check if the key already exist
        // iterate through the linkedlist and find the corresponding entry
        for (Entry<K, V> entry : entryLinkedList)
        {
            if (entry.getKey().equals(key))
            {
                entry.setValue(value);
                return;
            }
        }

        // insert the key value to the tree
        entryLinkedList.add(new Entry<>(key, value));

    }

    @Override
    public V get(K key)
    {
        // get the index of the bucket for the specified key
        int bucketIndex = getBucketIndex(key);

        // get the Tree at the index
        LinkedList<Entry<K, V>> entryLinkedList = buckets.get(bucketIndex);

        // check if tree already exist
        if (entryLinkedList == null)
        {
            // return null if tree is empty
            return null;
        }

        // iterate through the linkedlist and find the corresponding entry
        // this is a very inefficient way of doing this
        for (Entry<K, V> entry : entryLinkedList)
        {
            if (entry.getKey().equals(key))
            {
                return entry.getValue();
            }
        }
        
        // otherwise return null
        return null;
    }

    /**
     * Gets the bucket index given the key.
     *
     * @param key the key
     * @return the bucket index
     */
    private int getBucketIndex(K key)
    {
        // get a number between 0 and BUCKET_SIZE - 1,
        return Math.abs(key.hashCode() % (this.BUCKET_SIZE - 1));
    }

    public int size()
    {
        int size = 0;

        for (LinkedList<Entry<K, V>> t: buckets)
        {
            if (t != null)
            {
                size += t.size();
            }
        }
        return size;
    }

}




