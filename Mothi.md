# Mothi 简单使用

## 依赖库引入

* kotlin使用反射

  ```groovy
  def moshi_version = '1.9.2'
  implementation "com.squareup.moshi:moshi:$moshi_version"
  implementation "com.squareup.moshi:moshi-kotlin:$moshi_version" //kotlin 使用反射
  ```

* kotlin代码生成

  ```groovy
  apply plugin: 'kotlin'
  apply plugin: 'kotlin-kapt'
  
  dependencies{
      def moshi_version = '1.9.2'
  	implementation "com.squareup.moshi:moshi:$moshi_version"
  	kapt "com.squareup.moshi:moshi-kotlin-codegen:$moshi_version" //kotlin 代码生成
  }
  ```

## Mothi: demo

```kotlin
MoshiBean.kt
@JsonClass(generateAdapter = true)
data class MothiBean(
    val name:String,
    val age:Int?,
    @Json(name ="user_money")
    val money:Int
)

    val json = """
       {
            "name": "Most elegant",
            "age":null,
            "user_money":20
       }
    """

        val mothi = Moshi.Builder().build()
        val adapter1 = mothi.adapter<MothiBean>(MothiBean::class.java)
        val fromJson = adapter1.fromJson(json)
        print(fromJson) //MothiBean(name=Most elegant, age=null, money=20)

        val json2 = adapter1.toJson(MothiBean("adf", null, 100))
        print(json2) //{"name":"adf","user_money":100}
		

	   val adapter2 = mothi.adapter<MothiBean>(MothiBean::class.java).serializeNulls()
        val jsonString2 = adapter2.toJson(MothiBean("adf", null, 100))
        print(jsonString2) //{"name":"adf","age":null,"user_money":100}


```





## Moshi: Convert map to json

```kotlin
 val employeeMap: MutableMap<String, Any?> = HashMap()
        employeeMap["id"] = 1
        employeeMap["name"] = "Dhatri"
        employeeMap["tag"] = null
        employeeMap["tag1"] = ""
        employeeMap["hobbies"] = listOf("Trekking", "Singing")

        val addressMap: MutableMap<String, Any?> = HashMap()
        addressMap["city"] = "Hyderabad"
        addressMap["country"] = "India"

        employeeMap["address"] = addressMap

        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<Map<String, Any?>> = 				moshi.adapter(Types.newParameterizedType(MutableMap::class.java, String::class.java, Any::class.java))

//        val json: String = jsonAdapter.indent("  ").toJson(employeeMap)
        val json: String = jsonAdapter.toJson(employeeMap)
        println(json)
```

