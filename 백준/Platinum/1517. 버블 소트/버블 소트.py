import sys

N = int(sys.stdin.readline().strip())
numbers = list(map(int,sys.stdin.readline().split()))
ans = 0

def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    mid = len(arr)//2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])

    return merge(left,right)

def merge(left,right):
    global ans
    result = []
    i,j = 0,0

    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i+=1
        else:
            result.append(right[j])
            j += 1
            ans += len(left) - i


    result.extend(left[i:])
    result.extend(right[j:])
    return result

merge_sort(numbers)
print(ans)