package blog.jaturong.controller;

import blog.jaturong.models.Post;
import blog.jaturong.services.NotificationService;
import blog.jaturong.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    // http://localhost:8080/posts/view/3
    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Post post = postService.findById(id);
        if(post == null){
            notifyService.addErrorMessage("Cannot found post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }
}
