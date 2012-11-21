package org.veiset.coffew8.coffeepi.generated;
/** 
 * This class was automatically generated from all axioms pertaining to
 * the class CoffeeState, by JAxT. It should not be modified.
 * {@link CoffeeState}
 */
public class TestCoffeeStateAxioms extends junit.framework.TestCase {
  public TestCoffeeStateAxioms(  String name){
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
 * Test for {@link org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms#shouldRelateIncreasingAxiom(List())}
 */
  public void testCoffeeStateRequiredAxioms_shouldRelateIncreasingAxiom_(){
{
      org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms.shouldRelateIncreasingAxiom();
    }
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms#asymmetricNewerThanAxiom(CoffeeState, CoffeeState)}
 */
  public void testCoffeeStateRequiredAxioms_asymmetricNewerThanAxiom_CoffeeStateCoffeeState(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms.asymmetricNewerThanAxiom(p0,p1);
    }
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms#irreflexiveNewerThanAxiom(CoffeeState)}
 */
  public void testCoffeeStateRequiredAxioms_irreflexiveNewerThanAxiom_CoffeeState(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(1);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms.irreflexiveNewerThanAxiom(p0);
    }
  }
  /** 
 * Test for {@link org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms#transitiveAxiom(CoffeeState, CoffeeState, CoffeeState)}
 */
  public void testCoffeeStateRequiredAxioms_transitiveAxiom_CoffeeStateCoffeeStateCoffeeState(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState2);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1)     for (    org.veiset.coffew8.coffeepi.CoffeeState p2 : testSetorgveisetcoffew8coffeepiCoffeeState2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      org.veiset.coffew8.coffeepi.CoffeeStateRequiredAxioms.transitiveAxiom(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#signum(int)}
 */
  public void testComparableAxioms_signum_Int(){
    final int[] testSetInt0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createIntTestSet(1);
    assertNotNull("Data set not created",testSetInt0);
    for (    int p0 : testSetInt0) {
      jaxt.java.lang.ComparableAxioms.signum(p0);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty8congruenceCompareTo(T, T, T)}
 */
  public void testComparableAxioms_compareToProperty8congruenceCompareTo_TTT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState2);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1)     for (    org.veiset.coffew8.coffeepi.CoffeeState p2 : testSetorgveisetcoffew8coffeepiCoffeeState2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      jaxt.java.lang.ComparableAxioms.compareToProperty8congruenceCompareTo(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty7transitiveGT(T, T, T)}
 */
  public void testComparableAxioms_compareToProperty7transitiveGT_TTT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState2);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1)     for (    org.veiset.coffew8.coffeepi.CoffeeState p2 : testSetorgveisetcoffew8coffeepiCoffeeState2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      jaxt.java.lang.ComparableAxioms.compareToProperty7transitiveGT(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty6strongSymmetry(T, T)}
 */
  public void testComparableAxioms_compareToProperty6strongSymmetry_TT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ComparableAxioms.compareToProperty6strongSymmetry(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty5totalOrder(T, T)}
 */
  public void testComparableAxioms_compareToProperty5totalOrder_TT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ComparableAxioms.compareToProperty5totalOrder(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty4transitiveEQ(T, T, T)}
 */
  public void testComparableAxioms_compareToProperty4transitiveEQ_TTT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState2);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1)     for (    org.veiset.coffew8.coffeepi.CoffeeState p2 : testSetorgveisetcoffew8coffeepiCoffeeState2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      jaxt.java.lang.ComparableAxioms.compareToProperty4transitiveEQ(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty4symmetricEQ(T, T)}
 */
  public void testComparableAxioms_compareToProperty4symmetricEQ_TT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ComparableAxioms.compareToProperty4symmetricEQ(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty4reflexive(T)}
 */
  public void testComparableAxioms_compareToProperty4reflexive_T(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(1);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ComparableAxioms.compareToProperty4reflexive(p0);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty3transitiveLE(T, T, T)}
 */
  public void testComparableAxioms_compareToProperty3transitiveLE_TTT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(3);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState2);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1)     for (    org.veiset.coffew8.coffeepi.CoffeeState p2 : testSetorgveisetcoffew8coffeepiCoffeeState2) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      if (p2 == null)       assertNotNull("Test data contains illegal null entry",p2);
      jaxt.java.lang.ComparableAxioms.compareToProperty3transitiveLE(p0,p1,p2);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty3antisymmetricLE(T, T)}
 */
  public void testComparableAxioms_compareToProperty3antisymmetricLE_TT(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(2);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState1);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0)     for (    org.veiset.coffew8.coffeepi.CoffeeState p1 : testSetorgveisetcoffew8coffeepiCoffeeState1) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      if (p1 == null)       assertNotNull("Test data contains illegal null entry",p1);
      jaxt.java.lang.ComparableAxioms.compareToProperty3antisymmetricLE(p0,p1);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ComparableAxioms#compareToProperty2null(T)}
 */
  public void testComparableAxioms_compareToProperty2null_T(){
    final org.veiset.coffew8.coffeepi.CoffeeState[] testSetorgveisetcoffew8coffeepiCoffeeState0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createCoffeeStateTestSet(1);
    assertNotNull("Data set not created",testSetorgveisetcoffew8coffeepiCoffeeState0);
    for (    org.veiset.coffew8.coffeepi.CoffeeState p0 : testSetorgveisetcoffew8coffeepiCoffeeState0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ComparableAxioms.compareToProperty2null(p0);
    }
  }
  /** 
 * Test for {@link jaxt.java.lang.ObjectAxioms#hashCodeProperty2congruenceEquals(Object, Object)}
 */
  public void testObjectAxioms_hashCodeProperty2congruenceEquals_ObjectObject(){
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(2);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final int[] testSetInt1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createIntTestSet(2);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(1);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject1);
    final int[] testSetInt2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createIntTestSet(3);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(3);
    assertNotNull("Data set not created",testSetjavalangObject1);
    final java.lang.Object[] testSetjavalangObject2=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(3);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(2);
    assertNotNull("Data set not created",testSetjavalangObject0);
    final java.lang.Object[] testSetjavalangObject1=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(2);
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
    final java.lang.Object[] testSetjavalangObject0=org.veiset.coffew8.coffeepi.CoffeeStateGenerator.createObjectTestSet(1);
    assertNotNull("Data set not created",testSetjavalangObject0);
    for (    java.lang.Object p0 : testSetjavalangObject0) {
      if (p0 == null)       assertNotNull("Test data contains illegal null entry",p0);
      jaxt.java.lang.ObjectAxioms.equalsProperty1reflexive(p0);
    }
  }
}
