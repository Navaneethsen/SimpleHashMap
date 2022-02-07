package com.sen.collections.map;

import com.sen.collections.tree.AVLTree;
import com.sen.collections.tree.Node;
import com.sen.collections.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The type Simple map collection which is backed by a AVL tree.
 * 
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022/02/06
 */

public class SimpleMap<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Map<K, V>
{

    // we need an array which will act as the buckets for the key value pairs stored in a tree.
    List<AVLTree<K, V>> buckets;

    // the initial capacity of the buckets
    private int BUCKET_SIZE = 16;

    public SimpleMap()
    {
        initialize();
    }

    public SimpleMap(int bucketSize)
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
        AVLTree<K, V> avlTree = buckets.get(bucketIndex);

        // check if tree already exist
        if (avlTree == null)
        {
            // add a empty tree to the bucket
            avlTree = new AVLTree<>();
            // add the tree to the bucket
            buckets.set(bucketIndex, avlTree);
        }

        // insert the key value to the tree
        avlTree.insert(key, value);

    }

    @Override
    public V get(K key)
    {
        // get the index of the bucket for the specified key
        int bucketIndex = getBucketIndex(key);

        // get the Tree at the index
        AVLTree<K, V> avlTree = buckets.get(bucketIndex);

        // check if tree already exist
        if (avlTree == null)
        {
            // return null if tree is empty
            return null;
        }

        // return the value of node
        return avlTree.get(key);

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

        for (Tree<K, V> t: buckets)
        {
            if (t != null)
            {
                Node<K, V> node = t.getRoot();
                if (node != null)
                {
                    size += countNode(node);
                }
            }
        }
        return size;
    }

    private int countNode(Node<K, V> root)
    {
        //base case
        if(root==null)
            return 0;
        // recursive call to left child and right child and
        // add the result of these with 1 ( 1 for counting the root)
        return 1 + countNode(root.getLeft()) + countNode(root.getRight());
    }
}




