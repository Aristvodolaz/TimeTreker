// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.fragment.user;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class InfoFragment_ViewBinding implements Unbinder {
  private InfoFragment target;

  @UiThread
  public InfoFragment_ViewBinding(InfoFragment target, View source) {
    this.target = target;

    target.rvInfo = Utils.findRequiredViewAsType(source, R.id.rv_info, "field 'rvInfo'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvInfo = null;
  }
}
