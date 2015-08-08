package com.bv.cn.base.common.tree;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;

public class BvLevelTreeTraversal extends BvAbstractTreeTraveler {
	private LinkedList<ITreeNode> queue = new LinkedList<ITreeNode>();
	private LeveledTreeNode visited;

	public BvLevelTreeTraversal() {
		visitors = new HashSet<ITreeVisitor>();
	}

	@Override
	protected void visit(ITreeNode item) {
		visited = (LeveledTreeNode) item;
		super.visit(visited.getTargetNode());
	}

	public ITreeNode[] getPath() {
		if (visited == null) {
			return new ITreeNode[0];
		}
		return visited.getPath();
	}

	@Override
	public void traverse(ITreeNode root) {
		LeveledTreeNode leveledRoot = new LeveledTreeNode(root);
		queue.addLast(leveledRoot);

		// 按层访问节点
		while (queue.size() > 0) {
			LinkedList<ITreeNode> nextLevel = new LinkedList<ITreeNode>();
			for (ITreeNode item : queue) {
				// 完成本层的节点访问
				visit(item);
				// 同时找出下一层的节点
				if (item.hasChildren()) {
					ITreeNode[] children = item.getChildren();
					for (ITreeNode child : children) {
						nextLevel.addLast(child);
					}
				}
			}
			// 推进到下一层
			queue = nextLevel;
		}

	}

	public int getLevel() {
		if (visited == null) {
			return 0;
		}
		return visited.getLevel();
	}

	public static class LeveledTreeNode implements ITreeNode {
		private ITreeNode node;
		private WeakReference<ITreeNode> parent;
		private int level;

		public LeveledTreeNode(ITreeNode node) {
			this.node = node;
			this.level = 1;
		}

		public ITreeNode[] getChildren() {
			ITreeNode[] children = this.node.getChildren();
			ITreeNode[] childrenRtn = new LeveledTreeNode[children.length];
			for (int index = 0; index < children.length; index++) {
				ITreeNode child = children[index];
				LeveledTreeNode leveledChild = new LeveledTreeNode(child);
				leveledChild.setParent(this);
				leveledChild.level = this.level + 1;
				childrenRtn[index] = leveledChild;
			}
			return childrenRtn;
		}

		public boolean hasChildren() {
			return this.node.hasChildren();
		}

		public void setParent(ITreeNode parent) {
			this.parent = new WeakReference<ITreeNode>(parent);
		}

		public ITreeNode getParent() {
			if (this.parent == null) {
				return null;
			}
			return this.parent.get();
		}

		public ITreeNode[] getPath() {
			LinkedList<ITreeNode> path = new LinkedList<ITreeNode>();
			LeveledTreeNode item = this;
			while (item != null) {
				path.addFirst(item);
				item = (LeveledTreeNode) item.getParent();
			}
			ITreeNode[] result = new ITreeNode[path.size()];
			path.toArray(result);
			return result;
		}

		public int getLevel() {
			return level;
		}

		public ITreeNode getTargetNode() {
			return node;
		}
	}
}
