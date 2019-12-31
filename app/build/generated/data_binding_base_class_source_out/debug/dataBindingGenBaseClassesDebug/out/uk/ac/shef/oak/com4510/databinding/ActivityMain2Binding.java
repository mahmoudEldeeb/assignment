// Generated by data binding compiler. Do not edit!
package uk.ac.shef.oak.com4510.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.Deprecated;
import java.lang.Object;
import uk.ac.shef.oak.com4510.R;
import uk.ac.shef.oak.com4510.view_model.InsertVisitsViewModel;

public abstract class ActivityMain2Binding extends ViewDataBinding {
  @NonNull
  public final Button buttonEnd;

  @NonNull
  public final FloatingActionButton fab;

  @Bindable
  protected InsertVisitsViewModel mViewModel;

  protected ActivityMain2Binding(Object _bindingComponent, View _root, int _localFieldCount,
      Button buttonEnd, FloatingActionButton fab) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonEnd = buttonEnd;
    this.fab = fab;
  }

  public abstract void setViewModel(@Nullable InsertVisitsViewModel viewModel);

  @Nullable
  public InsertVisitsViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main2, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityMain2Binding>inflateInternal(inflater, R.layout.activity_main2, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_main2, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityMain2Binding>inflateInternal(inflater, R.layout.activity_main2, null, false, component);
  }

  public static ActivityMain2Binding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ActivityMain2Binding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityMain2Binding)bind(component, view, R.layout.activity_main2);
  }
}
