package com.cts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeOrderTest {

	public static void main(String[] args)
	{
		BinaryTreeNode root20=new BinaryTreeNode(20);
		BinaryTreeNode left10=new BinaryTreeNode(10);
		BinaryTreeNode right30=new BinaryTreeNode(30);
		root20.left=left10;
		root20.right=right30;
		
		
		BinaryTreeNode root60=new BinaryTreeNode(60);
		BinaryTreeNode left50=new BinaryTreeNode(50);
		BinaryTreeNode right70=new BinaryTreeNode(70);
		root60.left=left50;
		root60.right=right70;
		
		BinaryTreeNode root=new BinaryTreeNode(40);
		root.left=root20;
		root.right=root60;
		
		
		
		
		
		
		System.out.println(root);
		System.out.print(root20);
		System.out.println("pre order printing");
		preOrder(root);
		
		System.out.println("post order printing");
		postOrder(root);
		
		
		System.out.println("In order printing");
		InOrder(root);
		System.out.println("level  order printing");
		levelOrder(root);
		System.out.println("vertical order printing");
		verticalSum(root);

	}
	
	private static void verticalSum(BinaryTreeNode root) {
		Map<Integer,List<Integer>> hash=new HashMap<>();
		int count=0;
		verSum(hash,root,count);
		
		System.out.println(hash);
		
	}

	private static void verSum( Map<Integer, List<Integer>> hash, BinaryTreeNode root,int c) 
	{
		if(root==null)
		{
			return;
		}
		if(root.left!=null)
		{
			verSum(hash, root.left, c-1);
		}
		if(root.right!=null)
		{
			verSum(hash, root.right, c+1);
		}
		
		
		List<Integer> data=new ArrayList<>();
		
		if(hash.containsKey(c))
		{
			data=hash.get(c);
		}
		data.add(root.data);
		hash.put(c, data);
		
	}

	public static void preOrder(BinaryTreeNode root)
	{
		if(root==null){
			return;
		}
		System.out.print(root.data);
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	public static void postOrder(BinaryTreeNode root)
	{
		if(root==null){
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data);
		
	}
	public static void InOrder(BinaryTreeNode root)
	{
		if(root==null){
			return;
		}
		
		InOrder(root.left);
		System.out.print(root.data);
		InOrder(root.right);
	}
	public static void levelOrder(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		if(root==null){
			return;
		}else{
			queue.add(root);
		}
		
		while(!queue.isEmpty())
		{
		  BinaryTreeNode tempNode=queue.poll();
		 
		  System.out.println(tempNode.data);
		  if(tempNode.left!=null){
			  queue.add(tempNode.left);
		  }
		  if(tempNode.right!=null){
			  queue.add(tempNode.right);
		  }
		}
	}
	
}
