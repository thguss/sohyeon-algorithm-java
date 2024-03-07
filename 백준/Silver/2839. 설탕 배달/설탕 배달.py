N = int(input())
bongi=0

while True:
    if N%5==0:
        bongi+=N//5
        print(bongi)
        break
    
    N-=3
    bongi+=1

    if N<0:
        print(-1)
        break
