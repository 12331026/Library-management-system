package com.bv.cn.base.common.tree;

public interface ITreeVisitor {

	public void visit(ITreeNode node, ITreeTraveler traveler);
}
