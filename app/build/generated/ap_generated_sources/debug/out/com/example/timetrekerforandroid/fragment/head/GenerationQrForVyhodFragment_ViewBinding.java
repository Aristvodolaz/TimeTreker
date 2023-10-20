// Generated code from Butter Knife. Do not modify!
package com.example.timetrekerforandroid.fragment.head;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.timetrekerforandroid.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GenerationQrForVyhodFragment_ViewBinding implements Unbinder {
  private GenerationQrForVyhodFragment target;

  @UiThread
  public GenerationQrForVyhodFragment_ViewBinding(GenerationQrForVyhodFragment target,
      View source) {
    this.target = target;

    target.qrCode = Utils.findRequiredViewAsType(source, R.id.qrcode, "field 'qrCode'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GenerationQrForVyhodFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.qrCode = null;
  }
}
