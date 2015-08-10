/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ModelVisualPreferences extends OpenSimObject {
  private long swigCPtr;

  public ModelVisualPreferences(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.ModelVisualPreferences_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(ModelVisualPreferences obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_ModelVisualPreferences(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static ModelVisualPreferences safeDownCast(OpenSimObject obj) {
    long cPtr = opensimModelJNI.ModelVisualPreferences_safeDownCast(OpenSimObject.getCPtr(obj), obj);
    return (cPtr == 0) ? null : new ModelVisualPreferences(cPtr, false);
  }

  public void assign(OpenSimObject aObject) {
    opensimModelJNI.ModelVisualPreferences_assign(swigCPtr, this, OpenSimObject.getCPtr(aObject), aObject);
  }

  public static String getClassName() {
    return opensimModelJNI.ModelVisualPreferences_getClassName();
  }

  public OpenSimObject clone() {
    long cPtr = opensimModelJNI.ModelVisualPreferences_clone(swigCPtr, this);
    return (cPtr == 0) ? null : new ModelVisualPreferences(cPtr, true);
  }

  public String getConcreteClassName() {
    return opensimModelJNI.ModelVisualPreferences_getConcreteClassName(swigCPtr, this);
  }

  public void copyProperty_ModelDisplayHints(ModelVisualPreferences source) {
    opensimModelJNI.ModelVisualPreferences_copyProperty_ModelDisplayHints(swigCPtr, this, ModelVisualPreferences.getCPtr(source), source);
  }

  public ModelDisplayHints get_ModelDisplayHints(int i) {
    return new ModelDisplayHints(opensimModelJNI.ModelVisualPreferences_get_ModelDisplayHints__SWIG_0(swigCPtr, this, i), false);
  }

  public ModelDisplayHints upd_ModelDisplayHints(int i) {
    return new ModelDisplayHints(opensimModelJNI.ModelVisualPreferences_upd_ModelDisplayHints__SWIG_0(swigCPtr, this, i), false);
  }

  public void set_ModelDisplayHints(int i, ModelDisplayHints value) {
    opensimModelJNI.ModelVisualPreferences_set_ModelDisplayHints__SWIG_0(swigCPtr, this, i, ModelDisplayHints.getCPtr(value), value);
  }

  public int append_ModelDisplayHints(ModelDisplayHints value) {
    return opensimModelJNI.ModelVisualPreferences_append_ModelDisplayHints(swigCPtr, this, ModelDisplayHints.getCPtr(value), value);
  }

  public void constructProperty_ModelDisplayHints(ModelDisplayHints initValue) {
    opensimModelJNI.ModelVisualPreferences_constructProperty_ModelDisplayHints(swigCPtr, this, ModelDisplayHints.getCPtr(initValue), initValue);
  }

  public ModelDisplayHints get_ModelDisplayHints() {
    return new ModelDisplayHints(opensimModelJNI.ModelVisualPreferences_get_ModelDisplayHints__SWIG_1(swigCPtr, this), false);
  }

  public ModelDisplayHints upd_ModelDisplayHints() {
    return new ModelDisplayHints(opensimModelJNI.ModelVisualPreferences_upd_ModelDisplayHints__SWIG_1(swigCPtr, this), false);
  }

  public void set_ModelDisplayHints(ModelDisplayHints value) {
    opensimModelJNI.ModelVisualPreferences_set_ModelDisplayHints__SWIG_1(swigCPtr, this, ModelDisplayHints.getCPtr(value), value);
  }

  public ModelVisualPreferences() {
    this(opensimModelJNI.new_ModelVisualPreferences(), true);
  }

}