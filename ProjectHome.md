![https://lh6.googleusercontent.com/-L46HoQc1Gqs/UWK4OYDCgXI/AAAAAAAAxUs/jAb8VWiMtKU/s1024/NotifyFeatureGraphic_1024_500.jpg](https://lh6.googleusercontent.com/-L46HoQc1Gqs/UWK4OYDCgXI/AAAAAAAAxUs/jAb8VWiMtKU/s1024/NotifyFeatureGraphic_1024_500.jpg)

### **This project shows you how to use the [Notify](http://code.google.com/p/droid-notify/) API. Below is a simple code example:** ###

```


//API constants.
private static final String NOTIFY_API_NOTIFICATION_ACTION = "apps.droidnotify.api.NOTIFICATION_RECEIVED";
private static final String NOTIFY_API_PACKAGE = "package";
private static final String NOTIFY_API_TIMESTAMP = "timeStamp";
private static final String NOTIFY_API_DISPLAY_TEXT = "displayText";
private static final String NOTIFY_API_DISMISS_PENDINGINTENT = "dismissPendingIntent";
private static final String NOTIFY_API_DELETE_PENDINGINTENT = "deletePendingIntent";
private static final String NOTIFY_API_VIEW_PENDINGINTENT = "viewPendingIntent";
private static final String NOTIFY_API_CONTACT_ID  = "contactID";
private static final String NOTIFY_API_CONTACT_NAME  = "contactName";
private static final String NOTIFY_API_SENT_FROM_ADDRESS = "sentFromAddress";
private static final String NOTIFY_API_BIG_CONTENT_VIEW = "bigContentView";
private static final String NOTIFY_API_CONTENT_VIEW = "contentView";
private static final String NOTIFY_API_ENABLE_STATUS_BAR_NOTIFICATION = "enableStatusBarNotification";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATION_SOUND_URI = "statusBarNotificationSoundURI";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_ALWAYS_VALUE = "0";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_NEVER_VALUE = "1";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_WHEN_VIBRATE_MODE_VALUE = "2";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_SETTING = "statusBarNotificationVibrateSetting";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_PATTERN = "statusBarNotificationVibratePattern";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_SOUND_ENABLED = "statusBarNotificationInCallSoundEnabled";
private static final String NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_VIBRATE_ENABLED = "statusBarNotificationInCallVibrateEnabled";

//Create the intent that will be broadcast to the phone.
Intent broadcastNotificationIntent = new Intent();
broadcastNotificationIntent.setAction(NOTIFY_API_NOTIFICATION_ACTION);
broadcastNotificationIntent.putExtra(NOTIFY_API_TIMESTAMP, System.currentTimeMillis());
broadcastNotificationIntent.putExtra(NOTIFY_API_PACKAGE, "com.android.email");
broadcastNotificationIntent.putExtra(NOTIFY_API_DISPLAY_TEXT, "Haven't you seen my movies? THIS IS HOW I TALK!");

//Optional parameter.
broadcastNotificationIntent.putExtra(NOTIFY_API_CONTACT_NAME, "Samuel L. Jackson");

//Optional status bar notification parameters.
//Status Bar Notification parameters.
broadcastNotificationIntent.putExtra(NOTIFY_API_ENABLE_STATUS_BAR_NOTIFICATION, true); //Values can be "true" or "false".
broadcastNotificationIntent.putExtra(NOTIFY_API_STATUS_BAR_NOTIFICATION_SOUND_URI, "content://settings/system/notification_sound"); //String value of a sound URI.
broadcastNotificationIntent.putExtra(NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_SETTING, NOTIFY_API_STATUS_BAR_NOTIFICATIONS_VIBRATE_ALWAYS_VALUE); //Values can be "0" (Always), "1" (Never) or "2" (Only when in vibrate mode).
broadcastNotificationIntent.putExtra(NOTIFY_API_STATUS_BAR_NOTIFICATION_VIBRATE_PATTERN, "0,1200");
broadcastNotificationIntent.putExtra(NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_SOUND_ENABLED, false); //Values can be "true" or "false".
broadcastNotificationIntent.putExtra(NOTIFY_API_STATUS_BAR_NOTIFICATION_IN_CALL_VIBRATE_ENABLED, true); //Values can be "true" or "false".

//Optional parameter.
//Create a PendingIntent that is run when the "View" button is clicked.
PendingIntent nullPendingIntent = PendingIntent.getBroadcast(context, 0, new Intent(), 0);
broadcastNotificationIntent.putExtra(NOTIFY_API_VIEW_PENDINGINTENT, nullPendingIntent);

//Send the broadcast to the Notify application.
context.sendBroadcast(broadcastNotificationIntent);

```

### **This is the result of the code above:** ###

![https://lh4.googleusercontent.com/-asydJEimaM0/UWLdYm4vkNI/AAAAAAAAxWI/K6TWa4lL4Pk/s512/apiExample.png](https://lh4.googleusercontent.com/-asydJEimaM0/UWLdYm4vkNI/AAAAAAAAxWI/K6TWa4lL4Pk/s512/apiExample.png)