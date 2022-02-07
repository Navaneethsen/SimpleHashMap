package com.sen.collections.map;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;


/**
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022/02/07
 */
public class SimpleMapLLTest
{

    /**
     * String put and string get.
     */
    @Test
    public void stringPutAndStringGet()
    {
        SimpleMapLL<String, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put("1", "a");
        simpleMap.put("2", "b");
        simpleMap.put("3", "c");

        Assert.assertEquals("a", simpleMap.get("1"));
        Assert.assertEquals("b", simpleMap.get("2"));
        Assert.assertEquals("c", simpleMap.get("3"));

    }

    /**
     * String put with replace and string get.
     */
    @Test
    public void stringPutWithReplaceAndStringGet()
    {
        SimpleMapLL<String, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put("1", "a");
        simpleMap.put("2", "b");
        simpleMap.put("1", "c");
        simpleMap.put("2", "d");

        Assert.assertEquals("c", simpleMap.get("1"));
        Assert.assertEquals("d", simpleMap.get("2"));

    }

    /**
     * Integer put and string get.
     */
    @Test
    public void integerPutAndStringGet()
    {
        SimpleMapLL<Integer, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put(1, "a");
        simpleMap.put(2, "b");
        simpleMap.put(3, "c");

        Assert.assertEquals("a", simpleMap.get(1));
        Assert.assertEquals("b", simpleMap.get(2));
        Assert.assertEquals("c", simpleMap.get(3));

    }

    /**
     * Integer put with replace and string get.
     */
    @Test
    public void integerPutWithReplaceAndStringGet()
    {
        SimpleMapLL<Integer, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put(1, "a");
        simpleMap.put(2, "b");
        simpleMap.put(1, "c");
        simpleMap.put(2, "d");

        Assert.assertEquals("c", simpleMap.get(1));
        Assert.assertEquals("d", simpleMap.get(2));

    }

    /**
     * Gets for key not exist.
     */
    @Test
    public void getForKeyNotExist()
    {
        SimpleMapLL<Integer, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put(1, "a");
        simpleMap.put(2, "b");
        simpleMap.put(3, "c");

        Assert.assertNull(simpleMap.get(4));

    }

    /**
     * Gets for value is null.
     */
    @Test
    public void getForValueIsNull()
    {
        SimpleMapLL<Integer, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put(1, null);
        simpleMap.put(2, "b");
        simpleMap.put(3, "c");

        Assert.assertNull(simpleMap.get(1));

    }

    /**
     * Size.
     */
    @Test
    public void size()
    {
        SimpleMapLL<Integer, String> simpleMap = new SimpleMapLL<>();
        simpleMap.put(1, null);
        simpleMap.put(2, "b");
        simpleMap.put(3, "c");

        Assert.assertEquals(3, simpleMap.size());

    }

    /**
     * Size large - Test by adding 10 Million items.
     */
    @Test
    public void sizeLarge()
    {
        SimpleMapLL<String, String> simpleMap = new SimpleMapLL<>(16);

        Random random = new Random(12345);
        for (int i = 0; i < 10000000; i++)
        {
            simpleMap.put(String.valueOf(random.nextLong()), String.valueOf(random.nextLong()));
        }

        Assert.assertEquals(10000000, simpleMap.size());
    }
}