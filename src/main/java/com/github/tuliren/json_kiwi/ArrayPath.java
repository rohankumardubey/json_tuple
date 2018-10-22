package com.github.tuliren.json_kiwi;

import java.util.Objects;
import java.util.Optional;

/**
 * Tuple path for json array elements.
 */
public class ArrayPath implements TuplePath {

  private final Optional<String> name;
  private final int index;
  private final int size;

  public ArrayPath(Optional<String> name, int index, int size) {
    this.name = name;
    this.index = index;
    this.size = size;
  }

  @Override
  public Optional<String> getName() {
    return name;
  }

  @Override
  public boolean isArray() {
    return true;
  }

  @Override
  public Optional<Integer> getListIndex() {
    return Optional.of(index);
  }

  @Override
  public Optional<Integer> getListSize() {
    return Optional.of(size);
  }

  @Override
  public String toString() {
    return String.format("%s%s%d%s%d", name.orElse(Constants.KEYLESS_ARRAY_NAME), Constants.LIST_PATH_SEPARATOR, index, Constants.LIST_PATH_SEPARATOR, size);
  }

  @Override
  public int hashCode() {
    return name.hashCode() + 19 * index + 29 * size;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ArrayPath)) {
      return false;
    }

    ArrayPath that = (ArrayPath)other;
    return Objects.equals(this.name, that.name) &&
        this.index == that.index &&
        this.size == that.size;
  }

}
