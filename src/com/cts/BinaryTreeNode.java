package com.cts;

public class BinaryTreeNode
{
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public Integer data;

	public BinaryTreeNode(Integer data) {
		super();
		this.data = data;
	}
	public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, Integer data) {
		super();
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public boolean isLeaf() {
		return getLeft() == null && getRight() == null;
	}

	public String toString1() 
	{
		return Integer.toString(data);
	}

	@Override
	public String toString() 
	{
		String root, left = "null", right = "null";
		if (isLeaf()) 
		{
			return toString1();
		}

		root=toString1();

		if (getLeft() != null) {
			left = getLeft().toString();
		}
		if (getRight() != null) {
			right = getRight().toString();
		}
		return root + "(" + left + "," + right + ")";

	}

}
