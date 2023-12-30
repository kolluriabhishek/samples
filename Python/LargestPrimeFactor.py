import sys
import math

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    sol = -1
    #by 2
    while n % 2==0:
        sol = 2
        n=n/2
    #by 3
    k=math.floor(math.sqrt(n))
    for i in range(3, k, 2):
        while(n % i==0):
            n=n/i
            sol =i
    print(n)