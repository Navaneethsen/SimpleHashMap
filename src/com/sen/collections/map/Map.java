package com.sen.collections.map;


/**
 * The interface Map.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022 /02/06
 */
public interface Map<K extends Comparable<? super K>, V extends Comparable<? super V>>
{
    /**
     * Put the Key and Value to the map.
     *
     * @param key   the key
     * @param value the value
     */
    void put(K key, V value);

    /**
     * Get the value for a specific key from the map.
     *
     * @param key the key
     * @return the v
     */
    V get(K key);
}
