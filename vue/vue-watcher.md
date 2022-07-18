### vue--watch监听对象

```jsx
export default {
    data() {
        return{
            from: {
                name: '',
                phone: '',
                passWord: '',
            }
        }
    },
    watch: {
        from:{
            handler: function(val): {
                if(val.phone.length === 11 && val.name){
                    // todo
                } else {
                    // todo
                }
            } 
        },
        deep: true // 对象深度验证
    },
    'form.passWord': function(val){
        // 单个数据验证
        console.log(val)
    }
}
```
