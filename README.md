
# 方案
## SVG2IMG
### ~~win2d~~
- 方案
    - 解析 SVG 的 XML 结构
    - 调用 API 进行渲染
    - 动画支持，实现很帧动画的渲染、截屏
- 结果
    - 官方示例 **无法跑通**
- 可能性
    - 仅支持 Windows，转服务较难
    - 完全解析 SVG 并进行可能的层级解析，需要较大学习成本

### ~~htmlunit+ batik~~
- 方案
    - 尝试使用浏览器进行 SVG 播放，减少渲染实现成本
- 结果
    - 最新 2.31 版本 **无法正常解析** 网页
- 可能性
    - SVG及其动画的支持适配上，Chrome 上可以的 SVG 在 Safari 上无法正常播放、运动
    - Htmlunit 需要及时赶上浏览器的更新进度，可能性不大


## IMG2Video
- ffmpeg
    - 方案
        - 合并图片（以数值序列递增）、音频为视频
    - 结果
        ```
        以每秒25帧的频率展示图片，以将0到3秒区间音频，合并成为视频
        ffmpeg \
            [-framerate 6] -i <imgs|img/%d.png> \ 
            [-ss 0 -t 3] -i <audio> \
            -y <video>
        ```
    - 预期问题
        - 可能针对特定的图片、音频格式，需要进行相关编码指定


# 参考
## HtmlUnit
- [后台java执行javascript，利用D3.js生成SVG，并转成png格式](https://www.jianshu.com/p/3bd154ff23f6)

## Win2D
- [Win2D documentation](http://microsoft.github.io/Win2D/html/Introduction.htm)
- [Microsoft/Win2D](https://github.com/Microsoft/Win2D)

## SVG
- [SVG Print 1.2, Part 2: Language](https://www.w3.org/TR/SVGPrint12/)
- [SVG](https://developer.mozilla.org/zh-CN/docs/Web/SVG)
- [SVG, graphics in XML for the Web](https://www.xul.fr/en-xml-svg.php)

## UWP
- [UWP 手绘视频创作工具 “来画PRO” 技术分享系列](https://www.debugrun.com/a/8OJoh6Y.html)
- [UWP 手绘视频创作工具技术分享系列](https://cloud.tencent.com/developer/article/1112164)
- [UWP 手绘视频创作工具技术分享系列 - SVG 的解析和绘制](http://www.cnblogs.com/shaomeng/p/7476480.html)
- [win10 uwp win2d 入门 看这一篇就够了](https://lindexi.gitee.io/lindexi/post/win10-uwp-win2d-%E5%85%A5%E9%97%A8-%E7%9C%8B%E8%BF%99%E4%B8%80%E7%AF%87%E5%B0%B1%E5%A4%9F%E4%BA%86.html)


## FFMPEG
### 官网
- [ffmpeg](https://www.ffmpeg.org/ffmpeg.html)

### 参考
- [Combine one image + one audio file to make one video using FFmpeg](https://superuser.com/questions/1041816/combine-one-image-one-audio-file-to-make-one-video-using-ffmpeg)
- [Useful ‘FFmpeg’ Commands for Video, Audio and Image ](https://www.tecmint.com/ffmpeg-commands-for-video-audio-and-image-conversion-in-linux/)
- [How do I convert a video to GIF using ffmpeg, with reasonable quality?](https://superuser.com/questions/556029/how-do-i-convert-a-video-to-gif-using-ffmpeg-with-reasonable-quality)