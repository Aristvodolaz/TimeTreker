// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.activity;

import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CameraActivity_ViewBinding implements Unbinder {
  private CameraActivity target;

  @UiThread
  public CameraActivity_ViewBinding(CameraActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CameraActivity_ViewBinding(CameraActivity target, View source) {
    this.target = target;

    target.cameraView = Utils.findRequiredViewAsType(source, R.id.camera_preview, "field 'cameraView'", SurfaceView.class);
    target.emptyView = Utils.findRequiredViewAsType(source, R.id.empty_view, "field 'emptyView'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CameraActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cameraView = null;
    target.emptyView = null;
  }
}
