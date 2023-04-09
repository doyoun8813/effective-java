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
    	
    	// id���� Integer�� �� ����
    	// ������ id���� �ش� �޼��忡�� CacheKey ��ü key������ �����߱� ������ 
    	// �� �޼��尡 ������ key ���� ���� ������ �ȴ�.
    	// ���� Ŭ���̾�Ʈ���� CacheKey ��ü�� key ���� �Ҵ��ߴٸ� �޼��尡 ������ ��
    	// ������ �÷����� �̷������ ������ ĳ�ð� �����ְ� �ȴ�.
    	CacheKey key = new CacheKey(id);
    	
        if (cache.containsKey(key)) {
            return cache.get(key);
            
        } else {
            // TODO DB���� �о���ų� REST API�� ���� �о�� �� �ֽ��ϴ�.
            Post post = new Post();
            cache.put(key, post);
            return post;
        }        
        
    }

    public Map<CacheKey, Post> getCache() {
        return cache;
    }
}
