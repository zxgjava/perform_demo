package cn.agilean.test;

import cn.agilean.utils.PerformCPU;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by zxg on 16/4/25.
 */
public class PerformAndroidTest {
    @BeforeClass
    public void beforeClass() {

    }

    @Parameters({ "packageName"})
    @Test
    public void should_return_cpu_by_get_packageName_with_dump(String packageName) {
        Reporter.log(packageName + "-dump cpu:" + PerformCPU.getCpuByDump(packageName));
    }

    @Parameters({ "packageName"})
    @Test
    public void should_return_cpu_by_get_packageName_with_top(String packageName) {
        Reporter.log(packageName + "-top cpu:" + PerformCPU.getCpuByTop(packageName));
    }
}
