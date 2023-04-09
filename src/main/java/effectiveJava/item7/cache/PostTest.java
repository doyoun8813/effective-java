package effectiveJava.item7.cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class PostTest {
	
	//@Test
	public void cache() throws InterruptedException {
		
		PostRepository postRepository = new PostRepository();
		
		Integer p1 = 1;
		
		postRepository.getPostById(p1);
		
		assertFalse(postRepository.getCache().isEmpty());
		
		System.out.println("run gc");
		// ������ �÷����� �Ͼ�ٴ� ������ ������ ��·�� ���� ��
		System.gc();
		System.out.println("wait");
		Thread.sleep(3000L);
		
		System.out.println("ĳ�������ֳ�? : " + postRepository.getCache());
		
		// ����
		assertTrue(postRepository.getCache().isEmpty());
		
	}
	
	@Test
	public void backgroundThread() throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		PostRepository postRepository = new PostRepository();
		
		// AutoBoxing
		postRepository.getPostById(1);
		postRepository.getPostById(2);
		postRepository.getPostById(3);
		postRepository.getPostById(4);
		postRepository.getPostById(5);
		postRepository.getPostById(6);
		postRepository.getPostById(7);
		postRepository.getPostById(8);
		
		// ĳ�ÿ��� ���� ������ ĳ�ú��� �����ϴ� ������
		Runnable removeOldCache = () -> {
			
			System.out.println("running removeOldCache task");
			Map<CacheKey, Post> cache = postRepository.getCache();
			Set<CacheKey> cacheKeys = cache.keySet();
			Optional<CacheKey> key = cacheKeys.stream().min(Comparator.comparing(CacheKey::getCreated));
			key.ifPresent((k) -> {
				System.out.println("removing " + k);
				cache.remove(k);
			});
		};
		
		System.out.println("The time is : " + new Date());
		
		// 1�� �ĺ��� 3�� �������� removeOldCache �����층 ����
		executor.scheduleAtFixedRate(removeOldCache, 1, 3, TimeUnit.SECONDS);
		
		Thread.sleep(20000L);
		
		executor.shutdown();
		
	}
}
