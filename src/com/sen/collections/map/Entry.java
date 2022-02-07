package com.sen.collections.map;

/**
 * The type Entry.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022 /02/07
 */
public class Entry<K extends Comparable<? super K>, V extends Comparable<? super V>>
{
    /**
     * The Key.
     */
    K key;
    /**
     * The Value.
     */
    V value;

    /**
     * The Left Node.
     *
     * @param key   the key
     * @param value the value
     */
    public Entry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public K getKey()
    {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(K key)
    {
        this.key = key;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public V getValue()
    {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(V value)
    {
        this.value = value;
    }
}
