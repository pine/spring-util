package moe.pine.spring.util;

import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public abstract class MoreCollections {
    public static <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(MultiValueMap<K, V> m) {
        if (m.getClass() == UnmodifiableMultiValueMap.class) { // implicit NPE
            return m;
        }

        return new UnmodifiableMultiValueMap<>(m);
    }

    private static class UnmodifiableMultiValueMap<K, V>
            implements MultiValueMap<K, V>, Serializable {
        private static final long serialVersionUID = -2540751507397589458L;

        private final Map<K, List<V>> map;
        private final MultiValueMap<K, V> mvMap;

        UnmodifiableMultiValueMap(MultiValueMap<K, V> m) {
            map = Collections.unmodifiableMap(m);
            mvMap = m;
        }

        // MultiValueMap

        @Override
        public void add(K key, @Nullable V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addAll(K key, List<? extends V> values) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addAll(MultiValueMap<K, V> values) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addIfAbsent(K key, @Nullable V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Nullable
        public V getFirst(K key) {
            return mvMap.getFirst(key);
        }

        @Override
        public void set(K key, @Nullable V value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setAll(Map<K, V> values) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Map<K, V> toSingleValueMap() {
            return mvMap.toSingleValueMap();
        }

        // Map

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> compute(K key, BiFunction<? super K, ? super List<V>, ? extends List<V>> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> computeIfAbsent(K key, Function<? super K, ? extends List<V>> mappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> computeIfPresent(K key, BiFunction<? super K, ? super List<V>, ? extends List<V>> remappingFunction) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsKey(Object key) {
            return map.containsKey(key);
        }

        @Override
        public boolean containsValue(Object value) {
            return map.containsValue(value);
        }

        @Override
        public Set<Entry<K, List<V>>> entrySet() {
            return map.entrySet();
        }

        @Override
        public boolean equals(Object obj) {
            return map.equals(obj);
        }

        @Override
        public void forEach(BiConsumer<? super K, ? super List<V>> action) {
            map.forEach(action);
        }

        @Override
        public int hashCode() {
            return map.hashCode();
        }

        @Override
        public List<V> getOrDefault(Object key, List<V> defaultValue) {
            return map.getOrDefault(key, defaultValue);
        }

        @Override
        public void replaceAll(BiFunction<? super K, ? super List<V>, ? extends List<V>> function) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> putIfAbsent(K key, List<V> value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object key, Object value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean replace(K key, List<V> oldValue, List<V> newValue) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> replace(K key, List<V> value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> merge(K key, List<V> value, BiFunction<? super List<V>, ? super List<V>, ? extends List<V>> remappingFunction) {
            return map.merge(key, value, remappingFunction);
        }

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public boolean isEmpty() {
            return map.isEmpty();
        }


        @Override
        public List<V> get(Object key) {
            return map.get(key);
        }

        @Override
        public List<V> put(K key, List<V> value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<V> remove(Object key) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void putAll(Map<? extends K, ? extends List<V>> m) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Set<K> keySet() {
            return map.keySet();
        }

        @Override
        public Collection<List<V>> values() {
            return map.values();
        }
    }
}
