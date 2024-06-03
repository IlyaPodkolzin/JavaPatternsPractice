package pract3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> implements Set<E> {

    private final Set<E> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        int res = 0;
        try {
            semaphore.acquire();
            res = set.size();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.isEmpty();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean contains(Object o) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.contains(o);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> res = null;
        try {
            semaphore.acquire();
            res = set.iterator();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[0];
        try {
            semaphore.acquire();
            res = set.toArray();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] res = null;
        try {
            semaphore.acquire();
            res = set.toArray(a);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean add(E e) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.add(e);
            semaphore.release();
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean remove(Object o) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.remove(o);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.containsAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.addAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.retainAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        try {
            semaphore.acquire();
            res = set.removeAll(c);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            set.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "SemaphoreSet{" +
                "set=" + set +
                ", semaphore=" + semaphore +
                '}';
    }
}
