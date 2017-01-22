package be.renaudraas.playground.util;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import be.renaudraas.playground.business.mapper.Mapper;

public class ListUtils {

    private ListUtils() {
    }

    @NonNull
    public static <To, From> List<To> convert(@Nullable Collection<From> source, Mapper<From, To> mapper) {
        if (source == null) {
            return new ArrayList<>();
        }
        List<To> results = new ArrayList<>(source.size());
        for (From object : source) {
            To instance = mapper.map(object);
            results.add(instance);
        }
        return results;
    }
}
