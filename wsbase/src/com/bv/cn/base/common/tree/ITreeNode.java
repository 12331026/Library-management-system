package com.bv.cn.base.common.tree;

public interface ITreeNode {

	public boolean hasChildren();

	public ITreeNode[] getChildren();

	public ITreeNode getParent();
}
