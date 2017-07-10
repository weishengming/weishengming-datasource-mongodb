package com.weishengming.mongo.repository;

import com.weishengming.mongo.entities.UserInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by yangtianci on 2017/7/10.
 */
public interface UserInfoRepository  extends MongoRepository<UserInfo, ObjectId> {

}
