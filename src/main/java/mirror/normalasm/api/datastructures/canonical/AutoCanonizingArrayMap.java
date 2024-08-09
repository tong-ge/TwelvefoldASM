package mirror.normalasm.api.datastructures.canonical;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import mirror.normalasm.api.NormalStringPool;

import java.util.Map;

public class AutoCanonizingArrayMap<K, V> extends Object2ObjectArrayMap<K, V> {

    public AutoCanonizingArrayMap() {
        super();
    }

    public AutoCanonizingArrayMap(Map<K, V> map) {
        super(map);
    }

    @Override
    public V put(K k, V v) {
        if (k instanceof String) {
            k = (K) NormalStringPool.canonicalize((String) k);
        }
        if (v instanceof String) {
            v = (V) NormalStringPool.canonicalize((String) v);
        }
        return super.put(k, v);
    }
}
