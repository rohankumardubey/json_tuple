package com.github.tuliren.json_kiwi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestElementKeyPath extends BaseTestCase {

  @Test
  public void testElementPath() throws Exception {
    KeyPath elementPath = new ElementKeyPath(ELEMENT_PATH_NAME);
    assertEquals(elementPath, KeyPaths.create(elementPath.toString()));
  }

}
