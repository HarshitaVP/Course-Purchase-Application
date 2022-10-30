package com.sha.springbootmicroservice2purchase;

import com.sha.springbootmicroservice2purchase.model.Purchase;
import com.sha.springbootmicroservice2purchase.repository.PurchaseRepository;
import com.sha.springbootmicroservice2purchase.service.PurchaseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

    @Autowired
    private PurchaseServiceImpl service;

    @MockBean
    private PurchaseRepository repository;

    @Test
    public void findAllPurchaseOfUserTest() {
        Purchase purchase = new Purchase(1L, 101L, 1001L, "test-course-1", 80.0, LocalDateTime.now());
        when(repository.findAllByUserId(purchase.getUserId())).thenReturn(Stream
                .of(purchase).collect(Collectors.toList()));
        Assert.assertEquals(1, service.findAllPurchasesOfUser(purchase.getUserId()).size());
    }

    @Test
    public void saveCourseTest() {
        Purchase purchase = new Purchase(2L, 102L, 1002L, "test-course-2", 20.0, LocalDateTime.now());
        when(repository.save(purchase)).thenReturn(purchase);
        Assert.assertEquals(purchase, service.savePurchase(purchase));
    }

}
