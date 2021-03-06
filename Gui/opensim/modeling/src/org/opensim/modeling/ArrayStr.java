/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.opensim.modeling;

public class ArrayStr {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  public ArrayStr(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  public static long getCPtr(ArrayStr obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        opensimCommonJNI.delete_ArrayStr(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

   public java.util.Vector<String> toVector() {
       java.util.Vector<String> vector = new java.util.Vector<String>();
       vector.setSize(getSize());
       for(int i=0; i<getSize(); i++) vector.set(i, getitem(i));
       return vector;
   }
   public void append(java.util.Vector<String> vector) {
       for(int i=0; i<vector.size(); i++) append(vector.get(i));
   }
   public static ArrayStr fromVector(java.util.Vector<String> vector) {
       ArrayStr array = new ArrayStr();
       array.append(vector);
       return array;
   }

  public ArrayStr(String aDefaultValue, int aSize, int aCapacity) {
    this(opensimCommonJNI.new_ArrayStr__SWIG_0(aDefaultValue, aSize, aCapacity), true);
  }

  public ArrayStr(String aDefaultValue, int aSize) {
    this(opensimCommonJNI.new_ArrayStr__SWIG_1(aDefaultValue, aSize), true);
  }

  public ArrayStr(String aDefaultValue) {
    this(opensimCommonJNI.new_ArrayStr__SWIG_2(aDefaultValue), true);
  }

  public ArrayStr() {
    this(opensimCommonJNI.new_ArrayStr__SWIG_3(), true);
  }

  public ArrayStr(ArrayStr aArray) {
    this(opensimCommonJNI.new_ArrayStr__SWIG_4(ArrayStr.getCPtr(aArray), aArray), true);
  }

  public boolean arrayEquals(ArrayStr aArray) {
    return opensimCommonJNI.ArrayStr_arrayEquals(swigCPtr, this, ArrayStr.getCPtr(aArray), aArray);
  }

  public void trim() {
    opensimCommonJNI.ArrayStr_trim(swigCPtr, this);
  }

  public boolean setSize(int aSize) {
    return opensimCommonJNI.ArrayStr_setSize(swigCPtr, this, aSize);
  }

  public int getSize() {
    return opensimCommonJNI.ArrayStr_getSize(swigCPtr, this);
  }

  public int size() {
    return opensimCommonJNI.ArrayStr_size(swigCPtr, this);
  }

  public int append(String aValue) {
    return opensimCommonJNI.ArrayStr_append__SWIG_0(swigCPtr, this, aValue);
  }

  public int append(ArrayStr aArray) {
    return opensimCommonJNI.ArrayStr_append__SWIG_1(swigCPtr, this, ArrayStr.getCPtr(aArray), aArray);
  }

  public int insert(int aIndex, String aValue) {
    return opensimCommonJNI.ArrayStr_insert(swigCPtr, this, aIndex, aValue);
  }

  public int remove(int aIndex) {
    return opensimCommonJNI.ArrayStr_remove(swigCPtr, this, aIndex);
  }

  public void set(int aIndex, String aValue) {
    opensimCommonJNI.ArrayStr_set(swigCPtr, this, aIndex, aValue);
  }

  public String get(int aIndex) {
    return opensimCommonJNI.ArrayStr_get(swigCPtr, this, aIndex);
  }

  public String getitem(int index) {
    return opensimCommonJNI.ArrayStr_getitem(swigCPtr, this, index);
  }

  public void setitem(int index, String val) {
    opensimCommonJNI.ArrayStr_setitem(swigCPtr, this, index, val);
  }

  public String getLast() {
    return opensimCommonJNI.ArrayStr_getLast(swigCPtr, this);
  }

  public int findIndex(String aValue) {
    return opensimCommonJNI.ArrayStr_findIndex(swigCPtr, this, aValue);
  }

  public int rfindIndex(String aValue) {
    return opensimCommonJNI.ArrayStr_rfindIndex(swigCPtr, this, aValue);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo, int aHi) {
    return opensimCommonJNI.ArrayStr_searchBinary__SWIG_0(swigCPtr, this, aValue, aFindFirst, aLo, aHi);
  }

  public int searchBinary(String aValue, boolean aFindFirst, int aLo) {
    return opensimCommonJNI.ArrayStr_searchBinary__SWIG_1(swigCPtr, this, aValue, aFindFirst, aLo);
  }

  public int searchBinary(String aValue, boolean aFindFirst) {
    return opensimCommonJNI.ArrayStr_searchBinary__SWIG_2(swigCPtr, this, aValue, aFindFirst);
  }

  public int searchBinary(String aValue) {
    return opensimCommonJNI.ArrayStr_searchBinary__SWIG_3(swigCPtr, this, aValue);
  }

}
