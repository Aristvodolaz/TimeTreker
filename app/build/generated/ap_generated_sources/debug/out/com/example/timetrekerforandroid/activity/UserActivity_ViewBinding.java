// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.activity;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserActivity_ViewBinding implements Unbinder {
  private UserActivity target;

  @UiThread
  public UserActivity_ViewBinding(UserActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserActivity_ViewBinding(UserActivity target, View source) {
    this.target = target;

    target.timeBtn = Utils.findRequiredViewAsType(source, R.id.time_btn, "field 'timeBtn'", LinearLayout.class);
    target.qrcodeBtn = Utils.findRequiredViewAsType(source, R.id.qrcode_btn, "field 'qrcodeBtn'", LinearLayout.class);
    target.personBtn = Utils.findRequiredViewAsType(source, R.id.person_btn, "field 'personBtn'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.timeBtn = null;
    target.qrcodeBtn = null;
    target.personBtn = null;
  }
}
