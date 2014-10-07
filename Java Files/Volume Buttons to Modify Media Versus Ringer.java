//This will alllow the activty to change the volume buttons to increase the media volume (IE game and music sounds) instead of the ringer.
mContext = MainActivity.this;
mContext.setVolumeControlStream(AudioManager.STREAM_MUSIC);
