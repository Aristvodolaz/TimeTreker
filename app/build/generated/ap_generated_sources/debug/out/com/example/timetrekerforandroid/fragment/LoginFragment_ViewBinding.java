// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding implements Unbinder {
  private LoginFragment target;

  @UiThread
  public LoginFragment_ViewBinding(LoginFragment target, View source) {
    this.target = target;

    target.login = Utils.findRequiredViewAsType(source, R.id.login, "field 'login'", EditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", EditText.class);
    target.btn = Utils.findRequiredViewAsType(source, R.id.start, "field 'btn'", Button.class);
    target.warning = Utils.findRequiredViewAsType(source, R.id.warning, "field 'warning'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.login = null;
    target.password = null;
    target.btn = null;
    target.warning = null;
  }
}
