package org.rgs.utils;

import lombok.Data;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.resources.IgniteInstanceResource;
import org.apache.ignite.resources.ServiceContextResource;
import org.apache.ignite.services.Service;
import org.apache.ignite.services.ServiceCallContext;
import org.apache.ignite.services.ServiceContext;

import java.util.ArrayList;
import java.util.List;

@Data
public class CacheLoadServiceImpl implements Service {

    private List<String> cacheList = new ArrayList<>();

    @IgniteInstanceResource
    private Ignite ignite;

    @ServiceContextResource
    private ServiceContext ctx;

    @Override
    public void execute() {

        if (!cacheList.isEmpty()) {
            cacheList.forEach(this::loadCache);
        } else {
            ServiceCallContext callCtx = ctx.currentCallContext();
            String cacheName = callCtx != null ? callCtx.attribute("KEY_CACHE_NAME") : null;

            if (cacheName != null) {
                loadCache(cacheName);
            }
        }
    }

    private void loadCache(String cacheName) {
        IgniteCache<Integer, Object> cache = ignite.cache(cacheName);
        cache.loadCache(null);
        System.out.println("Cache[" + cacheName + "]が正常にロードしました。");
    }
}
