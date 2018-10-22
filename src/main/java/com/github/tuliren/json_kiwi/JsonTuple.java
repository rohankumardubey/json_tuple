package com.github.tuliren.json_kiwi;

import java.util.List;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * Json key value pair.
 */
public class JsonTuple {

  // key
  private final List<KeyPath> paths;
  // value type
  private final ValueType type;
  // value
  private final String value;

  private JsonTuple(List<KeyPath> paths, ValueType type, String value) {
    Preconditions.checkArgument(!paths.isEmpty(), "Value path cannot be empty: " + value);
    this.paths = paths;
    this.type = type;
    this.value = value;
  }

  public static JsonTuple create(String fullPath, ValueType type, String value) {
    Preconditions.checkArgument(type.category == ValueType.Category.JSON);

    List<KeyPath> paths = Lists.newLinkedList();
    for (String path : fullPath.split(Pattern.quote(Constants.PATH_SEPARATOR))) {
      paths.add(KeyPaths.create(path));
    }

    switch (type) {
      case JSON_STRING:
        return JsonTuple.createString(paths, value);
      case JSON_BOOLEAN:
        return JsonTuple.createBoolean(paths, value);
      case JSON_NUMBER:
        return JsonTuple.createNumber(paths, value);
      case JSON_NULL:
        return JsonTuple.createNull(paths);
      case JSON_EMPTY:
        return JsonTuple.createEmpty(paths);
      default:
        throw new IllegalArgumentException("Unexpected json type: " + type.name());
    }
  }

  static JsonTuple createString(List<KeyPath> paths, String value) {
    return new JsonTuple(paths, ValueType.JSON_STRING, value);
  }

  static JsonTuple createBoolean(List<KeyPath> paths, String value) {
    return new JsonTuple(paths, ValueType.JSON_BOOLEAN, value);
  }

  static JsonTuple createNumber(List<KeyPath> paths, String value) {
    return new JsonTuple(paths, ValueType.JSON_NUMBER, value);
  }

  static JsonTuple createNull(List<KeyPath> paths) {
    return new JsonTuple(paths, ValueType.JSON_NULL, null);
  }

  static JsonTuple createEmpty(List<KeyPath> paths) {
    return new JsonTuple(paths, ValueType.JSON_EMPTY, null);
  }

  public String getFullPaths() {
    return Joiner.on(Constants.PATH_SEPARATOR).join(paths);
  }

  public List<KeyPath> getPaths() {
    return paths;
  }

  public ValueType getType() {
    return type;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.format("%s: %s-%s", getFullPaths(), type.name(), value);
  }

}
