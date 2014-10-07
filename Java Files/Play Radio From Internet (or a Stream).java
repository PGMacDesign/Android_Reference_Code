//Music from the internet (IE Pandora)
	MediaPlayer mPlayer = new MediaPlayer();
	int length;
	
	public void Music_Stuff (){ 
		mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		String url = "pandora or whatnot";
		
		try {
			mPlayer.setDataSource(ACTIVITYNAME.this, Uri.parse(url));
			mPlayer.prepare();
			mPlayer.start();
		} catch (IOException e) {
			//Log.e(TAG, "Could not open file for playback.");
			Toast.makeText(ACTIVITYNAME.this, "error connecting. try with a wi-fi connection...",
			Toast.LENGTH_LONG).show();
		}
		
		mPlayer.setOnErrorListener(this);
		mPlayer.setOnErrorListener(new OnErrorListener() { 
			public boolean onError(MediaPlayer mp, int what, int extra) {
				onError(mPlayer, what, extra);
				return true;
			}
		});
	}
	
	public void pauseMusic() {
		if (mPlayer.isPlaying()) {
			mPlayer.pause();
			int length = mPlayer.getCurrentPosition();
		}
	}
	
	public void resumeMusic() {
		if (mPlayer.isPlaying() == false) {
			mPlayer.seekTo(length);
			mPlayer.start();
		}
	}
	
	public void stopMusic() {
		mPlayer.stop();
		mPlayer.release();
		mPlayer = null;
	}
	
	public void onDestroy() {
		super.onDestroy();
		mNotificationManager.cancel(1773);
		if (mPlayer != null) {
			try {
				mPlayer.stop();
				mPlayer.release();
			} finally {
				mPlayer = null;
			}
		}
	}
	
	public boolean onError(MediaPlayer mp, int what, int extra) {
		Toast.makeText(this, "error on loading", Toast.LENGTH_SHORT).show();
		if (mPlayer != null) {
			try {
				mPlayer.stop();
				mPlayer.release();
			} finally {
				mPlayer = null;
			}
		}
		
		return false;
	}