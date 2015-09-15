
def getMaxSqIndex(n):
    sq=1
    odd=1
   
    while sq<=n:
        odd=odd+2
        sq=sq+odd
    
    if sq==n:
        return odd/2+1
    else:
        return odd/2

def getNumSquares(n):
    col=getMaxSqIndex(n)
    row=n
    table=[[0 for x in xrange(col+1)] for x in xrange(row+1)]
    
    
    
    print table
    
    for c in xrange(col+1):
        table[0][c]=0.0
     
    for r in xrange(row+1):
        table[r][0]=float("inf")

    
    for c in xrange(1,col+1):
        
        for r in xrange(1,row+1):
            sq=c*c
            min=table[r][c-1]
            if r-sq>=0:
                cur=1+table[r-sq][c]
                table[r][c]=cur if cur<min else min
            else:
                table[r][c]=min
    print table[row][col]
            
            
    
if __name__=="__main__":
    getNumSquares(12)