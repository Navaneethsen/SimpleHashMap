package com.sen.collections.tree;

/**
 * The type Avl node.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public class AVLNode <K extends Comparable<? super K>, V extends Comparable<? super V>> implements Node<K, V>
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
	 */
	AVLNode<K, V> left;
	/**
	 * The Right Node.
	 */
	AVLNode<K, V> right;

	/**
	 * The Height of the Node.
	 */
	int height; //This is additional attribute that the AVL tree node will have.

	/**
	 * Instantiates a new Avl node.
	 *
	 * @param key   the key
	 * @param value the value
	 */
	AVLNode(K key, V value) {
		this.key = key;
		this.value = value;
		height = 1; //'height' is initialized to 1.
	}

	/**
	 * Gets key.
	 *
	 * @return the key
	 */
	@Override
	public K getKey() {
		return key;
	}

	/**
	 * Gets value.
	 *
	 * @return the value
	 */
	@Override
	public V getValue() {
		return value;
	}

	/**
	 * Gets left.
	 *
	 * @return the left
	 */
	@Override
	public AVLNode<K, V> getLeft() {
		return left;
	}

	/**
	 * Gets right.
	 *
	 * @return the right
	 */
	@Override
	public AVLNode<K, V> getRight() {
		return right;
	}
}