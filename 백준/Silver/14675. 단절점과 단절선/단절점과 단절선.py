import sys
from collections import defaultdict
from typing import DefaultDict, List, Tuple

N: int = int(sys.stdin.readline())

numDict: DefaultDict[int, List[int]] = defaultdict(list)
bridge: List[Tuple[int, int]] = []

for i in range(N - 1):
    num1, num2 = map(int, sys.stdin.readline().split())
    numDict[num1].append(num2)
    numDict[num2].append(num1)
    bridge.append((num1, num2))

vertex: List[int] = [0] * (N + 1) 
for key in numDict.keys():
    vertex[key] = len(numDict[key])

T: int = int(sys.stdin.readline())

for i in range(T):
    query = list(map(int, sys.stdin.readline().split()))
    numType, num1 = query[0], query[1]

    if numType == 1:
        print('no' if vertex[num1] == 1 else 'yes')
    else:
        print('yes')
