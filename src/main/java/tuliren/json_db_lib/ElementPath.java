package tuliren.json_db_lib;

import java.util.Objects;
import java.util.Optional;

public class ElementPath implements TuplePath {

  private final String name;

  public ElementPath(String name) {
    this.name = name;
  }

  @Override
  public Optional<String> getName() {
    return Optional.of(name);
  }

  @Override
  public boolean isArray() {
    return false;
  }

  @Override
  public Optional<Integer> getListIndex() {
    return Optional.empty();
  }

  @Override
  public Optional<Integer> getListSize() {
    return Optional.empty();
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int hashCode() {
    return 19 + name.hashCode();
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ElementPath)) {
      return false;
    }
    return Objects.equals(this.name, ((ElementPath)other).name);
  }

}
