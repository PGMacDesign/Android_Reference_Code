
//These 2 are to be used in separate section, IE on create or on a button call
mTimer = new MyTimmer(200, 200);
mTimer.start();

	//This is the class for the timer itself
	public class MyTimmer extends CountDownTimer {
	
		public MyTimmer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		public void onFinish() {
			launchApp();
		}

		public void onTick(long millisUntilFinished) {
		}
	}