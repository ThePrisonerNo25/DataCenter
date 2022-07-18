# git使用步骤——断开与原来远程仓库的连接，连接新仓库并上传

1.连接远程仓库
git remote add origin 仓库地址

2.查看远程连接
git remote -v

3.git取消与远程仓库的连接
git remote remove origin

4.初始化仓库

git init

5.连接新仓库

git remote add origin https://github.com/XXX.git

6.检查状态

git status

7.检查分支

git branch

8.创建分支

git checkout br

9.提交到 本地

git add .

10.提交说明

git commit -m “说明"

11.推送到远程分支

git push -u br

12.切换到主分支

git checkout main

13.本地合并

git merge br

14.推送到远程

git  push

15.删除本地分支

git branch --delete dev_20181018

16.删除远程分支

git push origin --delete dev_20181018
