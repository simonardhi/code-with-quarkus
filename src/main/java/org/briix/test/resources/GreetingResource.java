package org.briix.test.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.briix.test.models.Post;
import org.briix.test.repositories.PostRepository;
import org.briix.test.repositories.TagRepository;

import java.util.List;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    PostRepository postRepository;

    @Inject
    TagRepository tagRepository;

    @GET
    public List<Post> getAllPosts() {
        return postRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Post getPostById(@PathParam("id") Long id) {
        return postRepository.findById(id);
    }

    @POST
    @Transactional
    public void createPost(Post post) {
        postRepository.persist(post);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void updatePost(@PathParam("id") Long id, Post post) {
        Post existingPost = postRepository.findById(id);
        existingPost.title = post.title;
        existingPost.content = post.content;
        existingPost.tags = post.tags;
        postRepository.persist(existingPost);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletePost(@PathParam("id") Long id) {
        postRepository.deleteById(id);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}
