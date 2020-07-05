学习笔记
<p>
    1.二分查找：
    
    先找中间位置索引mid，判断mid是不是target的索引，是的话就返回
    否则，若left到mid位置是有序的（nums[left] <= nums[mid]):
      判断target是否在mid的左边（nums[left] <= target && nums[mid] > target):
          是：right = mid - 1;否：left = mid + 1;
    若left到mid位置是无序的（则mid到right肯定有序，因为只nums是一个有序数组只旋转了一次得到的）
      判断target是否在mid的右边（nums[mid] < target && nums[right] >= target）
          是：left = mid + 1；否：right = mid - 1
          
    二叉查找公式：int nums[], int target
        left = 0; ringht = nums.lenght -1;
        while(left <= right)
            mid = (left + right) / 2;
            nums[mid] == targert
                return
            target > nums[mid]
                left = mid + 1;
            target < nums[mid]
                right = mid - 1;
</p>
<p>
    2.dfs
        
    模板：
        递归
        visited = set() 
        def dfs(node, visited):
            if node in visited: # terminator
                # already visited 
                return 
            visited.add(node) 
            # process current node here. 
            ...
            for next_node in node.children(): 
                if next_node not in visited: 
                    dfs(next_node, visited)
         迭代
         def DFS(self, tree): 
         	if tree.root is None: 
         		return [] 
         	visited, stack = [], [tree.root]
         	while stack: 
         		node = stack.pop() 
         		visited.add(node)
         		process (node) 
         		nodes = generate_related_nodes(node) 
         		stack.push(nodes) 
         	# other processing work 
         	...
</p>

<p>
    3.贪心算法
    
    先证明：根据每一项去求解，每一项的结果累加就是最终结果
    对每一项进行贪心计算
</p>

<p>
    4.本周学习未解决的问题：
        
        1.机器人行走问题
        2.单词接龙问题
        对于这两个问题，现在的打算是下周系统的将深度广度遍历的题再做做。
</p>