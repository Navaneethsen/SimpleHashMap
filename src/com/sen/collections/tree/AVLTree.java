package com.sen.collections.tree;

/**
 * The type Avl tree.
 *
 * @param <K> the type parameter
 * @param <V> the type parameter
 * @author Navaneeth Sen
 * @version 1.0
 * @date 2022 /02/06
 */
public class AVLTree<K extends Comparable<? super K>, V extends Comparable<? super V>> implements Tree<K, V>
{
    private AVLNode<K, V> root;

    @Override
	public void insert(K key, V value)
    {
        root = insertRecursive(root, key, value);
    }

    /**
     * Insert the nodes in a recursive manner.
     * @param node
     * @param key
     * @param value
     * @return
     */
    private AVLNode<K, V> insertRecursive(AVLNode<K, V> node, K key, V value)
    {
        if (node == null)
        {
            return new AVLNode<K, V>(key, value);
        }

        if (key.compareTo(node.key) < 0)
        {
            node.left = insertRecursive(node.left, key, value);
        }
        else if (key.compareTo(node.key) > 0)
        {
            node.right = insertRecursive(node.right, key, value);
        }
        else
        {
            node.value = value;
        }

        node = avlize(node); //Node could change, so we have to assign back.  //This call is the only modification to 'insertRecursive' method compared unbalanced to BST.

        return node;
    }

    @Override
	public V get(K key)
    {
        root = getRecursive(root, key);
        return root.getValue();
    }

    /**
     * Gets the node for the given key in a recursive manner.
     *
     * @param node the node
     * @param key  the key
     * @return the recursive
     */
    private AVLNode<K, V> getRecursive(AVLNode<K, V> node, K key)
    {
        if (node == null)
        {
            return null;
        }

        if (node.key.equals(key))
        {
            return node;
        }
        else if (key.compareTo(node.key) < 0)
        {
            node.left = getRecursive(node.left, key);
        }
        else
        {
            node.right = getRecursive(node.right, key);
        }

        return node;
    }

    /**
     * This is the crux of the Tree and the job of this method is to balance the tree by rotating the nodes.
     *
     * @return the root
     */
    private AVLNode<K, V> avlize(AVLNode<K, V> node)
    { 
        //Check the AVL rotation illustrations in geek for geeks.
        // I have tried to create my own version of the same.
        int balance = getBalance(node);
        if (balance < -1)
        {
            if (getBalance(node.right) >= 0)
            {
                //Right-Left Case
                node.right = rotateRight(node.right);
            }
            //Right-Right Case
            return rotateLeft(node);

        }
        else if (balance > 1)
        {
            // Check the AVL rotation illustrations in geek for geeks.
            // I have tried to create my own version of the same.
            if (getBalance(node.left) <= 0)
            {
                //Left-Right Case
                node.left = rotateLeft(node.left);
            }

            //Left-Left Case
            return rotateRight(node);

        }
        // we don't want any rotation if there were no imbalance.
        else
        {
            // update height of the node.
            node.height = 1 + Math.max((node.left != null ? node.left.height : 0), (node.right != null ? node.right.height : 0)); 
            return node;
        }
    }

    private AVLNode<K, V> rotateLeft(AVLNode<K, V> node)
    {
        AVLNode<K, V> newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        
        //Update heights of the nodes that moved.
        node.height = 1 + Math.max((node.left != null ? node.left.height : 0), (node.right != null ? node.right.height : 0)); 

        //Calculate 'height' of 'newRoot' only after 'node' is a child of 'newRoot'.
        newRoot.height = 1 + Math.max(newRoot.left.height, (newRoot.right != null ? newRoot.right.height : 0)); 

        return newRoot;
    }

    private AVLNode<K, V> rotateRight(AVLNode<K, V> node)
    {
        AVLNode<K, V> newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        //Update heights of the nodes that moved.
        node.height = 1 + Math.max((node.left != null ? node.left.height : 0), (node.right != null ? node.right.height : 0)); 

        //Calculate 'height' of 'newRoot' only after 'node' is a child of 'newRoot'.
        newRoot.height = 1 + Math.max((newRoot.left != null ? newRoot.left.height : 0), newRoot.right.height); 
        return newRoot;
    }

    /**
     * Gets the balance of the node.
     * This is a O(1) operation.
     *
     * @param node the node
     * @return the balance
     */
    private int getBalance(AVLNode<K, V> node)
    {
        int left = node.left != null ? node.left.height : 0;
        int right = node.right != null ? node.right.height : 0;
        return left - right;
    }

    @Override
	public AVLNode<K, V> getRoot()
    {
        return root;
    }
}