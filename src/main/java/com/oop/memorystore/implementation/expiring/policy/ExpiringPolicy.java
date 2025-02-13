package com.oop.memorystore.implementation.expiring.policy;

import java.util.function.BiPredicate;

public interface ExpiringPolicy<V, T extends ExpiringPolicy.ExpirationData> {

  String named();

  default T createExpirationData(V value) {
    return null;
  }

  boolean checkExpiration(V value, T data);

  void onAccess(V value, T data);

  default BiPredicate<V, T> checkExpiration() {
    return this::checkExpiration;
  }

  static interface ExpirationData {}
}
