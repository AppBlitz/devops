package com.dev.ops;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.GenericSignatureFormatError;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DevopsApplicationTests {
  @Test
  void sampleTest() {
    int x = 0;
    assertTrue(0 == x, () -> "Error");
  }

}
