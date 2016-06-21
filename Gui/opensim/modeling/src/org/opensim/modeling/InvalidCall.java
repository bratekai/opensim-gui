/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class InvalidCall extends OpenSimException {
  private transient long swigCPtr;

  public InvalidCall(long cPtr, boolean cMemoryOwn) {
    super(opensimModelCommonJNI.InvalidCall_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(InvalidCall obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelCommonJNI.delete_InvalidCall(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public InvalidCall(String file, long line, String func, String msg) {
    this(opensimModelCommonJNI.new_InvalidCall__SWIG_0(file, line, func, msg), true);
  }

  public InvalidCall(String file, long line, String func) {
    this(opensimModelCommonJNI.new_InvalidCall__SWIG_1(file, line, func), true);
  }

}