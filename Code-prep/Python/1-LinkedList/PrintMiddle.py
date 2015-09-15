from LinkedList import LinkedList



def printMiddle(head):
    slow=head
    fast=head
    print slow.Next
    
    while fast!=None and fast.Next!=None and fast.Next.Next!=None:
        fast=fast.Next.Next
        slow=slow.Next
    
    return slow.data
    
if __name__=="__main__":
    l=LinkedList()
    l.insert(1)
    l.insert(2)
    l.insert(3)
    l.insert(4)
    l.insert(5)
    l.insert(6)
    l.printLL()
    print printMiddle(l.head)