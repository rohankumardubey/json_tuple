package com.github.tuliren.json_tuple;

import java.util.Optional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayKeyPath extends BaseTestCase {

  @Test
  public void testArrayPath() {
    KeyPath arrayPath = new ArrayKeyPath(Optional.of(ARRAY_PATH_NAME), ARRAY_INDEX, ARRAY_SIZE);
    assertEquals(arrayPath, KeyPaths.create(arrayPath.toString()));
  }

  @Test
  public void testKeylessArrayPath() {
    KeyPath arrayPath = new ArrayKeyPath(Optional.empty(), ARRAY_INDEX, ARRAY_SIZE);
    assertEquals(arrayPath, KeyPaths.create(arrayPath.toString()));
  }

}
