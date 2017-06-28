package com.fenqifu.mongo.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liujuntao
 * @version $Id: CRUDTest.java, v 0.1 2016年5月18日 下午4:37:16 liujuntao Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(AppConfigTest.class)
public class CRUDTest {
//    //主要两种方式，一种repository,一种template。写几个简单的例子。有很多种方式能实现crud
//    @Autowired
//    private GeinihuaRepository          geinihuaRepository;
//    @Autowired
//    private MongoTemplate               template;
//    @Autowired
//    private ContactsFileQueneRepository contactsFileQueneRepository;
//    @Autowired
//    private UserCleanRepository         userCleanRepository;
//
//    @Test
//    public void insertTest() {
//
//        //        //分页查询
//        //        List<Order> orders = new ArrayList<Order>();
//        //        //按id升序
//        //        orders.add(new Order(Direction.ASC, "id"));
//        //        SpringDatePageable pageable = new SpringDatePageable();
//        //        for (int i = 495400; i <= 495600; i++) {
//        //            pageable.setSort(new Sort(orders));
//        //            pageable.setPagenumber(i);
//        //            pageable.setPagesize(1);
//        //            Page<UserCleanBean> pageGeinihua = userCleanRepository.findAll(pageable);
//        //            List<UserCleanBean> list = pageGeinihua.getContent();
//        //            System.out.println(list.get(0).getId());
//        //        }
//
//        //        List<User> list = userRepository.findFirst100By(new Order(Direction.ASC, "id"));
//        //        System.out.println(list.size());
//        //        ContactsFileQuene cot = new ContactsFileQuene();
//        //        cot.setContactsFileupLiveHangzhou(11);
//        //        cot.setUserId("123");
//        //        cot.setStatus(1);
//        //        cot.setType(1);
//        //        contactsFileQueneRepository.insert(cot);
//        //        contactsFileQueneRepository.findFirst5ByStatusAndTypeAndContactsFileupLiveHangzhou(1, 1, order, contactsFileupLiveHangzhou)
//        //        Geinihua geinihua = new Geinihua();
//        //        geinihua.setAddTime(new Date());
//        //        geinihua.setBankname("工商银行1");
//        //        geinihua.setKahao("3123143");
//    }
//    //
//    //    @Test
//    //    public void updateTest() {
//    //        Geinihua geinihua = new Geinihua();
//    //        geinihua.setAddTime(new Date());
//    //        geinihua.setBankname("北京银行");
//    //        geinihua.setKahao("11111");
//    //        //插入
//    //        geinihuaRepository.insert(geinihua);
//    //        //修改
//    //        template.updateMulti(query(where("bankname").is("北京银行")), update("bankname", "北京银行修改").set("kahao", "22222"),
//    //            Geinihua.class);
//    //        List<Geinihua> list = geinihuaRepository.findByBankname("北京银行修改");
//    //        Assert.assertEquals(1, list.size());
//    //        Assert.assertEquals("北京银行修改", list.get(0).getBankname());
//    //        Assert.assertEquals("22222", list.get(0).getKahao());
//    //    }
//    //
//    //    @Test
//    //    public void deleteTest() {
//    //        Geinihua geinihua = new Geinihua();
//    //        geinihua.setAddTime(new Date());
//    //        geinihua.setBankname("农业银行");
//    //        //插入
//    //        geinihuaRepository.insert(geinihua);
//    //        long longbefore = geinihuaRepository.countByBanknameLike("农业银行");
//    //        Assert.assertEquals(1, longbefore);
//    //        geinihuaRepository.deleteByBankname("农业银行");
//    //        long longafter = geinihuaRepository.countByBanknameLike("农业银行");
//    //        Assert.assertEquals(0, longafter);
//    //    }
//    //
//        @Test
//        public void pageQueryTest() {
////            for (int i = 1; i < 11; i++) {
////                Geinihua geinihua = new Geinihua();
////                geinihua.setAddTime(new Date());
////                geinihua.setBankname("嘿嘿嘿");
////                geinihuaRepository.insert(geinihua);
////            }
//            //分页查询
//            List<Sort.Order> orders = new ArrayList<Sort.Order>();
//            //按id倒叙
//            orders.add(new Sort.Order(Sort.Direction.DESC, "_id"));
//            SpringDatePageable pageable = new SpringDatePageable();
//            //排序，也可在方法中OrderByXXX这种方式
//            pageable.setSort(new Sort(orders));
//            pageable.setPagenumber(1);
//            pageable.setPagesize(2);
//            Page<Geinihua> pageGeinihua = geinihuaRepository.findByBankname("嘿嘿嘿", pageable);
//            List<Geinihua> list = pageGeinihua.getContent();
//            Assert.assertEquals(2, list.size());
//        }
//    //
//    //    @Test
//    //    public void andTest() {
//    //        Geinihua geinihua = new Geinihua();
//    //        geinihua.setKahao("1234");
//    //        geinihua.setBankname("哈哈哈");
//    //        geinihuaRepository.insert(geinihua);
//    //        List<Geinihua> list = geinihuaRepository.findByBanknameAndKahao("哈哈哈", "1234");
//    //        Assert.assertEquals(1, list.size());
//    //    }
//    //
//    //    @Test
//    //    public void templateTest() {
//    //        Geinihua geinihua = new Geinihua();
//    //        geinihua.setKahao("1234");
//    //        geinihua.setBankname("哇咔咔");
//    //        geinihuaRepository.insert(geinihua);
//    //
//    //        List<Geinihua> list = template.find(query(where("bankname").is("哇咔咔").and("kahao").is("1234")), Geinihua.class,
//    //            "geinihua");
//    //        Assert.assertEquals(1, list.size());
//    //    }
//    //
//    //    @Before
//    //    public void before() {
//    //        geinihuaRepository.deleteByBankname("刘俊涛");
//    //        geinihuaRepository.deleteByBankname("工商银行1");
//    //        geinihuaRepository.deleteByBankname("北京银行修改");
//    //        geinihuaRepository.deleteByBankname("嘿嘿嘿");
//    //        geinihuaRepository.deleteByBankname("哈哈哈");
//    //        geinihuaRepository.deleteByBankname("哇咔咔");
//    //    }
////    @Test
////    public void geinihua(){
////    	Geinihua geinihua=geinihuaRepository.findByUserIdAndZizhuangtaiOrderByIdDesc("","");
////    	System.out.println(geinihua);
////    }
}
