package com.sha.springbootmicroservice2purchase.service;

import com.sha.springbootmicroservice2purchase.model.Purchase;

import java.util.List;

/**
 * @author sa
 * @date 9.10.2021
 * @time 17:59
 */
public interface PurchaseService
{
    Purchase savePurchase(Purchase purchase);

    List<Purchase> findAllPurchasesOfUser(Long userId);
}
