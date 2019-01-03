# -*- coding: utf-8 -*-
# 表达树
class Node:
    def __init__(self,data = None,left = None,right=None):
        self.data = data
        self.left = left
        self.right = right

# 通过栈来管理，后缀表达式 转 表达式树，
# 如果是操作数入栈，如果是 操作符 出栈 前两个，然后构建树 并再次将树 入栈
def buildExpressionTree(root,stack,arrays,index):
    if index >= len(arrays):
        return None
    print arrays[index]
    if arrays[index].isalpha():
        stack.append(arrays[index])
    elif arrays[index] in ["*","+"]:
        root = Node(arrays[index])
        right = stack.pop()
        left = stack.pop()

        root.left = Node(left) if not isinstance(left,Node) else left
        print 'root.left :',root.left.data
        root.right =Node(right) if not isinstance(right,Node) else right
        print 'root.right :',root.right.data
        stack.append(root)
    print stack
    buildExpressionTree(root,stack,arrays,index+1)   

# 中序遍历
def midPrint(root):
    if root == None:
        return
    midPrint(root.left)
    print root.data
    midPrint(root.right)

if __name__ == "__main__":
    arrays = ['a','b','+','c','d','e','+','*','*']
    root = Node()
    stack = []
    buildExpressionTree(root,stack,arrays,0)
    midPrint(stack[0])


