## 如何在NPM安装时使用不同版本的python

1. 安装[windows-build-tools](https://github.com/felixrieseberg/windows-build-tools)---包含python2.7版本

2. 指定npm使用的python版本

   ```js
   // 你可以用--python   如下
   npm install --python=python2.7
   
   // 将其设置为始终用于 NPM将在需要时将此选项传递给节点-gyp
   npm config set python python2.7
   ```

   

   

   

