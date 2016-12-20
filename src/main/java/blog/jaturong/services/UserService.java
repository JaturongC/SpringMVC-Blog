package blog.jaturong.services;


public interface UserService {
    boolean authenticate(String username, String password);
}
