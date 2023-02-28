package com.api.daylog.helper;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase
public abstract class RepositoryTestHelper {

    protected <T> ObjectAssert<?> assertThat(T actual) {
        return Assertions.assertThat(actual);
    }
}
