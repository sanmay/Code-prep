import sys


a=[5,4,6,9,2,10]
SUM=12
i=0
j=0
_sum=0
while(j<len(a)+1):
	print _sum
	if(_sum<SUM):
		_sum+=a[j]
		j+=1
	elif(_sum>SUM):
		_sum-=a[i]
		i+=1
	else:
		print i, j-1
		break;