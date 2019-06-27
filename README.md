# 首要声明
此库和demo主要是clone来自这位带哥的Repository[YeDaxia/Android-YRichEditor](https://github.com/YeDaxia/Android-YRichEditor)，感谢
<br>当然是做了适合自己的修改，主要修改内容如下

1. 升级了demo和module的依赖库
2. 修复二次编辑「点击提交」已上传的图片检测不出的问题
3. 修改了一些适合自己的样式问题
4. demo也修改了一些样式和功能

一些提示：

1. 建议直接clone下来运行看看，因为现在的demo只适合我自己的需求
2. 此富文本编辑器功能挺丰富的，但是我只用到了「插图」和「加粗」，demo里的其他功能我在xml里设置成GONE了，因此想看其他功能请务必自己修改
3. 更多的需求请查看以下的内容，因为下面的md文件除了失效的其余我没改过

提供一张预览图：

<img src="https://github.com/wenwenwen888/Android-YRichEditor/blob/master/preview/1.png" width="30%" height="30%">


# Android-YRichEditor

an android richedtor with native implementation

# Feature

1. 支持图文并排。
2. 支持加粗和链接。
3. 支持本地图片和网络图片。
4. 自定义图片加载和图片上传。

# Output

1. 图片，标题，段落作为一级标签。
2. 加粗，链接作为段落的内嵌标签。

示例：

```html

<h1>这是一级标题</h1>
<p>段落1<a href="http://heiman.com">hei man</a></p>
<p>段落2<b>我是加粗部分</b>hello<br></p>
<img src="http://github.com/pic.png" width="100", height="100"/>
<p>段落3<b>加粗加粗加粗<br>加粗加粗加粗</b></p>

```

# More

详细使用请查看示例，有关原理可以查看[Android原生简易图文编辑器](https://yedaxia.github.io/Android-RichEditor-And-NativeHtml/)

**Thanks:**

- XRichText: https://github.com/sendtion/XRichText
- cwac-richedit: https://github.com/commonsguy/cwac-richedit
- Html解析库Jsoup：https://jsoup.org/
