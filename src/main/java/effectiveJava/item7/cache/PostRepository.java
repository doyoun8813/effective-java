package effectiveJava.item7.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class PostRepository {

    private Map<CacheKey, Post> cache;

    public PostRepository() {
    	// HashMap -> WeakHashMap
        this.cache = new HashMap<>();
    }

    public Post getPostById(Integer id) {
    	
    	// id값을 Integer를 쓴 이유
    	// 가져온 id값을 해당 메서드에서 CacheKey 객체 key값으로 세팅했기 때문에 
    	// 이 메서드가 끝나면 key 값이 참조 해제가 된다.
    	// 만약 클라이언트에서 CacheKey 객체에 key 값을 할당했다면 메서드가 끝나기 전
    	// 가비지 컬렉션이 이루어졌기 때문에 캐시가 남아있게 된다.
    	CacheKey key = new CacheKey(id);
    	
        if (cache.containsKey(key)) {
            return cache.get(key);
            
        } else {
            // TODO DB에서 읽어오거나 REST API를 통해 읽어올 수 있습니다.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }        
        
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
