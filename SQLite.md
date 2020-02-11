 # SQLite数据库系统简介
 ### 轻型/嵌入式/ACID关系型数据库（A:atomicity-原子性,C:Consistency-一致性,I:Isolation-隔离性,D:Durability-持久性）
 ###SQLite可以看作一个API库、数据库引擎库

 ## 优点:
 * 轻量、高效
 * 绿色无需“安装”
 * 零配置
 * 动态数据类型
 * 单一文件

 ## 缺点:
 * 并发性能
 * 网络文件
 * SQL功能子集
 * 动态数据类型:
    1. NULL:空值
    2. INTEGER:带符号的整型
    3. REAL:浮点数字,存储为8-byte IEEE浮点数
    4. TEXT:字符串文本
    5. BLOB:二进制对象

 ## SQLite常用方法
 * 支持SQL92大部分规范：
      * CREATE:Tabke、View 、Index、Trigger
      * TRANSACTION
      * Insert ,select,delete,update
      * Drop
      * Alter
      * ATTACH

 * 约束条件
     1. NOT NULL
     2. UNIQUE
     3. PRIMARY KEY
     4. CHECK
     5. DEFAULT

 * 游标常用方法:
     方法名称 | 方法描述
     -|-
     getCount() |  获取总的项目数量
     isFirst() | 判断是否是第一条记录
     isLast() | 判断是否最后一条记录
     moveToFirst() | 移动到第一条记录
     moveToLast() | 移动到最后一条记录
     move(int offset) | 移动到指定记录
     moveToNext() | 移动到下一条记录
     moveToPrevious() | 移动到上一条记录
     getColumnIndexOrThrow(String columnName) | 根据列名称获得列索引
     getInt(int columnIndex) | 获得指定列的int类型值
     getString(int columnIndex) | 获得指定列的String类型值

 * 常用SQL方法:
     * Group By
     * HAVING
     * Distinct
     * Order By
     * Limit
     * Join,On
     * Like,GLOB
     * 通配符
     * In
     * Between


## SQLite高级功能
  * 聚合函数
    * avg(x)
    * count(x|*)
    * group_concat(x[,y])
    * max(x),min(x)
    * sum(x)

  * 核心函数
    * last_insert_rowid()
    * abs(X)
    * coalesce(X,Y,...)
    * ifnull(X,Y)
    * length(X)
    * lower(X)
    * Max ,min
    * nullif(X,Y)
    * like(X,Y)
    * random()
    * repace(X,Y,Z)
    * round(X)
    * substr(X,Y[,Z])
    * changes(),total_changes()
    * trim(x[,y]),ltrim(),rtrim()
    * typeof(X)
    * upper(X)
    * zeroblob(N),randomblob(N)
    * quote(X)
    * instr(X,Y)


  * 其他高级功能
    * date(timestring,modifier,modifier,...)
    * time(timestring,modifier,modifier,...)
    * datetime(timestring,modifier,modifier,...)
    * julianday(timestring,modifier,modifier,...)
    * strftime(format,timestring,modifier,modifier,...)
    * json(string),json_object(...)
    * json_array(value1,value2,...)
    * json_extract(json,path,...)
    * json_array_length(json)
    * json_insert(json,path,value,...)
    * json_replace(json,path,value,...)
    * json_set(json,path,value,...)

## 几个问题
    * AUTOINCREMENT field
    * VARCHAR 最大多少字符
    * round(9.95,1) = 9.9 而不是10.0
    * insert很慢
    * column1 = "column1" 无效

  ### 优化
      * PRAGMA auto_vacuum = 0| 1
      * PRAGMA cache_size = 9000; default_cache_size
      * PRAGMA page_size = bytes;
      * PRAGMA synchronous=FULL|NORMAL|offset
      * PRAGMA temp_store = MEMORY|FILE|DEFAULT
      * Transaction优化大批量数据的插入

### 优化
    * 索引

### 参数调整
    * sqlite_master , .schema
    * 一些命令参数

[来自慕课网的视频学习资料----Android数据库解析应用](https://www.imooc.com/learn/734)
