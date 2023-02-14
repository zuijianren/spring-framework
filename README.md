# 源码学习

## 源码编译步骤

1. 根据 `gradle/wrapper/gradle-wrapper.properties` 文件下载 gradle 对应版本, 并在下载完成后, 修改原路径如下

   ```properties
    #distributionUrl=https\://services.gradle.org/distributions/gradle-7.5.1-bin.zip
    distributionUrl=file:///d:/gradle-7.6/gradle-7.6-all.zip
    ```

2. 根据 `gradle/ide.gradle` 为项目设置正确的 jdk 版本
   > tips: 需要确保本地 jdk 版本为指定版本对应的最新版本, 否则可能会报错类找不到
3. 修改仓库地址. 修改 `build.gradle` 文件

   ```gradle
   repositories {
      mavenLocal() //先从maven本地仓库寻找jar包
      maven { name 'ali'; url 'https://maven.aliyun.com/repository/public/'} //阿里镜像仓库
      mavenCentral()
      maven { url "https://repo.spring.io/libs-spring-framework-build" }
   }

   // 测试仓库地址是否生效 函数 
   // 项目路径 cmd 下, 执行  `gradle showRepos` 命令
   tasks.register('showRepos') {
      doLast {
         println "All repos:"
         println repositories.collect { it.name + "=" + it.url }
      }
   }

   ```

4. 关闭代码检验. 修改 `build.gradle` 文件. 搜索 'checkstyle' 关键词, 注销相关代码
   > 避免自建测试模块还需要添加许多不必要的说明文件才能运行

5. 控制台乱码显示问题解决, 修改 idea->help->Edit Custom VM Options 添加如下配置

   ```txt
   -Dfile.encoding=UTF-8
   ```

6. 此外, 或许需要参考项目中的 `import-into-idea.md` 文件, 执行build命令?
   > 此次, 编译通过未使用到该文件. 可能是 idea 版本比较新? 版本: 2021.1.3

## 添加自定义模块进行测试

1. 以 gradle 的方式创建模块
2. 修改默认文件 `build.gradle` 文件 -> `模块名.gradle`
   * 如果不进行修改, 会导致即使在 `build.gradle` 文件中声明了依赖, 依然无法在模块中使用
   * 原因: spring 项目中的 `setting.gradle` 文件中存在如下代码

      ```gradle
         rootProject.name = "spring"
         // 此处导致新建模块的 gradle 文件   命名格式: 模块名.gradle  而不是 默认的 build.gradle
         rootProject.children.each { project ->
            project.buildFileName = "${project.name}.gradle"
         }
      ```

3. 执行测试代码时, 会执行许多 task
    * 解决方法: 修改编译环境中的 gradle 配置, 将 `Build and run using` 和 `Run tests using` 配置修改为  `idea` 即可