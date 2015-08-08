package com.bv.cn.base.common.tree;

public interface ITreeTraveler {

	public void traverse(ITreeNode root);

	public void addVisitor(ITreeVisitor visitor);

	public void removeVisitor(ITreeVisitor visitor);

	public ITreeNode[] getPath();
	
	public void stopTraversal(boolean isStop);
}
