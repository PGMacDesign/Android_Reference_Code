/*******************************************************************
* SETS THE ENTIRE FONT FOR THE ACTIVITY!
*
* mContext = AddSpellActivity.this;
*
* Typeface tf1 = Typeface.createFromAsset(mContext.getAssets(),
* "fonts/KaushanScript-Regular.otf"); final ViewGroup mContainer =
* (ViewGroup) findViewById(android.R.id.content).getRootView();
* setAppFont(mContainer, tf2);
*
*
* @param mContainer
* @param mFont
*/
public static final void setAppFont(ViewGroup mContainer, Typeface mFont) {
	if (mContainer == null || mFont == null)
	return;
	
	final int mCount = mContainer.getChildCount();
	
	// Loop through all of the children.
	for (int i = 0; i < mCount; ++i) {
		final View mChild = mContainer.getChildAt(i);
		if (mChild instanceof TextView) {
			// Set the font if it is a TextView.
			((TextView) mChild).setTypeface(mFont);
		} else if (mChild instanceof ViewGroup) {
			// Recursively attempt another ViewGroup.
			setAppFont((ViewGroup) mChild, mFont);
		}
	}
}