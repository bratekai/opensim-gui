/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class InvalidTable extends OpenSimException {
  private transient long swigCPtr;

  public InvalidTable(long cPtr, boolean cMemoryOwn) {
    super(opensimModelJNI.InvalidTable_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  public static long getCPtr(InvalidTable obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimModelJNI.delete_InvalidTable(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public InvalidTable() {
    this(opensimModelJNI.new_InvalidTable(), true);
  }

}