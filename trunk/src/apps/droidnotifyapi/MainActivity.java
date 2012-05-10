package apps.droidnotifyapi;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import apps.droidnotifyapi.R;

/**
 * This is the applications preference Activity.
 * 
 * @author Camille Sévigny
 */
public class MainActivity extends Activity {
	
	//================================================================================
    // Constants
    //================================================================================
	
	private static final String DROID_NOTIFY_API_NOTIFICATION_ACTION = "apps.droidnotify.api.NOTIFICATION_RECEIVED";
	private static final String DROID_NOTIFY_API_PACKAGE = "package";
	private static final String DROID_NOTIFY_API_TIMESTAMP = "timeStamp";
	private static final String DROID_NOTIFY_API_DISPLAY_TEXT = "displayText";
	private static final String DROID_NOTIFY_API_DISMISS_PENDINGINTENT = "dismissPendingIntent";
	private static final String DROID_NOTIFY_API_DELETE_PENDINGINTENT = "deletePendingIntent";
	private static final String DROID_NOTIFY_API_VIEW_PENDINGINTENT = "viewPendingIntent";  
	private static final String DROID_NOTIFY_API_CONTACT_ID  = "contactID";
	private static final String DROID_NOTIFY_API_CONTACT_NAME  = "contactName";
	private static final String DROID_NOTIFY_API_SENT_FROM_ADDRESS = "sentFromAddress";	
	private static final String DROID_NOTIFY_API_ENABLE_STATUS_BAR_NOTIFICATION = "enableStatusBarNotification";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_SOUND_URI = "statusBarNotificationSoundURI";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_ALWAYS_VALUE = "0";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_NEVER_VALUE = "1";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_WHEN_VIBRATE_MODE_VALUE = "2";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_SETTING = "statusBarNotificationVibrateSetting";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_PATTERN = "statusBarNotificationVibratePattern";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_SOUND_ENABLED = "statusBarNotificationInCallSoundEnabled";
	private static final String DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_VIBRATE_ENABLED = "statusBarNotificationInCallVibrateEnabled";
	
	//================================================================================
    // Properties
    //================================================================================

	private Context _context = null;
	private TextView _apiExampleTextView = null;
	
	//================================================================================
	// Protected Methods
	//================================================================================
	
	/**
	 * Called when the activity is created. Set up views and buttons.
	 * 
	 * @param bundle - Activity bundle.
	 */
	@Override
	protected void onCreate(Bundle bundle){
		super.onCreate(bundle);
	    _context = this;
	    this.setContentView(R.layout.main_activity);
	    initLayoutItems();
	}

	//================================================================================
	// Private Methods
	//================================================================================

	/**
	 * Initialize the layout items.
	 */
	private void initLayoutItems(){
		_apiExampleTextView = (TextView)findViewById(R.id.apiButton);
		_apiExampleTextView.setBackgroundResource(R.drawable.preference_row_click);
		_apiExampleTextView.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		//Create the intent that will be broadcast to the phone.
        		Intent broadcastNotificationIntent = new Intent();
        		broadcastNotificationIntent.setAction(DROID_NOTIFY_API_NOTIFICATION_ACTION);
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_TIMESTAMP, System.currentTimeMillis());
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_PACKAGE, "com.android.email");
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_DISPLAY_TEXT, "Haven't you seen my movies? THIS IS HOW I TALK!");
        		 
        		//Optional parameter.
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_CONTACT_NAME, "Samuel L. Jackson");
        		
        		//Optional status bar notification parameters.
        		//Status Bar Notification parameters.
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_ENABLE_STATUS_BAR_NOTIFICATION, true); //Values can be "true" or "false".
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_SOUND_URI, "content://settings/system/notification_sound"); //String value of a sound URI.
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_SETTING, DROID_NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_ALWAYS_VALUE); //Values can be "0" (Always), "1" (Never) or "2" (Only when in vibrate mode).
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_PATTERN, "0,1200");
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_SOUND_ENABLED, false); //Values can be "true" or "false".
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_VIBRATE_ENABLED, true); //Values can be "true" or "false".
        		
        		//Optional parameter.
        		//Create a PendingIntent that is run when the "View" button is clicked.
        		PendingIntent nullPendingIntent = PendingIntent.getBroadcast(_context, 0, new Intent(), 0);
        		broadcastNotificationIntent.putExtra(DROID_NOTIFY_API_VIEW_PENDINGINTENT, nullPendingIntent);
        		 
        		//Send the broadcast to the Droid Notify application.
        		_context.sendBroadcast(broadcastNotificationIntent);
        		 
        		//Send a 30 second delayed broadcast to the Droid Notify application.        		
        		//PendingIntent delayedPendingIntent = PendingIntent.getBroadcast(_context, 0, broadcastNotificationIntent, 0);        		
        		//AlarmManager alarmManager = (AlarmManager)_context.getSystemService(Context.ALARM_SERVICE);
        		//alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 30 * 1000, delayedPendingIntent);	
        	}
		});		
	}
	
}
