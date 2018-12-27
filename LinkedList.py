# -*- coding: utf-8 -*-
from collections import Iterator
from abc import ABCMeta, abstractmethod

class Collection():
    __metaclass__ = ABCMeta
    # 在指定位置添加数据
    @abstractmethod
    def addIndex(self,index,data):
        pass
    # 添加数据（在尾部）
    @abstractmethod
    def addData(self,data):
        pass
    # 获取集合的大小
    @abstractmethod
    def size(self):
        pass
    # 判断是否为空
    @abstractmethod    
    def isEmpty(self):
        pass
    # 清空集合
    @abstractmethod
    def clear(self):
        pass
    # 删除对应位置的数据
    @abstractmethod
    def remove(self,index):
        pass
    # 返回迭代器
    @abstractmethod
    def iterator(self):
        pass

        
class LinkedList(Collection):
    __thisSize = 0
    _beginMarker = None
    _endMarker = None

    def __init__(self):
        self.doClear()

    def doClear(self):
        # 创建空的头结点
        self._beginMarker = Node(None,None,None)
        # 创建空的尾节点，并将前驱指向头结点
        self._endMarker = Node(None,self._beginMarker,None)
        # 将头结点的后驱执行尾节点
        self._beginMarker._nextNode = self._endMarker
        # beginMarker <-----> endMarker
        self.__thisSize = 0
    
    # 获取对应位置的Node
    def __getNodeWithIndex(self,index):
        return self.__getNodeWithIndexLowerUpper(index,0,self.size())
    def __getNodeWithIndexLowerUpper(self,index,lower,upper):
        node = None
        if index < lower or index > upper:
            raise IndexOutOfBoundsException()
        if index < self.size()/2:
            p = self._beginMarker._nextNode
            for i in range(0,index,1):
                p = p._nextNode
        else:
            p = self._endMarker
            for i in range(self.size(),index,-1):
                p = p._prevNode
        return p
    
    def addIndex(self,index,data):
        currentIndexNode = self.__getNodeWithIndex(index)
        # 修改前驱将 Node 进行插入
        node = Node(data,currentIndexNode._prevNode,currentIndexNode)
        currentIndexNode._prevNode._nextNode = node
        currentIndexNode._prevNode = node
        self.__thisSize +=1
        

    def addData(self,data):
        # 在尾部插入 Node
        self.addIndex(self.size(),data)

    def size(self):
        return self.__thisSize
        
  
    def isEmpty(self):
        return self.size() == 0

    def clear(self):
        self.doClear()

    def remove(self,index):
        self.__removeNode(self.__getNodeWithIndex(index))
    
    def __removeNode(self,node):
        node._prevNode._nextNode = node._nextNode
        node._nextNode._prevNode = node._prevNode
        self.__thisSize -=1


    
    class LinkedListIterator(Iterator):
        ## 迭代器 当前的 位置
        __current = None
        __outter = None
        def __init__(self,outter=None):
            self.__outter = outter
            self.__current = outter._beginMarker._nextNode

        def next(self):
            if self.__current is self.__outter._endMarker:
                raise StopIteration
            nextItem = self.__current._data
            self.__current = self.__current._nextNode
            return nextItem

    def iterator(self):
        return self.LinkedListIterator(self)
class Node:
    # 节点数据
    _data = None
    # 节点的前驱
    _prevNode = None
    # 节点的后驱
    _nextNode = None
    def __init__(self,data,p,n):
        self._data = data
        self._prevNode = p
        self._nextNode = n



def buildList():
    pythonLinkedList = LinkedList()
    # 构建一个包含 0 -> 9 的 LinkedList
    for i in range(0,10,1):        
        pythonLinkedList.addData(i)
    return pythonLinkedList
    
def printList(list):
    printLinkedList = "头结点<->"
    for data in list.iterator():
        printLinkedList +=str(data) + "<->"
    printLinkedList += "尾节点"
    print printLinkedList

if __name__ == "__main__":
    # 构建 List
    pythonLinkedList = buildList()
    # 通过迭代器打印链表里面的数据
    printList(pythonLinkedList)

    print 'remove 4 index'
    pythonLinkedList.remove(4)
    printList(pythonLinkedList)

    
