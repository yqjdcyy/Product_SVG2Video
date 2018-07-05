
# IMG+ Audio= Video
- `ffmpeg -i img/bg.png -i audio/bgm-min.mp3 -y dest/png_mp3.mp4`
    ```
    convert:    success
    play:
        potplay:    success
        ffplay:     success
    ```

- `ffmpeg -loop 1 -shortest -y -i img/bg.png -i audio/bgm-min.mp3 -acodec copy dest/png_mp3.avi`
    ```
    convert:    fail
        Option shortest (finish encoding within shortest input) cannot be applied to input url img/bg.png
    ```

- `ffmpeg -loop 1 -y -i img/bg.png -i audio/bgm-min.mp3 -acodec copy -y dest/png_mp3_loop.avi`
    ```
    convert:    fail.not stop
    play:       
        potplay:    success
            audio.duration= 3
            video.duration= 19
        ffplay:     success
    ```

- `ffmpeg -y -i img/bg.png -i audio/bgm-min.mp3 -acodec copy -y dest/png_mp3.mp4`
    ```
    convert:    success
    play:       
        potplay:    success
        ffplay:     success
    ```

# IMGs+ Audio= Video
- `ffmpeg -i dest/png_mp3_loop-mp4/%d.jpg -i img/hand.png -y dest/jpgs_png.mp4`

- `ffprobe -i dest/jpgs_png.mp4`
    ```
    Metadata:    
        major_brand     : isom    
        minor_version   : 512    
        compatible_brands: isomiso2avc1mp41    
        encoder         : Lavf57.82.101  
    Duration: 00:00:13.28, start: 0.000000, bitrate: 199 kb/s    
    Stream #0:0(und): 
        Video: h264 (High) (avc1 / 0x31637661), yuvj420p(pc), 1150x650 [SAR 1:1 DAR 23:13], 179 kb/s, 25 fps, 25 tbr, 12800 tbn, 50 tbc (default)    
    Metadata:      
        handler_name    : VideoHandler   
    Stream #0:1(und): 
        Audio: aac (LC) (mp4a / 0x6134706D), 44100 Hz, mono, fltp, 69 kb/s (default)    
    Metadata:      
        handler_name    : SoundHandler
    ```

- `ffprobe -i dest/jpgs_mp3.mp4`
    ```
    Metadata:
        major_brand     : isom
        minor_version   : 512
        compatible_brands: isomiso2avc1mp41
        encoder         : Lavf57.82.101
    Duration: 00:00:13.28, start: 0.000000, bitrate: 199 kb/s
    Stream #0:0(und): Video: h264 (High) (avc1 / 0x31637661), yuvj420p(pc), 1150x650 [SAR 1:1 DAR 23:13], 179 kb/s, 25 fps, 25 tbr, 12800 tbn, 50 tbc (default)
    Metadata:
        handler_name    : VideoHandler
    Stream #0:1(und): Audio: aac (LC) (mp4a / 0x6134706D), 44100 Hz, mono, fltp, 69 kb/s (default)    Metadata:
        handler_name    : SoundHandler
    ```

- `ffmpeg -i img/loop/%d.png -r 24 -i audio/bgm-min.mp3 -y dest/pngs_r24.mp4`
    ```
    imgs(25)+ audio(3s)= video(3s)
    ```

- `ffmpeg -framerate 6 -i img/loop/%d.png -i audio/bgm-min.mp3 -y dest/pngs_framerate6.mp4`
    ```
    imgs(25)+ audio(3s)= video(4s, 6 frame/second)
    ```


# Video+ Audio= Video
- `ffmpeg -i video/bike.mp4 -i audio/bgm-min.mp3 -vcodec copy -acodec copy 0 -map 0.0:0 -map 1.0:1 dest/video_audio.mp4`
    ```
    video(5s)+ audio(3s)= video(5s)
    ```
- `ffmpeg -ss 0 -t 3 -i video/bike.mp4 -i audio/bgm-min.mp3 -y dest/video_audio.mp4`
    ```
    video[0:3]+ audio(3s)= video(3s)
    ```

