# Docker的常用命令

```shell
docker version  
docker info
docker 命令 --help  # 万能命令
```

# 镜像命令

### docker images 查看所有本地的主机上的镜像

```shell
REPOSITORY            TAG       IMAGE ID       CREATED        SIZE
jenkinsci/blueocean   latest    0841193fea4e   3 weeks ago    697MB
hello-world           latest    d1165f221234   4 months ago   13.3kB

# 解释
REPOSITORY  镜像的仓库源
TAG 	    镜像的标签
IMAGE ID    镜像的ID
CREATED     镜像的创建时间
SIZE        镜像的大小

# 可选项
-a, --all 		# 列出所有的镜像
-q, --quite		# 只显示镜像的id
```



### docker search 搜索镜像

```shell
chaos_ming0@instance-2:~$ docker search mysql
NAME                              DESCRIPTION    	STARS     OFFICIAL   AUTOMATED
mysql                             MySQL is a widely used, open-source relation…   11108     [OK]
mariadb                           MariaDB Server is a high performing open sou…    4211      [OK]

```



### docker pull 下载镜像

```shell
chaos_ming0@instance-2:~$ docker pull mysql
Using default tag: latest	#默认使用最新版本
latest: Pulling from library/mysql
b4d181a07f80: Pull complete
a462b60610f5: Pull complete
578fafb77ab8: Pull complete
524046006037: Pull complete
d0cbe54c8855: Pull complete
aa18e05cc46d: Pull complete
32ca814c833f: Pull complete
9ecc8abdb7f5: Pull complete
ad042b682e0f: Pull complete
71d327c6bb78: Pull complete
165d1d10a3fa: Pull complete
2f40c47d0626: Pull complete
Digest: sha256:52b8406e4c32b8cf0557f1b74517e14c5393aff5cf0384eff62d9e81f4985d4b	#签名
Status: Downloaded newer image for mysql:latest		
docker.io/library/mysql:latest	#真实地址

# 等价于
docker pull mysql
docker pull docker.io/library/mysql:latest

# 指定版本下载
chaos_ming0@instance-2:~$ docker pull mysql:5.7


```



### docker rmi -f 删除镜像

```shell

chaos_ming0@instance-2:~$ docker rmi -f 镜像名称   # 删除镜像
chaos_ming0@instance-2:~$ docker rmi -f 镜像id  # 删除镜像通过id
chaos_ming0@instance-2:~$ docker rmi -f 镜像id 镜像id 镜像id  # 删除多个镜像
chaos_ming0@instance-2:~$ docker rmi -f $(docker images -ap)  # 删除全部镜像

```



# 容器命令

### 新建容器并启动

```shell
docker run [可选参数] image
# 参数说明
--name="name"		容器名字
-d				   后台方式运行
-it 			   使用交互方式运行，进入容器查看内容
-p				   指定容器的端口 -p 8080:8000
	-p ip:主机端口:容器端口
	-p 主机端口:容器端口（常用）
	-p 容器端口
-p				   随机指定端口

# 启动并进入容器
docker run -it centos /bin/bash

# 从容器中退回主机
exit
```



### 列出运行的容器

```shell
docker ps 命令	# 列出当前正在运行的容器
-a		# 列出当前正在运行的容器 + 历史运行过的容器
-n=? 	# 显示最近创建的容器
-q		# 只显示容器的编号
```



### 退出容器

```shell
exit 		#直接停止容器并退出
Ctrl + P + Q 		# 容器不停止退出
```



### 删除容器

```shell
docker rm 容器id 		# 删除指定容器
docker rm -f $(docker ps -ap)		# 删除所有容器
```

### 启动和停止容器

```shell
docker start 容器id		# 启动容器
docker restart 容器id		# 重启容器
docker stop 容器id 		# 停止当前正在运行的容器
docker kill 容器id		# 强制停止当前容器
```

### 后台启动容器

```shell
docker run -d 镜像名称 		# 常见的坑，docker 容器用后台运行，就必须要有一个前台进程，docker发现没有应用，就会自动停止。 		#nginx,容器启动后，发现自己没有提供服务，就是没有程序了
```

### 查看日志

```shell
docker logs -f -t --tail 容器id
-tf 		# 显示日志
--tail number		# 显示日志条数
```

### 查看容器中的进程信息

```shell
docker top 容器id
```

### 查看镜像的元数据

```shell
docker inspect 容器id
```

### 进入当前的容器

```shell
# 方式一
docker exec -it 容器id bashShell  # 例如：docker exec -it centos容器id /bin/bash

# 方式二
docker attach 容器id 		

# docker exec 		# 进入容器后开启一个新的终端,可以在里面操作(常用)
# docker attach		# 进入容器正在执行的终端，不会启动新的进程!
```

### 从容器内拷贝文件到主机上

```shell
docker cp 容器id:容器内的路径  目的地的主机路径
```









