package moe.pine.spring.util;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SuppressWarnings("ConstantConditions")
public class MoreCollectionsTest {
    @Nested
    class UnmodifiableMultiValueMap {
        @Test
        void init() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1, m2);
        }

        @Test
        void init_byUnmodifiableMultiValueMap() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            final MultiValueMap<String, Integer> m3 = MoreCollections.unmodifiableMultiValueMap(m2);
            assertSame(m2, m3);
        }

        @Test
        void init_NPE() {
            assertThatThrownBy(() -> MoreCollections.unmodifiableMultiValueMap(null))
                    .isExactlyInstanceOf(NullPointerException.class);
        }

        @Test
        void add() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.add("baz", 4))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void addAll_List() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.addAll("baz", ImmutableList.of(4)))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void addAll_MultiValueMap() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = new LinkedMultiValueMap<>();
            m2.put("baz", ImmutableList.of(4));

            final MultiValueMap<String, Integer> m3 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m3.addAll(m2))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void addIfAbsent() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.addIfAbsent("baz", 4))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void getFirst() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1.getFirst("foo"), m2.getFirst("foo"));
            assertEquals(m1.getFirst("bar"), m2.getFirst("bar"));
            assertEquals(m1.getFirst("baz"), m2.getFirst("baz"));
        }
    }
}
