class Node(object):
    data=0
    left=None
    right=None
    
    def __init__(self, data):
        self.data=data
        self.left=None
        self.right=None
    
    def printNode(self):
        print self.data
    
class BinaryTree(object):
    root=None
    
    def __init__(self):
        self.root=None
        
    def insert(self,data,root):
        if root==None:
            temp=Node(data)
            if self.root==None:
                self.root=temp
            return temp
        elif data<root.data:
            root.left=self.insert(data,root.left)
        else:
            root.right=self.insert(data,root.right)
        return root

            
    def inorder(self,root):
        if root==None:
            return
        self.inorder(root.left)
        root.data
        self.inorder(root.right)
    
        


if __name__=="__main__":
    b=BinaryTree()
    b.insert(3,b.root)
    b.insert(1,b.root)
    b.insert(4,b.root)
    b.inorder(b.root)