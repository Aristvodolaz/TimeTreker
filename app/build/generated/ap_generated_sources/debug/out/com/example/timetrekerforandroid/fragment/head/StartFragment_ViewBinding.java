// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.fragment.head;

import android.view.View;
import android.widget.Button;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StartFragment_ViewBinding implements Unbinder {
  private StartFragment target;

  @UiThread
  public StartFragment_ViewBinding(StartFragment target, View source) {
    this.target = target;

    target.vhod = Utils.findRequiredViewAsType(source, R.id.vhod, "field 'vhod'", Button.class);
    target.vyhod = Utils.findRequiredViewAsType(source, R.id.vyhod, "field 'vyhod'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StartFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.vhod = null;
    target.vyhod = null;
  }
}
