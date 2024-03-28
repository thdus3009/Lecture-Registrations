package com.specialLecture;

import com.specialLecture.entity.Lecture;
import com.specialLecture.lecture.LectureService;
import com.specialLecture.lecture.repository.LectureJpaRepository;
import com.specialLecture.lecture.repository.UserLectureJpaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
public class ConcurrencyTest {
    @Autowired
    private LectureService lectureService;
    @Autowired
    private UserLectureJpaRepository userLectureJpaRepository;
    @Autowired
    private LectureJpaRepository lectureJpaRepository;

    @Test
    public void 여러명_동시_신청() throws Exception {
        int userCount = 100;
        Long lectureId = 1L;

        CountDownLatch latch = new CountDownLatch(userCount);
        ExecutorService executorService = Executors.newFixedThreadPool(userCount);

        for (int i=0; i<userCount; i++) {
            Long userId = Long.valueOf(i);

            executorService.submit(() -> {
                try {
                    lectureService.register(userId, lectureId);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        executorService.shutdown();


        latch.await();

        Long cnt = userLectureJpaRepository.count();
        Assertions.assertThat(cnt);

    }

    @Test
    public void 테스트(){
        Optional<Lecture> lecture = lectureJpaRepository.findById(1L);
        System.out.println(lecture);
        Assertions.assertThat(lecture);
    }
}
