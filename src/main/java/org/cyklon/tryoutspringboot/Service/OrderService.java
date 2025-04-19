package org.cyklon.tryoutspringboot.Service;

import lombok.RequiredArgsConstructor;
import org.cyklon.tryoutspringboot.DTO.OrderItemDTO;
import org.cyklon.tryoutspringboot.DTO.OrderRequestDTO;
import org.cyklon.tryoutspringboot.Model.Order;
import org.cyklon.tryoutspringboot.Model.OrderItem;
import org.cyklon.tryoutspringboot.Model.Products;
import org.cyklon.tryoutspringboot.Repository.OrderRepository;
import org.cyklon.tryoutspringboot.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequestDTO req){
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO itemDTO : req.getItems()){
            Products product = productRepository.findById(itemDTO.getProductId()).orElseThrow(()-> new RuntimeException("Product not found"));
            if(product.getStock() < itemDTO.getQuantity()){
                throw new RuntimeException("Quantity exceeds stock");
            }
            product.setStock(product.getStock() - itemDTO.getQuantity());

            OrderItem item = new OrderItem();
            item.setProducts(product);
            item.setQuantity(itemDTO.getQuantity());
            item.setPrice(product.getPrice() * itemDTO.getQuantity());
            item.setOrder(order);
            items.add(item);
        }
        order.setItems(items);
        return orderRepository.save(order);
    }
}
