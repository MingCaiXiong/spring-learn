package top.xiongmingcai.restful.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.TestDao;

import javax.annotation.Resource;

/**
 * (Test)表服务接口
 *
 * @author makejava
 * @since 2021-04-21 16:22:31
 */
@Service
public class TestService {
    @Resource
    private TestDao testDao;
    @Transactional
    public  void batchImport(){
        for (int i = 0; i < 10; i++) {
//            if (i ==3) {
//                throw  new RuntimeException("预期外异常!");
//            }
            testDao.insetSample();
        }
    }


}