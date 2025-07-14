package com.service;
import com.entity.Inventory;
import com.entity.Orders;
import com.entity.Product;
import com.repository.InventoryRepository;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public String placeOrder(Long productId, int quantity) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            return "Order Failed: Product not found!";
        }
 
        Inventory inventory = inventoryRepository.findByProductObj(product);
        if (inventory == null || inventory.getStock() < quantity) {
            return "Order Failed: Insufficient stock!";
        }
        inventory.setStock(inventory.getStock() - quantity);
        inventoryRepository.save(inventory);
        Orders order = new Orders();
        order.setProductObj(product);
        order.setQuantity(quantity);
        order.setStatus("PLACED");
        orderRepository.save(order);
        if(productId.equals(0L)){
            throw new RuntimeException("Order processing failed!");
        }
        return "Order Placed Successfully!";
    }
}