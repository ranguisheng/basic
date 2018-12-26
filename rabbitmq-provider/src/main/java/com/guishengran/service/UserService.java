package com.guishengran.service;

import com.guishengran.bean.UserEntity;
import com.guishengran.enums.ExchangeEnum;
import com.guishengran.enums.QueueEnum;
import com.guishengran.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Auther: guish
 * @Date: 2018/12/26 07:53
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QueueMessageService queueMessageService;
    /**
     * 保存用户
     * 并写入消息队列
     * @param userEntity
     * @return
     */
    public Long save(UserEntity userEntity) throws Exception
    {
        /**
         * 保存用户
         */
        userRepository.save(userEntity);
        /**
         * 将消息写入消息队列
         */
        queueMessageService.send(userEntity.getId(), ExchangeEnum.USER_REGISTER, QueueEnum.USER_REGISTER);

        return userEntity.getId();
    }
}
