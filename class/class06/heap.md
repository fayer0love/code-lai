HEAP
堆总是一棵完全树
任意节点都小于它的后裔，最小元素再堆的根上。（堆序性）
节点最小叫最小堆，节点最大叫最大堆
lChild index = index of parent * 2 + 1 
rChild index = index of parent * 2 + 2 
implemented as an unsorted array that follow the rules above

