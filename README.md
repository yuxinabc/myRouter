# myRouter
 安卓组件化开发，路由设置  
#### 模块介绍  
####  routerAnnotation  
自定义注解，标记需要处理的类和属性  
#### routerCompiler  
自定义注解处理器，处理被注解的类或属性，并通过JavaPoet生成指定代码  
#### routerCore  
封装了对routerCompiler生成的代码的调用和activity的跳转以及方法的调用，为app、module1、module2提供api
