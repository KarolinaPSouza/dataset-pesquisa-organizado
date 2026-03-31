#!/usr/bin/env python
# coding: utf-8

# In[7]:


number = 0
unique_values=0
n = int(input())
arr = list(map(int,input().split()))


# In[8]:


arr.sort()
number = arr[0]
unique_values += 1
for i in range(1,n):
    if number != arr[i]:
        number = arr[i]
        unique_values +=1
print(unique_values)


# In[ ]:



