# -*- coding: utf-8 -*-
# 二叉树
class Node:
    def __init__(self,data = None,leftNode = None,rightNode = None):
        self.data = data
        self.leftNode = leftNode
        self.rightNode = rightNode


def buildBinTree(root,arrays,index):
    if index >= len(arrays):
        return None
    root = Node(arrays[index])
    print index                           
    root.leftNode = buildBinTree(root.leftNode,arrays,2 * index+1)
    root.rightNode= buildBinTree(root.rightNode,arrays,2*index +2)
    return root
if __name__ == '__main__':
    a =[0,1,3,4,5,6,7,8]
    buildBinTree(None,a,0)