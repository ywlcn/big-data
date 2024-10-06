package com.rgs.ignite.hello.tasks;


import com.rgs.ignite.hello.model.Person;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.compute.ComputeTask;
import org.apache.ignite.compute.ComputeTaskSplitAdapter;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeJobResultPolicy;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;

import java.util.List;

public class GetAndUpdatePersonTask extends ComputeTaskSplitAdapter<Object, Object> {

    @Override
    protected List<? extends ComputeJob> split(int gridSize, Object arg) throws IgniteException {
        ComputeJob job = new ComputeJobAdapter(arg) {
            @Override
            public Object execute() {
                Ignite ignite = Ignition.localIgnite();
                IgniteCache<Long, Person> cache = ignite.cache("PersonCache");

//                Person person = cache.get(1);
//                if (person != null) {
//                    person.setAge(arg.getNewAge());
//                    cache.put(person.getId(), person);
//                }
                return new Person();
            }
        };
        return List.of(job);
    }

    @Override
    public Person reduce(List<ComputeJobResult> results) throws IgniteException {
        for (ComputeJobResult res : results) {
            if (res.getException() == null) {
                return (Person) res.getData();
            }
        }
        return null;
    }
}