package com.aaa.xmz.springcloud.service;

import com.aaa.xmz.springcloud.fallback.ISpringcloudFallBackFactory;
import com.aaa.xmz.springcloud.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @InterfaceName ISpringcloudService
 * @Description
 *   如果传的参数为普通类型，包装类型(int,double...String,Integer...)，@RequestParam，并且可以有多个
 *       但是如果所传的参数为实体类,map...，必须要使用@RequestBody，并且只能有一个
 *       在provider中必须要使用@RestController注解，而且在provider的controller中也必须携带@RequestBody
 *
 *       @RequestMapping("/")必须要和provider中controller的@RequestMapping("/")的值一模一样
 *
 *       @FeignClient("BOOK-PROVIDER"):
 *           值是eureka中的Application的值(一定是大写)
 * @Author sgz
 * @Date 2019/11/12 15:21
 * @Version 1.0
 **/
@FeignClient(value = "BOOK-PROVIDER",fallbackFactory = ISpringcloudFallBackFactory.class)
public interface ISpringcloudService {
    @RequestMapping("/all")
     List<Book> selectAllBooks();

}
