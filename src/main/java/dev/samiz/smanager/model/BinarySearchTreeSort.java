package dev.samiz.smanager.model;

import java.util.ArrayList;

public class BinarySearchTreeSort implements Sort{
    // Nested class which dictates the properties of our Node object.
    class Node {
        int nodeValue;
        Node leftNode;
        Node rightNode;

        public Node (int nodeValue){
            this.nodeValue = nodeValue;
            leftNode = null;
            rightNode = null;
        }
    }
    // Initialising the root of the tree.
    Node root;
    @Override
    public int[] sort(int[] arrayToSort) {
        // Returns the array straight away if it is empty.
        if (arrayToSort.length == 0)
            return arrayToSort;
        // Created a new array list to use during the search tree algorithm to house our node values following traversal.
        ArrayList<Integer> valueArrayList = new ArrayList<>();
        // We set the first element of the array we are sorting as the root value.
        root = new Node(arrayToSort[0]);
        // Using a for loop to iterate through the remaining values in the array we are sorting and add them to the tree.
        for (int i = 1; i < arrayToSort.length; i++){
            addValueToTree(root, arrayToSort[i]);
        }
        // We now traverse through the binary tree by calling th inOrderTraversal method.
        treeTraversal(root, valueArrayList);
        // We now create a new int array that is of the same size as the array list.
        int[] outputArray = new int[valueArrayList.size()];
        // Using a for-each loop we then transfer the values of the Array List back into an int array.
        int i = 0;
        for (int num : valueArrayList){
            outputArray[i] = num;
            i++;
        }
        return outputArray;
    }
    // Method that will be used to traverse through the array we are sorting in-order and form the tree using nodes.
    public Node addValueToTree(Node currentNode, int valueToAdd){
        if (currentNode == null)
            return new Node(valueToAdd);
        // If the value we want to add to the tree is <= the current node we add it to the left 'sub node' of the current node.
        // If the value we want to add to the tree is > the current node we add it to the right 'sub node' of the current node.
        // If none of the above conditions are met we just return the current node.
        if (valueToAdd <= currentNode.nodeValue){
            currentNode.leftNode = addValueToTree(currentNode.leftNode, valueToAdd);
        } else if (valueToAdd > currentNode.nodeValue){
            currentNode.rightNode = addValueToTree(currentNode.rightNode, valueToAdd);
        } else {
            return currentNode;
        }
        return currentNode;
    }
    // Method that will traverse through the nodes in order, adding each node value to the array list.
    public void treeTraversal(Node node, ArrayList<Integer> result){
        if (node != null){
            treeTraversal(node.leftNode, result);
            result.add(node.nodeValue);
            treeTraversal(node.rightNode, result);
        }
    }
}