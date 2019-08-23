#!/usr/bin/env python
# coding: utf-8

# In[4]:


from selenium import webdriver
import webbrowser
import os
from bs4 import BeautifulSoup

import re
import urllib

import urllib.request
driver = webdriver.Chrome('C:\\Users\\mjkim\\PythonCode\\chromedriver')


# In[5]:


driver.implicitly_wait(3)


# In[6]:


driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChwKGgoUdG9wc2VsbGluZ19mcmVlX0dBTUUQBxgD:S:ANO1ljJH_B0&gsr=Ch4KHAoaChR0b3BzZWxsaW5nX2ZyZWVfR0FNRRAHGAM%3D:S:ANO1ljLEXvI');
soup=BeautifulSoup(driver.page_source,'lxml')
str1=list()
str2=list()
str3=list()
str4=list()
str5=list()

sel1=soup.select('.eJxoSc img')

for e in sel1:
    str1.append(str(e))

for e in range(150):
    if e%3==0:
        str2.append(str1[e])

for e in str2:
    str3.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" src="',''))

for e in str3:
    str4.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" data-src="',''))

for e in str4:
    str5.append(e.split('-rw"')[0])

f=open("free_img.txt",'w+')

for app in str5:
    f.write(app+'\n')

f.close()


# In[7]:


driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChwKGgoUdG9wc2VsbGluZ19wYWlkX0dBTUUQBxgD:S:ANO1ljI3NIA&gsr=Ch4KHAoaChR0b3BzZWxsaW5nX3BhaWRfR0FNRRAHGAM%3D:S:ANO1ljKgPH8');
soup=BeautifulSoup(driver.page_source,'lxml')
str1=list()
str2=list()
str3=list()
str4=list()
str5=list()

sel1=soup.select('.eJxoSc img')

for e in sel1:
    str1.append(str(e))

for e in range(150):
    if e%3==0:
        str2.append(str1[e])

for e in str2:
    str3.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" src="',''))

for e in str3:
    str4.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" data-src="',''))

for e in str4:
    str5.append(e.split('-rw"')[0])

f=open("charged_img.txt",'w+')

for app in str5:
    f.write(app+'\n')

f.close()


# In[8]:


driver.get('https://play.google.com/store/apps/collection/cluster?clp=ChgKFgoQdG9wZ3Jvc3NpbmdfR0FNRRAHGAM%3D:S:ANO1ljKVCGg&gsr=ChoKGAoWChB0b3Bncm9zc2luZ19HQU1FEAcYAw%3D%3D:S:ANO1ljI_yc8');
soup=BeautifulSoup(driver.page_source,'lxml')
str1=list()
str2=list()
str3=list()
str4=list()
str5=list()

sel1=soup.select('.eJxoSc img')

for e in sel1:
    str1.append(str(e))

for e in range(150):
    if e%3==0:
        str2.append(str1[e])

for e in str2:
    str3.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" src="',''))

for e in str3:
    str4.append(e.replace('<img aria-hidden="true" class="T75of QNCnCf" data-ils="3" data-src="',''))

for e in str4:
    str5.append(e.split('-rw"')[0])

f=open("bestseller_img.txt",'w+')

for app in str5:
    f.write(app+'\n')

f.close()

