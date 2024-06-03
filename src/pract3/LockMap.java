package pract3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMap<K, V> implements Map<K, V> {
    private final Map<K, V> map = new HashMap<>();
    private final Lock lock = new ReentrantLock();

    @Override
    public int size() {
        lock.lock();
        int size = map.size();
        lock.unlock();
        return size;
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        boolean res = map.isEmpty();
        lock.unlock();
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        boolean res = map.containsKey(key);
        lock.unlock();
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        boolean res = map.containsValue(value);
        lock.unlock();
        return res;
    }

    @Override
    public V get(Object key) {
        lock.lock();
        V res = map.get(key);
        lock.unlock();
        return res;
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        V res = map.put(key, value);
        lock.unlock();
        return res;
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        V res = map.remove(key);
        lock.unlock();
        return res;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        map.putAll(m);
        lock.unlock();
    }

    @Override
    public void clear() {
        lock.lock();
        map.clear();
        lock.unlock();
    }

    @Override
    public Set<K> keySet() {
        lock.lock();
        Set<K> res = map.keySet();
        lock.unlock();
        return res;
    }

    @Override
    public Collection<V> values() {
        lock.lock();
        Collection<V> res = map.values();
        lock.unlock();
        return res;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        lock.lock();
        Set<Entry<K, V>> res = map.entrySet();
        lock.unlock();
        return res;
    }

    @Override
    public String toString() {
        lock.lock();
        String res = "LockMap{" +
                "map=" + map +
                '}';
        lock.unlock();
        return res;
    }
}
