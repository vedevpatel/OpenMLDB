package com._4paradigm.fesql_auto_test.checker;

import com._4paradigm.fesql.sqlcase.model.SQLCase;
import com._4paradigm.fesql_auto_test.entity.FesqlResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.testng.Assert;

import java.util.Map;

/**
 * @author zhaowei
 * @date 2021/2/5 5:23 PM
 */
@Slf4j
public class DiffVersionChecker extends BaseChecker{

    public DiffVersionChecker(SQLCase fesqlCase, FesqlResult fesqlResult, Map<String,FesqlResult> resultMap){
        super(fesqlCase,fesqlResult,resultMap);
    }

    @Override
    public void check() throws Exception {
        log.info("diff version check");
        if(MapUtils.isEmpty(resultMap)){
            log.info("resultMap is empty");
            return;
        }
        resultMap.entrySet().stream().forEach(e->{
            String version = e.getKey();
            FesqlResult result = e.getValue();
            Assert.assertTrue(fesqlResult.equals(result),"版本结果对比不一致\nmainVersion:\n"+fesqlResult+"\nversion:"+version+"\n"+result);
        });
    }
}