//Use animations
Animation slide_left = AnimationUtils.loadAnimation(this, R.anim.wave_scale);
Animation slide_right = AnimationUtils.loadAnimation(this, R.anim.wave_scale);
textView_splash_title.startAnimation(slide_left);
textView_splash_subtitle.startAnimation(slide_right);