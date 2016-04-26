package main.java;

import java.net.URL;

public class Stream {
	
	private String streamerName;
	private URL url;
	private String quality;
	private String bandwidth;
	private String resolution;
	
	public Stream(String streamerName, URL streamURL, 
			String streamQuality, String streamBandwidth, String resolution) {
		this.streamerName = streamerName;
		this.url = streamURL;
		this.quality = streamQuality;
		this.bandwidth = streamBandwidth;
		this.resolution = resolution;
	}
	
	public String getStreamerName() {
		return streamerName;
	}
	public URL getStreamURL() {
		return url;
	}
	public String getStreamQuality() {
		return quality;
	}
	public String getStreamBandwidth() {
		return bandwidth;
	}
	
	public String getStreamResolution() {
		return resolution;
	}
	
}
