def solution(cap, n, deliveries, pickups):
    answer = 0
    deliver = 0
    retrieve = 0
    
    for i in range(n-1,-1,-1):

        deliver += deliveries[i]
        retrieve += pickups[i]

        while deliver > 0 or retrieve > 0:

            answer += (i+1) * 2

            deliver -= cap
            retrieve -= cap     
            
    return answer