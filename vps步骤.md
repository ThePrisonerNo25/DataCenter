# vps步骤

### 1.设置系统时间

1. 查看当前时区
   命令 ： "date -R"
2. 例如：将系统日期设定成2009年11月3日的命令
   命令 ： "date -s 11/03/2009" 
3. 将系统时间设定成下午5点55分55秒的命令
   命令 ： "date -s 17:55:55"



### 2.安装v2ray

### 安裝 cURL

#### Debian

```
# apt update
# apt install curl
```

CentOS / Fedora

```
# dnf makecache
# dnf install curl
```

openSUSE

```
# zypper refresh
# zypper install curl
```

下載此指令碼

```
$ curl -O https://raw.githubusercontent.com/v2fly/fhs-install-v2ray/master/install-release.sh
```

執行此指令碼

```
# bash install-release.sh
```

### 該腳本安裝的文件符合 [Filesystem Hierarchy Standard (FHS)](https://en.wikipedia.org/wiki/Filesystem_Hierarchy_Standard)：

```
installed: /usr/local/bin/v2ray
installed: /usr/local/bin/v2ctl
installed: /usr/local/share/v2ray/geoip.dat
installed: /usr/local/share/v2ray/geosite.dat
installed: /usr/local/etc/v2ray/config.json
installed: /var/log/v2ray/
installed: /var/log/v2ray/access.log
installed: /var/log/v2ray/error.log
installed: /etc/systemd/system/v2ray.service
installed: /etc/systemd/system/v2ray@.service
```

### 3.v2ray配置文件

```json
{
  "inbounds": [{
    "port": 10099, 
    "protocol": "vmess",
    "settings": {
      "clients": [ {
            "id": "37bbe415-b5f7-f3bb-c0b7-5041d917a6ad",
            "alterId": 0
            
          }]
    }
  }],
  "outbounds": [{
    "protocol": "freedom",
    "settings": {}
  }]
}
```



### 4.Debian 9/10/11 快速开启BBR的方法

**1、修改系统变量**

```
echo "net.core.default_qdisc=fq" >> /etc/sysctl.conf 
echo "net.ipv4.tcp_congestion_control=bbr" >> /etc/sysctl.conf
```

**2、保存生效**

```
sysctl -p
```

**3、查看内核是否已开启 BBR**

```
sysctl net.ipv4.tcp_available_congestion_control
```

显示以下即已开启：

```
net.ipv4.tcp_available_congestion_control = reno cubic bbr
```

**4、查看 BBR 是否启动**

```
lsmod | grep bbr
```

显示以下即启动成功：

```
# lsmod | grep bbrtcp_bbr                20480  1
```


