package com.rgs.ignite.hello.tasks;

import org.apache.ignite.IgniteException;
import org.apache.ignite.compute.ComputeJob;
import org.apache.ignite.compute.ComputeJobAdapter;
import org.apache.ignite.compute.ComputeJobResult;
import org.apache.ignite.compute.ComputeTaskSplitAdapter;

import java.util.List;

public class AddNumbersTask extends ComputeTaskSplitAdapter<AddNumbersTaskArg, Integer> {

    @Override
    protected List<? extends ComputeJob> split(int gridSize, AddNumbersTaskArg arg) throws IgniteException {
        // 将任务拆分为两个子任务
        ComputeJob job1 = new ComputeJobAdapter(arg) {
            @Override
            public Object execute() {
                return ((AddNumbersTaskArg) argument(0)).getNumber1();
            }
        };

        ComputeJob job2 = new ComputeJobAdapter(arg) {
            @Override
            public Object execute() {
                return ((AddNumbersTaskArg) argument(0)).getNumber2();
            }
        };

        return List.of(job1, job2);
    }

    @Override
    public Integer reduce(List<ComputeJobResult> results) throws IgniteException {
        int sum = 0;
        for (ComputeJobResult res : results) {
            sum += (Integer) res.getData();
        }
        return sum;
    }
}