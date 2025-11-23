def solution(n, times):

    left = 1
    right = max(times) * n
    
    while left < right:
        mid = (left + right) // 2
        
        total = sum([mid//t for t in times])
        if total < n:
            left = mid + 1
        else:
            right = mid
    
    return left