package tuliren.json_db_lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValueType {

  @Test
  public void testValidValue() throws Exception {
    for (ValueType valueType : ValueType.values()) {
      assertEquals(valueType, ValueType.findByValue(valueType.value));
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidValue() throws Exception {
    ValueType.findByValue(5000);
  }

}
