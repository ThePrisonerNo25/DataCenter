## github ip 设置

##### 

1. 打开https://github.com.ipaddress.com/     记录 ip
   140.82.112.3

2. 打开https://websites.ipaddress.com/github.global.ssl.fastly.net#ipinfo    记录ip 
   199.232.69.194

3. 打开https://websites.ipaddress.com/assets-cdn.github.com    记录ip

   185.199.108.153
   185.199.109.153
   185.199.110.153
   185.199.111.153
   2606:50c0:8000::153
   2606:50c0:8001::153
   2606:50c0:8002::153
   2606:50c0:8003::153

4. 打开电脑的hosts文件，把下列的东东写在最后，然后保存即可
   185.199.108.153  assets-cdn.github.com
   185.199.109.153  assets-cdn.github.com 
   185.199.110.153  assets-cdn.github.com
   185.199.111.153  assets-cdn.github.com
   2606:50c0:8000::153  assets-cdn.github.com
   2606:50c0:8001::153  assets-cdn.github.com
   2606:50c0:8002::153  assets-cdn.github.com
   2606:50c0:8003::153  assets-cdn.github.com

   140.82.112.3  github.com
   199.232.69.194  github.global.ssl.fastly.net

5. 在终端在输以下指令刷新DNS（需要权限）
   sudo killall -HUP mDNSResponder;say DNS cache has been flushed

