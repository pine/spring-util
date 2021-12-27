package moe.pine.spring.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SuppressWarnings("ConstantConditions")
public class MoreCollectionsTest {
    @Nested
    class UnmodifiableMultiValueMap {
        // MultiValueMap

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

        @Test
        void set() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.set("baz", 4))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void setAll() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final Map<String, Integer> m2 = ImmutableMap.of("baz", 4);
            final MultiValueMap<String, Integer> m3 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m3.setAll(m2))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void toSingleValueMap() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1.toSingleValueMap(), m2.toSingleValueMap());
        }

        // Map

        @Test
        void clear() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(m2::clear).isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void compute() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.compute("baz", (k, v) -> v))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void computeIfAbsent() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.computeIfAbsent("baz", k -> ImmutableList.of(4)))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void computeIfPresent() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertThatThrownBy(() -> m2.computeIfPresent("foo", (k, v) -> ImmutableList.of(4)))
                    .isExactlyInstanceOf(UnsupportedOperationException.class);
        }

        @Test
        void containsKey() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1.containsKey("foo"), m2.containsKey("foo"));
            assertEquals(m1.containsKey("baz"), m2.containsKey("baz"));
        }

        @Test
        void containsValue() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1.containsValue(ImmutableList.of(1)), m2.containsValue(ImmutableList.of(1)));
            assertEquals(m1.containsValue(ImmutableList.of(2, 3)), m2.containsValue(ImmutableList.of(2, 3)));
            assertEquals(m1.containsValue(ImmutableList.of(4)), m2.containsValue(ImmutableList.of(4)));
        }

        @Test
        void entrySet() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = MoreCollections.unmodifiableMultiValueMap(m1);
            assertEquals(m1.entrySet(), m2.entrySet());
        }

        @Test
        void equals() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = new LinkedMultiValueMap<>();
            m2.put("foo", ImmutableList.of(1));
            m2.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m3 = MoreCollections.unmodifiableMultiValueMap(m1);
            final MultiValueMap<String, Integer> m4 = MoreCollections.unmodifiableMultiValueMap(m2);
            assertEquals(m1, m3);
            assertEquals(m1, m4);
            assertEquals(m3, m3);
            assertEquals(m3, m4);
        }

        @Test
        void equals_notEquals() {
            final MultiValueMap<String, Integer> m1 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));

            final MultiValueMap<String, Integer> m2 = new LinkedMultiValueMap<>();
            m1.put("foo", ImmutableList.of(1));
            m1.put("bar", ImmutableList.of(2, 3));
            m1.put("baz", ImmutableList.of(4));

            final MultiValueMap<String, Integer> m3 = MoreCollections.unmodifiableMultiValueMap(m1);
            final MultiValueMap<String, Integer> m4 = MoreCollections.unmodifiableMultiValueMap(m2);
            assertNotEquals(m1, m4);
            assertNotEquals(m2, m3);
            assertNotEquals(m3, m4);
        }
    }
}
