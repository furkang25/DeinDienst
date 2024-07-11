// Generated by view binder compiler. Do not edit!
package de.tecrox.deindienst.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.tecrox.deindienst.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final ImageButton button1;

  @NonNull
  public final ImageButton button2;

  @NonNull
  public final ImageButton button3;

  @NonNull
  public final ImageButton button4;

  @NonNull
  public final ImageButton buttonAdvice;

  @NonNull
  public final ConstraintLayout homeFragment;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final ImageButton imageButton2;

  @NonNull
  public final ImageButton imageButton4;

  @NonNull
  public final ImageButton imageButton5;

  @NonNull
  public final TextView textView2;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView, @NonNull Button button,
      @NonNull ImageButton button1, @NonNull ImageButton button2, @NonNull ImageButton button3,
      @NonNull ImageButton button4, @NonNull ImageButton buttonAdvice,
      @NonNull ConstraintLayout homeFragment, @NonNull ImageButton imageButton,
      @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton4,
      @NonNull ImageButton imageButton5, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.button = button;
    this.button1 = button1;
    this.button2 = button2;
    this.button3 = button3;
    this.button4 = button4;
    this.buttonAdvice = buttonAdvice;
    this.homeFragment = homeFragment;
    this.imageButton = imageButton;
    this.imageButton2 = imageButton2;
    this.imageButton4 = imageButton4;
    this.imageButton5 = imageButton5;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.button1;
      ImageButton button1 = ViewBindings.findChildViewById(rootView, id);
      if (button1 == null) {
        break missingId;
      }

      id = R.id.button2;
      ImageButton button2 = ViewBindings.findChildViewById(rootView, id);
      if (button2 == null) {
        break missingId;
      }

      id = R.id.button3;
      ImageButton button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.button4;
      ImageButton button4 = ViewBindings.findChildViewById(rootView, id);
      if (button4 == null) {
        break missingId;
      }

      id = R.id.buttonAdvice;
      ImageButton buttonAdvice = ViewBindings.findChildViewById(rootView, id);
      if (buttonAdvice == null) {
        break missingId;
      }

      ConstraintLayout homeFragment = (ConstraintLayout) rootView;

      id = R.id.imageButton;
      ImageButton imageButton = ViewBindings.findChildViewById(rootView, id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.imageButton2;
      ImageButton imageButton2 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton2 == null) {
        break missingId;
      }

      id = R.id.imageButton4;
      ImageButton imageButton4 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton4 == null) {
        break missingId;
      }

      id = R.id.imageButton5;
      ImageButton imageButton5 = ViewBindings.findChildViewById(rootView, id);
      if (imageButton5 == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, button, button1, button2, button3,
          button4, buttonAdvice, homeFragment, imageButton, imageButton2, imageButton4,
          imageButton5, textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
