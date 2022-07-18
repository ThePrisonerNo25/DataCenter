# 常用css 属性

* flex 左边自适应，右边固定
  
  ```js
  <div class="container">
      <div class="left"></div>
      <div class="right">
        <div class="r1">1233444234</div>
        <div class="r2">jieke</div>
      </div>
    </div>
  ```
  
  ```css
  .container {
    display: flex;
    background: #d3dce6;
  }
  .left {
    flex: 1 1 auto;
    background: green;
  }
  .right {
    flex: 0 0 auto;
    display: flex;
    background: red;
  }
  ```

* 单行文本
  
  - ```css
    white-space:nowrop; // 不换行,对于连续的数字或者英文字母可省略
    overflow:hidden; // 溢出隐藏
    text-overflow：ellipsis; // 文本溢出显示省略号
    ```

* 多行文本超出省略号
  
  ```scss
  display: -webkit-box; 
  oberflow: hidden;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2; // 显示几行
  ```
  
  
  
  
  
  
  
  
  
