# 简介

Filament是一款跨平台的实时的基于物理渲染引擎\(PBR\)，支持主流的Android、iOS、Linux、macOS、Windows和WebGL。为了在Android平台上高效运行，它被设计的足够小\(精简\)。

{% embed url="https://google.github.io/filament/" %}



### 文档

在Filament官网提供了非常值得一看的文档：

* [Filament](https://google.github.io/filament/Filament.html)： 关于PBR的深层理论，图形性能和相关实现。该文档说明了该引擎背后的数学原理以及为何在实现时作出这些决策。这个文档是一篇非常棒的PBR图形编程入门教程。
* [Materials](https://google.github.io/filament/Materials.html)：材质系统的说明手册，包括如何使用  `matc` 编译材质以及如何自定义材质。
* [Material Properties](https://google.github.io/filament/Material%20Properties.pdf)：标准材质中各种属性和方法的参考文档。



### 源码&下载

[下载Filament版本](https://github.com/google/filament/releases)以访问稳定的版本。发布档案包含生成资产所需的主机端工具。确保始终使用与运行时库相同版本的工具。这对于`matc`尤其重要。  


{% embed url="https://github.com/google/filament" %}

#### Android/JVM

推荐在Android和桌面端使用Gradle构建基于JVM的Filament项目

```text
repositories {
    // ...
    mavenCentral()
}

dependencies {
    // for android
    implementation 'com.google.android.filament:filament-android:version'
    // for desktop jar
    implementation files('path/to/filament-java.jar')
}
```

#### iOS

iOS projects can use CocoaPods to install the latest release:

```text
pod 'Filament', '~> 1.9.15'
```



### 官方示例

> TODO

