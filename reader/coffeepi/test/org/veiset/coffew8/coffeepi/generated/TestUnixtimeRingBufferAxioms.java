package org.veiset.coffew8.coffeepi.generated;
/** 
 * This class was automatically generated from all axioms pertaining to
 * the class UnixtimeRingBuffer, by JAxT. It should not be modified.
 * {@link UnixtimeRingBuffer}
 */
public class TestUnixtimeRingBufferAxioms extends junit.framework.TestCase {
  public TestUnixtimeRingBufferAxioms(  String name){
    super(name);
  }
  /** 
 * @see junit.framework.TestCase#setUp()
 */
  protected void setUp() throws Exception {
    super.setUp();
  }
  /** 
 * @see junit.framework.TestCase#tearDown()
 */
  protected void tearDown() throws Exception {
    super.tearDown();
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms#elementsMustBeTotallyOrdered(Array)}
 */
  public void testUnixtimeRingBufferRequiredAxioms_elementsMustBeTotallyOrdered_AInteger(){
    final java.lang.Integer[][] testSetAjavalangInteger0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createAIntegerTestSet(1);
    assertNotNull("Data set not created",testSetAjavalangInteger0);
    for (    java.lang.Integer[] p0 : testSetAjavalangInteger0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms.elementsMustBeTotallyOrdered(p0);
    }
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms#addedElementsIsReversedInGetLast(Array, UnixtimeRingBuffer)}
 */
  public void testUnixtimeRingBufferRequiredAxioms_addedElementsIsReversedInGetLast_UnixtimeRingBufferAInteger(){
    final org.veiset.coffew8.coffeepi.UnixtimeRingBuffer[] testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createUnixtimeRingBufferTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0);
    final java.lang.Integer[][] testSetAjavalangInteger1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createAIntegerTestSet(2);
    assertNotNull("Data set not created",testSetAjavalangInteger1);
    for (    org.veiset.coffew8.coffeepi.UnixtimeRingBuffer p0 : testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0)     for (    java.lang.Integer[] p1 : testSetAjavalangInteger1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms.addedElementsIsReversedInGetLast(p0,p1);
    }
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms#addedElementIsCurrent(Integer, UnixtimeRingBuffer)}
 */
  public void testUnixtimeRingBufferRequiredAxioms_addedElementIsCurrent_UnixtimeRingBufferInteger(){
    final org.veiset.coffew8.coffeepi.UnixtimeRingBuffer[] testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createUnixtimeRingBufferTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0);
    final java.lang.Integer[] testSetjavalangInteger1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createIntegerTestSet(2);
    assertNotNull("Data set not created",testSetjavalangInteger1);
    for (    org.veiset.coffew8.coffeepi.UnixtimeRingBuffer p0 : testSetorgveisetcoffew8coffeepiUnixtimeRingBuffer0)     for (    java.lang.Integer p1 : testSetjavalangInteger1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      org.veiset.coffew8.coffeepi.UnixtimeRingBufferRequiredAxioms.addedElementIsCurrent(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#hashCodeProperty2congruenceEquals(Object, Object)}
 */
  public void testObjectAxioms_hashCodeProperty2congruenceEquals_ObjectObject(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject1);
    for (    java.lang.Object p0 : testSetjavalangObject0)     for (    java.lang.Object p1 : testSetjavalangObject1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ObjectAxioms.hashCodeProperty2congruenceEquals(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#hashCodeProperty1function(int, Object)}
 */
  public void testObjectAxioms_hashCodeProperty1function_ObjectInt(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final int[] testSetInt1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createIntTestSet(2);
    assertNotNull("Data set not created",testSetInt1);
    for (    java.lang.Object p0 : testSetjavalangObject0)     for (    int p1 : testSetInt1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ObjectAxioms.hashCodeProperty1function(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#equalsProperty5null(Object)}
 */
  public void testObjectAxioms_equalsProperty5null_Object(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(1);
    assertNotNull("Data set not created",testSetjavalangObject0);
    for (    java.lang.Object p0 : testSetjavalangObject0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ObjectAxioms.equalsProperty5null(p0);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#equalsProperty4function(int, Object, Object)}
 */
  public void testObjectAxioms_equalsProperty4function_ObjectObjectInt(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject1);
    final int[] testSetInt2=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createIntTestSet(3);
    assertNotNull("Data set not created",testSetInt2);
    for (    java.lang.Object p0 : testSetjavalangObject0)     for (    java.lang.Object p1 : testSetjavalangObject1)     for (    int p2 : testSetInt2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ObjectAxioms.equalsProperty4function(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#equalsProperty3transitive(Object, Object, Object)}
 */
  public void testObjectAxioms_equalsProperty3transitive_ObjectObjectObject(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject1);
    final java.lang.Object[] testSetjavalangObject2=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject2);
    for (    java.lang.Object p0 : testSetjavalangObject0)     for (    java.lang.Object p1 : testSetjavalangObject1)     for (    java.lang.Object p2 : testSetjavalangObject2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      jaxt.java.lang.ObjectAxioms.equalsProperty3transitive(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#equalsProperty2symmetric(Object, Object)}
 */
  public void testObjectAxioms_equalsProperty2symmetric_ObjectObject(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject1);
    for (    java.lang.Object p0 : testSetjavalangObject0)     for (    java.lang.Object p1 : testSetjavalangObject1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ObjectAxioms.equalsProperty2symmetric(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#equalsProperty1reflexive(Object)}
 */
  public void testObjectAxioms_equalsProperty1reflexive_Object(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.UnixtimeRingBufferGenerator.createObjectTestSet(1);
    assertNotNull("Data set not created",testSetjavalangObject0);
    for (    java.lang.Object p0 : testSetjavalangObject0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ObjectAxioms.equalsProperty1reflexive(p0);
    }
  }
}
