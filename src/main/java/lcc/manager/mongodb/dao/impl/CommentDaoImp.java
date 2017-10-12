package lcc.manager.mongodb.dao.impl;

import lcc.manager.mongodb.dao.CommentDao;

import org.springframework.transaction.annotation.Transactional;


@Transactional(rollbackFor = Exception.class)
public class CommentDaoImp implements CommentDao {

}
