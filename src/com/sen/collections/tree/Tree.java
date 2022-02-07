package com.sen.collections.tree;

/**
 * The interface Tree.
 *
 * @param <K> the key parameter
 * @param <V> the value parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022 /02/06
 */
public interface Tree<K extends Comparable<? super K>, V extends Comparable<? super V>>
{
    /**
     * Insert.
     *
     * @param key   the key
     * @param value the value
     */
    void insert(K key, V value);

    /**
     * Get v.
     *
     * @param key the key
     * @return the v
     */
    V get(K key);

    /**
     * Gets root.
     *
     * @return the root
     */
    Node<K, V> getRoot();
}
