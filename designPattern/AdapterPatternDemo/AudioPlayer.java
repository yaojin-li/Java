﻿package AdapterPatternDemo;

//创建实现了 MediaPlayer 接口的实体类。
public class AudioPlayer implements MediaPlayer{
	
	MediaAdapter MediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		//播放MP3音乐文件的内置支持
		if (audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file Name: " + fileName);
		}
		
		//mediaAdapter 提供了播放其他文件格式的支持
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			MediaAdapter = new MediaAdapter(audioType);
			MediaAdapter.play(audioType, fileName);
		}else {
			System.out.println("Invalid media " + audioType + " format not supported");
		}
	}

}
