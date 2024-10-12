package org.rgs.demo.ignite.springdata.model;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
import org.apache.ignite.cache.affinity.AffinityKeyMapped;

@Data
public class CityKey implements Serializable {

    private int id;

    @AffinityKeyMapped
    private String countryCode;

    public CityKey(int id, String countryCode) {
        this.id = id;
        this.countryCode = countryCode;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CityKey key = (CityKey)o;
        return id == key.id &&
                countryCode.equals(key.countryCode);
    }

    @Override public int hashCode() {
        return Objects.hash(id, countryCode);
    }
}