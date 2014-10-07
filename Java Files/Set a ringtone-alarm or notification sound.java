
//Set the ringtone / notification sound
ContentValues values = new ContentValues();

values.put(MediaStore.MediaColumns.DATA, download_mp3_link);
values.put(MediaStore.MediaColumns.TITLE, song_name);
values.put(MediaStore.MediaColumns.MIME_TYPE, "audio/mp3");
values.put(MediaStore.Audio.Media.ARTIST, song_name);
values.put(MediaStore.Audio.Media.IS_RINGTONE, true);
values.put(MediaStore.Audio.Media.IS_NOTIFICATION, true);
values.put(MediaStore.Audio.Media.IS_ALARM, true);
values.put(MediaStore.Audio.Media.IS_MUSIC, true);

Uri uri = MediaStore.Audio.Media.getContentUriForPath(download_mp3_link);

Uri newUri = getContentResolver().insert(uri, values);

try {
	RingtoneManager.setActualDefaultRingtoneUri(context, 	RingtoneManager.TYPE_ALARM, newUri);
	Toast.makeText(context, "Ringtone has been set", Toast.LENGTH_LONG).show();
} catch (Throwable t) {
	Toast.makeText(context, "ERROR!", Toast.LENGTH_LONG).show();
}