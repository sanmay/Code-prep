import os


class Node(object):
    data=0.0
    Next=None
    
    def __init__(self,data):
        self.data=data
        self.next=None
        
    def printNode(self):
        print self.data
    
    
class LinkedList(object):
    '''This class provides insertion in linkedlist'''
    head=None
    
    def insert(self,data):
        temp=Node(data)
        if self.head==None:
            self.head=temp
        else:
            cur=self.head
            while cur.Next!=None:
                cur=cur.Next
            cur.Next=temp
            
    def printLL(self):
        cur=self.head
        while cur!=None:
            cur.printNode()
            cur=cur.Next
            
if __name__=="__main__":
    LL=LinkedList()
    LL.insert(2)
    LL.insert(3)
    LL.printLL()