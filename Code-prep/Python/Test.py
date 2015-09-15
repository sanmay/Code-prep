
import random


def test_fun(name,**args):
    print name.count('a')
    print args


class myclass(object):
    a=0
    b=0
    
    def __init__(self,a=0,b=0):
        self.a=a
        self.b=b
   #def __eq__(self,other):
    #    if self.a==other.a:
     #       return True
      #  else:
       #     return False
    
    def __str__(self):
        return str(self.a)
    
    def printme(self):
        print self.a,self.b
        
    @staticmethod
    def stat_method():
        print "this is static method"

class c_class(myclass):
    
    def __init__(self,a=0,b=0,c=0):
        super(c_class,self).__init__(a,b)
        
if __name__=="__main__":
    
    my_dict={}
    for i in xrange(1,100,2):
        num=random.randint(1,10)
        print num
        if my_dict.has_key(num):
            my_dict[num]=my_dict[num]+1
        else:
            my_dict[num]=1;
    
    for key in my_dict.keys():
        print my_dict[key]
    
    print my_dict
    
    
    
    