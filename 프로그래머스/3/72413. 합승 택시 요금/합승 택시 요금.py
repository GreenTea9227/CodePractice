import math

def solution(n, s, a, b, fares):
    
    
    taxi_price = [[math.inf] * (n+1) for _ in range(n+1)]
    
    for first, second, fare in fares:
        taxi_price[first][second] = fare
        taxi_price[second][first] = fare 
        
    for i in range(1,n+1):
        taxi_price[i][i] = 0
    
    for k in range(1,n+1):
        for i in range(1,n+1):
            for j in range(1,n+1):
                taxi_price[i][j] = min(taxi_price[i][j], taxi_price[i][k] + taxi_price[k][j])
                
 
    answer = math.inf
    for i in range(1,n+1):
        answer = min(answer , taxi_price[s][i] + taxi_price[i][a] + taxi_price[i][b])
        
            
    return answer