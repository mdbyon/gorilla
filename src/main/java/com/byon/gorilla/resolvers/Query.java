package com.byon.gorilla.resolvers;

import com.byon.gorilla.adapters.PostDao;
import com.byon.gorilla.models.Post;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class Query implements GraphQLResolver<Post> {

    private PostDao postsDao;

    public List<Post> getRecentPosts(int count, int offset) {
        return postsDao.getRecentPosts(count, offset);
    }
}
