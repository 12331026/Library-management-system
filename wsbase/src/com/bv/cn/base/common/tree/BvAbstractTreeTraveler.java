package com.bv.cn.base.common.tree;

import java.util.Set;

public abstract class BvAbstractTreeTraveler implements ITreeTraveler {

	protected boolean isStop = false;
	protected Set<ITreeVisitor> visitors;

	public abstract void traverse(ITreeNode root);

	public void addVisitor(ITreeVisitor visitor) {
		visitors.add(visitor);
	}

	public void removeVisitor(ITreeVisitor visitor) {
		visitors.remove(visitor);
	}

	protected void visit(ITreeNode item) {
		if (!isStop) {
			for (ITreeVisitor visitor : visitors) {
				visitor.visit(item, this);
			}
		}
	}

	public void stopTraversal(boolean isStop) {
		this.isStop = isStop;
	}

}
