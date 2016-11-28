package beans.property;

import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.io.Serializable;

public class BasicBean implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * The Quintessential Bean, phần tinh tế
  * This example bean has a single property called property. 
  * If the property were not a boolean, it would not have an isX() method. 
  * Also, if the property were read-only, it would not have a setX() method.
  * 
  * Một ví dụ thuộc tính đơn giản được gọi là property, nếu property ko phải là a boolean, nó ko có isX() method,
  * cũng thế, nếu thuộc tính chỉ đọc, nó ko có một method setX()
  * */
  private boolean property;
  
  public BasicBean() {
  }
  
  public boolean getProperty() {
    return property;
  }
  
  public boolean isProperty() {
    return property;
  }
  
  public void setProperty(boolean property) {
    this.property = property;
  }
  
  /**
   * A bound property fires a PropertyChangeEvent whenever its value is changed. 
   * This example bean implements a single bound integer property called myProperty.
   *  
   *  (biên giới) thuộc tính fires là PropertyChangeEvent, bất cứ khi nào giá trị của nó thay đổi.
   *  ví dụ bean implement thuộc tính  một (biên giới) số nguyên đc gọi là myProperty. 
   * */
  
  private int myProperty;
  
  public int getMyProperty() {
    return myProperty;
  }
  
  //  Create  the listener list;
  //  PropertyChangeSupport pceListeners = new PropertyChangeSupport(this);
  //  
  //  public void setMyProperty(int newValue) {
  //    int oldValue = myProperty;
  //    myProperty = newValue;
  //    pceListeners.firePropertyChange("myProperty", new Integer(oldValue), new Integer(newValue));
  //  }
  
  //  The listener list wrapper methods.
  //  public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
  //      pceListeners.addPropertyChangeListener(listener);
  //  }
  //  public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
  //      pceListeners.removePropertyChangeListener(listener);
  //  }
  
  /**A constrained property fires a PropertyChangeEvent whenever its value is about to be changed. 
   * Any listener can veto the event, thereby preventing the change. 
   * This example bean implements a single constrained integer property called myProperty. 
   * */
  
  //Create the listener list
  VetoableChangeSupport vceListeners = new VetoableChangeSupport(this);
  
  public void setMyProperty(int newValue) throws PropertyVetoException {
    vceListeners.fireVetoableChange("myProperty", new Integer(myProperty), new Integer(newValue));
    myProperty = newValue;
  }
  
  // The listener list wrapper methods.
  public synchronized void addVetoableChangeListener(VetoableChangeListener listener) {
    vceListeners.addVetoableChangeListener(listener);
  }
  
  public synchronized void removeVetoableChangeListener(VetoableChangeListener listener) {
    vceListeners.removeVetoableChangeListener(listener);
  }
  
}
