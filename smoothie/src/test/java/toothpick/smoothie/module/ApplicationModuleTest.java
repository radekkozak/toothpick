package toothpick.smoothie.module;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Application;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import toothpick.Scope;
import toothpick.ToothPick;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class ApplicationModuleTest {

  @Test
  public void testModule_shouldReturnApplicationBindings() throws Exception {
    //GIVEN
    Activity activity = Robolectric.buildActivity(Activity.class).create().get();
    Application application = RuntimeEnvironment.application;
    Scope appScope = ToothPick.openScope(application);
    appScope.installModules(new ApplicationModule(application));

    //WHEN
    Application injectedApp = appScope.getInstance(Application.class);
    AccountManager accountManager = appScope.getInstance(AccountManager.class);
    AssetManager assetManager = appScope.getInstance(AssetManager.class);
    ContentResolver contentResolver = appScope.getInstance(ContentResolver.class);
    Handler handler = appScope.getInstance(Handler.class);
    Resources resources = appScope.getInstance(Resources.class);
    SharedPreferences sharedPreferences = appScope.getInstance(SharedPreferences.class);

    //THEN
    assertThat(injectedApp, is(RuntimeEnvironment.application));
    assertThat(accountManager, notNullValue());
    assertThat(assetManager, notNullValue());
    assertThat(contentResolver, notNullValue());
    assertThat(handler, notNullValue());
    assertThat(resources, notNullValue());
    assertThat(sharedPreferences, notNullValue());
  }

  @Test
  public void testModule_shouldReturnSystemServices() throws Exception {
    //GIVEN
    Activity activity = Robolectric.buildActivity(Activity.class).create().get();
    Application application = RuntimeEnvironment.application;
    Scope appScope = ToothPick.openScope(application);
    appScope.installModules(new ApplicationModule(application));

    //WHEN
    Application injectedApp = appScope.getInstance(Application.class);
    LocationManager locationManager = appScope.getInstance(LocationManager.class);
    WindowManager windowManager = appScope.getInstance(WindowManager.class);
    ActivityManager activityManager = appScope.getInstance(ActivityManager.class);
    PowerManager powerManager = appScope.getInstance(PowerManager.class);
    AlarmManager alarmManager = appScope.getInstance(AlarmManager.class);
    NotificationManager notificationManager = appScope.getInstance(NotificationManager.class);
    KeyguardManager keyguardManager = appScope.getInstance(KeyguardManager.class);
    Vibrator vibrator = appScope.getInstance(Vibrator.class);
    ConnectivityManager connectivityManager = appScope.getInstance(ConnectivityManager.class);
    //WifiManager wifiManager = appScope.getInstance(WifiManager.class);
    InputMethodManager inputMethodManager = appScope.getInstance(InputMethodManager.class);
    SensorManager sensorManager = appScope.getInstance(SensorManager.class);
    TelephonyManager telephonyManager = appScope.getInstance(TelephonyManager.class);
    AudioManager audioManager = appScope.getInstance(AudioManager.class);
    DownloadManager downloadManager = appScope.getInstance(DownloadManager.class);

    //THEN
    assertThat(injectedApp, is(RuntimeEnvironment.application));
    assertThat(locationManager, notNullValue());
    assertThat(windowManager, notNullValue());
    assertThat(activityManager, notNullValue());
    assertThat(powerManager, notNullValue());
    assertThat(alarmManager, notNullValue());
    assertThat(notificationManager, notNullValue());
    assertThat(keyguardManager, notNullValue());
    assertThat(vibrator, notNullValue());
    assertThat(connectivityManager, notNullValue());
    //assertThat(wifiManager, notNullValue());
    assertThat(inputMethodManager, notNullValue());
    assertThat(sensorManager, notNullValue());
    assertThat(telephonyManager, notNullValue());
    assertThat(audioManager, notNullValue());
    assertThat(downloadManager, notNullValue());
  }
}