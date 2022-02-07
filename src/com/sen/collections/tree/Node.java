package com.sen.collections.tree;

/**
 * The interface Node.
 *
 * @param <K> the key parameter
 * @param <V> the value parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022 /02/06
 */
public interface Node<K extends Comparable<? super K>, V extends Comparable<? super V>>
{

    /**
     * Gets key.
     *
     * @return the key
     */
    K getKey();

    /**
     * Gets value.
     *
     * @return the value
     */
    V getValue();

    /**
     * Gets left.
     *
     * @return the left
     */
    Node<K, V> getLeft();

    /**
     * Gets right.
     *
     * @return the right
     */
    Node<K, V> getRight();
}
