#!/usr/bin/env python
# coding: utf-8

# In[3]:


from selenium import webdriver
from bs4 import BeautifulSoup
import os
import webbrowser
driver=webdriver.Chrome('C:\\Users\\mjkim\\PythonCode\\chromedriver')


# In[4]:



driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChwKGgoUdG9wc2VsbGluZ19mcmVlX0dBTUUQBxgD:S:ANO1ljJH_B0&gsr=Ch4KHAoaChR0b3BzZWxsaW5nX2ZyZWVfR0FNRRAHGAM%3D:S:ANO1ljLEXvI');

top_app_details = driver.find_elements_by_class_name('Q9MA7b')
f=open("free.txt",'w+')

for app in top_app_details:
    f.write(app.text+'\n')

f.close()


# In[5]:



driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChwKGgoUdG9wc2VsbGluZ19wYWlkX0dBTUUQBxgD:S:ANO1ljI3NIA&gsr=Ch4KHAoaChR0b3BzZWxsaW5nX3BhaWRfR0FNRRAHGAM%3D:S:ANO1ljKgPH8');

top_app_details = driver.find_elements_by_class_name('Q9MA7b')
f=open("charged.txt",'w+')

for app in top_app_details:
    f.write(app.text+'\n')

f.close()


# In[6]:


driver=webdriver.Chrome('C:\\Users\\mjkim\\chromedriver')
driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChgKFgoQdG9wZ3Jvc3NpbmdfR0FNRRAHGAM%3D:S:ANO1ljKVCGg&gsr=ChoKGAoWChB0b3Bncm9zc2luZ19HQU1FEAcYAw%3D%3D:S:ANO1ljI_yc8');

top_app_details = driver.find_elements_by_class_name('Q9MA7b')
f=open("bestseller.txt",'w+')

for app in top_app_details:
    f.write(app.text+'\n')

f.close()

