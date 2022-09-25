package bst;

import java.util.LinkedList;
import java.util.Queue;

public class bst_addNode {
	
	static class Node
	{
		int val;
		Node left, right;
		
		Node(int val){
			this.val = val;
			this.left = null;
			this.right = null;
			
		}
		
	}
	
	static void insertNode(Node head, int newVal)
	{
		Node newNode = new Node(newVal);
		Node curr = head;
		Node tempHead = null;
		while(curr!= null)
		{
			if(newVal < curr.val)
			{
				tempHead = curr;
				curr = curr.left;
			}
			else {
				tempHead = curr;
				curr = curr.right;
			}
			
		}
		
		if(newVal < tempHead.val)
		{
			tempHead.left = newNode;
		}
		else
		{
			tempHead.right = newNode;
		}
		//return head;
		
		
	}
	
	static void printBstInorder(Node head)
	{
		//Inorder (left, root, right)
		if(head== null)
		{
			return;
		}
		printBstInorder(head.left);
		System.out.println(head.val);
		printBstInorder(head.right);
		
		
	}
	
	static void printBstBfs(Node head)
	{
		//Implement bfs using queue
		Queue q = new LinkedList();
		Node curr = head;
		q.add(curr);
		while(curr!=null && q.size()>0) {
		
				Node popped = (Node) q.remove();
				System.out.println(popped.val);
				if(popped.left!=null)
					q.add(popped.left);
				if(popped.right!=null)
					q.add(popped.right);

		}
	}
	
	
	public static void main(String args[])
	{
		Node root = new Node(500);
		root.left = new Node(400);
		root.right = new Node(700);
		
		insertNode(root, 300);
		
		//printBstInorder(root);
		printBstBfs(root);
	
	}
}
